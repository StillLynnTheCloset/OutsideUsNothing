import org.jetbrains.compose.desktop.application.dsl.TargetFormat.*

plugins {
    kotlin("android")
    id("com.android.application")
    id("org.jetbrains.compose")
}

android {
    namespace = "com.stilllynnthecloset.outsideusnothing.android"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.stilllynnthecloset.outsideusnothing.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kotlin {
    explicitApi()
}

val ktlint by configurations.creating

dependencies {
    implementation(project(":app-compose"))
    implementation(project(":lib-oun"))
    implementation(project(":lib-hexgrid-compose"))

    implementation(AndroidX.core.ktx)
    implementation(AndroidX.lifecycle.runtime.ktx)
    implementation(AndroidX.activity.compose)
    implementation(compose.ui)
    implementation(compose.uiTooling)
    implementation(compose.preview)
    implementation(AndroidX.compose.material3)

    ktlint(libs.ktlint)
}

val outputDir = "${project.buildDir}/reports/ktlint/"
val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))

val ktlintCheck by tasks.creating(JavaExec::class) {
    inputs.files(inputFiles)
    outputs.dir(outputDir)

    description = "Check Kotlin code style."
    classpath = ktlint
    mainClass.set("com.pinterest.ktlint.Main")
    args = listOf("src/**/*.kt")
}
