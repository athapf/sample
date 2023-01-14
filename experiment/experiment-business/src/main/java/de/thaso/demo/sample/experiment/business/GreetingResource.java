package de.thaso.demo.sample.experiment.business;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Path("/greeting")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    @ConfigProperty(name = "experiment.message")
    private String message;

    @Inject
    private GreetingProducer greetingProducer;

    @GET
    @Path("/check")
    @Produces(MediaType.TEXT_PLAIN)
    public String check() {
        return "ok - " + message;
    }

    @GET
    public Greeting greeting(@QueryParam("name") String name)
        throws ExecutionException, InterruptedException, TimeoutException {

        greetingProducer.generate();

        return new Greeting(message, name, ModeEnum.COLLOQUIAL);
    }
}
