package entity;

/**
 * Created by mac on 2018/8/14.
 */
public class Trade {
    private int t_id;
    private String t_time;
    private String t_address;
    private String t_detail;
    private String t_outline;
    private String t_remark;
    private Customer customer;

    public Trade() {
    }

    public Trade(int t_id, String t_time, String t_address, String t_detail, String t_outline, String t_remake, Customer customer) {
        this.t_id = t_id;
        this.t_time = t_time;
        this.t_address = t_address;
        this.t_detail = t_detail;
        this.t_outline = t_outline;
        this.t_remark = t_remake;
        this.customer = customer;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_detail() {
        return t_detail;
    }

    public void setT_detail(String t_detail) {
        this.t_detail = t_detail;
    }

    public String getT_outline() {
        return t_outline;
    }

    public void setT_outline(String t_outline) {
        this.t_outline = t_outline;
    }

    public String getT_remark() {
        return t_remark;
    }

    public void setT_remark(String t_remark) {
        this.t_remark = t_remark;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
