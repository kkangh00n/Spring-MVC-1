package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/members")            //메소드 단위로 컨트롤러를 만들 수 있지만, 중복 url 제거를 위해 클래스 단위의 어노테이션 생성
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("/WEB-INF/views/new-form.jsp");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse
            response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);
        ModelAndView mav = new ModelAndView("/WEB-INF/views/save-result.jsp");
        mav.addObject("member", member);
        return mav;
    }

    @RequestMapping
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();
        ModelAndView mav = new ModelAndView("/WEB-INF/views/members.jsp");
        mav.addObject("members", members);
        return mav;
    }
}
