package com.heledron.spideranimation.spider.presets

import com.heledron.spideranimation.utilities.BlockDisplayModelPiece
import com.heledron.spideranimation.utilities.DisplayModel
import com.heledron.spideranimation.utilities.parseModelFromCommand
import org.bukkit.Material
import org.joml.Matrix4f
import org.joml.Quaternionf
import org.joml.Vector3f
import kotlin.math.atan2
import kotlin.math.sqrt

enum class SpiderTorsoModels(val model: DisplayModel) {
    EMPTY(DisplayModel.empty()),

    FLAT(
        parseModelFromCommand(
        """/summon block_display ~-0.5 ~ ~-0.5 {Passengers:[{id:"minecraft:block_display",block_state:{Name:"minecraft:polished_deepslate_slab",Properties:{type:"bottom"}},transformation:[0f,0f,0.75f,-0.375f,0f,0.9375f,0f,-0.2906f,-0.9375f,0f,0f,0.375f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:netherite_block",Properties:{}},transformation:[0f,0f,0.625f,-0.3125f,0f,0.4375f,0f,-0.2281f,-1.8125f,0f,0f,0.75f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:anvil",Properties:{facing:"east"}},transformation:[0.861f,0f,0f,-0.4306f,0f,0.6875f,0f,-0.5275f,0f,0f,0.6875f,-0.6875f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:anvil",Properties:{facing:"east"}},transformation:[0.861f,0f,0f,-0.4306f,0f,0.6875f,0f,-0.5275f,0f,0f,0.6875f,-0.1875f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.1171f,0f,0f,0.1756f,0f,0.0301f,0.0288f,0.3546f,0f,-0.0016f,0.5492f,-0.871f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:gray_concrete",Properties:{}},transformation:[0.1171f,0f,0f,-0.1171f,0f,0.0099f,0.0052f,0.3755f,0f,-0.0005f,0.0999f,-0.4715f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:gray_concrete",Properties:{}},transformation:[0.0585f,0f,0f,-0.0585f,0f,0.0099f,0.0026f,0.3703f,0f,-0.0005f,0.0499f,-0.5714f,0f,0f,0f,1f],Tags:["blinking_lights"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:gray_concrete",Properties:{}},transformation:[0.0585f,0f,0f,-0.0585f,0f,0.0099f,0.0026f,0.3675f,0f,-0.0005f,0.0499f,-0.6714f,0f,0f,0f,1f],Tags:["blinking_lights"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0.3513f,0f,0f,-0.1756f,0f,0.0076f,0.0288f,0.3546f,0f,-0.0004f,0.5492f,-0.871f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.3513f,0f,0f,-0.3513f,0f,0.4574f,0.034f,-0.1394f,0f,-0.024f,0.6491f,-1.546f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.1171f,0f,0f,-0.2927f,0f,0.0301f,0.0288f,0.3394f,0f,-0.0016f,0.5492f,-0.8702f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.3513f,0f,0f,-0.3513f,0f,0.4574f,0.034f,-0.1054f,0f,-0.024f,0.6491f,-0.8969f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.3513f,0f,0f,0f,0f,0.4574f,0.034f,-0.1394f,0f,-0.024f,0.6491f,-1.546f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.3513f,0f,0f,0f,0f,0.4574f,0.034f,-0.1054f,0f,-0.024f,0.6491f,-0.8969f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[-0.221f,0f,0.221f,-0.4375f,0f,0.3125f,0f,-0.0406f,-0.5169f,0f,-0.5169f,-0.25f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.625f,-0.3125f,0.0702f,0.1703f,0f,0.0995f,-0.5863f,0.0522f,0f,1.2713f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.317f,-0.1882f,0f,0.3113f,0f,0f,0.4375f,-0.1658f,-0.8823f,-0.0676f,0f,1.2813f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.25f,-0.475f,0.205f,0.2542f,0f,-0.1658f,-0.3282f,0.4065f,0f,0.3619f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.5f,-0.5012f,0.3019f,0f,0f,0.0381f,0f,0.698f,0f,0.0369f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[-0.3206f,0f,0.1879f,-0.3137f,0f,0.4375f,0f,-0.1658f,-0.881f,0f,-0.0684f,1.2813f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.245f,0.25f,0.205f,0.2542f,0f,-0.1658f,-0.3282f,0.4065f,0f,0.3619f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.5f,0f,0.3019f,0f,0f,0.0381f,0f,0.698f,0f,0.0369f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[-0.221f,0f,0.221f,0.4375f,0f,0.3125f,0f,-0.0406f,-0.5169f,0f,-0.5169f,-0.25f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.5f,0f,0f,-0.5f,0f,0.4219f,0f,-0.1037f,0f,0f,0.625f,-1.4375f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.875f,-0.4425f,0f,0.403f,0f,-0.1031f,-0.5f,0f,0f,0.3125f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:netherite_block",Properties:{}},transformation:[0f,0f,0.375f,-0.1925f,0f,0.3125f,0f,-0.1656f,-0.4375f,0f,0f,1.0556f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:netherite_block",Properties:{}},transformation:[-0.1615f,0f,0f,0.0806f,0f,0f,0.1615f,-0.0762f,0f,0.1615f,0f,0.9187f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.04f,-0.13f,0.04f,0f,0f,-0.1388f,0f,0.125f,0f,0.9406f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.04f,-0.0675f,0.04f,0f,0f,-0.1388f,0f,0.125f,0f,0.9406f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.125f,-0.005f,0.04f,0f,0f,-0.1388f,0f,0.125f,0f,0.9406f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:cyan_shulker_box",Properties:{}},transformation:[0f,0f,0.123f,-0.0619f,0.122f,0f,0f,-0.0569f,0f,0.125f,0f,0.9844f,0f,0f,0f,1f],brightness:{sky:15,block:15},Tags:["eye"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.5f,0f,0f,-0.5f,0f,0.4219f,0f,-0.1037f,0f,0f,0.625f,-0.8125f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.5f,0f,0f,0f,0f,0.4219f,0f,-0.1037f,0f,0f,0.625f,-1.4375f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.5f,0f,0f,0f,0f,0.4219f,0f,-0.1037f,0f,0f,0.625f,-0.8125f,0f,0f,0f,1f]}]}"""
    ).apply {
        scale(.8f)
        pieces.forEach {
            it.tags += "torso"
            if (it.block.material == Material.SMOOTH_QUARTZ) it.tags += "cloak"
            if (it.tags.contains("cloak")) it.block = org.bukkit.Material.WHITE_CONCRETE.createBlockData()
        }
    }),

