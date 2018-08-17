package service.impl;

import dao.ServeDao;
import dao.impl.ServeDaoImpl;
import entity.Handl;
import entity.Role;
import entity.Service;
import service.ServeService;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ServeServiceImpl implements ServeService {
    private ServeDao dao=new ServeDaoImpl();
    @Override
    public int save(Service s) throws SQLException {
        System.out.println(s);
        String sql="insert into service value(null,'"+s.getS_type()+"','"+s.getS_detail()+"',"+s.getCustomer().getC_id()+",'"+s.getS_state()+"','"+s.getS_request()+"',"+s.getRole().getR_id()+",'"+s.getS_time()+"',null,null) ";
        System.out.println(sql);
        return dao.update(sql);
    }

    @Override
    public List<Service> queryForCustomerList(Role u, String keyword) throws SQLException {
        String sql = "select distinct * from service s,customer c,role r where c.c_id=s.c_id and c.r_id=r.r_id and s.s_state != '已分配' ";
//        if (!(u.getuRole().getdId() == 3)) {
//            sql += " and c_manager =" + u.getuId();
//        }
        sql+=" and (c_name like '%"+keyword+"%' or s_type like '%"+keyword+"%')";
        System.out.println(sql);
        return dao.queryForList(sql);

    }

    @Override
    public int delete(String id) throws SQLException {
        String sql2="update handle set s_id = null where s_id= "+id;
        String sql="delete  from service where s_id ="+id;
        System.out.println(sql2);
        System.out.println(sql);
        return dao.delete(sql2,sql);
    }

    @Override
    public Service queryForService(String s_id) throws SQLException {
        String sql="select * from service where s_id ="+s_id;

        return (Service) dao.queryForList(sql);
    }

    @Override
    public int update(String s_id,String dispose) throws SQLException {
        Date date=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(date);
        String sql="update service set s_state='已分配',s_disposeman= '"+dispose+"',s_date='"+nowtime+"' where s_id ="+s_id;
        System.out.println(sql);
        int i = dao.update(sql);
        return i;
    }

    @Override
    public List<Service> queryForServiceList(Role u, String keyword) throws SQLException {

        String sql = "select distinct * from service s,customer c,role r where c.c_id=s.c_id and c.r_id=r.r_id and s.s_state != '已处理'";
//        if (!(u.getuRole().getdId() == 3)) {
//            sql += " and c_manager =" + u.getuId();
//        }
        sql+=" and (c_name like '%"+keyword+"%' or s_type like '%"+keyword+"%')";
        System.out.println(sql);
        return dao.queryForList(sql);
    }

    @Override
    public List<Service> queryForServe(Role u, String id) throws SQLException {
        String sql="select * from service s,customer c ,role r where s.c_id=c.c_id and c.c_id =r.r_id   and s_id =" +id;
//        System.out.println(sql);
        return dao.queryForList(sql);
    }

    @Override
    public int addSave(Handl h) throws SQLException {
        String sql="insert into handle value(null,"+h.getService().getS_id()+",'"+h.getH_handle()+"',"+h.getRole().getR_id()+",'"+h.getH_time()+"',null,null)";
//        System.out.println(sql);
        return dao.update(sql);
    }
    @Override
    public int updatestate(String s_id) throws SQLException {
        String sql="update service set s_state='已处理' where s_id ="+s_id;
//        System.out.println(sql);
        int i = dao.update(sql);
        return i;
    }

    @Override
    public List<Service> queryForFeedBackList(Role u, String keyword) throws SQLException {
        String sql = "select distinct * from service s,customer c,role r ,handle h where c.c_id=s.c_id and c.r_id=r.r_id and s.s_id = h.s_id and s.s_state = '已处理'  and h_result IS NULL";
//        if (!(u.getuRole().getdId() == 3)) {
//            sql += " and c_manager =" + u.getuId();
//        }
        sql+=" and (c_name like '%"+keyword+"%' or s_type like '%"+keyword+"%')";
//        System.out.println(sql);
        return dao.queryForList(sql);
    }

    @Override
    public List<Handl> queryForHandle(String id) throws SQLException {
        String sql="select distinct  * from  handle where s_id =" +id;
        System.out.println(sql);
        return dao.queryForList1(sql);
    }

    @Override
    public int updateState(String id) throws SQLException {
        String sql="update service set s_state ='已归档' where s_id ="+id;
//        System.out.println(sql);
        int i = dao.update(sql);
        return i;
    }
}
