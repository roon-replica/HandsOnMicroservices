package think.roon.handsonmicroservices.ch2.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, String> {
    Optional<Post> findByWriterId(String writerId);
}
