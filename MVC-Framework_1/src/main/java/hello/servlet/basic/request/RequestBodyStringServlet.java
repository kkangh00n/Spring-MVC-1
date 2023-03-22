package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//Http 요청방식 (api 문자열 메시지 방식)

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();      //스트림 형식으로 넘어옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        //스트림 형식을 문자형으로 바꿔줌

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
