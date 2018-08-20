package dao.impl;

import entity.Customer;
import entity.Role;
import dao.CustomerDao;
import dao.RoleDao;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public class CustomerDaoImpl implements CustomerDao{
    RoleDao roleDao=new RoleDaoImpl();
    @Override
    public List<Customer> queryForList(String sql) throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Customer> list = rsToList(rs);
        DBUtil.closeConn(conn);
        return list;
    }

    @Override
    public int insert(String sql) throws SQLException {

        System.out.println("到这了Customerdao");
        Connection conn = DBUtil.getConnection();
        System.out.println(conn);
        int i = conn.createStatement().executeUpdate(sql);
        DBUtil.closeConn(conn);
        return i;
    }

    @Override
    public int update(String sql1,String sql2,String sql3,String sql4, String sql) throws SQLException {

        System.out.println("这儿是Dao");
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        conn.createStatement().executeUpdate(sql1);
        conn.createStatement().executeUpdate(sql2);
        conn.createStatement().executeUpdate(sql3);
        conn.createStatement().executeUpdate(sql4);
        int i = conn.createStatement().executeUpdate(sql);
        conn.commit();
        DBUtil.closeConn(conn);
        return i;
    }

    @Override
    public Customer queryForCustomer(String sql) throws SQLException {
        return null;
    }

    @Override
    public int add(String sql) throws SQLException {
        return 0;
    }

    @Override
    public Customer queryById(int id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM customer,role WHERE c_id = ? AND customer.r_id=role.r_id ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                Role role = new Role();
                /**
                 * 1。customer 的信息
                 */
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
                customer.setC_state(rs.getString("c_state"));
                /**
                 * 2。role的信息
                 */
                role.setR_id(rs.getInt("r_id"));
                role.setR_name(rs.getString("r_name"));
                role.setR_position(rs.getString("r_position"));

                //3role放入customer里
                customer.setC_manager(role);

                return customer;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Customer> queryall() {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM customer c,role r where c.r_id=r.r_id ";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Customer> c =new ArrayList<>();
            while (rs.next()){
                Customer customer = new Customer();
                System.out.println();
                Role role = new Role();
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
                customer.setC_state(rs.getString("c_state"));
                role.setR_id(rs.getInt("r_id"));
                role.setR_name(rs.getString("r_name"));
                role.setR_position(rs.getString("r_position"));
                customer.setC_manager(role);
                c.add(customer);
            }
            System.out.println(c.toString());
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int update(Customer c) throws SQLException {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        List<Customer> customer = new ArrayList<>();
        String sql = "UPDATE customer set c_name=?,c_area=?,c_class=?,c_satifaction=?,c_credit=?,c_address=?,c_portcode=?,c_tel=?,c_website=? where c_id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,c.getC_name());
            ps.setString(2,c.getC_area());
            ps.setString(3, c.getC_class());
            ps.setInt(4,c.getC_satifaction());
            ps.setInt(5,c.getC_credit());
            ps.setString(6,c.getC_address());
            ps.setString(7,c.getC_portcode());
            ps.setString(8,c.getC_tel());
            ps.setString(9,c.getC_website());
            ps.setInt(10,c.getC_id());
             int rs = ps.executeUpdate();
         return rs;

    }





    private List<Customer> rsToList(ResultSet rs) throws SQLException {
        List<Customer> list = new ArrayList<>();
        while (rs.next()) {
            Customer c = new Customer();
            c.setC_id(rs.getInt("c_id"));
            c.setC_name(rs.getString("c_name"));
            c.setC_area(rs.getString("c_area"));
//            c.setC_manager(roleDao.queryForRole("select * from role where r_id = 1"));
            Role role=new Role();
            role.setR_id(rs.getInt("role.r_id"));
            role.setR_name(rs.getString("r_name"));
            role.setR_position(rs.getString("r_position"));
            c.setC_manager(role);
            c.setC_class(rs.getString("c_class"));
            c.setC_satifaction(rs.getInt("c_satifaction"));
            c.setC_credit(rs.getInt("c_credit"));
            c.setC_address(rs.getString("c_address"));
            c.setC_portcode(rs.getString("c_portcode"));
            c.setC_tel(rs.getString("c_tel"));
            c.setC_website(rs.getString("c_website"));
            c.setC_state(rs.getString("c_state"));

            list.add(c);
        }
//        System.out.println(list);
        return list;
    }
}
