package controller;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import entity.Role;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login_name = req.getParameter("login_name");
        String login_position = req.getParameter("login_position");
        String login_password = req.getParameter("login_password");
        LoginDao dao = new LoginDaoImpl();
//        System.out.println(login_name);
//        System.out.println(login_password);
        Role role = dao.login(login_name, login_password);
//        System.out.println(role != null);
//        System.out.println(role.toString());
//        System.out.println(login_position);
//        System.out.println(role.getR_position()==(login_position));

        if (role != null &&role.getR_position().equals(login_position)) {
            req.getSession().setAttribute("login_name",login_name );
            req.getSession().setAttribute("login_id",role.getR_id() );
            req.getSession().setAttribute("login_position",role.getR_position() );
            req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("/views/error.jsp");
        }
    }
}
