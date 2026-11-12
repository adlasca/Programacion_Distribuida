package com.programacion.distribuida.authors.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Optional;

@Path("/config")
public class TestConfigRest {

    //Solo si el componente es gestionado, con CDI
    @ConfigProperty(name="quarkus.http.port", defaultValue = "8080")
    Integer port;

    @ConfigProperty(name = "app.name")
    String diAppName;

    @GET
    public String test(){

        //punto de acceso a la configuracion
        Config config = ConfigProvider.getConfig();

        //listar las fuentes de configuracion
        config.getConfigSources().forEach(c->{
            System.out.printf("[%5d] %s%n" ,c.getOrdinal(),c.getName());
        });

        //recuperar un valor de configuracion
        String quarkusName= config.getValue("quarkus.application.name",String.class);
        String appName = config.getValue("app.name", String.class);

        Optional<String>appTitle = config.getOptionalValue("app.title",String.class);

        if (appTitle.isPresent()){
            System.out.println(appTitle);
        }else {
            System.out.println("Sin titulo");
        }

        System.out.println(appName+ "  "+ quarkusName);
        System.out.println("port= "+port);

        return diAppName;
    }
}


/*Para configurar externamente:
    en el cmd "export QUARKUS_HTTP_PORT=8090"

 */