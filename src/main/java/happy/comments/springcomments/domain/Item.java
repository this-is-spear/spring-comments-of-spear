package happy.comments.springcomments.domain;

import lombok.*;

import javax.persistence.*;

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

    private Long member_id;

    private String itemTitle;

    private String content;

    private int price;


}
