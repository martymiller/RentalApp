plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
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
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(Libs.appcompat)
    api(Libs.constraintLayout)
    api(Libs.koin)
    api(Libs.lifecycleExtensions)
    api(Libs.lifecycleLiveData)
    api(Libs.lifecycleViewModel)
    api(Libs.loggingInterceptor)
    api(Libs.navigationFragment)
    api(Libs.navigationUI)
    api(Libs.okHttp)
    api(Libs.picasso)
    api(Libs.retroFit)
    api(Libs.retroFitGsonConverter)
    api(Libs.rxAndroid)
    api(Libs.rxBinding)
    implementation(Libs.rxCallAdapter)
    api(Libs.rxJava)
    api(Libs.rxRelay)
    api(Libs.timber)
    //api("androidx.core:core-ktx:1.3.0")
    //implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testApi(Libs.koinTest)
    testApi("junit:junit:4.12")
    androidTestApi("androidx.test.ext:junit:1.1.1")
    androidTestApi("androidx.test.espresso:espresso-core:3.2.0")
}
