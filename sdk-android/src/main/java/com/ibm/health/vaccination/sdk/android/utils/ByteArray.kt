package com.ibm.health.vaccination.sdk.android.utils

/** Converts this ByteArray to its hexadecimal representation. */
internal fun ByteArray.toHex(separator: String = " "): String =
    joinToString(separator) { it.toUByte().toString(16).padStart(2, '0') }

/** Converts hexadecimal string to ByteArray. */
internal fun String.fromHex(): ByteArray =
    replace(whitespaceRegex, "")
        .chunkedSequence(2).map { it.toInt(16).toByte() }.toList().toByteArray()

private val whitespaceRegex = Regex("""\s+""")