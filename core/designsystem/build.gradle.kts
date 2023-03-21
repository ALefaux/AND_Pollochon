plugins {
    id("pollochon.android.library")
    id("pollochon.android.library.compose")
}

android {
    namespace = "fr.alefaux.pollochon.core.designsystem"

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
    api(libs.androidx.compose.material)
    api(libs.androidx.compose.tooling.preview)
    debugApi(libs.androidx.compose.tooling)
}
