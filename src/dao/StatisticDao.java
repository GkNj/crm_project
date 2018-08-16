package dao;

import entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StatisticDao {
    public ArrayList<Order> findByYear();
    public Order findByName();
    public Map findByClass();
    public Map<Integer, Integer> findByCredit();
    public Map findBySatifaction();
    public ArrayList findAllLost();
    public ArrayList findLostByCustomerName();
    public ArrayList findLostByMannager();
    List find(String findType);

}
