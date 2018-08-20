package dao.impl;

import dao.LinkmanDao;
import entity.Customer;
import entity.Linkman;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public class LinkmanDaoImpl implements LinkmanDao {


    @Override
    public int saveLinkman(String sql) throws SQLException {
        return 0;
    }

    @Override
    public int insert(String sql) throws SQLException {
        System.out.println("到这了LInkmandao");
        Connection conn = DBUtil.getConnection();
        System.out.println(conn);
        int i = conn.createStatement().executeUpdate(sql);
        DBUtil.closeConn(conn);
        return i;
    }

    @Override
    public List<Linkman> queryForList(String sql) throws SQLException{
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Linkman> list = rsToList(rs);
        DBUtil.closeConn(conn);
        return list;
    }

    private List<Linkman> rsToList(ResultSet rs) throws SQLException {
        List<Linkman> list = new ArrayList<>();
        while(rs.next()){
            Linkman linkman = new Linkman();
            linkman.setL_id(rs.getInt("l_id"));
            linkman.setL_name(rs.getString("l_name"));
            linkman.setL_position(rs.getString("l_position"));
            linkman.setL_tel(rs.getString("l_tel"));
            linkman.setL_phone(rs.getString("l_phone"));
            linkman.setL_remark(rs.getString("l_phone"));
            list.add(linkman);
        }
        System.out.println(list.toString());
        return list;

    }
    @Override
    public List<Customer> queryCustomer(String sql) throws SQLException{
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Customer> list = rsTolist(rs);
        DBUtil.closeConn(conn);
        return list;
    }

    @Override
    public Linkman queryById(int id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM linkman,customer WHERE l_id = ? and linkman.c_id = customer.c_id";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                Linkman linkman = new Linkman();
                Customer customer = new Customer();
                linkman.setL_name(rs.getString("l_name"));
                linkman.setL_phone(rs.getString("l_phone"));
                linkman.setL_position(rs.getString("l_position"));
                linkman.setL_remark(rs.getString("l_remark"));
                linkman.setL_tel(rs.getString("l_tel"));

                customer.setC_id(rs.getInt("c_id"));
                customer.setC_name(rs.getString("c_name"));
                customer.setC_area(rs.getString("c_area"));
                customer.setC_class(rs.getString("c_class"));
                customer.setC_satifaction(rs.getInt("c_satifaction"));
                customer.setC_credit(rs.getInt("c_credit"));
                customer.setC_address(rs.getString("c_address"));
                customer.setC_portcode(rs.getString("c_portcode"));
                customer.setC_tel(rs.getString("c_tel"));
                customer.setC_website(rs.getString("c_website"));

                //3role放入customer里
                linkman.setCustomer(customer);
                return linkman;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Customer> rsTolist(ResultSet rs) throws SQLException {
        List<Customer> list = new ArrayList<>();
        while(rs.next()){
            Customer customer = new Customer();
            customer.setC_id(rs.getInt("c_id"));
            customer.setC_name(rs.getString("c_name"));

            list.add(customer);
        }
        //System.out.println(list);
        return list;

    }

    @Override
    public int update(String sql) throws SQLException {
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        int i = conn.createStatement().executeUpdate(sql);
        conn.commit();
        DBUtil.closeConn(conn);
        return i;
    }
}
