// These plugins are declared here only to satisfy the Kotlin plugin - its version has to be stated once in the root
// project, and then subproject can apply it. Hence "apply false" here.
plugins {
    val kotlinVersion = "1.5.10"
    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.serialization") version kotlinVersion apply false
}

allprojects {
    repositories {
        jcenter()
    }
}
