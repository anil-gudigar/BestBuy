import java.util.Properties
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream

val debugVersionFileName by extra("version_debug")
val stagingVersionFileName by extra("version_staging")
val releaseVersionFileName by extra("version_release")
val preProdVersionFileName by extra("version_preprod")
val betaVersionFileName by extra("version_beta")
val MAJOR by extra("major")
val MINOR by extra("minor")
val PATCH by extra("patch")
val BUILD by extra("build")

extra["kotlinVersion"] = "1.5.0"
extra["dokkaVersion"] = "0.9.17"
extra["navigationVersion"] = "2.2.2"

val kotlinVersion: String by extra
val dokkaVersion: String by extra
val navigationVersion: String by extra
val libraries: Map<*, *> by extra

val appPropertiesFile = rootProject.file("app.properties")
val appProperties = Properties().apply { load(FileInputStream(appPropertiesFile)) }
extra["appProperties"] = appProperties
// Top-level build file where you can add configuration options common to all sub-projects/modules.

fun readVersionNameOnly(versionFileName: String): String {
    val version = readVersion(versionFileName)
    return "${version[extra["MAJOR"]]}.${version[extra["MINOR"]]}.${version[extra["PATCH"]]}"
}

fun readBuildCode(versionFileName: String): Int {
    val version = readVersion(versionFileName)
    return (version[extra["BUILD"]] as String).toInt()
}

fun readVersion(versionFileName: String): Properties {
    val versionFile = rootProject.file("$versionFileName.properties")
    val version = Properties()
    var stream: FileInputStream? = null
    try {
        stream = FileInputStream(versionFile)
        version.load(stream)
    } catch (e: FileNotFoundException) {
        // Handle the exception if needed
    } finally {
        stream?.close()
    }
    if (version[extra["MAJOR"]] == null) version[extra["MAJOR"]] = "1"
    if (version[extra["MINOR"]] == null) version[extra["MINOR"]] = "0"
    if (version[extra["PATCH"]] == null) version[extra["PATCH"]] = "0"
    if (version[extra["BUILD"]] == null) version[extra["BUILD"]] = "1"
    return version
}

fun updateVersionNumber(major: Int, minor: Int, patch: Int, build: Int, versionFileName: String) {
    val versionFile = rootProject.file("$versionFileName.properties")
    val version = readVersion(versionFileName)
    version[extra["MAJOR"]] = major.toString()
    version[extra["MINOR"]] = minor.toString()
    version[extra["PATCH"]] = patch.toString()
    version[extra["BUILD"]] = build.toString()
    val stream = FileOutputStream(versionFile)
    try {
        version.store(stream, null)
    } finally {
        stream.close()
    }
}

fun getCurrentTaskName(): String {
    val taskNames = gradle.startParameter.taskNames
    for (taskName in taskNames) {
        return when {
            taskName.contains("Debug", ignoreCase = true) -> "debug"
            taskName.contains("Release", ignoreCase = true) -> "release"
            else -> "flavor"
        }
    }
    return "flavor"
}

fun getEnvironmentName(): String {
    val taskNames = gradle.startParameter.taskNames
    for (taskName in taskNames) {
        return when {
            taskName.contains(
                "Debug",
                ignoreCase = true
            ) -> appProperties["DEBUG_WORKING_ENV"]!!.toString().toLowerCase().replace("\"", "")

            taskName.contains(
                "Release",
                ignoreCase = true
            ) -> appProperties["WORKING_ENV"]!!.toString().toLowerCase().replace("\"", "")

            else -> "env"
        }
    }
    return "env"
}

fun readVersionName(versionFileName: String, taskName: String, envName: String): String {
    val version = readVersion(versionFileName)
    return if (taskName == "release") {
        "${version[extra["MAJOR"]]}.${version[extra["MINOR"]]}.${version[extra["PATCH"]]}"
    } else {
        "$envName-[${version[extra["MAJOR"]]}.${version[extra["MINOR"]]}.${version[extra["PATCH"]]}]"
    }
}

