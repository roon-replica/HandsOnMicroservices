package think.roon.handsonmicroservices.ch2.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import think.roon.handsonmicroservices.ch2.messaging.TestMessage;
import think.roon.handsonmicroservices.ch2.messaging.TestPublisher;

@RequiredArgsConstructor
@RestController
public class MessagingApi {
    private final TestPublisher testPublisher;

    @GetMapping("/create-message")
    public String createMessage(){
        return testPublisher.processMessage(new TestMessage("testId","testContent"));
    }
}
