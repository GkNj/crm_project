package controller;


import dao.StatisticDao;
import dao.impl.StatisticDaoImpl;
import org.apache.commons.collections.map.HashedMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/statisticShow.do")
public class StatiticServlet extends HttpServlet {
    static StatisticDaoImpl statisticDao = new StatisticDaoImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        String method = req.getParameter("method");
        System.out.println(method);
        if (method.equalsIgnoreCase("findLost")) {
            System.out.println(123);
            this.findLost(req, resp);
        }
        if (method.equalsIgnoreCase("findByContribute")) {
            this.findByContribute(req, resp);
        }
        if (method.equalsIgnoreCase("findByYear")) {
            this.findByYear(req, resp);
        }
        if(method.equalsIgnoreCase("findByService")){
            this.findByService(req,resp);
        }
        if (method.equalsIgnoreCase("findType")){
            this.findType(req,resp);
        }
    }

    private void findType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("findType");
        Map map = new HashedMap();
        if ("kind".equals(type)){
            map = statisticDao.findByClass();
            req.setAttribute("findType",map);
            req.getRequestDispatcher("/statistics/customerConstructionClass.jsp").forward(req,resp);

        }if ("credit".equals(type)){
            map = statisticDao.findByCredit();
            req.setAttribute("findType",map);
            req.getRequestDispatcher("/statistics/customerConstructionCredit.jsp").forward(req,resp);

        }else {
            map = statisticDao.findBySatifaction();
        }
        req.setAttribute("findType",map);
        req.getRequestDispatcher("/statistics/customerConstructionSatisfication.jsp").forward(req,resp);


    }

    private void findLost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String managerName = req.getParameter("managerid");
        String customerName =req.getParameter("customerid");
        ArrayList list=new ArrayList();
        int id = 0;
        if (managerName==null&&customerName==null) {
            list = statisticDao.findAllLost();
//            req.setAttribute("findLost", all);
        }
//        else {
//        id = statisticDao.findManagerIdByName(managerName);
//        ArrayList<Lost> list = statisticDao.findLostByMannager(id);
//
//        int id1=statisticDao.findCustmerIdByName(customerName);
//        ArrayList<Lost> list1 =statisticDao.findLostByCustomerId(id1);
//        Set<Lost> setlost = new HashSet<>();
//        for (Lost lost : list1){
//            setlost.add(lost);
//        }
//        for (Lost lost:list ){
//            setlost.add(lost);
//        }
//        System.out.println(list);
//        req.setAttribute("findLost", setlost);
           else if((managerName==null&&customerName!=null)||"".equals(managerName)&&!"".equals(customerName)){
            System.out.println("ha");
            id=statisticDao.findCustmerIdByName(customerName);
            list=statisticDao.findLostByCustomerId(id);
            System.out.println(list);
        }else if((managerName!=null&&customerName==null)||!"".equals(managerName)&&"".equals(customerName)){
            System.out.println("haha");
            id=statisticDao.findManagerIdByName(managerName);
            list=statisticDao.findLostByMannager(id);
        }else if((managerName!=null&&customerName!=null)||!"".equals(managerName)&&!"".equals(customerName)){
            System.out.println("hahaha");
            list=statisticDao.findLostCustomer(customerName,managerName);
        }
        req.setAttribute("findLost",list);
        req.getRequestDispatcher("/statistics/customerLost.jsp").forward(req, resp);

    }


    private void findByService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String year = req.getParameter("year");
        Map map=statisticDao.findAllByService(year);
        req.setAttribute("findByService",map);
        System.out.println(map.size());
        req.getRequestDispatcher("/statistics/customerService.jsp").forward(req,resp);
    }

    private void findByYear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerName = req.getParameter("customerName");
        String year = req.getParameter("year");
        Map map = new HashedMap();
        System.out.println(customerName+"hahahaha");
        System.out.println(year+"hahah2");
        System.out.println("".equals(customerName));
        System.out.println("".equals(year));
        System.out.println("".equals(customerName)&&(!"".equals(year)));
        System.out.println(year==null);
        System.out.println(customerName==null);
        if (year==null&&customerName==null){
            map =statisticDao.findByContribute();
        }else {
            System.out.println("进入了else");
            if (("".equals(customerName) && "".equals(year))) {
                System.out.println("year  3");
                map = statisticDao.findByContribute();
            }
                if ("".equals(customerName)&&(!"".equals(year))) {
                    System.out.println("year  1");
                    map = statisticDao.findByYear(year);
                }
                if ((!"".equals(customerName)) &&(!"".equals(year))) {
                    System.out.println("year  2");
                    int id = statisticDao.findCustmerIdByName(customerName);
                    map = statisticDao.findByYear(year, id);
                }
            if ((!"".equals(customerName))&&("".equals(year))) {
                System.out.println("year  4");
                int id = statisticDao.findCustmerIdByName(customerName);
                map = statisticDao.findByContributeById(id);
            }
        }
        req.setAttribute("findByContribute", map);
        System.out.println(map.size());
        req.getRequestDispatcher("/statistics/customerContribute.jsp").forward(req, resp);
    }

    private void findByContribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map map = statisticDao.findByContribute();
        req.setAttribute("findByContribute", map);
        System.out.println(map.size());
        req.getRequestDispatcher("/statistics/customerContribute.jsp").forward(req, resp);

    }

    private void findLostByMannager(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("managerid");
//        StatisticDaoImpl statisticDao=new StatisticDaoImpl();
        int id = 0;
        id = statisticDao.findManagerIdByName(name);
        StatisticDao dao = new StatisticDaoImpl();
        ArrayList list = dao.findLostByMannager(id);
        System.out.println(list);
        req.setAttribute("findLostByMannager", list);
        req.getRequestDispatcher("/statistics/customerLost.jsp").forward(req, resp);
    }

}
