package entity;

public class Handl {
    private int h_id;
    private Service service;
    private String h_handle;
    private Role role;
    private String h_time;
    private  String h_result;
    private  int h_stai;

    @Override
    public String toString() {
        return "Handl{" +
                "h_id=" + h_id +
                ", service=" + service +
                ", h_handle='" + h_handle + '\'' +
                ", role=" + role +
                ", h_time='" + h_time + '\'' +
                ", h_result='" + h_result + '\'' +
                ", h_stai='" + h_stai + '\'' +
                '}';
    }

    public Handl() {
    }



    public int getH_id() {

        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getH_handle() {
        return h_handle;
    }

    public void setH_handle(String h_handle) {
        this.h_handle = h_handle;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getH_time() {
        return h_time;
    }

    public void setH_time(String h_time) {
        this.h_time = h_time;
    }

    public String getH_result() {
        return h_result;
    }

    public void setH_result(String h_result) {
        this.h_result = h_result;
    }

    public int getH_stai() {
        return h_stai;
    }

    public void setH_stai(int h_stai) {
        this.h_stai = h_stai;
    }
}
