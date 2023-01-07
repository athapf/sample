package de.thaso.demo.sample.consumer.web;

import de.thaso.demo.sample.consumer.business.GreetingConsumer;
import de.thaso.demo.sample.consumer.business.GreetingResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api")
public abstract class WebApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(GreetingResource.class);
        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> resources = new java.util.HashSet<>();
        resources.add(GreetingConsumer.class);
        return resources;
    }
}
