package dao;

import entity.Lost;

import java.sql.SQLException;
import java.util.List;

public interface LostDao {
    public List<Lost> mQueryForLost(int id) throws SQLException;
    public List<Lost> queryLost(int id) throws SQLException ;
    public int runAdd(int id, String s) throws SQLException ;
    public int reasonAdd(int id, String s, String state) throws SQLException ;

}