    BOXY(
        parseModelFromCommand(
        command = """/summon block_display ~-0.5 ~ ~-0.5 {Passengers:[{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.1f,0f,0f,0.15f,0f,0.0427f,0.0288f,0.4922f,0f,-0.0022f,0.5492f,-0.8771f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:gray_concrete",Properties:{}},transformation:[0.1f,0f,0f,-0.1f,0f,0.014f,0.0052f,0.5131f,0f,-0.0007f,0.0999f,-0.4777f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:gray_concrete",Properties:{}},transformation:[0.05f,0f,0f,-0.05f,0f,0.014f,0.0026f,0.5079f,0f,-0.0007f,0.0499f,-0.5775f,0f,0f,0f,1f],Tags:["blinking_lights"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:gray_concrete",Properties:{}},transformation:[0.05f,0f,0f,-0.05f,0f,0.014f,0.0026f,0.5062f,0f,-0.0007f,0.0499f,-0.6776f,0f,0f,0f,1f],Tags:["blinking_lights"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0.3f,0f,0f,-0.15f,0f,0.0108f,0.0288f,0.4922f,0f,-0.0006f,0.5492f,-0.8771f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.1f,0f,0f,-0.25f,0f,0.0427f,0.0288f,0.4707f,0f,-0.0022f,0.5492f,-0.876f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.3f,0f,0f,-0.3f,0f,0.6491f,0.034f,-0.1936f,0f,-0.034f,0.6491f,-1.5421f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.3f,0f,0f,-0.3f,0f,0.6491f,0.0366f,-0.1595f,0f,-0.034f,0.699f,-0.893f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.3f,0f,0f,0f,0f,0.6491f,0.034f,-0.1936f,0f,-0.034f,0.6491f,-1.5421f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.3f,0f,0f,0f,0f,0.6491f,0.0366f,-0.1595f,0f,-0.034f,0.699f,-0.893f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.625f,-0.3125f,0.1124f,0.2578f,0f,0.1663f,-0.5863f,0.0494f,0f,1.2794f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.0817f,-0.1868f,0f,0.375f,0f,0f,0.7f,-0.2863f,-0.9339f,-0.0163f,0f,1.2844f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.25f,-0.435f,0.328f,0.3625f,0f,-0.2863f,-0.3282f,0.3623f,0f,0.365f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.4375f,-0.4375f,0.483f,0f,0f,0.04f,0f,0.698f,0f,0.04f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[-0.0817f,0f,0.1868f,-0.375f,0f,0.7f,0f,-0.2863f,-0.9339f,0f,-0.0163f,1.2844f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.245f,0.185f,0.328f,0.3625f,0f,-0.2863f,-0.3282f,0.3623f,0f,0.365f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0f,0f,0.4375f,0f,0.483f,0f,0f,0.04f,0f,0.698f,0f,0.04f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:netherite_block",Properties:{}},transformation:[0f,0f,0.375f,-0.1925f,0f,0.375f,0f,-0.1875f,-0.4375f,0f,0f,1.0588f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:netherite_block",Properties:{}},transformation:[-0.1615f,0f,0f,0.0806f,0f,0f,0.1615f,-0.0819f,0f,0.1615f,0f,0.9219f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.04f,-0.13f,0.04f,0f,0f,-0.1412f,0f,0.125f,0f,0.9437f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.04f,-0.0675f,0.04f,0f,0f,-0.1412f,0f,0.125f,0f,0.9437f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.125f,-0.005f,0.04f,0f,0f,-0.1412f,0f,0.125f,0f,0.9437f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:polished_deepslate_slab",Properties:{type:"bottom"}},transformation:[0f,0f,0.75f,-0.3675f,0f,0.9375f,0f,-0.3125f,-0.9375f,0f,0f,0.3781f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:netherite_block",Properties:{}},transformation:[0f,0f,0.625f,-0.3125f,0f,0.5f,0f,-0.25f,-1.8125f,0f,0f,0.7531f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.4375f,0f,0f,-0.4375f,0f,0.5469f,0f,-0.1256f,0f,0f,0.625f,-1.4344f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.761f,-0.3806f,0f,0.403f,0f,-0.0138f,-0.5f,0f,0f,0.3156f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:anvil",Properties:{facing:"east"}},transformation:[0.736f,0f,0f,-0.375f,0f,-0.6875f,0f,0.0625f,0f,0f,-0.6875f,0.5031f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:anvil",Properties:{facing:"east"}},transformation:[0.736f,0f,0f,-0.375f,0f,-0.6875f,0f,0.0625f,0f,0f,-0.6875f,0.0031f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:cyan_shulker_box",Properties:{}},transformation:[0f,0f,0.123f,-0.0619f,0.122f,0f,0f,-0.0625f,0f,0.125f,0f,0.9875f,0f,0f,0f,1f],brightness:{sky:15,block:15},Tags:["eye"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.4375f,0f,0f,-0.4375f,0f,0.5469f,0f,-0.1256f,0f,0f,0.6875f,-0.8125f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.4375f,0f,0f,0f,0f,0.5469f,0f,-0.1256f,0f,0f,0.625f,-1.4344f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:smooth_quartz",Properties:{}},transformation:[0.4375f,0f,0f,0f,0f,0.5469f,0f,-0.1256f,0f,0f,0.6875f,-0.8125f,0f,0f,0f,1f]}]}"""
    ).apply {
        scale(.75f)
        pieces.forEach {
            it.tags += "torso"
            if (it.block.material == Material.SMOOTH_QUARTZ) it.tags += "cloak"
            if (it.tags.contains("cloak")) it.block = org.bukkit.Material.WHITE_CONCRETE.createBlockData()
        }
    }),

