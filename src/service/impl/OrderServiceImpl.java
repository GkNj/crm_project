package service.impl;


import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import entity.Linkman;
import entity.Order;
import service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();


    @Override
    public int save(Linkman linkman) throws SQLException {
        return 0;
    }

    @Override
    public List<Order> queryForOrder(String id) throws SQLException {
        System.out.println(id);
        String sql = "select * from orders where c_id = "+id;
        System.out.println(sql);
        return dao.queryForList(sql);
    }

    @Override
    public List<Order> queryOrder(String id) throws SQLException {
        String sql = "select * from orders where o_id = "+id;
        System.out.println(sql);
        return dao.queryForList(sql);
    }

}
