plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "ru.code.codeworkers"
    compileSdk = 34

    buildFeatures.viewBinding = true
    buildFeatures.buildConfig = true

    defaultConfig {
        applicationId = "ru.code.codeworkers"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    testImplementation ("android.arch.core:core-testing:1.1.1")
    implementation ("androidx.activity:activity-ktx:1.9.0")
    implementation ("androidx.fragment:fragment-ktx:1.6.2")
    implementation ("androidx.core:core-ktx:1.13.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation ("com.google.android.material:material:1.11.0")
    implementation ("androidx.room:room-runtime:2.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.android.material:material:1.11.0")
    implementation(platform("com.google.firebase:firebase-bom:32.7.3"))
    implementation("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-messaging-ktx:23.4.1")
    implementation ("com.google.android.gms:play-services-base:18.4.0")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("com.squareup.retrofit2:retrofit:2.10.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.10.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")
}