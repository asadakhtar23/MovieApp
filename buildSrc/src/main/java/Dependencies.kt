
object Versions {
    const val versionCode = 1
    const val versionName = "1.0"

    const val kotlin = "1.5.30"
    const val material = "1.3.0"
    const val appcompat = "1.2.0"
    const val constraintLayout = "2.0.4"

    const val gradlePlugin = "4.2.2"

    const val junit = "4.+"
    const val extJunit = "1.1.3"
    const val espresso = "3.4.0"

    const val coreKtx = "1.7.0"
    const val lifecycleVersion = "2.3.1"
    const val activityKtx = "1.3.0"
    const val fragmentKtx = "1.3.0"

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

object Kotlin {
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object TestLib {
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val junitRunner = "androidx.test.runner.AndroidJUnitRunner"
}