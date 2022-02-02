package happy.comments.springcomments.web.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/items")
public class ItemController {

    @RequestMapping("/{itemId}")
    public String itemDetail(@PathVariable Long itemId, Model model) {

        return "item/item-detail";
    }
}
