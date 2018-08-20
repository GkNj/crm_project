package dao.impl;

import dao.RoleDao;
import entity.Role;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public class RoleDaoImpl implements RoleDao {
    @Override
    public List<Role> queryForList() throws SQLException {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs=null;
        String sql="SELECT * FROM role";
        ps = conn.prepareStatement(sql);
        List<Role> list = new ArrayList<>();
        rs = ps.executeQuery();
        while (rs.next()) {
            Role role = new Role();
            /**
             * role的信息
             */
            role.setR_id(rs.getInt("r_id"));
            role.setR_name(rs.getString("r_name"));
            role.setR_position(rs.getString("r_position"));
            list.add(role);
        }
        System.out.println("到Dao了"+list);
        return list;
    }

    @Override
    public int insert(String sql) throws SQLException {
        System.out.println("到这了Roledao_insert");
        Connection conn = DBUtil.getConnection();
        System.out.println(conn);
        int i = conn.createStatement().executeUpdate(sql);
        DBUtil.closeConn(conn);
        return i;
    }

    @Override
    public int update(String sql1, String sql2) throws SQLException {
        return 0;
    }

    @Override
    public Role queryForRole(String sql) throws SQLException {
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Role> list =rsToList(rs);
        DBUtil.closeConn(conn);
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public int add(String sql) throws SQLException {
        return 0;
    }
    private List<Role> rsToList(ResultSet rs) throws SQLException {
        List<Role> list = new ArrayList<>();
        while(rs.next()){
            Role r = new Role();
            r.setR_id(rs.getInt("r_id"));
            r.setR_name(rs.getString("r_name"));
            r.setR_position(rs.getString("r_position"));
            list.add(r);
        }
        return list;
    }

}
