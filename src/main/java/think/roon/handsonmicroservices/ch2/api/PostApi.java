package think.roon.handsonmicroservices.ch2.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import think.roon.handsonmicroservices.ch2.domain.Post;
import think.roon.handsonmicroservices.ch2.domain.PostRepository;

@RequiredArgsConstructor
@RestController
public class PostApi {
    private final PostRepository postRepository;

    @GetMapping("/posts")
    public Post getPostByWriterId(String writerId){
        return postRepository.findByWriterId(writerId).orElse(null);
    }
}
