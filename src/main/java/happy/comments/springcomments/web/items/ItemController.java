package happy.comments.springcomments.web.items;

import happy.comments.springcomments.domain.Item;
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
        log.info("id {}", itemId);
        Item item = itemRepository.findById(itemId).stream().findFirst().orElse(null);
        if (item == null) {
            return "redirect:/";
        }
        model.addAttribute("item", item);

        return "item/item-detail";
    }

    @PostMapping("/comments/edit")
    public String editComment(@ModelAttribute EditForm editForm) {
        return "";
    }

    @PostMapping("/comments/add")
    public String addComment(){
        return "";
    }
}
