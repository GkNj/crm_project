package service.impl;

import dao.ServeDao;
import dao.impl.ServeDaoImpl;
import entity.Role;
import entity.Service;
import service.ServeService;

import java.sql.SQLException;
import java.util.List;

public class ServeServiceImpl implements ServeService {
    private ServeDao dao=new ServeDaoImpl();
    @Override
    public int save(Service s) throws SQLException {
        System.out.println(s);
        String sql="insert into service value(null,'"+s.getS_type()+"','"+s.getS_detail()+"',"+s.getCustomer().getC_id()+",'"+s.getS_state()+"','"+s.getS_request()+"',"+s.getRole().getR_id()+",'"+s.getS_time()+"') ";
        System.out.println(sql);
        return dao.update(sql);
    }

    @Override
    public List<Service> queryForCustomerList(Role u, String keyword) throws SQLException {
        String sql = "select * from customer where 1=1";
//        if (!(u.getuRole().getdId() == 3)) {
//            sql += " and c_manager =" + u.getuId();
//        }
        sql+=" and (c_name like '%"+keyword+"%' or s_type like '%"+keyword+"%')";
        System.out.println(sql);
        return dao.queryForList(sql);

    }
}
