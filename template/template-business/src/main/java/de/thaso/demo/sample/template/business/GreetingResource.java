package de.thaso.demo.sample.template.business;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingResource.class);

    @Inject
    private ProducerRestClient producerRestClient;

    @GET
    @Path("/check")
    @Produces(MediaType.TEXT_PLAIN)
    public String check() {
        LOGGER.info("==> check" );
        return "ok / " + producerRestClient.callCheck();
    }

    @GET
    public Greeting greeting(@QueryParam("name") String name)
        throws ExecutionException, InterruptedException, TimeoutException {

        if(StringUtils.isBlank(name)) {
            return producerRestClient.callGreeting(name);
        }
        return new Greeting("Hello World!", "none", ModeEnum.COLLOQUIAL);
    }
}
