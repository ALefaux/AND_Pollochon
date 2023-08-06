plugins {
    id("pollochon.android.feature")
    id("pollochon.android.library.compose")
}

android {
    namespace = "fr.alefaux.pollochon.feature.survey.create"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}
