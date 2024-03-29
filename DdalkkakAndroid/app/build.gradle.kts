import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    id("kotlin-kapt")
//    id("com.google.gms.google-services")
}

fun getBaseUrl(url: String): String {
    val properties = Properties()
    val inputStream = FileInputStream("local.properties")
    properties.load(inputStream)
    return properties.getProperty(url)
}


android {
    namespace = "com.example.ddalkkak_android"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ddalkkak_android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        //base_url
        buildConfigField("String", "BASE_URL", getBaseUrl("base_url"))
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation ("androidx.room:room-runtime:2.6.1")
    annotationProcessor("androidx.room:room-compiler:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // SavedState
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0")

    // Okhttp
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    //Moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation("com.squareup.moshi:moshi:1.12.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.12.0")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Android KTX
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation("androidx.activity:activity-ktx:1.8.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    //ViewModel
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")

    //gson
    implementation("com.google.code.gson:gson:2.10.1")

    //Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    //coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

kapt {
    correctErrorTypes = true
}