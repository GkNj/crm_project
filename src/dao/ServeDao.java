package dao;

import entity.Customer;
import entity.Role;

import java.sql.SQLException;

public interface ServeDao {
    public int update(String sql) throws SQLException;

    public Customer queryForCustomer(String sql) throws SQLException;

    public Role queryForRole(String sql) throws SQLException;
}
