package dao.impl;

import dao.ServeDao;
import entity.Customer;
import entity.Role;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServeDaoImpl implements ServeDao {
    @Override
    public int update(String sql) throws SQLException {
        Connection conn=DBUtil.getConnection();
        Statement sta = conn.createStatement();
        int i = sta.executeUpdate(sql);
        DBUtil.closeConn(conn);
        return i;
    }

    @Override
    public Customer queryForCustomer(String sql) throws SQLException {

        Connection conn=DBUtil.getConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery(sql);
        List<Customer> list=rsToList(rs);
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Role queryForRole(String sql) throws SQLException {
        System.out.println(sql);
        Connection conn=DBUtil.getConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery(sql);
        List<Role> list=rstoList(rs);
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    private List<Customer> rsToList(ResultSet rs) throws SQLException {
        List<Customer> list=new ArrayList<>();
        while (rs.next()){
            Customer c=new Customer();
            c.setC_id(rs.getInt("c_id"));
            c.setC_name(rs.getString("c_name"));
            c.setC_area(rs.getString("c_area"));
            Role role=new Role();
            role.setR_id(rs.getInt("r_id"));
            c.setC_manager(role);
            c.setC_class(rs.getString("c_class"));
            c.setC_satifaction(rs.getInt("c_satifaction"));
            c.setC_credit(rs.getInt("c_credit"));
            c.setC_portcode(rs.getString("c_portcode"));
            c.setC_tel(rs.getString("c_tel"));
            c.setC_website(rs.getString("c_website"));
            c.setC_state(rs.getString("c_state"));
            c.setC_address(rs.getString("c_address"));
            list.add(c);
        }
        return list;
    }

    private List<Role> rstoList(ResultSet rs) throws SQLException {
        List<Role> list=new ArrayList<>();
        while (rs.next()){
            Role r=new Role();
            r.setR_id(rs.getInt("r_id"));
            r.setR_name(rs.getString("r_name"));
            r.setR_position(rs.getString("r_position"));
            list.add(r);
            System.out.println(r.toString());
        }
        return list;
    }
}
