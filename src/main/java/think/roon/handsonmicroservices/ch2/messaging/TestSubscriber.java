package think.roon.handsonmicroservices.ch2.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(Sink.class)
public class TestSubscriber {
    @StreamListener(target = Sink.INPUT)
    public void receive(TestMessage message) {
        log.info("received: {}", message);
    }
}
