package controller;

import dao.ServeDao;
import dao.impl.ServeDaoImpl;
import entity.Role;
import entity.Service;
import service.ServeService;
import service.impl.ServeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/serve.do")
public class ServeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServeService service = new ServeServiceImpl();
    private ServeDao dao = new ServeDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        String method = req.getParameter("method");
        try {
            if (method.equalsIgnoreCase("create")) {
                this.create(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        String s_type = req.getParameter("s_type");
        String s_detail = req.getParameter("s_detail");
        String customer = req.getParameter("customer");
        String s_state = req.getParameter("s_state");
        String s_request = req.getParameter("s_request");
        String role = req.getParameter("role");
        String s_time = req.getParameter("s_time");
        Service s = new Service();
        s.setS_type(s_type);
        s.setS_detail(s_detail);
        s.setCustomer(dao.queryForCustomer("select * from customer where c_name='" + customer + "'"));
        s.setS_state(s_state);
        s.setS_request(s_request);
        Role role1 = dao.queryForRole("select * from role where r_name='" + role + "'");
        s.setRole(role1);
        s.setS_time(s_time);
        System.out.println(s.toString());
        int i = service.save(s);
        System.out.println(i);
        req.getRequestDispatcher("/service/create.jsp").forward(req, resp);
    }
}
