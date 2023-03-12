plugins {
    id("pollochon.android.application")
    id("pollochon.android.application.compose")
    id("pollochon.android.application.firebase")
    id("kotlin-parcelize")
}

android {
    defaultConfig {
        applicationId = "fr.alefaux.pollochon"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }

    namespace = "fr.alefaux.pollochon"
}

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:designsystem"))

    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso)

    // Navigation Component
    implementation(libs.androidx.navigation.compose)

    // Timber
    implementation(libs.timber)

    // Koin
    implementation(libs.koin.compose)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.interceptor)

    // Preference
    implementation(libs.androidx.preference)

    // LiveData
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.extensions)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.lifecycle.livedata)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.auth)

    // SplashScreen
    implementation(libs.androidx.core.splashscreen)
}
