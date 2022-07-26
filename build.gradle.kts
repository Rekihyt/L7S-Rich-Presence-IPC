import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.reki"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    jcenter()

//    maven {
//        name = "meteor-maven"
//        url = uri("https://maven.meteordev.org/releases")
//        metadataSources {
//            mavenPom()
//            artifact()
//            gradleMetadata()
//        }
//    }
//    maven("https://maven.meteordev.org")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.jagrosh:DiscordIPC:0.4")
    implementation("ch.qos.logback:logback-classic:1.2.6")
    implementation("org.slf4j:slf4j-simple:1.7.36")
    implementation("org.slf4j:slf4j-api:1.7.36")
//    implementation("meteordevelopment:discord-ipc:1.1")
//    implementation("com.google.code.gson:gson:2.9.0")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}