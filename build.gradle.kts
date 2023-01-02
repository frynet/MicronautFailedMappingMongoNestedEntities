val kotlin_version: String by project
val kotlin_coroutines_version: String by project
val logback_version: String by project

val java_version = JavaVersion.VERSION_11


plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("kapt") version "1.6.21"
    kotlin("plugin.allopen") version "1.6.21"

    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.6.3"
    id("io.micronaut.aot") version "3.6.3"
}

version = "0.1"
group = "org.example"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlin_coroutines_version")

    implementation("io.micronaut:micronaut-inject")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")

    kapt("io.micronaut.data:micronaut-data-document-processor")
    implementation("io.micronaut.data:micronaut-data-mongodb")
    runtimeOnly("org.mongodb:mongodb-driver-sync")

    kapt("io.micronaut.openapi:micronaut-openapi")
    implementation("io.swagger.core.v3:swagger-annotations")

    implementation("ch.qos.logback:logback-classic:$logback_version")
}


application {
    mainClass.set("org.example.Application")
}
java {
    sourceCompatibility = java_version
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = java_version.toString()
        }
    }

    compileTestKotlin {
        kotlinOptions {
            jvmTarget = java_version.toString()
        }
    }
}


graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("org.example.*")
    }

    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading.set(true)
        convertYamlToJava.set(true)
        precomputeOperations.set(true)
        cacheEnvironment.set(true)
        optimizeClassLoading.set(true)
        deduceEnvironment.set(true)
        optimizeNetty.set(true)
    }
}
