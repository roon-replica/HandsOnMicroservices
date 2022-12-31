package think.roon.handsonmicroservices.ch3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ch3/test")
@RestController
public class SampleApi {

    @GetMapping
    public SampleResponse getTestData(String productId) {
        return new SampleResponse(productId, List.of("review1", "review2"));
    }

    @AllArgsConstructor
    @Getter
    private static class SampleResponse {
        private String productId;
        private List<String> reviews;
    }
}
