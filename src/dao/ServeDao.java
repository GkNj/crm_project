package dao;

import entity.Customer;
import entity.Role;
import entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServeDao {
    public int update(String sql) throws SQLException;

    public Customer queryForCustomer(String sql) throws SQLException;

    public Role queryForRole(String sql) throws SQLException;

    public List<Service> queryForList(String sql) throws SQLException;
}
