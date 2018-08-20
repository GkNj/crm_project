package dao.impl;

import dao.LostDao;
import dao.RoleDao;
import entity.Customer;
import entity.Lost;
import entity.Role;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LostDaoImpl implements  LostDao{
    RoleDao roleDao = new RoleDaoImpl();

    public List<Lost> bQueryForList() throws SQLException {
        List<Lost> list = new ArrayList();
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        String sql = "select * from lost l,customer c,role r where l.c_id=c.c_id and  l.r_id =r.r_id";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Lost lost = new Lost();
            lost.setL_id(rs.getInt("l_id"));
            lost.setL_time(rs.getString("l_time"));
            lost.setL_measure(rs.getString("l_measure"));
            lost.setL_reason(rs.getString("l_reason"));
            lost.setL_state(rs.getString("l_state"));

            Role role = new Role();
            role.setR_id(rs.getInt("r_id"));
            role.setR_name(rs.getString("r_name"));

            Customer customer = new Customer();
            customer.setC_id(rs.getInt("c_id"));
            customer.setC_name(rs.getString("c_name"));

            lost.setRole(role);
            lost.setCustomer(customer);
            lost.setL_measure(rs.getString("l_measure"));
            list.add(lost);
        }
        DBUtil.closeConn(conn);
        return list;


    }


    public List<Lost> mQueryForLost(int id) throws SQLException {
        List<Lost> list = new ArrayList();
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        String sql = "select * from lost l,customer c,role r where l.r_id='"+id+"' and l.c_id=c.c_id and  l.r_id =r.r_id and l.l_state='暂缓流失'";
        System.out.println("这是LostDao"+sql);
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Lost lost = new Lost();
            lost.setL_id(rs.getInt("l_id"));
            lost.setL_time(rs.getString("l_time"));
            lost.setL_measure(rs.getString("l_measure"));
            lost.setL_reason(rs.getString("l_reason"));
            lost.setL_state(rs.getString("l_state"));

            Role role = new Role();
            role.setR_id(rs.getInt("r_id"));
            role.setR_name(rs.getString("r_name"));

            Customer customer = new Customer();
            customer.setC_id(rs.getInt("c_id"));
            customer.setC_name(rs.getString("c_name"));


            lost.setRole(role);
            lost.setCustomer(customer);
            lost.setL_measure(rs.getString("l_measure"));
            list.add(lost);
            System.out.println(lost.toString());
        }
        DBUtil.closeConn(conn);
        return list;


    }


    public List<Lost> queryLost(int id) throws SQLException {
        List<Lost> list = new ArrayList();
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        String sql = "select * from lost l,customer c,role r where l.l_id='"+id+"' and l.c_id=c.c_id and  l.r_id =r.r_id ";
        System.out.println("这是LostDao"+sql);
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Lost lost = new Lost();
            lost.setL_id(rs.getInt("l_id"));
            lost.setL_time(rs.getString("l_time"));
            lost.setL_measure(rs.getString("l_measure"));
            lost.setL_reason(rs.getString("l_reason"));
            lost.setL_state(rs.getString("l_state"));

            Role role = new Role();
            role.setR_id(rs.getInt("r_id"));
            role.setR_name(rs.getString("r_name"));

            Customer customer = new Customer();
            customer.setC_id(rs.getInt("c_id"));
            customer.setC_name(rs.getString("c_name"));

            lost.setRole(role);
            lost.setCustomer(customer);
            lost.setL_measure(rs.getString("l_measure"));
            list.add(lost);
            System.out.println(lost.toString());
        }
        DBUtil.closeConn(conn);
        return list;
    }

    @Override
    public int runAdd(int id,String s) throws SQLException {
        Connection conn = DBUtil.getConnection();
        System.out.println("在这儿了"+s);
        String sql = "update lost set l_measure=? where l_id=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,s);
        ps.setInt(2,id);
        System.out.println("这是LostDaoupdate中runadd的"+sql);
        int rs=ps.executeUpdate();
        DBUtil.closeConn(conn);
        return rs;
    }
    @Override
    public int reasonAdd(int id,String s,String state) throws SQLException {
        Connection conn = DBUtil.getConnection();
        System.out.println("在这儿了"+s);
        String sql = "update lost l,customer c set l_reason=?,l_state=?, c.c_state=? where l_id=? and l.c_id=c.c_id";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setString(1,s);
        ps.setString(2,state);
        ps.setString(3,state);
        ps.setInt(4,id);
        System.out.println("这是LostDaoupdate中reasonadd的"+sql);
        int rs=ps.executeUpdate();
        DBUtil.closeConn(conn);
        return rs;
    }

    public Map<Integer, Integer> findCustomerIdNotInLost(){
        List<Integer> list = new ArrayList();
        Map<Integer,Integer> map = new HashMap<>();

        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select c_id,r_id from customer where c_id not in(select c_id from lost)";
        System.out.println(sql);
        try {
            ps=conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()){
                map.put(rs.getInt("c_id"),rs.getInt("r_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConn(conn);
        }
        return map;
    }

}


