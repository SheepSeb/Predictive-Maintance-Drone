package sebnae.predictivemaintence.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sebnae.predictivemaintence.model.Drone;
import sebnae.predictivemaintence.model.Motor;
import sebnae.predictivemaintence.model.Sensors.IMUSensor;

@RestController
public class DroneController {
    private final ObjectMapper objectMapper;

    DroneController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostMapping("/drone")
    public String drone(@RequestBody String drone) throws JsonProcessingException {
        System.out.println(drone);
        Drone drone1 = objectMapper.readValue(drone, Drone.class);
        System.out.println("Drone ID: " + drone1);
        return "Value: " + (((Motor) drone1.getMotors().get(0)).getTimestamp());
    }
}
