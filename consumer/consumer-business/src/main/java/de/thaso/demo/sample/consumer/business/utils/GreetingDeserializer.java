package de.thaso.demo.sample.consumer.business.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.thaso.demo.sample.consumer.business.Greeting;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class GreetingDeserializer implements Deserializer<Greeting> {

    @Override
    public Greeting deserialize(String topic, byte[] bytes) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(bytes, Greeting.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
