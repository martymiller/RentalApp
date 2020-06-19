object Apps {
    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Libs {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val koin = "org.koin:koin-android:${Versions.koin}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.androidLifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-core-ktx:${Versions.androidLifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val retroFit = "com.squareup.retrofit2:retrofit:${Versions.retroFit}"
    const val retroFitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retroFit}"
    const val rxCallAdapter = "com.github.akarnokd:rxjava3-retrofit-adapter:${Versions.rxCallAdapter}"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid}"
    const val rxBinding = "com.jakewharton.rxbinding4:rxbinding:${Versions.rxBinding}"
    const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"
    const val rxRelay = "com.jakewharton.rxrelay3:rxrelay:${Versions.rxRelay}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
}

private object Versions {
    const val androidLifecycle = "2.2.0"
    const val appcompat = "1.0.2"
    const val constraintLayout = "1.1.3"
    const val glide = "4.11.0"
    const val gradle = "4.0.0"
    const val koin = "2.1.5"
    const val kotlinGradlePlugin = "1.3.50"
    const val navigation = "2.2.2"
    const val okHttp = "4.7.2"
    const val retroFit = "2.9.0"
    const val rxAndroid = "3.0.0"
    const val rxBinding = "4.0.0"
    const val rxCallAdapter = "3.0.0"
    const val rxJava = "3.0.4"
    const val rxRelay = "3.0.0"
    const val timber = "4.7.1"

    /* test */
    const val junit = "4.12"
}
