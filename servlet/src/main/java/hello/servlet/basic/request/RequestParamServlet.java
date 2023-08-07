package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameterNames().asIterator()
                .forEachRemaining(param -> System.out.println(param + "=" + req.getParameter(param)));

        // 단일 파라미터
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        // 중복되는 이름
        String[] usernames = req.getParameterValues("username");
    }
}
