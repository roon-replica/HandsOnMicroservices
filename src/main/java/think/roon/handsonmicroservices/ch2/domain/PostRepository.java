package think.roon.handsonmicroservices.ch2.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {
    Optional<Post> findByWriterId(String writerId);
}
