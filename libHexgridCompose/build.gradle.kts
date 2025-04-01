import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

val versionPropertiesFile = System.getenv("APP_VERSION_PROPERTIES")?.let { FileInputStream(it) } ?: FileInputStream(rootProject.file("appCompose/app-version.properties"))
val versionProperties = Properties()
versionProperties.load(versionPropertiesFile)

val major = System.getenv("APP_VERSION_MAJOR") ?: versionProperties["APP_VERSION_MAJOR"]
val minor = System.getenv("APP_VERSION_MINOR") ?: versionProperties["APP_VERSION_MINOR"]
val patch = System.getenv("APP_VERSION_PATCH") ?: versionProperties["APP_VERSION_PATCH"]
val build = System.getenv("APP_VERSION_BUILD") ?: versionProperties["APP_VERSION_BUILD"]

group = "com.stilllynnthecloset.outsideusnothing"
version = "$major.$minor.$patch-$build"

kotlin {
    explicitApi()
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    jvm("desktop")

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "libHexGridCompose"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "libHexGridCompose.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            implementation(project(":libOun"))

            implementation(libs.kotlin.stdlib)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.androidx.annotation)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.jetbrains.compose.runtime)
            implementation(libs.jetbrains.compose.ui)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(libs.jetbrains.compose.material3)
        }
    }
}

android {
    namespace = "com.stilllynnthecloset.outsideusnothing.libHexgridCompose"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

//val ktlint by configurations.creating
//
//dependencies {
//    implementation(project(":lib-oun"))
//
//    implementation(libs.kotlin.stdlib)
//
//    implementation(libs.androidx.annotation)
//    implementation(libs.kotlinx.serialization.json)
//
//    implementation(libs.jetbrains.compose.runtime)
//    implementation(libs.jetbrains.compose.ui)
//    implementation(libs.jetbrains.compose.uiTooling)
//    implementation(libs.jetbrains.compose.uiToolingPreview)
//    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
//    implementation(libs.jetbrains.compose.material3)
//
//    ktlint(libs.ktlint)
//}
//
//tasks.withType<KotlinCompile>().all {
//    compilerOptions {
//        jvmTarget.set(JvmTarget.JVM_17)
//    }
//}
//tasks.withType<JavaCompile>().all {
//    targetCompatibility = "17"
//    sourceCompatibility = "17"
//}
//
//kotlin {
//    explicitApi()
//}
//
//val outputDir = "${project.layout.buildDirectory}/reports/ktlint/"
//val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))
//
//val ktlintCheck by tasks.creating(JavaExec::class) {
//    inputs.files(inputFiles)
//    outputs.dir(outputDir)
//
//    description = "Check Kotlin code style."
//    classpath = ktlint
//    mainClass.set("com.pinterest.ktlint.Main")
//    args = listOf("src/**/*.kt")
//}
