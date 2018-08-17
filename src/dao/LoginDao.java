package dao;

import entity.Role;

public interface LoginDao {
    Role login(String name,String password);
}
