import org.jetbrains.compose.desktop.application.dsl.TargetFormat.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.kapt)
}
val versionPropertiesFile = System.getenv("APP_VERSION_PROPERTIES")?.let { FileInputStream(it) } ?: FileInputStream(rootProject.file("app-desktop/app-version.properties"))
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
    implementation(project(":app-compose"))
    implementation(project(":lib-oun"))
    implementation(project(":lib-hexgrid-compose"))

    implementation(libs.kotlin.stdlib)

    implementation(libs.kotlinx.coroutines.swing)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.annotation)

    implementation(compose.desktop.currentOs)
    implementation(libs.jetbrains.compose.uiTooling)
    implementation(libs.jetbrains.compose.uiToolingPreview)
    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
    implementation(libs.jetbrains.compose.material3)

    implementation(libs.okio)

    ktlint(libs.ktlint)
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

compose.desktop {
    application {
        mainClass = "com.stilllynnthecloset.outsideusnothing.desktop.MainKt"
//        jvmArgs += listOf("-Xmx2G")
//        args += listOf("-customArgument")

        nativeDistributions {
            targetFormats(Dmg, Msi, Deb, Rpm, Exe)
            outputBaseDir.set(project.buildDir.resolve("packages"))
            packageName = "Outside us Nothing"
            packageVersion = "$major.$minor.$patch"
            description = "Outside us Nothing"
            copyright = "© 2023 Lynn"
            vendor = "Lynn"

            includeAllModules = true // TODO: Replace with modules("java.util", etc.) for sleeker package sizes
//            modules()//"com.zaxxer","java.net", "java.time", "java.awt","java.util", // This doesn't seem to work...

            macOS {
                // https://github.com/JetBrains/compose-jb/blob/master/tutorials/Signing_and_notarization_on_macOS/README.md
                // For details on how to make this work on macOS.

                iconFile.set(project.file("icons/ic_launcher.icns"))
            }
            linux {
                iconFile.set(project.file("icons/ic_launcher.png"))
                packageName = "outside-us-nothing"
                packageVersion = "$major.$minor.$patch"
                debMaintainer = "lynn"
                menuGroup = "games"
                appRelease = "1"
                appCategory = "games"
//                rpmLicenseType = "TYPE_OF_LICENSE"
//                debPackageVersion = "DEB_VERSION"
//                rpmPackageVersion = "RPM_VERSION"
            }
            windows {
                iconFile.set(project.file("icons/ic_launcher.ico"))
                packageVersion = "$major.$minor.$patch"
                console = false
                dirChooser = true
                perUserInstall = true
                menuGroup = "games"
                upgradeUuid = "aad770d1-fbe4-494e-a2a2-0bcfdc5c0511"
//                msiPackageVersion = "MSI_VERSION"
//                exePackageVersion = "EXE_VERSION"
            }
        }
    }
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

val installDebian by tasks.creating(Exec::class) {
    workingDir("${buildDir}/")
    commandLine(listOf("sudo", "dpkg", "-i", "packages/main/deb/outside-us-nothing_$major.$minor.$patch-${build}_amd64.deb"))
    dependsOn("packageDeb")
}
