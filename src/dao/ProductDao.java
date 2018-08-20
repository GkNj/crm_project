package dao;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public List<Product> queryForList(String sql) throws SQLException;

}
