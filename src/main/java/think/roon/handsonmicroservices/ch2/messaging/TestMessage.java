package think.roon.handsonmicroservices.ch2.messaging;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class TestMessage implements Serializable {
    private String id;
    private String content;
}