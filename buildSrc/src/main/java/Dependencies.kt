
object Versions {
    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlin = "1.5.30"
    const val kotlinCoroutines = "1.5.0-native-mt"
    const val material = "1.3.0"
    const val appcompat = "1.2.0"
    const val constraintLayout = "2.0.4"

    const val ndkVersion = "23.0.7599858"

    const val gradlePlugin = "4.2.2"

    const val junit = "4.+"
    const val extJunit = "1.1.3"
    const val espresso = "3.4.0"

    const val coreKtx = "1.7.0"
    const val lifecycleVersion = "2.3.1"
    const val activityKtx = "1.3.0"
    const val fragmentKtx = "1.3.0"

    const val gson = "2.8.2"

    const val retrofit = "2.9.0"
    const val converterGson = "2.9.0"
    const val converterScalars = "2.9.0"

    const val loggingInterceptor = "4.9.1"
    const val okhttp = "4.0.0"

    const val hiltAndroid = "2.40"

    const val glide = "4.10.0"

}

object App {
    const val id = "com.android.movieapp"
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
}

object AndroidSdk {
    const val min = 21
    const val compile = 31
    const val target = compile
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
}

object ImageLoader {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object DI {
    const val hiltAndroidGradle =  "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltAndroid}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
}

object Retrofit2 {
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.converterGson}"
    const val converterScalars = "com.squareup.retrofit2:converter-scalars:${Versions.converterScalars}"

    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val okhttp = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.okhttp}"
}

object Kotlin {
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object TestLib {
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val junitRunner = "androidx.test.runner.AndroidJUnitRunner"
}