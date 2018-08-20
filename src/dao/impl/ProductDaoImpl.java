package dao.impl;

import dao.ProductDao;
import entity.Product;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> queryForList(String sql) throws SQLException{
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Product> list = rsToList(rs);
        DBUtil.closeConn(conn);
        //System.out.println(list);
        return list;
    }



    private List<Product> rsToList(ResultSet rs) throws SQLException {
        List<Product> list = new ArrayList<>();
        while(rs.next()){
            Product product = new Product();
            product.setP_id(rs.getInt("p_id"));
            product.setP_name(rs.getString("p_name"));
            product.setP_num(rs.getInt("p_num"));
            product.setP_unit(rs.getString("p_unit"));
            product.setP_price(rs.getDouble("p_price"));
            list.add(product);
        }
        //System.out.println(list);
        return list;

    }
}
