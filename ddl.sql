CREATE TABLE customer
(
    c_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    c_name VARCHAR(255),
    c_area VARCHAR(255),
    r_id INT(11),
    c_class VARCHAR(255),
    c_satifaction INT(11),
    c_credit INT(11),
    c_portcode VARCHAR(255),
    c_tel VARCHAR(255),
    c_fix VARCHAR(255),
    c_website VARCHAR(255),
    c_state VARCHAR(255),
    c_address VARCHAR(255),
    CONSTRAINT fk_r_c FOREIGN KEY (r_id) REFERENCES role (r_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX r_id ON customer (r_id);
CREATE TABLE linkman
(
    l_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    l_name VARCHAR(255),
    l_position VARCHAR(255),
    l_tel VARCHAR(255),
    l_phone VARCHAR(255),
    l_remark VARCHAR(255),
    c_id INT(11),
    CONSTRAINT fk_c_l FOREIGN KEY (c_id) REFERENCES customer (c_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX c_id ON linkman (c_id);
CREATE TABLE lost
(
    l_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    l_reason VARCHAR(255),
    l_state VARCHAR(255),
    c_id INT(11),
    l_measure VARCHAR(255),
    CONSTRAINT fk_c_lost FOREIGN KEY (c_id) REFERENCES customer (c_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX c_id ON lost (c_id);
CREATE TABLE `order`
(
    o_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    o_time VARCHAR(255),
    o_address VARCHAR(255),
    o_state VARCHAR(255),
    c_id INT(11),
    o_sum VARCHAR(255),
    CONSTRAINT fk_c_o FOREIGN KEY (c_id) REFERENCES customer (c_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX c_id ON orders (c_id);
CREATE TABLE product
(
    p_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    p_name VARCHAR(255),
    p_num INT(11),
    p_unit VARCHAR(255),
    p_price DECIMAL(10),
    o_id INT(11),
    CONSTRAINT fk_p_o FOREIGN KEY (o_id) REFERENCES orders (o_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX o_id ON product (o_id);
CREATE TABLE role
(
    r_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    r_name VARCHAR(255),
    r_position VARCHAR(255)
);
CREATE TABLE trade
(
    t_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    t_time VARCHAR(255),
    t_address VARCHAR(255),
    t_detail VARCHAR(255),
    t_outline VARCHAR(255),
    t_remark VARCHAR(255),
    c_id INT(11),
    CONSTRAINT fk_c_t FOREIGN KEY (c_id) REFERENCES customer (c_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX c_id ON trade (c_id);

create table handle
(
    h_id INT(10) auto_increment
        primary key,
    s_id INT(10) null,
    d_id INT(10) null,
    h_handle VARCHAR(255) null,
    r_id INT(10) null,
    h_time VARCHAR(255) null
)
;
create table distribute
(
    d_id INT(10) auto_increment
        primary key,
    s_id INT(10) null,
    r_id INT(10) null,
    d_time VARCHAR(255) null
)
;
create table service
(
    s_id INT(10) auto_increment
        primary key,
    s_type VARCHAR(255) null,
    s_detail VARCHAR(255) null,
    c_id INT(10) null,
    s_state VARCHAR(255) null,
    s_request VARCHAR(255) null,
    r_id INT(10) null,
    s_time VARCHAR(255) null
)
;