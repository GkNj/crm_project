package service;

import entity.Customer;
import entity.Linkman;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public interface LinkmanService {

    public int save(Linkman l) throws SQLException;
    public List<Linkman> queryForLinkman(String id) throws SQLException;
    public List<Customer> queryCustomer(String id) throws SQLException;
    public int deleteLinkman(String cId) throws SQLException;

}
