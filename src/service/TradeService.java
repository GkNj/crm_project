package service;

import entity.Trade;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public interface TradeService {
    public int save(Trade trade) throws SQLException;
    public List<Trade> queryForList(String sql) throws SQLException;
    public int update(String sql) throws SQLException;
    Trade queryById(int id);
    public int update(Trade trade) throws SQLException;
    public int deleteTrade(String id) throws SQLException;
    public List<Trade> queryForTrade(String id) throws SQLException;

}
