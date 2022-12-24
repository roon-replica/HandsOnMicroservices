package think.roon.handsonmicroservices.ch2.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@IdClass(CommentPK.class)
@Table(name = "comment")
@Entity
public class Comment {
    @Id private String postId;
    @Id private String writerId;

    private String content;
    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;
}
