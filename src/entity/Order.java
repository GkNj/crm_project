package entity;

/**
 * Created by mac on 2018/8/14.
 */
public class Order {
    private int o_id;
    private String o_time;
    private String o_position;
    private String o_state;
    private String o_item;
    private String o_num;
    private String o_unit;
    private String o_price;
    private Customer customer;

    public Order() {
    }

    public Order(int o_id, String o_time, String o_position, String o_state, String o_item, String o_num, String o_unit, String o_price, Customer customer) {
        this.o_id = o_id;
        this.o_time = o_time;
        this.o_position = o_position;
        this.o_state = o_state;
        this.o_item = o_item;
        this.o_num = o_num;
        this.o_unit = o_unit;
        this.o_price = o_price;
        this.customer = customer;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getO_time() {
        return o_time;
    }

    public void setO_time(String o_time) {
        this.o_time = o_time;
    }

    public String getO_position() {
        return o_position;
    }

    public void setO_position(String o_position) {
        this.o_position = o_position;
    }

    public String getO_state() {
        return o_state;
    }

    public void setO_state(String o_state) {
        this.o_state = o_state;
    }

    public String getO_item() {
        return o_item;
    }

    public void setO_item(String o_item) {
        this.o_item = o_item;
    }

    public String getO_num() {
        return o_num;
    }

    public void setO_num(String o_num) {
        this.o_num = o_num;
    }

    public String getO_unit() {
        return o_unit;
    }

    public void setO_unit(String o_unit) {
        this.o_unit = o_unit;
    }

    public String getO_price() {
        return o_price;
    }

    public void setO_price(String o_price) {
        this.o_price = o_price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
