package service.impl;


import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import entity.Product;
import service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao dao = new ProductDaoImpl();


    @Override
    public List<Product> queryForProduct(String id) throws SQLException {
        String sql = "select * from product where o_id = "+id;
        System.out.println(sql);
        return dao.queryForList(sql);
    }

}
