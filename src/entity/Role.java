package entity;

/**
 * Created by mac on 2018/8/14.
 */
public class Role {
    private int r_id;
    private String r_name;
    private String r_position;

    public Role() {
    }

    public Role( String r_name, String r_position) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.r_position = r_position;
    }

    public Role(int r_id, String r_name, String r_position) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.r_position = r_position;
    }

    @Override
    public String toString() {
        return "Role{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_position='" + r_position + '\'' +
                '}';
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getR_position() {
        return r_position;
    }

    public void setR_position(String r_position) {
        this.r_position = r_position;
    }
}
