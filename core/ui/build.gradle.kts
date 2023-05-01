plugins {
    id("pollochon.android.library")
    id("pollochon.android.library.compose")
}

android {
    namespace = "fr.alefaux.pollochon.core.ui"

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
    implementation(project(":core:designsystem"))

    implementation(libs.androidx.core)
    api(libs.androidx.compose.material)
    api(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.tooling.preview)
    debugImplementation(libs.androidx.compose.tooling)
    implementation(libs.androidx.compose.runtime.livedata)

    api(libs.coil.compose)
}
