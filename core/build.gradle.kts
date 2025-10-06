plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)
    kotlin("plugin.serialization")
}

android {
    compileSdk = AndroidConfig.COMPILE_SDK
    namespace = "extensions.utils"

    defaultConfig {
        minSdk = AndroidConfig.MIN_SDK
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    api(libs.extensions.lib)
    api(libs.injekt.core)
    api(libs.coroutines)
    api(libs.kotlin.json)
    api(libs.kotlin.json.okio)
    api(libs.jsoup)
    api(libs.okhttp)
}