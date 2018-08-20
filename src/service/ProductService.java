package service;

import entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    public List<Product> queryForProduct(String id) throws SQLException;
}
