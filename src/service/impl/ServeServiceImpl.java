package service.impl;

import dao.ServeDao;
import dao.impl.ServeDaoImpl;
import entity.Service;
import service.ServeService;

import java.sql.SQLException;

public class ServeServiceImpl implements ServeService {
    private ServeDao dao=new ServeDaoImpl();
    @Override
    public int save(Service s) throws SQLException {
        System.out.println(s);
        String sql="insert into service value(null,'"+s.getS_type()+"','"+s.getS_detail()+"',"+s.getCustomer().getC_id()+",'"+s.getS_state()+"','"+s.getS_request()+"',"+s.getRole().getR_id()+",'"+s.getS_time()+"') ";
        System.out.println(sql);
        return dao.update(sql);
    }
}
