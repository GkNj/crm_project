package service;


import entity.Service;

import java.sql.SQLException;

public interface ServeService {

  public   int save(Service s) throws SQLException;

}
