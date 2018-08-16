package service.impl;

import dao.impl.CustomerDaoImpl;
import entity.Customer;
import dao.CustomerDao;

import service.CustomerService;

import java.sql.SQLException;

/**
 * Created by mac on 2018/8/15.
 */
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao dao = new CustomerDaoImpl();

    @Override
    public int save(Customer c) throws SQLException {
        String sql = "insert into customer value(null,'"+c.getC_name()+
                                                    "',"+c.getC_area()+
                                                    ","+c.getC_manager()+
                                                    ","+c.getC_class()+
                                                    ",'"+c.getC_satifaction()+
                                                    "','"+c.getC_credit()+
                                                    "','"+c.getC_address()+
                                                    "','"+c.getC_portcode()+
                                                    "',"+c.getC_tel()+
                                                    "','"+c.getC_fix()+
                                                    "','"+c.getC_website()+
                                                    "',"+c.getC_state()+")";
		/*System.out.println(sql);*/
        return dao.insert(sql);
    }

    @Override
    public int deleteCustomer(String cId) throws SQLException {
        String sql1 = "update maintain_info set m_customer = null where m_customer = "+cId;
        String sql2 = "delete from customer where c_id="+cId;
        return dao.update(sql1,sql2);
    }
}
