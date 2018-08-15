package entity;

public class Distribute {
    private int d_id;
    private Service s_id;
    private Role role;
    private String d_time;

    public Distribute() {
    }

    public Distribute(int d_id, Service s_id, Role role, String d_time) {

        this.d_id = d_id;
        this.s_id = s_id;
        this.role = role;
        this.d_time = d_time;
    }

    public int getD_id() {

        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public Service getS_id() {
        return s_id;
    }

    public void setS_id(Service s_id) {
        this.s_id = s_id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getD_time() {
        return d_time;
    }

    public void setD_time(String d_time) {
        this.d_time = d_time;
    }
}