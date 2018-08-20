package dao;

import entity.Role;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public interface RoleDao {


    public List<Role> queryForList() throws SQLException;//查询所有信息

    public int insert(String sql) throws SQLException;//编辑信息？？

    public int update(String sql1, String sql2) throws SQLException;//编辑信息？？

    public Role queryForRole(String sql) throws SQLException;//查询客户

    public int add(String sql) throws SQLException;
}
