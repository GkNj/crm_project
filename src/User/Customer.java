package User;

/**
 * Created by mac on 2018/8/14.
 */
public class Customer {
    private int c_id;
    private String c_name;
    private String c_area;
    private Role c_manager;
    private String c_address;
    private String c_class;
    private int c_satifaction;
    private int c_credit;
    private String c_adress;
    private String c_portcode;
    private String c_tel;
    private String c_fix;
    private String c_website;
    private String c_state;

    public Customer() {
    }

    public Customer(int c_id, String c_name, String c_area, String c_address, String c_class, int c_satifaction, int c_credit, String c_adress, String c_portcode, String c_tel, String c_fix, String c_website, String c_state) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_area = c_area;
        this.c_address = c_address;
        this.c_class = c_class;
        this.c_satifaction = c_satifaction;
        this.c_credit = c_credit;
        this.c_adress = c_adress;
        this.c_portcode = c_portcode;
        this.c_tel = c_tel;
        this.c_fix = c_fix;
        this.c_website = c_website;
        this.c_state = c_state;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_area() {
        return c_area;
    }

    public void setC_area(String c_area) {
        this.c_area = c_area;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_class() {
        return c_class;
    }

    public void setC_class(String c_class) {
        this.c_class = c_class;
    }

    public int getC_satifaction() {
        return c_satifaction;
    }

    public void setC_satifaction(int c_satifaction) {
        this.c_satifaction = c_satifaction;
    }

    public int getC_credit() {
        return c_credit;
    }

    public void setC_credit(int c_credit) {
        this.c_credit = c_credit;
    }

    public String getC_adress() {
        return c_adress;
    }

    public void setC_adress(String c_adress) {
        this.c_adress = c_adress;
    }

    public String getC_portcode() {
        return c_portcode;
    }

    public void setC_portcode(String c_portcode) {
        this.c_portcode = c_portcode;
    }

    public String getC_tel() {
        return c_tel;
    }

    public void setC_tel(String c_tel) {
        this.c_tel = c_tel;
    }

    public String getC_fix() {
        return c_fix;
    }

    public void setC_fix(String c_fix) {
        this.c_fix = c_fix;
    }

    public String getC_website() {
        return c_website;
    }

    public void setC_website(String c_website) {
        this.c_website = c_website;
    }

    public String getC_state() {
        return c_state;
    }

    public void setC_state(String c_state) {
        this.c_state = c_state;
    }
}
