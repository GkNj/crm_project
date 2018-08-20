package entity;

public class Product {
    private int p_id;
    private String p_name;
    private int p_num;
    private String p_unit;
    private double p_price;
    private Order o_id;

    public Product() {
    }

    public Product(int p_id, String p_name, int p_num, String p_unit, double p_price, Order o_id) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_num = p_num;
        this.p_unit = p_unit;
        this.p_price = p_price;
        this.o_id = o_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_num() {
        return p_num;
    }

    public void setP_num(int p_num) {
        this.p_num = p_num;
    }

    public String getP_unit() {
        return p_unit;
    }

    public void setP_unit(String p_unit) {
        this.p_unit = p_unit;
    }

    public double getP_price() {
        return p_price;
    }

    public void setP_price(double p_price) {
        this.p_price = p_price;
    }

    public Order getO_id() {
        return o_id;
    }

    public void setO_id(Order o_id) {
        this.o_id = o_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", p_num='" + p_num + '\'' +
                ", p_unit='" + p_unit + '\'' +
                ", p_price='" + p_price + '\'' +
                ", o_id=" + o_id +
                '}';
    }
}
