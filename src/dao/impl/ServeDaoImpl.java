package dao.impl;

import dao.ServeDao;
import entity.Customer;
import entity.Handl;
import entity.Role;
import entity.Service;
import util.DBUtil;

import java.sql.*;
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

        Connection conn=DBUtil.getConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery(sql);
        List<Role> list=rstoList(rs);
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Service> queryForList(String sql) throws SQLException {
        Connection conn = DBUtil.getConnection();

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Service> list = rsTolist(rs);
        DBUtil.closeConn(conn);
        return list;
    }

    @Override
    public List<Handl> queryForList1(String sql) throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Handl> list = RsTolist(rs);
        if (!list.isEmpty()){
            list.get(0);
        }
        return list;
    }

    private List<Handl> RsTolist(ResultSet rs) throws SQLException {
        List<Handl> list =new ArrayList<>();
        while (rs.next()){
            Handl h=new Handl();
            Service service=new Service();
            h.setH_id(rs.getInt("h_id"));
            service.setS_id(rs.getInt("s_id"));
//            service.setS_type(rs.getString("s_type"));
//            service.setS_detail(rs.getString("s_detail"));
//            Customer customer=new Customer();
//            customer.setC_name(rs.getString("c_name"));
//            service.setCustomer(customer);
//            service.setS_state(rs.getString("s_state"));
//            service.setS_request(rs.getString("s_request"));
//            Role role=new Role();
//            role.setR_name(rs.getString("r_name"));
//            service.setRole(role);
//            service.setS_time(rs.getString("s_time"));
//            service.setS_disposeman(rs.getString("s_disposeman"));
//            service.setS_date(rs.getString("s_date"));
            h.setService(service);
            h.setH_handle(rs.getString("h_handle"));
            Role role1=new Role();
            role1.setR_id(rs.getInt("r_id"));
            h.setRole(role1);
            h.setH_time(rs.getString("h_time"));
            h.setH_result(rs.getString("h_result"));
//            h.setH_stai(rs.getString("h_stai"));
            list.add(h);
        }
        return list;
     }

    @Override
    public int delete(String sql,String sql2) throws SQLException {
        Connection conn=DBUtil.getConnection();
        Statement sta = conn.createStatement();
        conn.setAutoCommit(false);

        sta.executeUpdate(sql2);
        int i = sta.executeUpdate(sql);
        conn.commit();
        DBUtil.closeConn(conn);
        return i;
    }

    @Override
    public Service queryForService(String sql) throws SQLException {
        Connection conn=DBUtil.getConnection();
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery(sql);
        List<Service> list=rsTolist(rs);
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public int updateHandle(Handl handl) {
       Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update handle set h_result=?,h_sati=? where h_id=?";
        try {
            ps= con.prepareStatement(sql);
            ps.setString(1,handl.getH_result());
            ps.setInt(2,handl.getH_stai());
            ps.setInt(3,handl.getH_id());
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }




    private List<Service> rsTolist(ResultSet rs) throws SQLException {
        List<Service> list=new ArrayList<>();
        while (rs.next()){
            Service s=new Service();
            s.setS_id(rs.getInt("s_id"));
            s.setS_type(rs.getString("s_type"));
            s.setS_detail(rs.getString("s_detail"));
            Customer customer=new Customer();
            customer.setC_id(rs.getInt("c_id"));
            customer.setC_name(rs.getString("c_name"));
            s.setCustomer(customer);
            s.setS_request(rs.getString("s_request"));
            Role role=new Role();
            role.setR_id(rs.getInt("r_id"));
            role.setR_name(rs.getString("r_name"));
            s.setRole(role);
            s.setS_time(rs.getString("s_time"));
            s.setS_disposeman(rs.getString("s_disposeman"));
            s.setS_date(rs.getString("s_date"));
            s.setS_state(rs.getString("s_state"));
            list.add(s);

        }
        return list;
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
        }
        return list;
    }
}
