package happy.comments.springcomments.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String itemTitle;

    private String contents;

    private int price;

    @OneToMany(mappedBy = "item")
    @ToString.Exclude
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void updateComment(Comment comment) {
        comments.add(comment);
        comment.setItem(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return id != null && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
