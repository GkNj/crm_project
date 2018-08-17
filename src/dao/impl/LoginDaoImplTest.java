package dao.impl;

import dao.LoginDao;

public class LoginDaoImplTest {

    @org.junit.Test
    public void login() {
        LoginDao dao = new LoginDaoImpl();
        System.out.println(dao.login("张三","123"));
    }
}