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

@WebServlet(name = "reqeustBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream(); // 메세지 바디의 내용을 바이트 코드로 얻을 수 있다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// 바이트를 문자로 변환(매개변수는 어떤 인코딩인지 알려줌)

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("OK");
    }
}
