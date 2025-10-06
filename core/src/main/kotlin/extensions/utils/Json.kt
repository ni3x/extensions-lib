package extensions.utils

// From https://github.com/keiyoushi/extensions-source/blob/main/core/src/main/kotlin/keiyoushi/utils/Json.kt

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.InputStream

inline fun <reified T> Response.parseAs(): T {
    return body.byteStream().parseAs()
}

inline fun <reified T> InputStream.parseAs(): T {
    return Json.decodeFromStream(this)
}

inline fun <reified T> String.parseAs(): T {
    return Json.decodeFromString(this)
}

fun Any.toRequestBody(): RequestBody {
    val json = Json.encodeToString(kotlinx.serialization.serializer(this::class.java), this)
    return json.toRequestBody("application/json".toMediaType())
}