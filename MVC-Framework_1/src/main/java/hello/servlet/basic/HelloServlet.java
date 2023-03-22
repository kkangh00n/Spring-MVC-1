package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//서블릿 매개변수

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);     //요청
        System.out.println("response = " + response);   //응답

        String username = request.getParameter("username");
        System.out.println("username = " + username);


        //HTTP 응답 메시지의 데이터 담기
        response.setContentType("text/plain");                 //헤더에 들어감
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello" + username);     //응답 메시지 바디에 들어감


    }
}
