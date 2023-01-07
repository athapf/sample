package de.thaso.demo.sample.producer.business;

import de.thaso.demo.sample.producer.business.utils.GreetingSerializer;
import org.apache.commons.lang3.StringUtils;

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
    private GreetingProducer greetingProducer;

    @GET
    @Path("/check")
    @Produces(MediaType.TEXT_PLAIN)
    public String check() {
        return "ok";
    }

    @GET
    public Greeting greeting(@QueryParam("name") String name)
        throws ExecutionException, InterruptedException, TimeoutException {

        if(StringUtils.isBlank(name)) {
            return greetingProducer.sendEmployee(new Greeting("Hello, World!", "myself", ModeEnum.COLLOQUIAL));
        }
        return new Greeting("Hello World!", "none", ModeEnum.COLLOQUIAL);
    }
}
