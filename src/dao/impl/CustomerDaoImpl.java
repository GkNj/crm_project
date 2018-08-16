package dao.impl;

import entity.Customer;
import dao.CustomerDao;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public class CustomerDaoImpl implements CustomerDao{


    @Override
    public List<Customer> queryForList(String sql) throws SQLException {
       return null;
    }

    @Override
    public int insert(String sql) throws SQLException {
        Connection conn = DBUtil.getConnection();
        int i = conn.createStatement().executeUpdate(sql);
        DBUtil.closeConn(conn);
        return i;
    }

    @Override
    public int update(String sql1, String sql2) throws SQLException {
        return 0;
    }

    @Override
    public Customer queryForCustomer(String sql) throws SQLException {
        return null;
    }

    @Override
    public int add(String sql) throws SQLException {
        return 0;
    }
}
