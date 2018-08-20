package service;

import entity.Linkman;
import entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    public int save(Linkman linkman) throws SQLException;
    public List<Order> queryForOrder(String id) throws SQLException;
    public List<Order> queryOrder(String id) throws SQLException;

}
