plugins {
    id("pollochon.android.library")
    id("pollochon.android.koin")
    kotlin("plugin.serialization") version "1.8.10"
}

android {
    namespace = "fr.alefaux.pollochon.core.network"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":core:model"))

    implementation(libs.retrofit)
    implementation(libs.retrofit.interceptor)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.serialization.converter)
}
