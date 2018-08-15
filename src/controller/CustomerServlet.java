package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mac on 2018/8/15.
 */
@WebServlet("/customer.do")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("method");

        try {
            if(method.equalsIgnoreCase("query")){
                this.query(req,res);
            }else if(method.equalsIgnoreCase("add")){
                this.add(req,res);
            }else if(method.equalsIgnoreCase("addSave")){
                this.addSave(req,res);
            }else if(method.equalsIgnoreCase("delete")){
                this.delete(req,res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse res) {
    }

    private void addSave(HttpServletRequest req, HttpServletResponse res) {
    }

    private void add(HttpServletRequest req, HttpServletResponse res) {
    }

    private void query(HttpServletRequest req, HttpServletResponse res) {
    }
}
