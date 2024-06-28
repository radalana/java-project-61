plugins {
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}
dependencies {
    implementation("org.apache.commons:commons-lang3:3.14.0")
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
