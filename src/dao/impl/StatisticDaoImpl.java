package dao.Impl;

import entity.Order;
import dao.StatisticDao;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticDaoImpl implements StatisticDao {

    @Override
    public ArrayList<Order> findByYear() {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            String sql = "select * from order where year=?";
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Order findByName() {
        return null;
    }

    @Override
    public Map findByClass() {
        return new HashMap<String,Integer>();
    }

    /**
     * wyb
     * 根据信誉分类查找
     * @return
     */
    @Override
    public Map<Integer, Integer> findByCredit() {
        Map<Integer,Integer>  map = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn=DBUtil.getConnection();
            String sql = "select c_credit,count(c_id) as num from customer group by c_credit;";
            ps = conn.prepareStatement(sql);
            rs= ps.executeQuery(sql);
            while (rs.next()){
                map.put(rs.getInt("c_credit"),rs.getInt("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn,rs,ps);
        }
        return map;
    }

    @Override
    public Map findBySatifaction() {
        return new HashMap<Integer,Integer>();
    }

    @Override
    public ArrayList findAllLost() {
        return null;
    }

    @Override
    public ArrayList findLostByCustomerName() {
        return null;
    }

    @Override
    public ArrayList findLostByMannager() {
        return null;
    }

    @Override
    public List find(String findType) {
        return null;
    }
}
