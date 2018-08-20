package dao.impl;

import dao.CustomerDao;

/**
 * Created by mac on 2018/8/15.
 */
public class CustomerDaoImplTest {
    CustomerDao dao  = new CustomerDaoImpl();

    @org.junit.Test
    public void queryForList() throws Exception {

    }

    @org.junit.Test
    public void insert() throws Exception {
        dao.insert("INSERT INTO customer VALUE (3,1,2,1,4,5,6,7,2,3,2,3,3)");
    }

    @org.junit.Test
    public void update() throws Exception {

    }

    @org.junit.Test
    public void queryForCustomer() throws Exception {

    }

    @org.junit.Test
    public void add() throws Exception {

    }

}