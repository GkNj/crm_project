package service;

import entity.Lost;

import java.sql.SQLException;
import java.util.List;

public interface LostService {
    public List<Lost> queryForLostList() throws SQLException;
}
