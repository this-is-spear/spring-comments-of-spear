package happy.comments.springcomments.domain;

import happy.comments.springcomments.domain.comment.Comment;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    //    private Long member_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String itemTitle;

    private String content;

    private int price;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
}
