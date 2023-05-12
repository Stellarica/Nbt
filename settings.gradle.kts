val projectName = "Nbt"
rootProject.name = projectName

pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net/")
        gradlePluginPortal()
    }

    plugins {
        val kotlin_version: String by settings
        kotlin("jvm") version kotlin_version
        kotlin("plugin.serialization") version kotlin_version

        val paperweight_version: String by settings
        id("io.papermc.paperweight.userdev") version paperweight_version
    }
}