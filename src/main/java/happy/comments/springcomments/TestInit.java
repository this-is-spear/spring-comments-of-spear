package happy.comments.springcomments;

import happy.comments.springcomments.domain.Item;
import happy.comments.springcomments.domain.Member;
import happy.comments.springcomments.domain.comment.Comment;
import happy.comments.springcomments.repository.CommentRepository;
import happy.comments.springcomments.repository.ItemRepository;
import happy.comments.springcomments.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestInit {

    private final ItemRepository itemRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    @PostConstruct
    public void saveComments() {
        Item item = new Item();
        item.setItemTitle("testItem");
        item.setPrice(1000);
        item.setContent("testContent");
        itemRepository.save(item);

        Member member = new Member();
        member.setName("tis");
        memberRepository.save(member);

        Comment comment = new Comment(item.getId(), member.getId(),"this content");
        commentRepository.save(comment);
    }
}
