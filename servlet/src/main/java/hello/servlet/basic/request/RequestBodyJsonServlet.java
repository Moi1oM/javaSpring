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

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        String meessage = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("meessage = " + meessage);
        HelloData helloData = objectMapper.readValue(meessage, HelloData.class);
        System.out.println("username = " + helloData.getUsername());
        System.out.println("age = " + helloData.getAge());
    }
}