fun getVersionFileNameDependsOnBuildType(): String {
    val taskNames = gradle.startParameter.taskNames
    for (taskName in taskNames) {
        return when {
            taskName.contains("Debug", ignoreCase = true) -> extra["debugVersionFileName"] as String
            taskName.contains(
                "Release",
                ignoreCase = true
            ) -> extra["releaseVersionFileName"] as String

            else -> extra["stagingVersionFileName"] as String
        }
    }
    return extra["stagingVersionFileName"] as String
}


val appVersionCode = readBuildCode(getVersionFileNameDependsOnBuildType())
val appVersionName = readVersionName(
    getVersionFileNameDependsOnBuildType(),
    getCurrentTaskName(),
    getEnvironmentName()
)


extra["configuration"] = mapOf(
    "package" to "com.bestbuy.app",
    "compileSdkVersion" to 34,
    "targetSdkVersion" to 34,
    "minSdkVersion" to 24,
    "appVersionCode" to appVersionCode,
    "appVersionName" to appVersionName
)
val commonDependencies = mapOf(
    "kotlinVersion" to "1.4.21",
    "appCompatVersion" to "1.7.0",
    "constraintLayoutVersion" to "1.1.2",
    "archLifeCycleVersion" to "1.1.1",
    "gsonVersion" to "2.8.5",
    "rxKotlinVersion" to "2.3.0",
    "rxAndroidVersion" to "2.1.0",
    "retrofitVersion" to "2.9.0",
    "okHttp3Version" to "4.9.1",
    "glideVersion" to "4.11.0",
    "junit4Version" to "4.12",
    "testRunnerVersion" to "1.0.2",
    "mockKVersion" to "1.8.13.kotlin13",
    "espressoVersion" to "3.0.2",
    "daggerVersion" to "2.48",
    "daggerannotationVersion" to "2.48",
    "androidxlegacyVersion" to "1.0.0",
    "androidxcoreVesrion" to "1.1.0",
    "multidexVersion" to "2.0.1",
    "runtimeVersion" to "2.2.0",
    "vectordrawableVersion" to "1.1.0",
    "navigationVersion" to "2.3.4",
    "lifecycleVersion" to "2.2.0",
    "androidmaterialVersion" to "1.1.0",
    "installreferrer" to "1.1",
    "easingVersion" to "2.0@aar",
    "androidanimationsVersion" to "2.3@aar",
    "firebasecoreVersion" to "17.2.1",
    "firebasemessagingVersion" to "20.1.0",
    "playservicesgcmVersion" to "16.1.0",
    "sentryandroidVersion" to "1.7.16",
    "crashlyticsVersion" to "2.10.1",
    "amplitudeVersion" to "2.25.2",
    "libphonenumberVersion" to "8.10.12-1",
    "androidimagecropperVersion" to "2.7.0",
    "MPAndroidChartVersion" to "v3.1.0",
    "expandablerecyclerviewVersion" to "1.3",
    "sendBirdVersion" to "3.0.96",
    "roomVersion" to "2.5.0",
    "awsversion" to "2.14.+",
    "stethoVersion" to "1.6.0",
    "biometricVersion" to "1.0.1",
    "firebaseconfigVersion" to "19.1.0",
    "razorpayVersion" to "1.5.12",
    "firebasePerformenceMonitorVersion" to "19.0.10",
    "timberVersion" to "4.7.1",
    "androiddesignVersion" to "28.0.0",
    "picassoVersion" to "2.71828",
    "architectureLifecycleVersion" to "1.1.1",
    "guavaVersion" to "27.0.1-android",
    "sqlcipherVersion" to "4.3.0@aar",
    "androidxsqliteVersion" to "2.0.1",
    "analyticsVersion" to "4.3.1",
    "firebaseanalyticsVersion" to "17.2.0",
    "leacysupportversion" to "1.0.0",
    "shimmerversion" to "0.5.0",
    "kotlinxCoroutinesVersion" to "0.30.1",
    "lottieVersion" to "3.4.4",
    "frescoVersion" to "2.2.0",
    "frescoAnimatedGifVersion" to "1.9.0",
    "objectboxVersion" to "2.6.0",
    "location" to "17.1.0",
    "auth" to "18.1.0",
    "identity" to "17.0.0",
    "phoneselector" to "17.4.0",
    "servicebase" to "17.6.0",
    "paging_version" to "3.0.0-alpha07"
)

