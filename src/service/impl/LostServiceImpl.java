package service.impl;

import dao.CustomerDao;
import dao.impl.CustomerDaoImpl;
import entity.Lost;
import service.LostService;

import java.sql.SQLException;
import java.util.List;

public class LostServiceImpl implements LostService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public List<Lost> queryForLostList() throws SQLException {
        String sql = "select * from lost where r_id = 1";
//        System.out.println(sql);
        //return customerDao.queryForList(sql);
        return null;
    }
}
