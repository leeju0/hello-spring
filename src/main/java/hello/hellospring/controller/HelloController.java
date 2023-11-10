package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //웹 에서 /hello url로 들어오면 아래 메소드호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
                                       // key                 value
        return "hello"; //hello.html에게 가라



    }
}
