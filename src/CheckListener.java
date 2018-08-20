/**
 * @author ������ 2018-08-17 20:33
 */


import dao.OrderDao;
import dao.impl.LostDaoImpl;
import dao.impl.OrderDaoImpl;
import entity.MyTime;
import entity.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

/**
 * ���ڼ�����ݿ�
 */
@WebListener(value = "check")
public class CheckListener implements ServletContextListener {

    private final long PERIOD = 1000 * 60 * 60 * 24 * 7;
    private final long TWO_MONTH = 86400000 * 60;
    private Timer timer = null;

    // Public constructor is required by servlet spec
    public CheckListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("init");

        timer = new Timer(true);

        sce.getServletContext().log("启动定时器");



        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int day = calendar.get(Calendar.DATE);
        int minute = calendar.get(Calendar.MINUTE);
        if (dayOfWeek == 7 && hour == 2) {

            calendar.set(year, month, day, hour, minute);
            Date date = calendar.getTime();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    LostDaoImpl lostDao1 = new LostDaoImpl();
                    Map<Integer,Integer> ids= lostDao1.findCustomerIdNotInLost();
                    for (int r_id : ids.keySet())
                        try {
                            orderDays(ids.get(r_id),r_id);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                }
            }, date, PERIOD);
        }


    }

    public void contextDestroyed(ServletContextEvent sce) {
        if (timer != null) {
            timer.cancel();
        }
    }
    public static void orderDays(int id,int login_id) throws ParseException, SQLException {
        OrderService orderService = new OrderServiceImpl();
        List<Order> list = orderService.queryForOrder(id + "");
        long min = 1000000;
        long i = 0;
        String a = null;
        if (list.size() != 0) {
            for (Order order : list) {
                String str = order.getO_time();
                MyTime myTime = new MyTime();
                i = myTime.days(str);
                System.out.println(i);
                System.out.println(a);
                if (i < min) {
                    min = i;
                    a = str;
                }
            }
            System.out.println("ade ===" + a);
            if (min > 180 && min != 100000) {
                OrderDao orderDao = new OrderDaoImpl();
                System.out.println(a);
                orderDao.update(id + "");
                System.out.println("");
                orderDao.add(a, id + "", login_id + "");
            }
        }
    }
}
