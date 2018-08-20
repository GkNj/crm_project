package controller;

import dao.CustomerDao;
import dao.RoleDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.RoleDaoImpl;
import entity.Customer;
import entity.Role;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
@WebServlet(urlPatterns = "/customer.do")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();
    private RoleDao roledao = new RoleDaoImpl();
    private CustomerDao customerdao = new CustomerDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("method");

        System.out.println(method);
        try {
            System.out.println(method.equalsIgnoreCase("queryById"));
            System.out.println("come on babalalala");
            if(method.equalsIgnoreCase("query")){
                this.query(req,res);
            }else if(method.equalsIgnoreCase("queryById")){
                System.out.println("来了");
                this.queryById(req,res);
            }else if(method.equalsIgnoreCase("queryManager")){
                this.queryManager(req,res);
            }else if(method.equalsIgnoreCase("addSave")){
                this.addSave(req,res);
            }else if(method.equalsIgnoreCase("delete")){
                this.delete(req,res);
            }else if(method.equalsIgnoreCase("update")){
                this.update(req,res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void queryManager(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        System.out.println("servlet到了");
        List<Role> list = roledao.queryForList();
        req.setAttribute("roleList", list);
        System.out.println(list.toString());
        req.getRequestDispatcher("/customer/connoisseuradd.jsp").forward(req, res);
    }

    private void update(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {

        int id = Integer.parseInt(req.getParameter("cId"));
        res.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String c_name = req.getParameter("c_name");
        String c_area = req.getParameter("c_area");
        String c_class = req.getParameter("c_class");
        int c_satifaction = Integer.valueOf(req.getParameter("c_satifaction"));
        System.out.println(c_satifaction);
        int c_credit =Integer.parseInt(req.getParameter("c_credit"));
        String c_address = req.getParameter("c_address");
        String c_portcode = req.getParameter("c_portcode");
        String c_tel = req.getParameter("c_tel");
        String c_website = req.getParameter("c_website");
        String c_state="正常";//默认为正常的

        Customer c = new Customer();
        c.setC_id(id);
        c.setC_name(c_name);
        c.setC_area(c_area);
        c.setC_class(c_class);
        c.setC_satifaction(c_satifaction);
        c.setC_credit(c_credit);
        c.setC_address(c_address);
        c.setC_portcode(c_portcode);
        c.setC_tel(c_tel);
        c.setC_website(c_website);
        c.setC_state(c_state);
//        System.out.println(c.toString());
        int i= customerdao.update(c);
        System.out.println(i);
        res.sendRedirect(req.getContextPath()+"/customer.do?method=query");
    }


    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {

        System.out.println("这是Servlet");
        String cId = req.getParameter("cId");
        System.out.println(cId);
        int i = customerService.deleteCustomer(cId);
        res.sendRedirect(req.getContextPath()+"/customer.do?method=query");
    }

    private void addSave(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException {
        res.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String c_name = req.getParameter("c_name");
        String c_area = req.getParameter("c_area");
        Role role = new Role();
        System.out.println(req.getSession().getAttribute("login_id"));
        System.out.println(req.getSession().getAttribute("login_name"));
//        System.out.println(req.getParameter("c_manager"));
        role.setR_id(Integer.parseInt(String.valueOf(req.getSession().getAttribute("login_id"))));
        String c_class = req.getParameter("c_class");
        int c_satifaction = Integer.parseInt(req.getParameter("c_satifaction"));
        int c_credit =Integer.parseInt(req.getParameter("c_credit"));
        String c_address = req.getParameter("c_address");
        String c_portcode = req.getParameter("c_portcode");
        String c_tel = req.getParameter("c_tel");
        String c_website = req.getParameter("c_website");
        String c_state="正常";//默认为正常的

        Customer c = new Customer();
        c.setC_name(c_name);
        c.setC_area(c_area);
        c.setC_manager(role);
        c.setC_class(c_class);
        c.setC_satifaction(c_satifaction);
        c.setC_credit(c_credit);
        c.setC_address(c_address);
        c.setC_portcode(c_portcode);
        c.setC_tel(c_tel);
        c.setC_website(c_website);
        c.setC_state(c_state);
        System.out.println(c.toString());
        int i = customerService.save(c);
        res.sendRedirect(req.getContextPath()+"/customer.do?method=query");


    }


    private void query(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        String login_position= (String) req.getSession().getAttribute("login_position");
        int login_id= (int) req.getSession().getAttribute("login_id");
        String login_name= (String) req.getSession().getAttribute("login_name");
        CustomerDaoImpl customerdao = new CustomerDaoImpl();
        List<Customer> list = new ArrayList();
        if (login_position.equals("高管")){
            System.out.println("是高官  来这儿了");
            list = customerdao.queryall();
            System.out.println("高管"+list.toString());
        }
        else if (login_position.equals("客户经理"))
            list=((CustomerServiceImpl) customerService).queryForCustomerList(login_id);
        req.setAttribute("list", list);
        //System.out.println(list);
        req.getRequestDispatcher("/customer/connoisseur.jsp").forward(req, res);
    }


    private void queryById(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        CustomerDao dao = new CustomerDaoImpl();
        int id = Integer.parseInt(req.getParameter("cId"));
        System.out.println(id);
        Customer c = dao.queryById(id);
        req.setAttribute("customer", c);
        System.out.println(c);
        req.getRequestDispatcher("/customer/connoisseurupdate.jsp").forward(req, res);
    }
}
