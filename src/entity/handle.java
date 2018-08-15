package entity;

public class handle {
    private  String  h_id;
    private  Service service;
    private  Distribute distribute;
    private String h_handle;
    private  Role role;
    private  String h_time;

    public handle() {
    }

    public handle(String h_id, Service service, Distribute distribute, String h_handle, Role role, String h_time) {

        this.h_id = h_id;
        this.service = service;
        this.distribute = distribute;
        this.h_handle = h_handle;
        this.role = role;
        this.h_time = h_time;
    }

    public String getH_id() {

        return h_id;
    }

    public void setH_id(String h_id) {
        this.h_id = h_id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Distribute getDistribute() {
        return distribute;
    }

    public void setDistribute(Distribute distribute) {
        this.distribute = distribute;
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
}
