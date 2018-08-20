package dao;

import entity.Trade;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public interface TradeDao {
    public int insert(String sql) throws SQLException;//编辑信息？？
    public List<Trade> queryForList(String sql) throws SQLException;
    public int update(String sql) throws SQLException;
    Trade queryById(int id);
    public int update(Trade trade) throws SQLException;
}
