import org.jetbrains.compose.desktop.application.dsl.TargetFormat.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.FileInputStream
import java.util.Properties

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose")
    id("kotlin-kapt")
}

val versionPropertiesFile = System.getenv("APP_VERSION_PROPERTIES")?.let { FileInputStream(it) } ?: FileInputStream(rootProject.file("app-compose/app-version.properties"))
val versionProperties = Properties()
versionProperties.load(versionPropertiesFile)

val major = System.getenv("APP_VERSION_MAJOR") ?: versionProperties["APP_VERSION_MAJOR"]
val minor = System.getenv("APP_VERSION_MINOR") ?: versionProperties["APP_VERSION_MINOR"]
val patch = System.getenv("APP_VERSION_PATCH") ?: versionProperties["APP_VERSION_PATCH"]
val build = System.getenv("APP_VERSION_BUILD") ?: versionProperties["APP_VERSION_BUILD"]

group = "com.stilllynnthecloset.outsideusnothing"
version = "$major.$minor.$patch-$build"

val ktlint by configurations.creating

dependencies {
    implementation(kotlin("stdlib"))

    implementation(project(":lib-oun"))

    implementation(AndroidX.annotation)
    implementation(KotlinX.serialization.json)

    implementation(compose.runtime)
    implementation(compose.uiTooling)
    implementation(compose.preview)
    implementation(compose.ui)
    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
    implementation(compose.material3)

    ktlint("com.pinterest:ktlint:_")
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "17"
}
tasks.withType<JavaCompile>().all {
    targetCompatibility = "17"
    sourceCompatibility = "17"
}

kotlin {
    explicitApi()
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
