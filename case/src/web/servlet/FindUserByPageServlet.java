package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author KuiLian
 * @date 2020/6/14 - 1:17
 */
@WebServlet("/FindUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        if (currentPage==null || currentPage.equals("")){
            currentPage="1";
        }
        if (rows==null || rows.equals("")){
            rows="5";
        }
        Map<String, String[]> codition = request.getParameterMap();
        request.setAttribute("condition",codition);

        UserService service = new UserServiceImpl();
       PageBean pb= service.findUserByPage(currentPage,rows,codition);
        System.out.println(pb);
       request.setAttribute("pb",pb);
       request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
