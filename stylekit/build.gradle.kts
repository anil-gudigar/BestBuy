import java.util.Properties
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}
val configuration = rootProject.extra["configuration"] as Map<*, *>
val libraries = rootProject.extra["libraries"] as Map<*, *>
val appProperties = rootProject.extra["appProperties"] as java.util.Properties
val kotlinVersion = rootProject.extra["kotlinVersion"] as String
val dokkaVersion = rootProject.extra["dokkaVersion"] as String
val navigationVersion = rootProject.extra["navigationVersion"] as String

android {
    namespace = "com.bestbuy.stylekit"
    compileSdk = configuration["compileSdkVersion"] as Int
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        minSdk = configuration["minSdkVersion"] as Int
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(project(mapOf("path" to ":core")))
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}