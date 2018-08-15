package entity;

import entity.Customer;

/**
 * Created by mac on 2018/8/14.
 */
public class Linkman {
    private int l_id;
    private String l_name;
    private String l_position;
    private String l_tel;
    private String l_phone;
    private String l_remark;
    private Customer customer;

    public Linkman() {
    }

    public Linkman(int l_id, String l_name, String l_position, String l_tel, String l_phone, String l_remark, Customer customer) {
        this.l_id = l_id;
        this.l_name = l_name;
        this.l_position = l_position;
        this.l_tel = l_tel;
        this.l_phone = l_phone;
        this.l_remark = l_remark;
        this.customer = customer;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getL_position() {
        return l_position;
    }

    public void setL_position(String l_position) {
        this.l_position = l_position;
    }

    public String getL_tel() {
        return l_tel;
    }

    public void setL_tel(String l_tel) {
        this.l_tel = l_tel;
    }

    public String getL_phone() {
        return l_phone;
    }

    public void setL_phone(String l_phone) {
        this.l_phone = l_phone;
    }

    public String getL_remark() {
        return l_remark;
    }

    public void setL_remark(String l_remark) {
        this.l_remark = l_remark;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
