package de.thaso.demo.sample.experiment.business.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.thaso.demo.sample.experiment.business.Greeting;
import org.apache.kafka.common.serialization.Serializer;

public class GreetingSerializer implements Serializer<Greeting> {

    @Override
    public byte[] serialize(String s, Greeting employee) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(employee);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
}
