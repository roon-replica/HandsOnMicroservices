package think.roon.handsonmicroservices.ch5;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ch5/test")
@RestController
public class SwaggerSampleApi {

    @ApiOperation(value = "test")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad Request."),
            @ApiResponse(code = 404, message = "Not found."),
            @ApiResponse(code = 422, message = "Unprocessable entity.")
    })
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