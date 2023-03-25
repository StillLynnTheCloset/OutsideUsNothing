import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("kotlin-kapt")
}

group = "com.stilllynnthecloset.outsideusnothing"
version = "1.0"

kotlin {
    explicitApi()
}

val ktlint by configurations.creating

dependencies {
    implementation(kotlin("stdlib"))
    implementation(KotlinX.coroutines.core)

//    implementation(Square.moshi.kotlinReflect)
//    implementation(Square.moshi.adapters)
//    kapt(Square.moshi.kotlinCodegen)

    ktlint("com.pinterest:ktlint:_")
}

tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "17"
}
tasks.withType<JavaCompile>().all {
    targetCompatibility = "17"
    sourceCompatibility = "17"
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
