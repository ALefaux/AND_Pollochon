plugins {
    id("pollochon.android.feature")
    id("pollochon.android.library.compose")
}

android {
    namespace = "fr.alefaux.pollochon.feature.profile"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}
