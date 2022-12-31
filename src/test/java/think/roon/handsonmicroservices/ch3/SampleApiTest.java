package think.roon.handsonmicroservices.ch3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleApiTest {
    @Autowired
    private WebTestClient client;

    @Test
    public void getTestData() { //테스트가 되긴하는데 너무 느리다..
        String productId = "123";

        client.get()
                .uri("/ch3/test?productId=" + productId)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.productId").isEqualTo("123")
                .jsonPath("$.reviews.length()").isEqualTo(2)
                .jsonPath("$.reviews[0]").isEqualTo("review1");

    }
}