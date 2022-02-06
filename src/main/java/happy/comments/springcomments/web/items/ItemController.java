package happy.comments.springcomments.web.items;

import happy.comments.springcomments.domain.Item;
import happy.comments.springcomments.domain.Member;
import happy.comments.springcomments.domain.comment.Comment;
import happy.comments.springcomments.repository.CommentRepository;
import happy.comments.springcomments.repository.ItemRepository;
import happy.comments.springcomments.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
@Slf4j
public class ItemController {

    private final ItemRepository itemRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/{itemId}")
    public String itemDetail(@PathVariable Long itemId, Model model) {
        log.info("id : {}", itemId);
        Item item = itemRepository.findById(itemId).stream().findFirst().orElse(null);
        if (item == null) {
            return "redirect:/";
        }
        model.addAttribute("item", item);

        return "item/item-detail";
    }

    @PostMapping("/comments/edit")
    public String editComment(@RequestBody EditForm editForm) {
        log.info("editForm : [{}][{}]",editForm.getMember_id(), editForm.getContent());
        try {
            Comment editComment = commentRepository.findById(editForm.getComment_id()).orElseThrow(NoSuchFieldError::new);
            Member member = memberRepository.findById(editForm.getMember_id()).orElseThrow(NoSuchFieldError::new);
            if (editComment.checkMember(member)) {
                editComment.updateComment(editForm.getContent());
                commentRepository.save(editComment);
            }
        } catch (Exception e) {
            log.error("[{}][{}]",this.getClass(), e.getMessage());
        }
        return "redirect:/items/"+editForm.getItem_id();
    }

    @PostMapping("/comments/add")
    public String addComment(@RequestBody AddForm addForm){
        log.info("addForm : [{}][{}]",addForm.getMember_id(), addForm.getContent());
        try {
            Item item = itemRepository.findById(addForm.getItem_id()).orElseThrow(NoSuchFieldError::new);
            Member member = memberRepository.findById(addForm.getMember_id()).orElseThrow(NoSuchFieldError::new);
            Comment comment = new Comment(member, item, addForm.getContent());
            commentRepository.save(comment);
        } catch (Exception e) {
            log.error("[{}][{}]",this.getClass(), e.getMessage());
        }
        return "redirect:/items/"+addForm.getItem_id();
    }
}
