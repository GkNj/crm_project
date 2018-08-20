package dao;

import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StatisticDao {
    public Map findByYear(String year, int c_id);
    public Order findByName();
    public Map findByClass();
    public Map<Integer, Integer> findByCredit();
    public Map findBySatifaction();
    public ArrayList findAllLost();
    public ArrayList findLostByCustomerId(int id);
    public ArrayList findLostByMannager(int id);
    List find(String findType);
    Map<String, Integer> findByContribute();
}
