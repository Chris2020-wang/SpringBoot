package springboot.front_endmvcbasics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    //the name messageForm has to math the POJO's name in html
    //if we want to use different name other than messageForm
    //we have to use @ModelAttribute("...") MessageForm ..., to explicitly tell spring, the model in argument is matching
    //which POJO in html
    @GetMapping("/home")
    public String getHomePage(MessageForm messageForm, Model model) {
        model.addAttribute("greetings", this.messageListService.getMessages());
        return "home";
    }

    @PostMapping("/home")
    public String addMessage(MessageForm messageForm, Model model) {
        messageListService.addMessage(messageForm.getText());
        model.addAttribute("greetings", messageListService.getMessages());
        return "home";
    }

}


