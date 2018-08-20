package service.impl;

import dao.LinkmanDao;
import dao.impl.LinkmanDaoImpl;
import entity.Customer;
import entity.Linkman;
import service.LinkmanService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mac on 2018/8/15.
 */
public class LinkmanServiceImpl implements LinkmanService {
    private LinkmanDao dao = new LinkmanDaoImpl();

    @Override
    public int save(Linkman l) throws SQLException {
        String sql = "insert into linkman value(null ,'"+l.getL_name()+
                "','"+l.getL_position()+
                "','"+l.getL_tel()+
                "','"+l.getL_phone()+
                "','"+l.getL_remark()+
                "','"+l.getCustomer().getC_id()+"')";
        System.out.println(sql);
        return dao.insert(sql);

    }

    @Override
    public List<Linkman> queryForLinkman(String id) throws SQLException {
        String sql = "select * from linkman where c_id = "+id;
        System.out.println(sql);
        return dao.queryForList(sql);
    }

    @Override
    public List<Customer> queryCustomer(String id) throws SQLException {
        String sql = "select * from customer where c_id = "+id;
        //System.out.println(sql);
        return dao.queryCustomer(sql);
    }

    @Override
    public int deleteLinkman(String lId) throws SQLException {
        String sql = "delete from linkman where l_id="+lId;
        return dao.update(sql);
    }
}
