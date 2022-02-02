package happy.comments.springcomments.web;

import happy.comments.springcomments.TestInit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final TestInit testInit;

    @RequestMapping
    public String home() {
        testInit.saveMember();
        testInit.saveItem();

        return "home";
    }
}
