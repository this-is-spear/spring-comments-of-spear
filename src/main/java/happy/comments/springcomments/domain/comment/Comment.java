package happy.comments.springcomments.domain.comment;

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

    private Long member_id;
    private Long item_id;
    private String content;

    @Override
    public String showContent() {
        return this.content;
    }

    public Comment(Long member_id, Long item_id, String content) {
        this.member_id = member_id;
        this.item_id = item_id;
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

    public boolean checkMember(Long member_id) {
        return Objects.equals(this.member_id, member_id);
    }
}
