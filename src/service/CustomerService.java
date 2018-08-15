package service;

import User.Customer;

import java.sql.SQLException;

/**
 * Created by mac on 2018/8/15.
 */
public interface CustomerService {

    public int save(Customer c) throws SQLException;

    public int deleteCustomer(String cId) throws SQLException;
}
