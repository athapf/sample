package de.thaso.demo.sample.template.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ProducerRestClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerRestClient.class);

    public String callCheck() {
        Client client = ClientBuilder.newClient();
        final Response response = client.target("http://localhost:8080")
            .path("thaso/sample/producer/api/greeting/check")
            .request()
            .accept(MediaType.TEXT_PLAIN)
            .get();
        LOGGER.info("==> producer check : " + response.getStatus());
        return response.readEntity(String.class);
    }

    public Greeting callGreeting(final String name) {
        Client client = ClientBuilder.newClient();
        final Response response = client.target("http://localhost:8080")
            .path("thaso/sample/producer/api/greeting")
            .queryParam("name", name)
            .request()
            .accept(MediaType.APPLICATION_JSON)
            .get();
        LOGGER.info("==> producer greeting : " + response.getStatus());
        return response.readEntity(Greeting.class);
    }
}
