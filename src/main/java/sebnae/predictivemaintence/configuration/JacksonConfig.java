package sebnae.predictivemaintence.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sebnae.predictivemaintence.model.Sensor;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();

        module.addDeserializer(Sensor.class, new SensorsDeserializer());

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
