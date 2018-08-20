package controller;

import entity.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/product.do")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("method");

        try {
            if(method.equalsIgnoreCase("query")){
                this.query(req,res);
            }
//            else if(method.equalsIgnoreCase("add")){
//                this.add(req,res);
//            }else if(method.equalsIgnoreCase("addSave")){
//                this.addSave(req,res);
//            }else if(method.equalsIgnoreCase("delete")){
//                this.delete(req,res);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(method);
    }
    private void query(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String oId = req.getParameter("o_id");
        //System.out.println(id);
        List<Product> list = productService.queryForProduct(oId);
        req.setAttribute("list", list);
        System.out.println(list.toString());
        req.getRequestDispatcher("/customer/mingxi.jsp").forward(req, res);
    }
}
