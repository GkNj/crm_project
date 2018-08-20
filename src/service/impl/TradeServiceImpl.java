package service.impl;

import dao.TradeDao;
import dao.impl.TradeDaoImpl;
import entity.Customer;
import entity.Trade;
import service.TradeService;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public class TradeServiceImpl implements TradeService {
    private TradeDao dao = new TradeDaoImpl();


    @Override
    public int save(Trade t) throws SQLException {
        String sql = "insert into trade value(null ,'"+t.getT_time()+
                "','"+t.getT_address()+
                "','"+t.getT_detail()+
                "','"+t.getT_outline()+
                "','"+t.getT_remark()+
                "','"+t.getCustomer().getC_id()+"')";
        System.out.println(sql);
        return dao.insert(sql);
    }

    @Override
    public List<Trade> queryForList(String sql) throws SQLException{
        Connection conn = DBUtil.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        List<Trade> list = rsToList(rs);
        DBUtil.closeConn(conn);
        //System.out.println(list);
        return list;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection conn = DBUtil.getConnection();
        conn.setAutoCommit(false);
        int i = conn.createStatement().executeUpdate(sql);
        conn.commit();
        DBUtil.closeConn(conn);
        return i;
    }

    private List<Trade> rsToList(ResultSet rs) throws SQLException {
        List<Trade> list = new ArrayList<>();
        while(rs.next()){
            Trade trade = new Trade();
            trade.setT_id(rs.getInt("t_id"));
            trade.setT_time(rs.getString("t_time"));
            trade.setT_address(rs.getString("t_address"));
            trade.setT_detail(rs.getString("t_detail"));
            trade.setT_outline(rs.getString("t_outline"));
            trade.setT_remark(rs.getString("t_remark"));
            list.add(trade);
        }
        System.out.println(list);
        return list;

    }

    @Override
    public Trade queryById(int id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM trade,customer WHERE t_id = ? and trade.c_id = customer.c_id";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                Trade trade = new Trade();
                Customer customer = new Customer();
                trade.setT_time(rs.getString("t_time"));
                trade.setT_address(rs.getString("t_address"));
                trade.setT_detail(rs.getString("t_detail"));
                trade.setT_outline(rs.getString("t_outline"));
                trade.setT_remark(rs.getString("t_remark"));

                customer.setC_id(rs.getInt("c_id"));
                customer.setC_name(rs.getString("c_name"));
                customer.setC_area(rs.getString("c_area"));
                customer.setC_class(rs.getString("c_class"));
                customer.setC_satifaction(rs.getInt("c_satifaction"));
                customer.setC_credit(rs.getInt("c_credit"));
                customer.setC_address(rs.getString("c_address"));
                customer.setC_portcode(rs.getString("c_portcode"));
                customer.setC_tel(rs.getString("c_tel"));
                customer.setC_website(rs.getString("c_website"));

                //3role放入customer里
                trade.setCustomer(customer);
                return trade;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int update(Trade trade) throws SQLException {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        List<Trade> list = new ArrayList<>();
        String sql = "UPDATE trade set t_time=?,t_address=?,t_detail=?,t_outline=?,t_remark=?where t_id = ? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1,trade.getT_time());
        ps.setString(2,trade.getT_address());
        ps.setString(3,trade.getT_detail());
        ps.setString(4,trade.getT_outline());
        ps.setString(5,trade.getT_remark());
        ps.setInt(6,trade.getT_id());
        int rs = ps.executeUpdate();
        return rs;
    }

    @Override
    public List<Trade> queryForTrade(String id) throws SQLException {
        String sql = "select * from trade where c_id = "+id;
        //System.out.println(sql);
        return dao.queryForList(sql);
    }
    @Override
    public int deleteTrade(String id) throws SQLException {
        String sql = "delete from trade where t_id="+id;
        System.out.println(sql);
        return dao.update(sql);
    }


}
