package happy.comments.springcomments.web.items;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@RequiredArgsConstructor
public class EditForm {
    private Long comment_id;
    private Long member_id;
    private Long item_id;
    private String content;
}
