import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kotlinx_version: String by project
val exposed_version: String by project

plugins {
    application
    kotlin("jvm") version "1.4.21"
    kotlin("plugin.serialization") version "1.4.10"
}

group = "com.sneed"
version = "0.0.1"

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-gson:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:$ktor_version")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization:$ktor_version")
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-dao:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinx_version")
    implementation(kotlin("stdlib"))
    implementation("org.xerial:sqlite-jdbc:3.32.3.2")
    implementation("org.slf4j:slf4j-simple:1.7.9")
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")

sourceSets["main"].resources.srcDirs("resources")

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}