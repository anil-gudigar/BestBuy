plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}
val configuration = rootProject.extra["configuration"] as Map<*, *>
val libraries = rootProject.extra["libraries"] as Map<*, *>
val appProperties = rootProject.extra["appProperties"] as java.util.Properties

android {
    namespace = "com.bestbuy.storelocator"
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
            buildConfigField("String", "BASE_URL", "${appProperties["BASE_URL"]}")
            buildConfigField("String", "BASE_IMAGE_URL", "${appProperties["BASE_IMAGE_URL"]}")
        }
        debug {
            isMinifyEnabled = false
            buildConfigField("String", "BASE_URL", "${appProperties["BASE_URL_DEBUG"]}")
            buildConfigField(
                "String",
                "BASE_IMAGE_URL",
                "${appProperties["BASE_IMAGE_URL_DEBUG"]}"
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
    api(project(mapOf("path" to ":stylekit")))
    // Dagger
    libraries["daggerannotation"]?.let { kapt(it) }
    libraries["daggerprocessor"]?.let { kapt(it) }
    libraries["dagger"]?.let { api(it) }
    // Room
    libraries["roomruntime"]?.let { api(it) }
    libraries["roomruntimektx"]?.let { api(it) }
    libraries["roomcompiler"]?.let { kapt(it) }
    libraries["roomcompiler"]?.let { annotationProcessor(it) }

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}