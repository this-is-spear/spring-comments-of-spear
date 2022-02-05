package happy.comments.springcomments.domain.comment;

import happy.comments.springcomments.domain.Item;
import happy.comments.springcomments.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@RequiredArgsConstructor
@Table(name = "comment")
public class Comment implements CommentInterface{

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @Column(insertable = true, updatable = false)
    private LocalDateTime createDate;

    @Column(insertable = false, updatable = true)
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member comment_member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    private String content;

    @Override
    public String showContent() {
        return this.content;
    }

    public Comment(Member member, Item item, String content) {
        this.comment_member = member;
        this.item = item;
        this.content = content;
        this.createDate = LocalDateTime.now();
    }

    @Override
    public boolean checkUpdate() {
        return this.updateDate!= null;
    }

    public void updateComment(String content) {
        this.content = content;
        this.updateDate = LocalDateTime.now();
    }

    public boolean checkMember(Member member) {
        return Objects.equals(this.comment_member.getId(), member.getId());
    }
}
