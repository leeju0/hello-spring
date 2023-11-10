package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") //웹 에서 /hello url로 들어오면 아래 메소드호출
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        // key                 value
        return "hello"; //hello.html에게 가라
    }

    @GetMapping("hello-mvc") //이번엔 파라미터로 값을 받아보자. name값 받아오기
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
