package de.thaso.demo.sample.consumer.business;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    private GreetingConsumer greetingConsumer;

    @GET
    @Path("/check")
    @Produces(MediaType.TEXT_PLAIN)
    public String check() {

        greetingConsumer.check();
        return "ok";
    }
}
