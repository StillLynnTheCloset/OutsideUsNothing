import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") apply false
    kotlin("kapt") apply false
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("org.jetbrains.compose") apply false
    application

    id("com.android.application") apply false
    id("com.android.library") apply false
}

group = "com.stilllynnthecloset.outsideusnothing"
version = "1.0"

buildscript {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")
        classpath("org.jetbrains.kotlin:kotlin-serialization:_")
    }
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "17"
}

tasks.withType<JavaCompile>().all {
    targetCompatibility = "17"
    sourceCompatibility = "17"
}
