package de.thaso.demo.sample.producer.web;

import de.thaso.demo.sample.producer.business.GreetingResource;

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
}
