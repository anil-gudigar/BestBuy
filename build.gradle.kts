// Top-level build file where you can add configuration options common to all sub-projects/modules.
apply {
    from("dependencies.gradle.kts")
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("com.android.library") version "8.1.1" apply false
}


buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
    }
}

allprojects {
}

tasks{
    register("clean", Delete::class){
        delete(rootProject.buildDir)
    }
}




