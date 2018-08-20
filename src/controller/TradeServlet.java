package controller;

import dao.TradeDao;
import dao.impl.TradeDaoImpl;
import entity.Customer;
import entity.Trade;
import service.LinkmanService;
import service.TradeService;
import service.impl.LinkmanServiceImpl;
import service.impl.TradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/trade.do")
public class TradeServlet extends HttpServlet {
    TradeService tradeService = new TradeServiceImpl();
    LinkmanService linkmanService = new LinkmanServiceImpl();
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String method = req.getParameter("method");

        try {
            if(method.equalsIgnoreCase("query")){
                this.query(req,res);
            }else if(method.equalsIgnoreCase("delete")){
                this.delete(req,res);
            }else if(method.equalsIgnoreCase("addSave")){
                this.addSave(req,res);
            }else if(method.equalsIgnoreCase("queryById")){
                this.queryById(req,res);
            }else if(method.equalsIgnoreCase("update")){
                this.update(req,res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(method);
    }

    private void addSave(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, SQLException {
        res.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        int id = Integer.valueOf(req.getParameter("cId"));
        System.out.println("来过了servlet");
        String t_time = req.getParameter("t_time");
        String t_address = req.getParameter("t_address");
        String t_detail = req.getParameter("t_detail");
        String t_outline = req.getParameter("t_outline");
        String t_remark = req.getParameter("t_remark");
        Customer customer = new Customer();
        customer.setC_id(id);
        Trade t = new Trade();
        t.setT_time(t_time);
        t.setT_address(t_address);
        t.setT_detail(t_detail);
        t.setT_outline(t_outline);
        t.setT_remark(t_remark);
        t.setCustomer(customer);
        System.out.println("trade" + t.toString());
        int i = tradeService.save(t);
        req.getRequestDispatcher("/trade.do?method=query&c_id="+id).forward(req, res);

    }

    private void delete(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        String tId = req.getParameter("id");
        String cId = req.getParameter("c_id");
        System.out.println(tId);
        System.out.println(cId);
        int i = tradeService.deleteTrade(tId);
        req.getRequestDispatcher("/trade.do?method=query&c_id="+cId).forward(req, res);

    }
    private void queryById(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
        TradeDao dao = new TradeDaoImpl();

        int id = Integer.parseInt(req.getParameter("tId"));
        //System.out.println(id);
        Trade t = dao.queryById(id);
        //System.out.println(t.toString());
        req.setAttribute("trade", t);
        req.setAttribute("t_id",id);
        req.setAttribute("c_id",t.getCustomer().getC_id());
        req.getRequestDispatcher("/customer/tradeupdate.jsp").forward(req, res);
    }
    private void update(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ServletException {

        TradeDao dao = new TradeDaoImpl();
        int id = Integer.parseInt(req.getParameter("t_id"));
        String t_time = req.getParameter("t_time");
        int id1 = Integer.parseInt(req.getParameter("c_id"));
        //System.out.println("id1   "+id1);
        String t_address = req.getParameter("t_address");
        String t_detail = req.getParameter("t_detail");
        String t_outline = req.getParameter("t_outline");
        String t_remark = req.getParameter("t_remark");
        Trade trade = new Trade();
        trade.setT_id(id);
        trade.setT_time(t_time);
        trade.setT_address(t_address);
        trade.setT_detail(t_detail);
        trade.setT_outline(t_outline);
        trade.setT_remark(t_remark);
        int i= dao.update(trade);
        req.getRequestDispatcher("/trade.do?method=query&c_id="+id1).forward(req, res);
    }
    private void query(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
        String id = req.getParameter("c_id");
        List<Trade> list = tradeService.queryForTrade(id);
        req.setAttribute("list", list);
        List<Customer> list1 = linkmanService.queryCustomer(id);
        req.setAttribute("list1",list1);
        req.setAttribute("cId",id);
        req.getRequestDispatcher("/customer/communication.jsp").forward(req, res);
    }
}
