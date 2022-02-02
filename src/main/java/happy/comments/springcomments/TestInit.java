package happy.comments.springcomments;

import happy.comments.springcomments.domain.Comment;
import happy.comments.springcomments.domain.Item;
import happy.comments.springcomments.domain.Member;
import happy.comments.springcomments.repository.CommentRepository;
import happy.comments.springcomments.repository.ItemRepository;
import happy.comments.springcomments.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class TestInit {

    private final ItemRepository itemRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    public TestInit(ItemRepository itemRepository, CommentRepository commentRepository, MemberRepository memberRepository) {
        this.itemRepository = itemRepository;
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void inIt() {

        Member member = new Member();
        member.setName("tis");
        memberRepository.save(member);

        Item item = new Item();
        item.setItemTitle("a"+1);
        item.setMember(member);
        item.setPrice(20000);
        for (long i = 0L; i < 200L; i++) {
            Comment comment = new Comment();
            comment.setContent("comment"+i);
            item.updateComment(comment);
            commentRepository.save(comment);
        }
        itemRepository.save(item);
    }

    public void saveMember() {
        Member member = new Member();
        member.setName("tis");
        memberRepository.save(member);
    }

    public void saveItem() {
        Member member = new Member();
        member.setName("tis");
        memberRepository.save(member);

        Item item = new Item();
        item.setItemTitle("a"+1);
        item.setMember(member);
        item.setPrice(20000);
        item.setContents("item test");
        itemRepository.save(item);

        for (long i = 0L; i < 200L; i++) {
            Comment comment = new Comment();
            comment.setContent("comment"+i);
            comment.setMember(member);
            comment.setItem(item);
            commentRepository.save(comment);
        }
    }
}
