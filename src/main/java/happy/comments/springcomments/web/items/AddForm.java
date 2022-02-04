package happy.comments.springcomments.web.items;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AddForm {
    private Long member_id;
    private Long item_id;
    private String content;
}
