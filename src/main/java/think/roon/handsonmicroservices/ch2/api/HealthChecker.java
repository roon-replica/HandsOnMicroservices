package think.roon.handsonmicroservices.ch2.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthChecker {
    @GetMapping(value = "/test", produces = "application/json")
    public List<String> test() {
        return List.of("status", "200", "OK");
    }
}
