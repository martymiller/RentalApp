plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("kotlin-android")
}

android {
    compileSdkVersion(Apps.compileSdk)
    buildToolsVersion("29.0.3")
    buildFeatures { viewBinding = true }
    kotlinOptions { jvmTarget = "1.8" }

    defaultConfig {
        applicationId = "com.marty.rentalapp"
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            consumerProguardFile("proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            consumerProguardFile("proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.appcompat)
    implementation(Libs.constraintLayout)
    implementation(Libs.glide)
    implementation(Libs.koin)
    implementation(Libs.lifecycleExtensions)
    implementation(Libs.lifecycleLiveData)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.loggingInterceptor)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUI)
    implementation(Libs.okHttp)
    implementation(Libs.retroFit)
    implementation(Libs.retroFitGsonConverter)
    implementation(Libs.rxAndroid)
    implementation(Libs.rxBinding)
    implementation(Libs.rxCallAdapter)
    implementation(Libs.rxJava)
    implementation(Libs.rxRelay)
    implementation(Libs.timber)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation(Libs.koinTest)
    testImplementation("junit:junit:4.12")
    annotationProcessor(Libs.glideCompiler)
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
