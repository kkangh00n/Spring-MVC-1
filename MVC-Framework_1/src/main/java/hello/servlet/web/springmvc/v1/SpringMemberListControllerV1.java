package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members")
    public ModelAndView process() {

        //==================로직 실행====================
        List<Member> members = memberRepository.findAll();

        //===================뷰 리졸버에 모델 전달=================
        ModelAndView mv = new ModelAndView("/WEB-INF/views/members.jsp");
        mv.addObject("members", members);
        return mv;
    }
}
