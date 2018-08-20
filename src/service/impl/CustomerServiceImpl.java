package service.impl;

import entity.Customer;
import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import dao.impl.RoleDaoImpl;
import dao.RoleDao;
import service.CustomerService;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao dao = new CustomerDaoImpl();
    private RoleDao roleDao=new RoleDaoImpl();

    @Override
    public int save(Customer c) throws SQLException {
        String sql = "insert into customer value(null ,'"+c.getC_name()+
                                                    "','"+c.getC_area()+
                                                    "','"+c.getC_manager().getR_id()+
                                                    "','"+c.getC_class()+
                                                    "','"+c.getC_satifaction()+
                                                    "','"+c.getC_credit()+
                                                    "','"+c.getC_address()+
                                                    "','"+c.getC_portcode()+
                                                    "','"+c.getC_tel()+

                                                    "','"+c.getC_website()+
                                                    "','"+c.getC_state()+"')";
		System.out.println(sql);
        return dao.insert(sql);
    }

    public int updateCustomer(Customer c) throws SQLException {
        String sql = "insert into customer value(null ,'"+c.getC_name()+
                "','"+c.getC_area()+
                "','"+c.getC_manager().getR_id()+
                "','"+c.getC_class()+
                "','"+c.getC_satifaction()+
                "','"+c.getC_credit()+
                "','"+c.getC_address()+
                "','"+c.getC_portcode()+
                "','"+c.getC_tel()+
                "','"+c.getC_website()+
                "','"+c.getC_state()+"')";
        System.out.println(sql);
        return dao.insert(sql);
    }

    @Override
    public int deleteCustomer(String cId) throws SQLException {
        System.out.println("这儿是service");
        String sql1 = "update linkman set c_id = null where c_id = "+cId;
        String sql2 = "update orders set c_id = null where c_id = "+cId;
        String sql3 = "update lost set c_id = null where c_id = "+cId;
        String sql4 = "update trade set c_id = null where c_id = "+cId;
        String sql = "delete from customer where c_id="+cId;
        return dao.update(sql1,sql2,sql3,sql4,sql);
    }

    @Override
    public List<Customer> queryForList(String sql) throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Customer> list = rsToList(rs);
        DBUtil.closeConn(conn);
        return list;

    }

    public List<Customer> rsToList(ResultSet rs) throws SQLException {
        List<Customer> list = new ArrayList<>();
        while(rs.next()){
            Customer c = new Customer();
            c.setC_id(rs.getInt("c_id"));
            c.setC_name(rs.getString("c_name"));
            c.setC_area(rs.getString("c_area"));
            c.setC_manager(roleDao.queryForRole("select * from role where r_id = 1"));
            c.setC_class(rs.getString("c_class"));
            c.setC_satifaction(rs.getInt("c_satifaction"));
            c.setC_credit(rs.getInt("c_credit"));
            c.setC_portcode(rs.getString("c_portcode"));
            c.setC_tel(rs.getString("c_tel"));
            c.setC_website(rs.getString("c_website"));
            c.setC_address(rs.getString("c_address"));
            list.add(c);
        }
        System.out.println(list);
        return list;

    }
    @Override
    public List<Customer> queryForCustomerList(int r_id) throws SQLException {
        String sql = "select * from customer,role where customer.r_id=role.r_id and customer.r_id="+r_id;
        System.out.println(sql);
        return dao.queryForList(sql);
    }

    @Override
    public Customer queryById() throws SQLException {
        String sql = "select * from customer where r_id = cId";
        System.out.println(sql);
        return queryById();
    }

}
