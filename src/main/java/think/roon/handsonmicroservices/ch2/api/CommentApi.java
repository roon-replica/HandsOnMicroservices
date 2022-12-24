package think.roon.handsonmicroservices.ch2.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import think.roon.handsonmicroservices.ch2.domain.Comment;
import think.roon.handsonmicroservices.ch2.domain.CommentRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentApi {
    private final CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<Comment> comments(){
        return commentRepository.findAll();
    }
}
