package com.heledron.spideranimation

import com.google.gson.Gson
import com.heledron.spideranimation.spider.configuration.CloakOptions
import com.heledron.spideranimation.spider.configuration.SpiderDebugOptions
import com.heledron.spideranimation.spider.configuration.SpiderOptions
import com.heledron.spideranimation.spider.presets.*
import com.heledron.spideranimation.utilities.BlockDisplayModelPiece
import com.heledron.spideranimation.utilities.CustomItemRegistry
import com.heledron.spideranimation.utilities.Serializer
import org.bukkit.Bukkit.createInventory
import org.bukkit.Material
import org.bukkit.entity.Display

fun registerCommands(plugin: SpiderAnimationPlugin) {
    fun getCommand(name: String) = plugin.getCommand(name) ?: throw Exception("Command $name not found")

    getCommand("options").apply {
        val options = mapOf(
            "walkGait" to { AppState.options.walkGait },
            "gallopGait" to { AppState.options.gallopGait },

            "debug" to { AppState.options.debug },
            "misc" to { AppState.miscOptions },
            "cloak" to { AppState.options.cloak },
        )

        val defaultObjects = mapOf(
            "walkGait" to { SpiderOptions().apply { scale(AppState.options.bodyPlan.scale) }.walkGait },
            "gallopGait" to { SpiderOptions().apply { scale(AppState.options.bodyPlan.scale) }.gallopGait },

            "debug" to { SpiderDebugOptions() },
            "misc" to { MiscellaneousOptions() },
            "cloak" to { CloakOptions() },
        )

        setExecutor { sender, _, _, args ->
            val obj = options[args.getOrNull(0)]?.invoke() ?: return@setExecutor false
            val default = defaultObjects[args.getOrNull(0)]?.invoke() ?: return@setExecutor false
            val option = args.getOrNull(1) ?: return@setExecutor false
            val valueUnParsed = args.getOrNull(2)

            fun printable(obj: Any?) = Gson().toJson(obj)

            if (option == "reset") {
                val map = Serializer.toMap(default) as Map<*, *>
                Serializer.writeFromMap(obj, map)
                sender.sendMessage("Reset all options")
            } else if (valueUnParsed == null) {
                val value = Serializer.get(obj, option)
                sender.sendMessage("Option $option is ${printable(value)}")
            } else if (valueUnParsed == "reset") {
                val value = Serializer.get(default, option)
                Serializer.set(obj, option, value)
                sender.sendMessage("Reset option $option to ${printable(value)}")
            } else {
                val parsed = try {
                    Gson().fromJson(valueUnParsed, Any::class.java)
                } catch (e: Exception) {
                    sender.sendMessage("Could not parse: $valueUnParsed")
                    return@setExecutor true
                }
                Serializer.setMap(obj, option, parsed)
                val value = Serializer.get(obj, option)
                sender.sendMessage("Set option $option to ${printable(value)}")
            }

            plugin.writeAndSaveConfig()

            return@setExecutor true
        }

        setTabCompleter { _, _, _, args ->
            if (args.size == 1) {
                return@setTabCompleter options.keys.filter { it.contains(args.last(), true) }
            }

            if (args.size == 2) {
                val obj = options[args[0]]?.invoke() ?: return@setTabCompleter emptyList()
                val map = Serializer.toMap(obj)

                // get keys recursively
                val current = args.last()
                fun getKeys(obj: Any?, output: MutableList<String>, prefix: String = "") {
                    // hide items on the next "layer"
                    val suffix = prefix.slice(current.length + 1 until prefix.length)
                    if (suffix.contains(".") || suffix.contains("[")) return

                    if (prefix.isNotEmpty()) output.add(prefix)

                    if (obj is Map<*, *>) {
                        for ((key, value) in obj) getKeys(value, output, if (prefix.isNotEmpty()) "$prefix.$key" else key.toString())
                    }
                    if (obj is List<*>) {
                        for ((index, value) in obj.withIndex()) getKeys(value, output, "$prefix[$index]")
                    }
                }

                val keys = mutableListOf<String>()
                getKeys(map, keys)

                return@setTabCompleter keys.filter { it.startsWith(current, true) }
            }

            val obj = options[args[0]]?.invoke() ?: return@setTabCompleter emptyList()
            val map = Serializer.toMap(obj) as Map<*, *>
            val sample = map[args[1]]
            val keys = (if (sample is Boolean) listOf("true", "false") else emptyList()) + "reset"
            return@setTabCompleter keys.filter { it.contains(args.last(), true) }
        }
    }

    getCommand("modify_model").apply {
        fun getLegPieces() = AppState.options.bodyPlan.legs.flatMap { it.segments }.flatMap { it.model.pieces }
        fun getBodyPieces() = AppState.options.bodyPlan.bodyModel.pieces
        fun getAllPieces() = getLegPieces() + getBodyPieces()
        fun getAvailableTags() = getAllPieces().flatMap { it.tags }.distinct()

        setExecutor { sender, _, _, args ->
            val orGroups = mutableListOf<MutableList<String>>()
            val changes = mutableListOf<(piece: BlockDisplayModelPiece) -> Unit>()

            var clause = "or"
            orGroups += mutableListOf<String>()
            for ((index,arg) in args.withIndex()) {
                if (arg == "or") {
                    clause = "or"
                    orGroups += mutableListOf<String>()
                    continue
                }

                if (arg == "to") {
                    clause = "to"

                    val blockID = args.getOrNull(index + 1) ?: return@setExecutor false
                    val block = Material.matchMaterial(blockID)?.createBlockData() ?: return@setExecutor false
                    changes.add { piece -> piece.block = block }
                    continue
                }

                if (arg == "brightness") {
                    clause = "brightness"
                    val blockLight = args.getOrNull(index + 1)?.toIntOrNull() ?: 0
                    val skyLight = args.getOrNull(index + 2)?.toIntOrNull() ?: 15
                    val brightness = Display.Brightness(blockLight, skyLight)
                    changes.add { piece -> piece.brightness = brightness }
                    continue
                }

                if (arg == "scale") {
                    clause = "scale"
                    val x = args.getOrNull(index + 1)?.toFloatOrNull() ?: 1.0f
                    val y = args.getOrNull(index + 2)?.toFloatOrNull() ?: 1.0f
                    val z = args.getOrNull(index + 3)?.toFloatOrNull() ?: 1.0f
                    changes.add { piece -> piece.scale(x, y, z) }
                    continue
                }

                if (clause == "or") orGroups.last().add(arg)
            }


            fun matches(piece: BlockDisplayModelPiece): Boolean {
                return orGroups.any { andGroup ->
                    andGroup.all { selector ->
                        piece.block.material.key.toString() == selector ||
                                piece.tags.contains(selector)
                    }
                }
            }

            val pieces = getAllPieces().filter { matches(it) }

            pieces.forEach { piece -> changes.forEach { it(piece) } }

            sender.sendMessage("Modified ${pieces.size} blocks with ${changes.size} changes")

            return@setExecutor true
        }

        setTabCompleter { _, _, _, args ->
            val clauses = listOf("or", "to", "brightness")
            val clause = args.findLast { it in clauses } ?: "or"

            val tags = getAvailableTags()
            val materials = Material.entries.filter { it.isBlock }.map { it.key.toString() }

            var options = listOf<String>()

            if (clause == "or") options = tags + materials + clauses
            if (clause == "to") options = materials + clauses
            if (clause == "brightness") options = List(16) { it.toString() } + clauses
            if (clause == "scale") options = clauses

            return@setTabCompleter options.filter { it.contains(args.last(), true) }
        }
    }

    getCommand("torso_model").apply {
        setExecutor { _, _, _, args ->
            val option = args.getOrNull(0) ?: return@setExecutor false

            val model = SpiderTorsoModels.entries.find { it.name.equals(option, true) }?.model?.clone() ?: return@setExecutor false

            val currentScale = AppState.options.bodyPlan.scale.toFloat()
            AppState.options.bodyPlan.bodyModel = model.scale(currentScale)
            plugin.writeAndSaveConfig()

            return@setExecutor true
        }

        setTabCompleter { _, _, _, args ->
            return@setTabCompleter SpiderTorsoModels
                .entries.map { it.name.lowercase() }
                .filter { it.contains(args.last(), true) }
        }
    }

    getCommand("leg_model").apply {
        setExecutor { sender, _, _, args ->
            val option = args.getOrNull(0) ?: return@setExecutor false

            when (option) {
                "empty" -> applyEmptyLegModel(AppState.options.bodyPlan)
                "mechanical" -> applyMechanicalLegModel(AppState.options.bodyPlan)
                "line" -> {
                    val materialName = args.getOrNull(1) ?: "minecraft:netherite_block"
                    val material = Material.matchMaterial(materialName)?.createBlockData() ?: run {
                        sender.sendMessage("Invalid material: $materialName")
                        return@setExecutor true
                    }

                    applyLineLegModel(AppState.options.bodyPlan, material)
                }
                else -> {
                    sender.sendMessage("Invalid leg model: $option")
                    return@setExecutor true
                }
            }

            plugin.writeAndSaveConfig()

            sender.sendMessage("Set leg model to $option")

            return@setExecutor true
        }

        setTabCompleter { _, _, _, args ->
            var options = listOf<String>()

            if (args.size == 1) options = listOf("empty", "mechanical", "line")
            if (args.getOrNull(0) == "line") options = Material.entries.map { it.key.toString() }

            return@setTabCompleter options.filter { it.contains(args.last(), true) }
        }
    }

    getCommand("fall").setExecutor { sender, _, _, args ->
        val spider = AppState.spider ?: return@setExecutor true

        val height = args[0].toDoubleOrNull()

        if (height == null) {
            sender.sendMessage("Usage: /spider:fall <height>")
            return@setExecutor true
        }

        spider.teleport(spider.location().add(0.0, height, 0.0))


        return@setExecutor true
    }

    getCommand("preset").apply {
        val presets = mapOf(
            "biped" to ::biped,
            "quadruped" to ::quadruped,
            "hexapod" to ::hexapod,
            "octopod" to ::octopod,
            "quadbot" to ::quadBot,
            "hexbot" to ::hexBot,
            "octobot" to ::octoBot,
        )

        setExecutor { sender, _, _, args ->
            val name = args.getOrNull(0) ?: return@setExecutor false

            val segmentCount = args.getOrNull(1)?.toIntOrNull() ?: 4
            val segmentLength = args.getOrNull(2)?.toDoubleOrNull() ?: 1.0

            val createPreset = presets[name]
            if (createPreset == null) {
                sender.sendMessage("Invalid preset: $name")
                return@setExecutor true
            }

            AppState.options = createPreset(segmentCount, segmentLength)
            plugin.writeAndSaveConfig()

            AppState.recreateSpider()


            sender.sendMessage("Applied preset: $name")

            return@setExecutor true
        }

        setTabCompleter { _, _, _, args ->
            if (args.size == 1) {
                return@setTabCompleter presets.keys.filter { it.contains(args.last(), true) }
            }
            return@setTabCompleter emptyList()
        }
    }

    getCommand("scale").setExecutor { sender, _, _, args ->
        val scale = args[0].toDoubleOrNull()

        if (scale == null) {
            sender.sendMessage("Usage: /spider:scale <scale>")
            return@setExecutor true
        }

        val oldScale = AppState.options.bodyPlan.scale
        AppState.options.scale(scale / oldScale)

        plugin.writeAndSaveConfig()

        AppState.recreateSpider()

        sender.sendMessage("Set scale to $scale")

        return@setExecutor true
    }

    getCommand("items").setExecutor { sender, _, _, _ ->
        val player = sender as? org.bukkit.entity.Player ?: return@setExecutor true

        val inventory = createInventory(null, 9 * 3, "Items")
        for (item in CustomItemRegistry.items) {
            inventory.addItem(item.defaultItem.clone())
        }

        player.openInventory(inventory)

        return@setExecutor true
    }
}