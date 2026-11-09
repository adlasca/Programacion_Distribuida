plugins {
    id("java")
    id("com.gradleup.shadow") version "9.6.1"
    id("io.freefair.lombok") version "9.8.3"
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}
val helidonVersion = "4.5.6"

dependencies {
    //Servidor HTTP
    implementation("io.helidon.webserver:helidon-webserver:$helidonVersion")

    //JSON
    implementation("io.helidon.http.media:helidon-http-media-jsonp:${helidonVersion}")
    implementation("io.helidon.http.media:helidon-http-media-jsonb:${helidonVersion}")

    //Configuracion
    implementation("io.helidon.config:helidon-config-yaml:$helidonVersion")

    //Acceso a datos
    implementation("io.helidon.dbclient:helidon-dbclient:$helidonVersion")
    implementation("io.helidon.dbclient:helidon-dbclient-jdbc:$helidonVersion")
    //Pool de conexiones
    implementation("io.helidon.dbclient:helidon-dbclient-hikari:${helidonVersion}")

    implementation("org.postgresql:postgresql:42.7.14")
}

tasks.shadowJar {
    mergeServiceFiles()
}

tasks.jar{
    manifest {
        attributes["Main-Class"] = "com.programacion.distribuida.web.Web03Main"
    }
}
