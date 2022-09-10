object ProjectLevel {
    const val core = ":core"
    const val domain = ":domain"
}
object Versions {
    const val navigation = "2.5.0"
    const val coil = "2.1.0"
    const val retrofit = "2.9.0"
    const val interceptor = "4.9.1"
    const val gson = "2.9.0"
    const val mockWebServer = "4.9.1"
    const val hilt = "2.38.1"
    const val hiltNavigation = "1.0.0"
    const val legacySupport = "1.0.0"
    const val lifeCircleExtensions = "2.2.0"
    const val viewModelKtx = "2.5.0"
    const val composeVersion = "1.1.0-beta01"
    const val roomVersion = "2.3.0"
    const val constraintLayout = "1.1.0-alpha03"
    const val coroutines = "1.6.1"
    const val coreKtx = "1.7.0"
    const val material3 = "1.0.0-alpha01"
    const val lifeCircleRuntime = "2.3.1"
    const val composeActivity = "1.3.1"
    const val junit = "4.13.2"
    const val extJunit = "1.1.3"
    const val espressoCore = "3.4.0"
}

object ExternalDependencies {
    const val navigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.interceptor}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.gson}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockWebServer}"
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val kaptCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val kaptAndroidTest = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hiltTesting = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    const val legacySupport = "androidx.legacy:legacy-support-v4${Versions.legacySupport}"
    const val lifeCircleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCircleExtensions}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelKtx}"
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata:${Versions.composeVersion}"
    const val roomDatabase = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomDatabaseCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomDatabaseTesting = "androidx.room:room-testing:${Versions.roomVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}"
    const val materialIcons = "androidx.compose.material:material-icons-extended:${Versions.composeVersion}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val composeUI = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val material = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val lifeCircleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCircleRuntime}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val testImplementation = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val uiTest = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.composeVersion}"
}