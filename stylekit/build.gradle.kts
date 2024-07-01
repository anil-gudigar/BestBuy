import java.util.Properties
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
        compose = true
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

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.compose.runtime:runtime:1.3.2")
    implementation("androidx.compose.runtime:runtime:1.0.0")
    implementation("androidx.compose.runtime:runtime-android:1.6.8")
    implementation("androidx.compose.ui:ui-graphics-android:1.6.8")
    implementation ("androidx.compose.material:material:1.6.8")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.6.8")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}