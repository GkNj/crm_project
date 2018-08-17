package service;


import entity.Handl;
import entity.Role;
import entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServeService {

    public int save(Service s) throws SQLException;

    public List<Service> queryForCustomerList(Role u, String keyword) throws SQLException;

    public int delete(String id) throws SQLException;

    public Service queryForService(String s_id) throws SQLException;

    public int update(String service1, String dispose) throws SQLException;

    public List<Service> queryForServiceList(Role u, String keyword) throws SQLException;

    public List<Service> queryForServe(Role u, String id) throws SQLException;

    public int addSave(Handl h) throws SQLException;

    public int updatestate(String s_id) throws SQLException;

    public List<Service> queryForFeedBackList(Role u, String keyword) throws SQLException;

   public List<Handl> queryForHandle(String id) throws SQLException;

    int updateState(String id) throws SQLException;
}
