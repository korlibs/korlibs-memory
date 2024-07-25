@file:Suppress("PackageDirectoryMismatch")

package korlibs.memory.internal

/** Returns the float representation of [this] memory bits */
internal inline fun Int.reinterpretAsFloat(): Float = Float.fromBits(this)
/** Returns the float representation of [this] memory bits */
internal inline fun Long.reinterpretAsDouble(): Double = Double.fromBits(this)

/** Returns the bits in memory of [this] float */
internal inline fun Float.reinterpretAsInt(): Int = this.toRawBits()
/** Returns the bits in memory of [this] float */
internal inline fun Double.reinterpretAsLong(): Long = this.toRawBits()

/** Extracts [count] bits at [offset] from [this] [Int] */
internal fun Int.extract(offset: Int, count: Int): Int = (this ushr offset) and ((1 shl count) - 1)
/** Extracts 4 bits at [offset] from [this] [Int] */
internal inline fun Int.extract4(offset: Int): Int = (this ushr offset) and 0b1111
/** Extracts 8 bits at [offset] from [this] [Int] as [Byte] */
internal fun Int.extractByte(offset: Int): Byte = (this ushr offset).toByte()

/** Takes n[bits] of [this] [Int], and extends the last bit, creating a plain [Int] in one's complement */
internal fun Int.signExtend(bits: Int): Int = (this shl (32 - bits)) shr (32 - bits) // Int.SIZE_BITS
