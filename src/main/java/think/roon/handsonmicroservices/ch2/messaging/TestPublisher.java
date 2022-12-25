package think.roon.handsonmicroservices.ch2.messaging;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Getter
@Component
@EnableBinding(Source.class)
public class TestPublisher {
    @Autowired
    private Source testSource;

    public String processMessage(TestMessage message){
        testSource.output().send(MessageBuilder.withPayload(message).build());

        return "message published";
    }
}
