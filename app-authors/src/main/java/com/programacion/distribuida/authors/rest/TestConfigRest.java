package com.programacion.distribuida.authors.rest;

import io.vertx.core.Vertx;
import io.vertx.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.Service;
import jakarta.inject.Inject;
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

    @Inject
    Vertx vertx;

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

    @GET
    @Path("/test2")
    public String test2(){
        ConsulClientOptions options = new ConsulClientOptions()
                .setHost("127.0.0.1")
                .setPort(8500);

//Busqueda de servicios disponibles
        ConsulClient client = ConsulClient.create(vertx,options);
        var response = client.catalogServiceNodes("app-authors");

        response.onComplete(it->{
           if(it.succeeded()){
               System.out.println("found " + it.result().getList().size() + " services");
               for (Service service : it.result().getList()) {
                   System.out.println("Service node: " + service.getNode());
                   System.out.println("Service address: " + service.getAddress());
                   System.out.println("Service port: " + service.getPort());
               }
           }
        });

        return "test";
    }
//java -Dquarkus.http.port=8071 -jar build/quarkus-app/quarkus-run.jar
}


/*Para configurar externamente:
    en el cmd "export QUARKUS_HTTP_PORT=8090"

 */