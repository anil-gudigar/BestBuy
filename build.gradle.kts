// Top-level build file where you can add configuration options common to all sub-projects/modules.
apply {
    from("dependencies.gradle.kts")
}

plugins {
    id("com.android.application") version "8.1.4" apply false
    id("com.android.library") version "8.1.4" apply false
    kotlin("android") version "1.7.0" apply false
    kotlin("android.extensions") version "1.7.0" apply false
    kotlin("kapt") version "1.7.0" apply false
}


buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.20")
    }
}

allprojects {

}

tasks{
    register("clean", Delete::class){
        delete(rootProject.buildDir)
    }
}

