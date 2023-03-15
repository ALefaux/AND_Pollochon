plugins {
    id("pollochon.android.feature")
    id("pollochon.android.library.compose")
}
android {
    namespace = "fr.alefaux.pollochon.feature.login"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    dependencies {
        // Firebase
        implementation(platform(libs.firebase.bom))
        implementation(libs.firebase.auth)
        implementation(libs.firebase.auth.google)

        implementation(libs.kotlinx.coroutines.play.services)
    }
}
