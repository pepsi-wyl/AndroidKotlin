plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "site.ylan.sunnyweather"
    compileSdk = 34

    defaultConfig {
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions.add("version")

    productFlavors {
        create("dev") {
            dimension = "version"

            applicationId = "site.ylan.sunnyweather.dev"

            buildConfigField("int", "LOG_LEVEL", "1")

            buildConfigField("String", "WEATHER_BASE_URL", "\"https://api.caiyunapp.com\"")
            buildConfigField("String", "WEATHER_TOKEN", "\"JFjz6EKZtKYqSeVB\"")
        }
        create("sit") {
            dimension = "version"

            applicationId = "site.ylan.sunnyweather.sit"

            buildConfigField("int", "LOG_LEVEL", "3")

            buildConfigField("String", "WEATHER_BASE_URL", "\"https://api.caiyunapp.com\"")
            buildConfigField("String", "WEATHER_TOKEN", "\"JFjz6EKZtKYqSeVB\"")
        }
        create("prod") {
            dimension = "version"

            applicationId = "site.ylan.sunnyweather.prod"

            buildConfigField("int", "LOG_LEVEL", "5")

            buildConfigField("String", "WEATHER_BASE_URL", "\"https://api.caiyunapp.com\"")
            buildConfigField("String", "WEATHER_TOKEN", "\"JFjz6EKZtKYqSeVB\"")
        }
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/java")
            res.srcDirs("src/main/res")
            manifest.srcFile("src/main/AndroidManifest.xml")
            assets.srcDirs("src/main/assets")
            jniLibs.srcDirs("src/main/jniLibs")
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
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    implementation("androidx.lifecycle:lifecycle-livedata:2.8.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.8.2")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.work:work-runtime:2.8.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
}