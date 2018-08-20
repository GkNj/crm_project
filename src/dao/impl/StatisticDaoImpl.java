package dao.impl;

import entity.Customer;
import entity.Lost;
import entity.Order;
import dao.StatisticDao;
import entity.Role;
import org.apache.commons.collections.map.HashedMap;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticDaoImpl implements StatisticDao {
    /**
     * wyb
     * 按年份查询
     * @param year
     * @return
     */

    public Map findByYear(String year) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map map = new HashedMap();
        try {
            conn = DBUtil.getConnection();
            String sql = "select *,sum(o_sum) as sum\n" +
                    "from `orders`,customer where `orders`.c_id=customer.c_id group by `orders`.c_id";

            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("year查到数据了");
                String year1 = rs.getString("o_time");
                System.out.println(year1);
                String[] y1 = year1.split("-");
                System.out.println(y1[0]);
                System.out.println(y1[0]==year);
                System.out.println(y1[0].equals(year));
                if (y1[0].equals(year)){
                    map.put(rs.getString("c_name"), rs.getInt("sum"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn,rs,ps);
        }

        return map;
    }

    @Override
    public Map findByYear(String year, int c_id) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map map = new HashedMap();
        try {
            conn = DBUtil.getConnection();
            String sql = "select *,sum(o_sum) as sum\n" +
                    "from `orders`,customer where `order`.c_id=customer.c_id and `orders`.c_id=? group by `orders`.c_id";
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            ps.setInt(1,c_id);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("year查到数据了");
                String year1 = rs.getString("o_time");
                System.out.println(year1);
                String[] y1 = year1.split("-");
                if (y1[0].equals(year)){
                    map.put(rs.getString("c_name"), rs.getInt("sum"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn,rs,ps);
        }

        return map;

    }

    /**
     * 通过客户姓名查询
     * @return
     */
    @Override
    public Order findByName() {
        return null;
    }

    /**
     * lzl
     * 按用户等级查询
     *
     * @return
     */
    @Override
    public Map findByClass() {
        Map<String, Integer> map = new HashMap<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select c_class ,count(c_id) as num from customer GROUP BY c_class;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(123123);
                System.out.println();
                map.put(rs.getString("c_class"), rs.getInt("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        return map;
    }

    /**
     * 根据年份查询服务类型
     */
    public Map findServiceByYear(String year){
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;
        Map<String,Integer> map=new HashMap<>();
        conn=DBUtil.getConnection();
        try {
            String sql="select s_time ,s_type ,from service";
            ps=conn.prepareStatement(sql);
            System.out.println(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                String year1=rs.getString("s_time");
                String[] y1=year1.split("-");
                if(y1[0].equals(year)){
                    map.put(rs.getString("s_type"),rs.getInt("sum"));
                    System.out.println(map);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn,rs,ps);
        }
        return map;
    }

    /**
     * 查询全部服务类型
     * @return
     */
    public Map findAllByService(String year) {
        Map<String, Integer> map = new HashMap<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql;
            if (year==null||year.equals("")) {
                sql = "select s_type ,count(*) as num from service group by s_type";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    map.put(rs.getString("s_type"),rs.getInt("num"));

                }
            }else {
                sql = "select s_type ,s_time from service group by s_type;";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                        String year2 = rs.getString("s_time");
                        String[] years =year2.split("-");
                        String type =rs.getString("s_type");
                        if (years[0].equals(year)){
                            if (map.containsKey(type)){
                                map.put(type,map.get(type)+1);
                            }else{
                                map.put(type,1);
                            }
                        }

                    }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        return map;
    }

    /**
     * wyb
     * 根据信誉分类查找
     *
     * @return
     */
    @Override
    public Map<Integer, Integer> findByCredit() {
        Map<Integer, Integer> map = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select c_credit,count(c_id) as num from customer group by c_credit;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getInt("c_credit"), rs.getInt("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        return map;
    }

    /**
     * lzl
     * 按满意度分类查找
     *
     * @return
     */
    @Override
    public Map findBySatifaction() {
        Map<Integer, Integer> map = new HashMap<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select c_satifaction ,count(c_id) as num from customer GROUP BY c_satifaction";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                map.put(rs.getInt("c_satifaction"), rs.getInt("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }

        return map;
    }

    /**
     * 查询流失的所有客户
     * @return
     */
    @Override
    public ArrayList findAllLost() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        ArrayList list=new ArrayList();
        String sql="select  * from customer c,lost l,role r WHERE c.c_id=l.c_id and l.r_id=r.r_id";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Lost lost = new Lost();
                lost.setL_reason(rs.getString("l_reason"));
                Role role = new Role();
                role.setR_id(rs.getInt("r_id"));
                role.setR_name(rs.getString("r_name"));
                Customer customer = new Customer();
                customer.setC_name(rs.getString("c_name"));
                customer.setC_id(rs.getInt("c_id"));
                customer.setC_manager(role);
                lost.setCustomer(customer);
                list.add(lost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        return list;
    }

    /**
     * 通过流失顾客姓名查找流失顾客id
     * @return
     */

    public int findCustmerIdByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        Customer customer=new Customer();
        Role role = new Role();
        int id = 0;
        try {
            String sql = "select c_id from customer WHERE c_name=?;";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                customer.setC_id(rs.getInt("c_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        id = customer.getC_id();
        return id;
    }

    /**
     * 根据年份客户查询
     */

    public ArrayList findLostCustomer(String cname,String rname){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList list=new ArrayList();
        conn=DBUtil.getConnection();
        String sql="select  c.c_name,l.l_reason,r.r_name from customer c,lost l,role r\n" +
                "WHERE c.c_id=l.c_id and l.r_id=r.r_id and c_name=? and r_name=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,cname);
            ps.setString(2,rname);
            rs=ps.executeQuery();
            while (rs.next()){
                Role role=new Role();
                role.setR_name(rs.getString("r_name"));
                Customer customer=new Customer();
                customer.setC_name(rs.getString("c_name"));
                customer.setC_manager(role);
                Lost lost=new Lost();
                lost.setL_reason(rs.getString("l_reason"));
                lost.setCustomer(customer);
                list.add(lost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 通过客户id寻找客户信息
     * @return
     */

    @Override
    public ArrayList findLostByCustomerId(int id) {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=DBUtil.getConnection();
        ArrayList list=new ArrayList();
        System.out.println(id);
        String sql="select * from customer c,lost l,role r\n" +
                "WHERE c.c_id=l.c_id and l.r_id=r.r_id and l.c_id=?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(123123);
                Lost lost = new Lost();
                lost.setL_reason(rs.getString("l_reason"));
                Role role = new Role();
                role.setR_id(rs.getInt("r_id"));
                role.setR_name(rs.getString("r_name"));

                Customer customer = new Customer();
                customer.setC_name(rs.getString("c_name"));
                customer.setC_id(rs.getInt("c_id"));

                customer.setC_manager(role);

                lost.setCustomer(customer);
                list.add(lost);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.release(conn, rs, ps);
        }
        return list;
    }


    /**
     * 根据管理者姓名查询管理者id
     * @param name
     * @return
     */
    public int findManagerIdByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBUtil.getConnection();
        Role role = new Role();
        int id = 0;
        try {
            String sql = "select r_id from role WHERE r_name='" + name + "'";
            ps = conn.prepareStatement(sql);
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                role.setR_id(rs.getInt("r_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        id = role.getR_id();
        return id;
    }

    /**
     * lzl
     * 通过管理员寻找流失客户
     * @return
     */
    @Override
    public ArrayList findLostByMannager(int id) {
        ArrayList list = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from customer c,lost l" +
                    ",role r WHERE c.c_id=l.c_id and l.r_id=r.r_id and l.r_id=" + id;
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Lost lost = new Lost();
                lost.setL_reason(rs.getString("l_reason"));
                Role role = new Role();
                role.setR_id(rs.getInt("r_id"));
                role.setR_name(rs.getString("r_name"));
                role.setR_position(rs.getString("r_position"));

                Customer customer = new Customer();
                customer.setC_name(rs.getString("c_name"));
                customer.setC_id(rs.getInt("c_id"));

                customer.setC_manager(role);

                lost.setCustomer(customer);
                list.add(lost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        return list;
    }

    @Override
    public List find(String findType) {
        return null;
    }

    @Override
    public Map<String, Integer> findByContribute() {
        Map<String, Integer> map = new HashedMap();
        ArrayList list = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select *,sum(o_sum) as sum\n" +
                    "from `orders`,customer where `orders`.c_id=customer.c_id group by `orders`.c_id";

            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("c_name"));
                System.out.println(123);
                map.put(rs.getString("c_name"), rs.getInt("sum"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        return map;
    }

    public Map findByContributeById(int id) {
        Map<String, Integer> map = new HashedMap();
        ArrayList list = new ArrayList();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select *,sum(o_sum) as sum\n" +
                    "from `orders`,customer where `orders`.c_id=customer.c_id and `orders`.c_id=? group by `orders`.c_id";
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("c_name"));
                System.out.println(123);
                map.put(rs.getString("c_name"), rs.getInt("sum"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.release(conn, rs, ps);
        }
        return map;
    }
}
