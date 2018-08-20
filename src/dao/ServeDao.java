package dao;

import entity.Customer;
import entity.Handl;
import entity.Role;
import entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServeDao {
    public int update(String sql) throws SQLException;

    public Customer queryForCustomer(String sql) throws SQLException;

    public Role queryForRole(String sql) throws SQLException;

    public List<Service> queryForList(String sql) throws SQLException;

    public List<Handl> queryForList1(String sql) throws SQLException;

    public int delete(String sql2, String sql) throws SQLException;

    public List<Handl> queryForList2(String sql) throws SQLException;

    public Service queryForService(String sql) throws SQLException;

    int updateHandle(Handl handl);


}
