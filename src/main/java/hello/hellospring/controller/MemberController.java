package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {


    private final MemberService memberService;

    @Autowired //DI
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members/new") //GET방식
    public String createForm() {
        return "members/createMemberForm"; //-> 이 html 보여줌
    }

    @PostMapping("/members/new")
    //post는 데이터를 등록할떄씀 / get은 데이터를 조회할때 씀
    //createMemberForm.html에서 <input 태그 부분에> 만약 값이 입력되면
    //여기로 들어와서 메소드실행함
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; //회원가입 끝나면 홈화면으로 보내기
    }

    @GetMapping("/members") // 조회기능
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
