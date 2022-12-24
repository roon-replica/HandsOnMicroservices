package think.roon.handsonmicroservices.ch2.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PostDao {
    private final MongoTemplate mongoTemplate;

    public List<Post> findPostByWriterId(String writerId) {
        Query mongoQuery = new Query();
        mongoQuery.addCriteria(Criteria.where("writerId").is(writerId));

        return mongoTemplate.find(mongoQuery, Post.class);
    }

    public List<Post> findAll() {
        return mongoTemplate.findAll(Post.class);
    }
}
