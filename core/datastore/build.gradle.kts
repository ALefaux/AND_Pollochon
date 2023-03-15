plugins {
    id("pollochon.android.library")
    id("pollochon.android.koin")
}

android {
    namespace = "fr.alefaux.pollochon.core.datastore"

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
    implementation(libs.androidx.datastore.preferences)
}
