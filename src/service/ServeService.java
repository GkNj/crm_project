package service;


import entity.Role;
import entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServeService {

    public int save(Service s) throws SQLException;

    public List<Service> queryForCustomerList(Role u, String keyword) throws SQLException;
}
