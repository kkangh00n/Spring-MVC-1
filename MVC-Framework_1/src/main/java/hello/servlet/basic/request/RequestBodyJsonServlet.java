package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//Http 요청방식 (api JSON 메시지 방식)

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();         //JSON형식의 메시지를 객체로 변환하기 위함

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();          //JSON도 결국은 문자라서, stream형식으로 넘어옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        //Post메소드로 요청된 JSON메시지

        System.out.println("messageBody = " + messageBody);         //JSON 메시지 출력

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        //JSON메시지를 HelloData객체로 바꿈

        System.out.println("helloData.username = " + helloData.getUsername());
        System.out.println("helloData.age = " + helloData.getAge());
        response.getWriter().write("ok");
    }
}
