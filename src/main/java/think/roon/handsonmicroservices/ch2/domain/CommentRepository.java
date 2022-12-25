package think.roon.handsonmicroservices.ch2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, CommentPK> {
}
