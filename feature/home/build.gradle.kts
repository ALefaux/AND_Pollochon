plugins {
    id("pollochon.android.feature")
    id("pollochon.android.library.compose")
}

android {
    namespace = "fr.alefaux.pollochon.feature.home"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}
