package dao.impl;

import dao.LoginDao;
import entity.Role;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImpl implements LoginDao {
    @Override
    public Role login(String name, String password) {
        Connection conn = DBUtil.getConnection();
        Statement statement = null;
        ResultSet rs =null;
        try {
            statement = conn.createStatement();
            String sql = "select * from role where r_password ='"+password+"' and " +
                    "r_name='"+name+"'";
            rs = statement.executeQuery(sql);
            while (rs.next()){
                Role role =new Role();
                role.setR_id(rs.getInt("r_id"));
                role.setR_name(rs.getString("r_name"));
                role.setR_position(rs.getString("r_position"));
                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        DBUtil.closeConn(conn);
        return null;
    }
}
