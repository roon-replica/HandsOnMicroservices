package think.roon.handsonmicroservices.ch2.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import think.roon.handsonmicroservices.ch2.domain.Post;
import think.roon.handsonmicroservices.ch2.domain.PostDao;
import think.roon.handsonmicroservices.ch2.domain.PostRepository;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApi {
    private final PostRepository postRepository;
    private final PostDao postDao;

    @GetMapping("/posts/post")
    public Post getPostByWriterId(String writerId){
        return postRepository.findByWriterId(writerId).orElse(null);
    }

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postRepository.findAll();
    }
}
