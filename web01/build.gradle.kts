plugins {
    id("java")
    id("war")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("jakarta.ws.rs:jakarta.ws.rs-api:4.0.0")
    implementation("commons-collections:commons-collections:3.2.2")
}
