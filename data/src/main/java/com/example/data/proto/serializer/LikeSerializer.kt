package com.example.data.proto.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.example.data.LikePreferences
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object LikeSerializer : Serializer<LikePreferences> {
    override val defaultValue: LikePreferences
        get() = LikePreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): LikePreferences {
        try {
            return LikePreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: LikePreferences, output: OutputStream) = t.writeTo(output)
}