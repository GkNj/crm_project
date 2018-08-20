package controller;

import entity.Customer;
import entity.Order;
import entity.Product;
import service.LinkmanService;
import service.OrderService;
import service.ProductService;
import service.impl.LinkmanServiceImpl;
import service.impl.OrderServiceImpl;
import service.impl.ProductServiceImpl;
import util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/order.do")
public class OrderServlet extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    LinkmanService linkmanService = new LinkmanServiceImpl();
    ProductService productService = new ProductServiceImpl();
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("method");

        try {
            if(method.equalsIgnoreCase("query")){
                this.query(req,res);
            }else if(method.equalsIgnoreCase("queryProduct")){
                this.queryProduct(req,res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(method);
    }

    private void query(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String id = req.getParameter("c_id");
        System.out.println(id);
        List<Order> list = orderService.queryForOrder(id);
        List<Customer> list1 = linkmanService.queryCustomer(id);
        req.setAttribute("list", list);
        req.setAttribute("list1", list1);
        System.out.println(list);
        req.getRequestDispatcher("/customer/history.jsp").forward(req, res);
    }
    private void queryProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String oId = req.getParameter("o_id");
        double sum = 0;
        //System.out.println(id);
        List<Order> list = orderService.queryOrder(oId);
        List<Product> list1 = productService.queryForProduct(oId);
        req.setAttribute("list", list1);
        req.setAttribute("list2", list);
        for(Product product:list1){
            sum = sum+product.getP_price()*product.getP_num();
        }
        System.out.println(sum);
        req.setAttribute("sum",sum);
        //System.out.println(list1.toString());
        req.getRequestDispatcher("/customer/mingxi.jsp").forward(req, res);
    }


    public int update(String id) throws SQLException {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        List<Customer> list = new ArrayList<>();
        String sql = "UPDATE customer set c_state = '"+"暂缓流失"+"' where c_id = ? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,id);
        int rs = ps.executeUpdate();
        return rs;
    }

    public int add(String a,String c_id,String r_id) throws SQLException{
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "insert into lost value (null,'"+a+"',null, '"+"暂缓流失"+"','"+c_id+"',null,'"+r_id+"')";
        ps = conn.prepareStatement(sql);
        System.out.println("daozhele"+sql);
        int rs = ps.executeUpdate();
        return rs;
    }
}
