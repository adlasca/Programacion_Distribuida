package com.programacion.distribuida.books;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import io.vertx.core.Vertx;
import io.vertx.ext.consul.ConsulClient;
import io.vertx.ext.consul.ConsulClientOptions;
import io.vertx.ext.consul.ServiceOptions;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class BooksLifeCycle {

    @Inject
    @ConfigProperty(name = "consul.host", defaultValue = "127.0.0.1")
    String consulHost;

    @Inject
    @ConfigProperty(name = "consul.port", defaultValue = "8500")
    Integer consulPort;

    @Inject
    @ConfigProperty(name = "quarkus.http.port", defaultValue = "8070")
    Integer appPort;

    @Inject
    @ConfigProperty(name = "app.name")
    String appName;

    String serviceId;
    String ipAddress;

    @PostConstruct
    public  void construct(){
        ipAddress="127.0.0.1";
        serviceId = "%s-%s:%d".formatted(appName,ipAddress,appPort);
    }

    public void init(@Observes StartupEvent event, Vertx vertx){

        try {
            ConsulClientOptions options = new ConsulClientOptions()
                    .setHost(consulHost)
                    .setPort(consulPort);

            ConsulClient client = ConsulClient.create(vertx,options);

            ServiceOptions serviceOptions = new ServiceOptions()
                    .setName(appName)
                    .setId(serviceId)
                    .setAddress(ipAddress)
                    .setPort(appPort);

            client.registerService(serviceOptions )
                    .onSuccess(it-> System.out.println("Service registered with Consul"+serviceId))
                    .onFailure(it-> System.out.println("Service registration failed: "+it.getMessage()));

        }catch (Exception ex){
         ex.printStackTrace();
        }
    }

    public void destroy(@Observes ShutdownEvent event, Vertx vertx){
        System.out.println("AuthorsLifeCycle.destroy() called");
        try {
            ConsulClientOptions options = new ConsulClientOptions()
                    .setHost(consulHost)
                    .setPort(consulPort);

            ConsulClient client = ConsulClient.create(vertx,options);

            ServiceOptions serviceOptions = new ServiceOptions()
                    .setName(appName)
                    .setId(serviceId)
                    .setAddress(ipAddress)
                    .setPort(appPort);

            client.deregisterService(serviceId)
                    .onSuccess(it-> System.out.println("Service deregistered with Consul"+serviceId))
                    .onFailure(it-> System.out.println("Service deregistration failed: "+it.getMessage()));

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
