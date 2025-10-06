package extensions.utils

import android.content.SharedPreferences
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class PreferenceDelegate<T>(
    private val key: String,
    private val defaultValue: T,
) : ReadOnlyProperty<SharedPreferences, T> {

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): T {
        return when (defaultValue) {
            is String -> thisRef.getString(key, defaultValue) as T
            is Int -> thisRef.getInt(key, defaultValue) as T
            is Long -> thisRef.getLong(key, defaultValue) as T
            is Float -> thisRef.getFloat(key, defaultValue) as T
            is Boolean -> thisRef.getBoolean(key, defaultValue) as T
            else -> throw IllegalArgumentException("Unsupported preference type")
        }
    }
}

fun <T> SharedPreferences.delegate(key: String, defaultValue: T): PreferenceDelegate<T> {
    return PreferenceDelegate(key, defaultValue)
}