    STEALTH(
        parseModelFromCommand(
        command = """/summon block_display ~-0.5 ~ ~-0.5 {Passengers:[{id:"minecraft:block_display",block_state:{Name:"minecraft:netherite_block",Properties:{}},transformation:[0f,-0.221f,0.221f,-0.0106f,0f,0.221f,0.221f,-0.2125f,-0.8125f,0f,0f,1.2056f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:gray_shulker_box",Properties:{}},transformation:[0f,0f,0.125f,-0.0731f,0.125f,0f,0f,-0.0581f,0f,0.125f,0f,1.0875f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:cyan_shulker_box",Properties:{}},transformation:[-0.0424f,0f,0.0424f,-0.0106f,0.0424f,0f,0.0424f,-0.04f,0f,0.125f,0f,1.0906f,0f,0f,0f,1f],Tags:["eye"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.375f,-0.1981f,0.1683f,0.1799f,0f,0.275f,-0.5728f,0.0528f,0f,1.5025f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0.2588f,-0.1811f,0f,0.3019f,0f,0f,0.4885f,-0.2519f,-0.9659f,-0.0485f,0f,1.5488f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[-0.0915f,0.1258f,0.2415f,-0.5106f,0.3535f,0.4862f,0f,-0.2519f,-0.3416f,0.4695f,-0.0647f,0.6369f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[-0.2542f,0f,0.1811f,-0.3231f,0f,0.4885f,0f,-0.2519f,-0.9485f,0f,-0.0485f,1.5562f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0.0915f,-0.1258f,0.2415f,0.2394f,0.3535f,0.4862f,0f,-0.2519f,-0.3416f,0.4695f,0.0647f,0.6369f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.5f,-0.2606f,0.2788f,-0.0268f,0f,0.3731f,0.0107f,0.6975f,0f,0.3119f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[-0.2415f,0.2731f,0.1279f,-0.3856f,0.1411f,0.274f,-0.1308f,0.1856f,-1.1998f,-0.0227f,-0.0411f,1.5562f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0.2496f,-0.1277f,-0.2731f,0.3644f,0.1479f,-0.1307f,0.274f,0.1856f,-1.2159f,-0.0421f,-0.0227f,1.5563f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.375f,-0.3856f,-0.0784f,0.808f,0f,-0.139f,-0.7459f,-0.0849f,0f,0.0852f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.125f,-0.3231f,-0.1241f,0.0597f,0f,0.6489f,-1.181f,-0.0063f,0f,-0.1861f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.125f,0.1769f,-0.1241f,0.0597f,0f,0.6489f,-1.181f,-0.0063f,0f,-0.1861f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.125f,-0.1356f,-0.0131f,0.0174f,0f,0.6361f,-0.1243f,-0.0018f,0f,-0.3073f,0f,0f,0f,1f],Tags:["cloak"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.0625f,-0.0731f,-0.0065f,0.0174f,0f,0.61f,-0.0622f,-0.0018f,0f,-0.556f,0f,0f,0f,1f],Tags:["cloak"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.0625f,-0.0731f,-0.0065f,0.0174f,0f,0.5966f,-0.0622f,-0.0018f,0f,-0.6834f,0f,0f,0f,1f],Tags:["cloak"]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.375f,-0.0106f,-0.0784f,0.808f,0f,-0.139f,-0.7459f,-0.0849f,0f,0.0852f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.375f,-0.3856f,-0.0784f,0.808f,0f,-0.2174f,-0.7459f,-0.0849f,0f,-0.6607f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.375f,-0.0106f,-0.0784f,0.808f,0f,-0.2174f,-0.7459f,-0.0849f,0f,-0.6607f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0.4421f,0f,0.4418f,-0.125f,0f,0.5625f,0f,-0.125f,-0.5301f,0f,0.5305f,-0.5f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0.4421f,0f,0.4418f,-0.75f,0f,0.5625f,0f,-0.125f,-0.5301f,0f,0.5305f,-0.5f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.5f,-0.5f,0f,0.7031f,0f,-0.1906f,-0.625f,0f,0f,0.125f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.75f,-0.3856f,0f,0.5495f,0f,-0.1894f,-0.6875f,0f,0f,0.5875f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.5f,-0.2606f,0f,0.5625f,0f,-0.1894f,-0.75f,0f,0f,1.15f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_shulker_box",Properties:{}},transformation:[0f,0f,0.5f,-0.2606f,0f,0.332f,0f,0.1231f,-0.6875f,0f,0f,0.5875f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:anvil",Properties:{facing:"east"}},transformation:[0.861f,0f,0f,-0.4306f,0f,0.6875f,0f,-0.4869f,0f,0f,0.6875f,-0.5938f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:anvil",Properties:{facing:"east"}},transformation:[0.861f,0f,0f,-0.4306f,0f,-0.6875f,0f,0.2006f,0f,0f,-0.6875f,0.5938f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.5f,-0.5f,0f,0.7031f,0f,-0.1906f,-0.75f,0f,0f,-0.5f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.5f,-0.0625f,0f,0.7031f,0f,-0.1906f,-0.625f,0f,0f,0.125f,0f,0f,0f,1f]},{id:"minecraft:block_display",block_state:{Name:"minecraft:black_concrete",Properties:{}},transformation:[0f,0f,0.5f,-0.0625f,0f,0.7031f,0f,-0.1906f,-0.75f,0f,0f,-0.5f,0f,0f,0f,1f]}]}"""
    ).apply {
        this.scale(.8f)
        this.pieces.forEach {
            it.tags += "torso"
            if (it.block.material == Material.BLACK_CONCRETE) it.tags += "cloak"
            if (it.tags.contains("cloak")) it.block = org.bukkit.Material.WHITE_CONCRETE.createBlockData()
        }
    })
}