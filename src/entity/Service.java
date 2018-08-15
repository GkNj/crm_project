package entity;

public class Service {
    private int s_id;
    private String s_type;
    private String s_detail;
    private Customer customer;
    private String s_state;
    private  String s_request;
    private  Role role;
    private  String s_time;

    public Service() {
    }

    public Service(int s_id, String s_type, String s_detail, Customer customer, String s_state, String s_request, Role role, String s_time) {

        this.s_id = s_id;
        this.s_type = s_type;
        this.s_detail = s_detail;
        this.customer = customer;
        this.s_state = s_state;
        this.s_request = s_request;
        this.role = role;
        this.s_time = s_time;
    }

    @Override
    public String toString() {
        return "Service{" +
                "s_id=" + s_id +
                ", s_type='" + s_type + '\'' +
                ", s_detail='" + s_detail + '\'' +
                ", customer=" + customer +
                ", s_state='" + s_state + '\'' +
                ", s_request='" + s_request + '\'' +
                ", role=" + role +
                ", s_time='" + s_time + '\'' +
                '}';
    }

    public int getS_id() {

        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public String getS_detail() {
        return s_detail;
    }

    public void setS_detail(String s_detail) {
        this.s_detail = s_detail;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getS_state() {
        return s_state;
    }

    public void setS_state(String s_state) {
        this.s_state = s_state;
    }

    public String getS_request() {
        return s_request;
    }

    public void setS_request(String s_request) {
        this.s_request = s_request;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }
}
