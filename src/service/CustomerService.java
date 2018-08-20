package service;

import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public interface CustomerService {

    public int save(Customer c) throws SQLException;

    public int deleteCustomer(String cId) throws SQLException;

    public List<Customer> queryForList(String sql) throws SQLException;

    public List<Customer> rsToList(ResultSet rs) throws SQLException;

    public List<Customer> queryForCustomerList(int r_id) throws SQLException;

    public Customer queryById() throws SQLException;

}
