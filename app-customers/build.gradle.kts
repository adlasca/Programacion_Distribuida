plugins {
    id("java")
    id("org.springframework.boot") version "4.2.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}
extra["springCloudVersion"] = "2026.0.0"
dependencies {
    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    //Registro automatico de consul en Spring
    implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

