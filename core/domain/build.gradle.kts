plugins {
    id("pollochon.android.library")
    id("pollochon.android.koin")
}

android {
    namespace = "fr.alefaux.pollochon.core.domain"

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
    implementation(project(":core:data"))

    implementation(libs.kotlinx.coroutines.android)
}
