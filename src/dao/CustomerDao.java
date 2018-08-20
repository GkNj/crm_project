package dao;

import entity.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public interface CustomerDao {

    public List<Customer> queryForList(String sql) throws SQLException;//查询所有信息

    public int insert(String sql) throws SQLException;//编辑信息？？

    public int update(String sql1, String sql2, String sql3, String sql4, String sql) throws SQLException;//编辑信息？？

    public int update(Customer c) throws SQLException;

    public Customer queryForCustomer(String sql) throws SQLException;//查询客户

    public int add(String sql) throws SQLException;

    Customer queryById(int id);
}
