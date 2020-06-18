package web.Filter;

import com.sun.jndi.toolkit.url.Uri;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author KuiLian
 * @date 2020/6/15 - 15:10
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")  || uri.contains("/css/*") || uri.contains("/fonts/*") || uri.contains("/js/*")|| uri.contains("/check")) {
            System.out.println(uri);
            chain.doFilter(req, resp);

        }else {
            Object user = request.getSession().getAttribute("user");
            if (user!=null){
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_msg","ÄúÎ´µÇÈë");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

//        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
