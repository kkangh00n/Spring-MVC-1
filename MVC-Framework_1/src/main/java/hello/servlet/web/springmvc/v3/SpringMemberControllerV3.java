package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")            //회원가입 new-form 페이지를 웹브라우저에 출력
    public String newForm() {
        return "/WEB-INF/views/new-form.jsp";
    }

    @PostMapping("/save")
    //1. 회원가입 버튼을 누르면 save버튼을 통해 save-result 페이지 출력
    //2. @RequestParam을 통해 Http Post메시지의 파라미터들 핸들러가 전달받음
    //3.model을 통해 회원 정보가 들어있는 객체를 뷰가 전달받음

    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "/WEB-INF/views/save-result.jsp";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "/WEB-INF/views/members.jsp";
    }
}
