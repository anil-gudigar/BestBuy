import java.util.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
}
val configuration = rootProject.extra["configuration"] as Map<*, *>
val libraries = rootProject.extra["libraries"] as Map<*, *>
val appProperties = rootProject.extra["appProperties"] as Properties
val kotlinVersion = rootProject.extra["kotlinVersion"] as String
val dokkaVersion = rootProject.extra["dokkaVersion"] as String
val navigationVersion = rootProject.extra["navigationVersion"] as String

android {
    namespace = "com.bestbuy.core"
    compileSdk = configuration["compileSdkVersion"] as Int
    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = configuration["minSdkVersion"] as Int
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        buildConfigField("String", "API_DEVELOPER_TOKEN", "${providers.gradleProperty("api_developer_token").get()}")
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
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    api("androidx.annotation:annotation:1.8.0")
    libraries["kotlinStdLib"]?.let { api(it) }
    libraries["appCompat"]?.let { api(it) }
    libraries["constraintLayout"]?.let { api(it) }
    // Networking
    libraries["gson"]?.let { api(it) }
    libraries["json"]?.let { api(it) }
    libraries["retrofit"]?.let { api(it) }
    libraries["retrofitRxAdapter"]?.let { api(it) }
    libraries["retrofitGsonConverter"]?.let { api(it) }
    libraries["okhttp3"]?.let { api(it) }
    libraries["okhttp3Interceptor"]?.let { api(it) }
    libraries["stetho"]?.let { api(it) }
    libraries["stethoOkhttp"]?.let { api(it) }

    // Dagger
    libraries["daggerannotation"]?.let { kapt(it) }
    libraries["daggerprocessor"]?.let { kapt(it) }
    libraries["dagger"]?.let { api(it) }
    libraries["daggerandroid"]?.let { api(it) }
    libraries["daggerandroidsupport"]?.let { api(it) }
    libraries["daggerannotation"]?.let { annotationProcessor(it) }

    // Room
    libraries["roomruntime"]?.let { api(it) }
    libraries["roomruntimektx"]?.let { api(it) }
    libraries["roomcompiler"]?.let { kapt(it) }
    libraries["roomcompiler"]?.let { annotationProcessor(it) }

    // AndroidX
    libraries["androidxcore"]?.let { api(it) }
    libraries["multidex"]?.let { api(it) }
    libraries["androidxwork"]?.let { api(it) }
    libraries["androidxvectordrawable"]?.let { api(it) }
    libraries["kotlinxCoroutines"]?.let { api(it) }
    libraries["androidxlegacy"]?.let { api(it) }
    libraries["corektxandroidx"]?.let { api(it) }

    // Navigation
    libraries["androidxnavigationfragment"]?.let { api(it) }
    libraries["androidxnavigationui"]?.let { api(it) }
    libraries["androidxnavigationfragmentktx"]?.let { api(it) }
    libraries["androidxnavigationuiktx"]?.let { api(it) }

    // Lifecycle
    libraries["androidxlifecycleextesion"]?.let { api(it) }
    libraries["androidxlifecycleviewmodel"]?.let { api(it) }
    libraries["lifecycleextensions"]?.let { api(it) }
    libraries["lifecycleruntime"]?.let { api(it) }
    libraries["lifecyclecompiler"]?.let { annotationProcessor(it) }
    libraries["lifecyclelivedataktx"]?.let { api(it) }
    libraries["lifecycleviewmodelktx"]?.let { api(it) }

    // Image Library
    libraries["glide"]?.let { api(it) }
    libraries["androidmaterial"]?.let { api(it) }

    libraries["paging"]?.let { api(it) }

    // Logging
    libraries["timber"]?.let { api(it) }

    implementation("androidx.core:core-ktx:1.13.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}