package controller;


import entity.Customer;
import entity.Linkman;
import entity.Role;
import dao.impl.LinkmanDaoImpl;
import dao.LinkmanDao;
import service.LinkmanService;
import service.impl.LinkmanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
@WebServlet(urlPatterns = "/linkman.do")
public class LinkmanServlet extends HttpServlet {

    private LinkmanService linkmanService = new LinkmanServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("method");

        System.out.println(method);
        try {
            if(method.equalsIgnoreCase("query")){
                this.query(req,res);
            }else if(method.equalsIgnoreCase("queryById")){
                this.queryById(req,res);
            }else if(method.equalsIgnoreCase("delete")) {
                this.delete(req, res);
            }else if(method.equalsIgnoreCase("addSave")){
                this.addSave(req,res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void queryById(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LinkmanDao dao = new LinkmanDaoImpl();
        int id = Integer.parseInt(req.getParameter("lId"));
        System.out.println(id);
        Linkman l = dao.queryById(id);
        req.setAttribute("linkman", l);
        System.out.println(l);
        req.getRequestDispatcher("/customer/linkmanupdate.jsp").forward(req, res);
    }

    private void addSave(HttpServletRequest req, HttpServletResponse res) throws Exception {
            res.setCharacterEncoding("utf-8");
            req.setCharacterEncoding("utf-8");
            int id = Integer.valueOf(req.getParameter("cId"));
            System.out.println("来过了servlet");
            String l_name = req.getParameter("l_name");
            String l_position = req.getParameter("l_position");
            String l_tel = req.getParameter("l_tel");
            String l_phone = req.getParameter("l_phone");
            String l_remark = req.getParameter("l_remark");
            Customer customer = new Customer();
            customer.setC_id(id);
            Linkman l = new Linkman();
            l.setL_name(l_name);
            l.setL_position(l_position);
            l.setL_tel(l_tel);
            l.setL_phone(l_phone);
            l.setL_remark(l_remark);
            l.setCustomer(customer);
            System.out.println("linkman" + l.toString());
            int i = linkmanService.save(l);
            req.getRequestDispatcher("/linkman.do?method=query&c_id="+id).forward(req, res);
//            res.sendRedirect(req.getContextPath() + "/linkman.do?method=query");
    }

    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        String lId = req.getParameter("id");
        String cId = req.getParameter("c_id");
        System.out.println(cId);
        int i = linkmanService.deleteLinkman(lId);
        //res.sendRedirect(req.getContextPath()+"/linkman.do?method=query");
        req.getRequestDispatcher("/linkman.do?method=query&c_id="+cId).forward(req, res);
    }


    private void query(HttpServletRequest req, HttpServletResponse res) throws SQLException,ServletException, IOException {
        String id = req.getParameter("c_id");
        System.out.println(id);
        List<Linkman> list = linkmanService.queryForLinkman(id);
        req.setAttribute("list", list);
        List<Customer> list1 = linkmanService.queryCustomer(id);
        req.setAttribute("list1",list1);
        req.setAttribute("cId",id);
        req.getRequestDispatcher("/customer/linkman.jsp").forward(req, res);
    }

}
