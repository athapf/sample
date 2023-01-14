package de.thaso.demo.sample.experiment.business;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class GreetingProducer {
    private final static Logger LOGGER = LoggerFactory.getLogger(GreetingProducer.class);

private final Random random = new Random();

    @Outgoing("prices-out")
    public Multi<Double> generate() {
        // Build an infinite stream of random prices
        // It emits a price every 4 seconds
        return Multi.createFrom().ticks().every(Duration.ofSeconds(4))
                .map(x -> random.nextDouble());
    }
}
