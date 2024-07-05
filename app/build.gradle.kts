plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-android")
    id ("kotlin-kapt")
}
val configuration = rootProject.extra["configuration"] as Map<*, *>
val libraries = rootProject.extra["libraries"] as Map<*, *>
val debugVersionFileName = rootProject.extra["debugVersionFileName"] as String
val stagingVersionFileName = rootProject.extra["stagingVersionFileName"] as String
val releaseVersionFileName = rootProject.extra["releaseVersionFileName"] as String
val appProperties = rootProject.extra["appProperties"] as java.util.Properties
val kotlinVersion = rootProject.extra["kotlinVersion"] as String
val dokkaVersion = rootProject.extra["dokkaVersion"] as String

android {
    namespace = configuration["package"] as String
    compileSdk = configuration["compileSdkVersion"] as Int
    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = configuration["package"] as String
        minSdk = configuration["minSdkVersion"] as Int
        targetSdk = configuration["targetSdkVersion"] as Int
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    dataBinding.enable = true

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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(project(mapOf("path" to ":core")))
    api(project(mapOf("path" to ":search")))
    api(project(mapOf("path" to ":stylekit")))
    // Dagger
    libraries["daggerannotation"]?.let { kapt(it) }
    libraries["daggerprocessor"]?.let { kapt(it) }
    libraries["dagger"]?.let { api(it) }

    implementation("androidx.core:core-ktx:1.13.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}