package net.stellarica.nbt

import net.minecraft.nbt.ByteArrayTag
import net.minecraft.nbt.ByteTag
import net.minecraft.nbt.DoubleTag
import net.minecraft.nbt.FloatTag
import net.minecraft.nbt.IntArrayTag
import net.minecraft.nbt.IntTag
import net.minecraft.nbt.LongArrayTag
import net.minecraft.nbt.LongTag
import net.minecraft.nbt.NbtUtils
import net.minecraft.nbt.ShortTag
import net.minecraft.nbt.StringTag
import java.util.UUID

fun Boolean.toNbt(): ByteTag = ByteTag.valueOf(this)
fun Byte.toNbt(): ByteTag = ByteTag.valueOf(this)
fun Short.toNbt(): ShortTag = ShortTag.valueOf(this)
fun Int.toNbt(): IntTag = IntTag.valueOf(this)
fun Long.toNbt(): LongTag = LongTag.valueOf(this)
fun Float.toNbt(): FloatTag = FloatTag.valueOf(this)
fun Double.toNbt(): DoubleTag = DoubleTag.valueOf(this)
fun Char.toNbt(): IntTag = IntTag.valueOf(code)
fun String.toNbt(): StringTag = StringTag.valueOf(this)

fun ByteArray.toNbt() = ByteArrayTag(this)
fun List<Byte>.toNbt() = ByteArrayTag(this)
fun IntArray.toNbt() = IntArrayTag(this)
fun List<Int>.toNbt() = IntArrayTag(this)
fun LongArray.toNbt() = LongArrayTag(this)
fun List<Long>.toNbt() = LongArrayTag(this)

fun UUID.toNbt(): IntArrayTag = NbtUtils.createUUID(this)
