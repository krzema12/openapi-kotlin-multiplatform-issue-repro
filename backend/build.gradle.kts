plugins {
    // Core dependencies.
    application
    kotlin("jvm")
    kotlin("plugin.serialization")

    // Tests and code quality.
    id("info.solidsoft.pitest") version "1.5.2"
    id("io.gitlab.arturbosch.detekt") version "1.15.0"
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"

    // Deployment.
    id("com.bmuschko.docker-java-application") version "6.7.0"
    id("com.patdouble.awsecr") version "0.6.2"
}

group = "it.krzeminski"
version = "0.0.1-SNAPSHOT"

repositories {
    // This JCenter entry should be completely gone once JCenter is deprecated.
    // See https://jfrog.com/blog/into-the-sunset-bintray-jcenter-gocenter-and-chartcenter/
    jcenter {
        content {
            // Detekt needs 'kotlinx-html' for the HTML report.
            includeGroup("org.jetbrains.kotlinx")
        }
    }
}

dependencies {
    val ktorVersion = "1.5.2"

    implementation("org.openapitools:kotlin-client:1.0.0")

    // Core dependencies.
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-server-cio:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")

    // Temporarily, until ktor uses current Kotlin's kotlin-reflect library. Otherwise, it causes compile time warning
    // (treated in the project as error).
    implementation(kotlin("reflect"))
}

application {
    mainClass.set("ExampleApplicationKt")
}
