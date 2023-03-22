package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Http 응답메시지 (JSON)

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();             //json -> 문자로 변환

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("content-type", "application/json");     //json 형식
        response.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();               //객체에 데이터 삽입
        data.setUsername("kim");
        data.setAge(20);

        System.out.println(data);

        String result = objectMapper.writeValueAsString(data);      //객체를 json형태의 문자로 바꿈

        System.out.println(result);

        response.getWriter().write(result);
    }
}
