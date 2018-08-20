package dao;

import entity.Customer;
import entity.Linkman;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public interface LinkmanDao {
    public int saveLinkman(String sql) throws SQLException;
    public int insert(String sql) throws SQLException;//编辑信息？？
    public List<Linkman> queryForList(String sql) throws SQLException;
    public List<Customer> queryCustomer(String sql) throws SQLException;
    Linkman queryById(int id);
    public int update(String sql) throws SQLException;//编辑信息？？

}
