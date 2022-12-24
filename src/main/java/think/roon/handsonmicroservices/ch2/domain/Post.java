package think.roon.handsonmicroservices.ch2.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document
public class Post {
    @Id
    private String id;

    @Version
    private int version;

    private String writerId;
    private String content;
    private int rate;

    @CollectionTable(name = "comment_pks")
    @ElementCollection
    private List<CommentPK> commentPKList;
}
