package controller;

import dao.LostDao;
import dao.OrderDao;
import dao.impl.LostDaoImpl;
import dao.impl.OrderDaoImpl;
import entity.Lost;
import entity.MyTime;
import entity.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/liushi.do")
public class LiushiServlet extends HttpServlet {
    //    LiushiService liushiService = new LiushiServiceImpl();
    LostDao dao=new LostDaoImpl();
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("method");
        System.out.println(method);
        try {
            if(method.equalsIgnoreCase("query")){
                this.query(req,res);
            }else if(method.equalsIgnoreCase("queryLost")){
                this.queryLost(req,res);
            }else if(method.equalsIgnoreCase("confirm")){
                this.confirm(req,res);
            } else if(method.equalsIgnoreCase("save")){
                this.save(req,res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(method);
    }

    private void confirm(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {

        int id= Integer.parseInt(req.getParameter("l_id"));
        System.out.println("有没有啊啊啊"+id);
        List<Lost> list =dao.queryLost(id);
        req.setAttribute("list", list);
        System.out.println(list.toString());
        req.getRequestDispatcher("/customer/confirm.jsp").forward(req, res);

    }

    private void save(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
//        int id = Integer.valueOf(req.getParameter("l_id"));
        int id= Integer.parseInt(req.getParameter("l_id"));
        System.out.println("有没有"+id);
        String s=null;
        int j=0;
        int i=0;
        String s1=req.getParameter("runadd");
        String s2=req.getParameter("hahaha");
        String s3=req.getParameter("reason");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(s3==null);
        System.out.println(s3);
        if(s3==null||s3.equals("")){
            s=s1+"//"+s2;
            i=dao.runAdd(id,s);
            req.getRequestDispatcher("/liushi.do?method=query").forward(req, res);}
        else{
            s=s3;
            String state="已流失";
            i =dao.reasonAdd(id,s,state);
            req.getRequestDispatcher("/liushi.do?method=query").forward(req, res);
        }
    }

    private void queryLost(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("l_id"));
        System.out.println("有没有啊"+id);
        List<Lost> list =dao.queryLost(id);
        req.setAttribute("list", list);
        System.out.println(list.toString());
        req.getRequestDispatcher("/customer/liushi.jsp").forward(req, res);
//        req.getRequestDispatcher("/customer/liushilist.jsp").forward(req, res);
    }

    private void query(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException, ParseException {
        String login_position= (String) req.getSession().getAttribute("login_position");
        int login_id= (int) req.getSession().getAttribute("login_id");
        String login_name= (String) req.getSession().getAttribute("login_name");
        LostDaoImpl lostDao = new LostDaoImpl();
        List list = new ArrayList();
        if (login_position.equals("高管")){
            list = lostDao.bQueryForList();
        }
        else if (login_position.equals("客户经理")){
            System.out.println("用的这个");
            LostDaoImpl lostDao1 = new LostDaoImpl();
            Map<Integer,Integer> ids= lostDao1.findCustomerIdNotInLost();
            for (int c_id : ids.keySet()) {
                System.out.println(c_id);
                System.out.println(ids.get(c_id));
                orderDays(c_id, ids.get(c_id));
            }
            list=((LostDaoImpl) lostDao).mQueryForLost(login_id);}
        System.out.println(list.size()+"-----------------------------------------");
        req.setAttribute("lostlist",list);
        req.getRequestDispatcher("/customer/liushilist.jsp").forward(req, res);
    }


    public static void orderDays(int id,int login_id) throws ParseException, SQLException {
        OrderService orderService = new OrderServiceImpl();
        List<Order> list = orderService.queryForOrder(id + "");
        long min = 1000000;
        long i = 0;
        String a = null;
        if (list.size() != 0) {
            for (Order order : list) {
                String str = order.getO_time();
                MyTime myTime = new MyTime();
                i = myTime.days(str);
                System.out.println(i);
                System.out.println(a);
                if (i < min) {
                    min = i;
                    a = str;
                }
            }
            System.out.println("ade ===" + a);
            if (min > 180 && min != 100000) {
                OrderDao orderDao = new OrderDaoImpl();
                System.out.println(a);
                orderDao.update(id + "");
                System.out.println("");
                orderDao.add(a, id + "", login_id + "");
            }
        }
    }

}
