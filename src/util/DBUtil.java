package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public class DBUtil {
    private static DataSource ds = null;
    static {
        ds = new ComboPooledDataSource("mysql");
    }

    /**
     * 通用数据查询方法
     * @throws SQLException
     */
    public static List<Map<String,Object>> queryForList(String sql) throws SQLException{
        Connection conn = ds.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        List<Map<String,Object>> list = rsToList(rs);
        DBUtil.closeConn(conn);
        return list;
    }

    /**
     * 通用数据增删改方法
     * @throws SQLException
     */
    public static void excuteUpdate(String sql) throws SQLException{
        Connection conn = ds.getConnection();
        Statement stat = conn.createStatement();
        int count = stat.executeUpdate(sql);
        DBUtil.closeConn(conn);
    }

    /**
     * ResultSet转换List方法
     */
    private static List<Map<String, Object>> rsToList(ResultSet rs) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<>();
        SimpleDateFormat df  = new SimpleDateFormat("yyyy-MM-dd");
        while(rs.next()){
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                switch (rs.getMetaData().getColumnType(i)) {
                    case Types.INTEGER:
                        map.put(rs.getMetaData().getColumnName(i), rs.getInt(i));
                        break;
                    case Types.DOUBLE:
                        map.put(rs.getMetaData().getColumnName(i), rs.getDouble(i));
                        break;
                    case Types.DATE:
                        map.put(rs.getMetaData().getColumnName(i), df.format(new Date(rs.getDate(i).getTime())));
                        break;
                    default:
                        map.put(rs.getMetaData().getColumnName(i), rs.getString(i));
                        break;
                }
            }
            list.add(map);
        }

        return list;
    }

    /**
     * 获取数据库链接方法
     */
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("数据库链接获取异常，请检查链接参数！");
        }
        return null;
    }


    /**
     * 关闭链接方法
     */
    public static void closeConn(Connection conn){
        try {
            if(conn!=null){
                conn.close();
                //conn  = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if(conn!=null){
                    conn.close();
                    //conn  = null;
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
                System.err.println("数据库链接关闭失败！");
            }
        }
    }

    public static void main(String[] args) throws SQLException {

        DBUtil.excuteUpdate("update student set sname= '王菊2号' where s = '08'");

    }
}
