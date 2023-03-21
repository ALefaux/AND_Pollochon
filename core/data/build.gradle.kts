plugins {
    id("pollochon.android.library")
    id("pollochon.android.koin")
}

android {
    namespace = "fr.alefaux.pollochon.core.data"

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
    implementation(project(":core:datastore"))
    implementation(project(":core:model"))
}
