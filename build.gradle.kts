plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("io.papermc.paperweight.userdev")
    `maven-publish`
}

version = property("version")!!

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    paperweightDevelopmentBundle("io.papermc.paper:dev-bundle:${property("minecraft_version")}-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${property("kx_ser_version")}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${property("kotlin_version")}")

    testImplementation("io.kotest:kotest-runner-junit5:${property("kotest_version")}")
    testImplementation("io.kotest:kotest-assertions-core:${property("kotest_version")}")
    testImplementation("io.kotest:kotest-property:${property("kotest_version")}")
}

tasks {
    build {
        dependsOn(reobfJar)
    }
    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}

kotlin {
    jvmToolchain(17)
}


publishing {
    repositories {
        maven {
            name = "Stellarica"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) "https://repo.stellarica.net/snapshots" else "https://repo.stellarica.net/releases")
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "net.stellarica" // todo: move these to gradle properties
            artifactId = "nbt"
            version = project.version.toString()
            from(components["java"])
        }
    }
}