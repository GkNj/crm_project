package dao;

import entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    public int saveLinkman(String sql) throws SQLException;
    public List<Order> queryForList(String sql) throws SQLException;
    public int update(String id) throws SQLException ;

    public int add(String a, String c_id, String r_id) throws SQLException;
}
