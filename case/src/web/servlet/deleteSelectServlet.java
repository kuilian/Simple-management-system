package web.servlet;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author KuiLian
 * @date 2020/6/13 - 16:54
 */
@WebServlet("/deleteSelectServlet")
public class deleteSelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String[] ids = request.getParameterValues("uid");
        UserService service = new UserServiceImpl();
        for (String id : ids) {
            service.deleteSelected(Integer.parseInt(id));
        }

        response.sendRedirect("/FindUserByPageServlet");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
