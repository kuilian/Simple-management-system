package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author KuiLian
 * @date 2020/6/11 - 18:18
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.���ñ���
        request.setCharacterEncoding("utf-8");

        //2.��ȡ����
        //2.1��ȡ�û���д��֤��
        String verifycode = request.getParameter("verifycode");

        //3.��֤��У��
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//ȷ����֤��һ����
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //��֤�벻��ȷ
            //��ʾ��Ϣ
            request.setAttribute("login_msg","��֤�����");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            return;
        }

        Map<String, String[]> map = request.getParameterMap();
        //4.��װUser����
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //5.����Service��ѯ
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);
        //6.�ж��Ƿ��¼�ɹ�
        if(loginUser != null){
            //��¼�ɹ�
            //���û�����session
            session.setAttribute("user",loginUser);
            //��תҳ��
       response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            //��¼ʧ��
            //��ʾ��Ϣ
            System.out.println(loginUser);
            request.setAttribute("login_msg","�û������������");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
