plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "today.pathos.mvvm"
        minSdk = 23
        targetSdk = 31
        versionCode = 2
        versionName = "0.6.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        kapt {
            arguments {
                arg("room.schemaLocation", "${rootDir}/schemas")
            }
            javacOptions {
                option("-Xmaxerrs", 1000)
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.activity:activity-ktx:1.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIFE_CYCLE_VERSION}")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFE_CYCLE_VERSION}")
    implementation("androidx.room:room-runtime:${Version.ROOM_VERSION}")
    implementation("androidx.room:room-ktx:${Version.ROOM_VERSION}")
    implementation("androidx.room:room-rxjava3:${Version.ROOM_VERSION}")
    kapt("androidx.room:room-compiler:${Version.ROOM_VERSION}")

    // RxJava
    implementation("io.reactivex.rxjava3:rxjava:3.1.3")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    // DI
    implementation("com.google.dagger:hilt-android:${Version.HILT_VERSION}")
    kapt("com.google.dagger:hilt-android-compiler:${Version.HILT_VERSION}")
    kapt("androidx.hilt:hilt-compiler:${Version.HILT_ANDROIDX_VERSION}")

    // Testing
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:${Version.HILT_VERSION}")
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.3")
    androidTestImplementation("androidx.test:rules:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.arch.core:core-testing:${Version.CORE_TESTING_VERSION}")
    androidTestImplementation("org.mockito:mockito-android:4.1.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:${Version.HILT_VERSION}")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-inline:4.1.0")
    testImplementation("io.mockk:mockk:1.12.1")
    testImplementation("androidx.arch.core:core-testing:${Version.CORE_TESTING_VERSION}")
    testImplementation("androidx.room:room-testing:${Version.ROOM_VERSION}")


}