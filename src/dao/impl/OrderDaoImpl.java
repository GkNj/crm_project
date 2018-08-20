package dao.impl;

import entity.Customer;
import dao.OrderDao;
import entity.Order;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public int saveLinkman(String sql) throws SQLException {
        return 0;
    }

    @Override
    public List<Order> queryForList(String sql) throws SQLException{
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Order> list = rsToList(rs);
        DBUtil.closeConn(conn);
        //System.out.println(list);
        return list;
    }



    private List<Order> rsToList(ResultSet rs) throws SQLException {
        List<Order> list = new ArrayList<>();
        while(rs.next()){
            Order order = new Order();
            order.setO_id(rs.getInt("o_id"));
            order.setO_time(rs.getString("o_time"));
            order.setO_position(rs.getString("o_address"));
            order.setO_state(rs.getString("o_state"));
            list.add(order);
        }
        //System.out.println(list);
        return list;

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
        String sql1 = "insert into lost value(null,'"+a+"',null,null,'暂缓流失','"+c_id+"','"+r_id+"')";
        String sql = "insert into lost value (null,'"+a+"',null, '"+"暂缓流失"+"','"+c_id+"',null,'"+r_id+"')";
        ps = conn.prepareStatement(sql1);
        System.out.println("daozhele"+sql);
        int rs = ps.executeUpdate();
        return rs;
    }

}