extra["libraries"] = mapOf(
    "appCompat" to "androidx.appcompat:appcompat:${commonDependencies["appCompatVersion"]}",
    "kotlinStdLib" to "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${commonDependencies["kotlinVersion"]}",
    "constraintLayout" to "androidx.constraintlayout:constraintlayout:${commonDependencies["constraintLayoutVersion"]}",
    "recyclerview" to "androidx.recyclerview:recyclerview:${commonDependencies["appCompatVersion"]}",
    "archLifeCycle" to "android.arch.lifecycle:extensions:${commonDependencies["archLifeCycleVersion"]}",
    "gson" to "com.google.code.gson:gson:${commonDependencies["gsonVersion"]}",
    "rxKotlin" to "io.reactivex.rxjava2:rxkotlin:${commonDependencies["rxKotlinVersion"]}",
    "rxAndroid" to "io.reactivex.rxjava2:rxandroid:${commonDependencies["rxAndroidVersion"]}",
    "rxjava" to "io.reactivex.rxjava2:rxjava:2.2.0",
    "retrofit" to "com.squareup.retrofit2:retrofit:${commonDependencies["retrofitVersion"]}",
    "retrofitGsonConverter" to "com.squareup.retrofit2:converter-gson:${commonDependencies["retrofitVersion"]}",
    "retrofitRxAdapter" to "com.squareup.retrofit2:adapter-rxjava2:${commonDependencies["retrofitVersion"]}",
    "okhttp3" to "com.squareup.okhttp3:okhttp:${commonDependencies["okHttp3Version"]}",
    "okhttp3Interceptor" to "com.squareup.okhttp3:logging-interceptor:${commonDependencies["okHttp3Version"]}",
    "glide" to "com.github.bumptech.glide:glide:${commonDependencies["glideVersion"]}",
    "dagger" to "com.google.dagger:dagger:${commonDependencies["daggerVersion"]}",
    "daggerannotation" to "com.google.dagger:dagger-compiler:${commonDependencies["daggerVersion"]}",
    "daggerprocessor" to "com.google.dagger:dagger-android-processor:${commonDependencies["daggerVersion"]}",
    "daggerandroid" to "com.google.dagger:dagger-android:${commonDependencies["daggerVersion"]}",
    "daggerandroidsupport" to "com.google.dagger:dagger-android-support:${commonDependencies["daggerVersion"]}",
    "androidxlegacy" to "androidx.legacy:legacy-support-v4:${commonDependencies["androidxlegacyVersion"]}",
    "androidxcore" to "androidx.core:core:${commonDependencies["androidxcoreVesrion"]}",
    "multidex" to "androidx.multidex:multidex:${commonDependencies["multidexVersion"]}",
    "androidxwork" to "androidx.work:work-runtime:${commonDependencies["runtimeVersion"]}",
    "androidxvectordrawable" to "androidx.vectordrawable:vectordrawable:${commonDependencies["vectordrawableVersion"]}",
    "biometric" to "androidx.biometric:biometric:${commonDependencies["biometricVersion"]}",
    "firebaseconfig" to "com.google.firebase:firebase-config:${commonDependencies["firebaseconfigVersion"]}",
    "razorpay" to "com.razorpay:checkout:${commonDependencies["razorpayVersion"]}",
    "architectureLifecycle" to "android.arch.lifecycle:runtime:${commonDependencies["architectureLifecycleVersion"]}",
    "annotationProcessor" to "android.arch.lifecycle:compiler:${commonDependencies["architectureLifecycleVersion"]}",
    "guava" to "com.google.guava:guava:${commonDependencies["guavaVersion"]}",

    //navigation
    "androidxnavigationfragment" to "androidx.navigation:navigation-fragment:${commonDependencies["navigationVersion"]}",
    "androidxnavigationui" to "androidx.navigation:navigation-ui:${commonDependencies["navigationVersion"]}",
    "androidxnavigationfragmentktx" to "androidx.navigation:navigation-fragment-ktx:${commonDependencies["navigationVersion"]}",
    "androidxnavigationuiktx" to "androidx.navigation:navigation-ui-ktx:${commonDependencies["navigationVersion"]}",

    //lifecycle
    "androidxlifecycleextesion" to "androidx.lifecycle:lifecycle-extensions:${commonDependencies["lifecycleVersion"]}",
    "androidxlifecycleviewmodel" to "androidx.lifecycle:lifecycle-viewmodel-ktx:${commonDependencies["lifecycleVersion"]}",
    "lifecyclelivedataktx" to "androidx.lifecycle:lifecycle-livedata-ktx:${commonDependencies["lifecycleVersion"]}",
    "lifecycleviewmodelktx" to "androidx.lifecycle:lifecycle-viewmodel-ktx:${commonDependencies["lifecycleVersion"]}",

    //Image Library
    "androidmaterial" to "com.google.android.material:material:${commonDependencies["androidmaterialVersion"]}",
    "installreferrer" to "com.android.installreferrer:installreferrer:${commonDependencies["installreferrer"]}",
    "picasso" to "com.squareup.picasso:picasso:${commonDependencies["picassoVersion"]}",
    "blurry" to "jp.wasabeef:blurry:4.0.0",

    //
    "easing" to "com.daimajia.easing:library:${commonDependencies["easingVersion"]}",
    "androidanimations" to "com.daimajia.androidanimations:library:${commonDependencies["androidanimationsVersion"]}",

    //firebase
    "firebasecore" to "com.google.firebase:firebase-core:${commonDependencies["firebasecoreVersion"]}",
    "firebasemessaging" to "com.google.firebase:firebase-messaging:${commonDependencies["firebasemessagingVersion"]}",
    "playservicesgcm" to "com.google.android.gms:play-services-gcm:${commonDependencies["playservicesgcmVersion"]}",
    "firebasePerformenceMonitor" to "com.google.firebase:firebase-perf:${commonDependencies["firebasePerformenceMonitorVersion"]}",

    //Crash reporting
    "sentryandroid" to "io.sentry:sentry-android:${commonDependencies["sentryandroidVersion"]}",
    "crashlytics" to "com.crashlytics.sdk.android:crashlytics:${commonDependencies["crashlyticsVersion"]}",

    "amplitude" to "com.amplitude:android-sdk:${commonDependencies["amplitudeVersion"]}",
    "libphonenumber" to "io.michaelrocks:libphonenumber-android:${commonDependencies["libphonenumberVersion"]}",
    "androidimagecropper" to "com.theartofdev.edmodo:android-image-cropper:${commonDependencies["androidimagecropperVersion"]}",

    "MPAndroidChart" to "com.github.PhilJay:MPAndroidChart:${commonDependencies["MPAndroidChartVersion"]}",
    "expandablerecyclerview" to "com.thoughtbot:expandablerecyclerview:${commonDependencies["expandablerecyclerviewVersion"]}",

    "sendbird" to "com.sendbird.sdk:sendbird-android-sdk:${commonDependencies["sendBirdVersion"]}",
    "roomruntime" to "androidx.room:room-runtime:${commonDependencies["roomVersion"]}",
    "roomruntimektx" to "androidx.room:room-ktx:${commonDependencies["roomVersion"]}",
    "roomcompiler" to "androidx.room:room-compiler:${commonDependencies["roomVersion"]}",

    "awsversionS3" to "com.amazonaws:aws-android-sdk-s3:${commonDependencies["awsversion"]}",
    "awsversionmobileClient" to "com.amazonaws:aws-android-sdk-mobile-client:${commonDependencies["awsversion"]}",
    "stetho" to "com.facebook.stetho:stetho:${commonDependencies["stethoVersion"]}",
    "stethoOkhttp" to "com.facebook.stetho:stetho-okhttp3:${commonDependencies["stethoVersion"]}",
    "sqlcipher" to "net.zetetic:android-database-sqlcipher:${commonDependencies["sqlcipherVersion"]}",
    "androidxsqlite" to "androidx.sqlite:sqlite:${commonDependencies["androidxsqliteVersion"]}",
    "timber" to "com.jakewharton.timber:timber:${commonDependencies["timberVersion"]}",
    "lifecycleextensions" to "androidx.lifecycle:lifecycle-extensions:${commonDependencies["lifecycleVersion"]}",
    "analytics" to "com.segment.analytics.android:analytics:${commonDependencies["analyticsVersion"]}",
    "firebaseanalytics" to "com.google.firebase:firebase-analytics:17.2.0",
    "json" to "com.googlecode.json-simple:json-simple:1.1",
    "leacysupport" to "androidx.legacy:legacy-support-v4:${commonDependencies["leacysupportversion"]}",
    "facebookshimmer" to "com.facebook.shimmer:shimmer:${commonDependencies["shimmerversion"]}",
    "kotlinxCoroutines" to "org.jetbrains.kotlinx:kotlinx-coroutines-android:${commonDependencies["kotlinxCoroutinesVersion"]}",
    "exoplayer" to "com.google.android.exoplayer:exoplayer:2.11.4",
    "youtubeplayer" to "com.pierfrancescosoffritti.androidyoutubeplayer:core:10.0.5",
    "androidxrecyclerview" to "androidx.recyclerview:recyclerview:1.0.0",
    "corektxandroidx" to "androidx.core:core-ktx:1.3.1",
    "flowlayout" to "com.nex3z:flow-layout:1.2.4",
    "flexbox" to "com.google.android:flexbox:2.0.1",
    "webpdecoder" to "com.zlc.glide:webpdecoder:2.0.4.11.0",
    "lottie" to "com.airbnb.android:lottie:${commonDependencies["lottieVersion"]}",
    "fresco" to "com.facebook.fresco:fresco:${commonDependencies["frescoVersion"]}",
    "frescoAnimatedWebp" to "com.facebook.fresco:animated-webp:${commonDependencies["frescoVersion"]}",
    "frescoWebpSupport" to "com.facebook.fresco:webpsupport:${commonDependencies["frescoVersion"]}",
    "frescoAnimatedGif" to "com.facebook.fresco:animated-gif:${commonDependencies["frescoAnimatedGifVersion"]}",
    "paging" to "androidx.paging:paging-runtime:${commonDependencies["paging_version"]}"
)

extra["kaptLibraries"] = mapOf(
    "archLifeCycle" to "android.arch.lifecycle:compiler:${commonDependencies["archLifeCycleVersion"]}"
)

extra["testLibraries"] = mapOf(
    "junit4" to "junit:junit:${commonDependencies["junit4Version"]}",
    "mockK" to "io.mockk:mockk:${commonDependencies["mockKVersion"]}",
    "rxKotlin" to "${libraries["rxKotlin"]}",
    "rxAndroid" to "${libraries["rxAndroid"]}"
)

extra["androidTestLibraries"] = mapOf(
    "testRunner" to "com.android.support.test:runner:${commonDependencies["testRunnerVersion"]}",
    "testRules" to "com.android.support.test:rules:${commonDependencies["testRunnerVersion"]}",
    "espresso" to "com.android.support.test.espresso:espresso-core:${commonDependencies["espressoVersion"]}",
    "mockK" to "io.mockk:mockk-android:${commonDependencies["mockKVersion"]}"
)

