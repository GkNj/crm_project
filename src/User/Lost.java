package User;

/**
 * Created by mac on 2018/8/14.
 */
public class Lost {
    private int l_id;
    private String l_measure;
    private String l_reason;
    private String l_state;
    private Customer customer;

    public Lost() {
    }

    public Lost(int l_id, String l_measure, String l_reason, String l_state, Customer customer) {
        this.l_id = l_id;
        this.l_measure = l_measure;
        this.l_reason = l_reason;
        this.l_state = l_state;
        this.customer = customer;
    }

    public int getL_id() {
        return l_id;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public String getL_measure() {
        return l_measure;
    }

    public void setL_measure(String l_measure) {
        this.l_measure = l_measure;
    }

    public String getL_reason() {
        return l_reason;
    }

    public void setL_reason(String l_reason) {
        this.l_reason = l_reason;
    }

    public String getL_state() {
        return l_state;
    }

    public void setL_state(String l_state) {
        this.l_state = l_state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
