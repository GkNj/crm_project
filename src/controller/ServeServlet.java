package controller;

import dao.ServeDao;
import dao.impl.ServeDaoImpl;
import entity.Handl;
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
import java.util.List;

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
            if (method.equalsIgnoreCase("query")) {
                this.query(req, resp);
            }
            if (method.equalsIgnoreCase("delete")) {
                this.delete(req, resp);
            }
            if (method.equalsIgnoreCase("fenpei")) {
                this.fenpei(req, resp);
            }
            if (method.equalsIgnoreCase("query1")) {
                this.query1(req, resp);
            }
            if (method.equalsIgnoreCase("query2")) {
                this.query2(req, resp);
            }
            if (method.equalsIgnoreCase("addHandle")) {
                this.addHandle(req, resp);
            }
            if (method.equalsIgnoreCase("query3")) {
                this.query3(req, resp);
            }
            if (method.equalsIgnoreCase("query4")) {
                this.query4(req, resp);
            }
            if (method.equalsIgnoreCase("addResult")) {
                this.addResult(req, resp);
            }
            if (method.equalsIgnoreCase("query5")) {
                this.query5(req, resp);
            }
            if (method.equalsIgnoreCase("query6")) {
                this.query6(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void query6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String keyword = req.getParameter("keyword");
        String id = req.getParameter("id");
        String h_id = req.getParameter("h_id");
        System.out.println(h_id);
        if (keyword == null) {
            keyword = "";
        }
        Role u = (Role) req.getSession().getAttribute("user");
        List<Service> list = service.queryForServe(u, id);
        List<Handl> list1 = service.queryForHandle1(id);
        req.setAttribute("list", list);
        req.setAttribute("handle", list1.get(0));
        System.out.println(list1.toString());
        req.getRequestDispatcher(req.getContextPath() + "service/showplacefile.jsp").forward(req, resp);
    }

    private void query5(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String keyword = req.getParameter("keyword");
//
        if (keyword == null) {
            keyword = "";
        }
        Role u = (Role) req.getSession().getAttribute("user");
        List<Service> list = service.queryForPlacefile(u, keyword);
        req.setAttribute("list", list);
//        System.out.println(list.toString());
        req.getRequestDispatcher(req.getContextPath() + "service/sum.jsp").forward(req, resp);
    }

    private void addResult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int h_id = Integer.parseInt(req.getParameter("h_id"));
        int satification = Integer.parseInt(req.getParameter("satifaction"));
        String id = req.getParameter("id");
        String result = req.getParameter("result");
        Handl handl = new Handl();
        handl.setH_id(h_id);
        handl.setH_result(result);
        handl.setH_stai(satification);
        ServeDao dao = new ServeDaoImpl();
        dao.updateHandle(handl);
        service.updateState(id);
        req.getRequestDispatcher("/serve.do?method=query3").forward(req, resp);


    }

    private void query4(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String keyword = req.getParameter("keyword");
        String id = req.getParameter("id");
        System.out.println(id);
        if (keyword == null) {
            keyword = "";
        }
        Role u = (Role) req.getSession().getAttribute("user");
        List<Service> list = service.queryForServe(u, id);
        List<Handl> list1 = service.queryForHandle(id);
        req.setAttribute("list", list);
        req.setAttribute("handle", list1.get(0));
        System.out.println(list);
        System.out.println(list1.toString());
        req.getRequestDispatcher(req.getContextPath() + "service/editorfeedback.jsp").forward(req, resp);
    }

    private void query3(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String keyword = req.getParameter("keyword");
//        System.out.println(keyword);
        if (keyword == null) {
            keyword = "";
        }
        Role u = (Role) req.getSession().getAttribute("user");
        List<Service> list = service.queryForFeedBackList(u, keyword);
        req.setAttribute("list", list);
//        System.out.println(list.toString());
        req.getRequestDispatcher(req.getContextPath() + "service/feedback.jsp").forward(req, resp);

    }

    private void addHandle(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String s_id = req.getParameter("id");
        String handle = req.getParameter("handle");
        int r_id = (int) req.getSession().getAttribute("login_id");
//        System.out.println(r_id);
        String sTime = req.getParameter("s_time");
//        System.out.println(req.getSession().getAttribute("login_id"));
//        System.out.println(req.getSession().getAttribute("login_name"));
//        System.out.println(req.getSession().getAttribute("login_position"));
        Handl h = new Handl();
        Service service1 = new Service();
        service1.setS_id(Integer.parseInt(s_id));
        h.setService(service1);
        h.setH_handle(handle);
        Role role = new Role();
        role.setR_id(r_id);
        System.out.println(role.toString());
        h.setRole(role);
        h.setH_time(sTime);
        int i = service.addSave(h);
        int a = service.updatestate(s_id);
        req.getRequestDispatcher(req.getContextPath() + "/serve.do?method=query1").forward(req, resp);
    }

    private void query2(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String keyword = req.getParameter("keyword");
        String id = req.getParameter("id");
        System.out.println(id);
        if (keyword == null) {
            keyword = "";
        }
        Role u = (Role) req.getSession().getAttribute("user");
        List<Service> list = service.queryForServe(u, id);
        req.setAttribute("list", list);
        System.out.println(list.toString());
        req.getRequestDispatcher(req.getContextPath() + "service/editormanage.jsp").forward(req, resp);
    }

    private void query1(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String keyword = req.getParameter("keyword");

//        System.out.println(keyword);
        if (keyword == null) {
            keyword = "";
        }
        Role u = (Role) req.getSession().getAttribute("user");
        List<Service> list = service.queryForServiceList(u, keyword);
        req.setAttribute("list", list);
//        System.out.println(list.toString());
        req.getRequestDispatcher(req.getContextPath() + "service/manage.jsp").forward(req, resp);

    }

    private void fenpei(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String s_id = req.getParameter("id");
        String dispose = req.getParameter("dispose");
        System.out.println(s_id);
        System.out.println(dispose);
        int i = service.update(s_id, dispose);
        resp.sendRedirect(req.getContextPath() + "/serve.do?method=query");
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String id = req.getParameter("id");
        int i = service.delete(id);
        resp.sendRedirect(req.getContextPath() + "/serve.do?method=query");
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String keyword = req.getParameter("keyword");
//        System.out.println(keyword);
        if (keyword == null) {
            keyword = "";
        }
        Role u = (Role) req.getSession().getAttribute("user");
        List<Service> list = service.queryForCustomerList(u, keyword);
        req.setAttribute("list", list);
//        System.out.println(list.toString());
        req.getRequestDispatcher(req.getContextPath() + "service/allocation.jsp").forward(req, resp);

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
        s.setS_time(s_time.trim());
        int i = service.save(s);
        System.out.println(i);
        req.getRequestDispatcher("/service/create.jsp").forward(req, resp);
    }


}
