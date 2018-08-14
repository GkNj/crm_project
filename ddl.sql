CREATE TABLE customer
(
    c_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    c_name VARCHAR(255),
    c_area VARCHAR(255),
    r_id INT(11),
    c_class VARCHAR(255),
    c_satifaction INT(11),
    c_credit INT(11),
    c_adress VARCHAR(255),
    c_portcode VARCHAR(255),
    c_tel VARCHAR(255),
    c_fix VARCHAR(255),
    c_website VARCHAR(255),
    c_state VARCHAR(255),
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
    l_mesure VARCHAR(255),
    l_reason VARCHAR(255),
    l_state VARCHAR(255),
    c_id INT(11),
    CONSTRAINT fk_c_lost FOREIGN KEY (c_id) REFERENCES customer (c_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX c_id ON lost (c_id);
CREATE TABLE `order`
(
    o_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    o_time DATETIME,
    o_address VARCHAR(255),
    o_state VARCHAR(255),
    o_item VARCHAR(255),
    o_num INT(11),
    o_unit VARCHAR(255),
    o_price DECIMAL(10),
    c_id INT(11),
    CONSTRAINT fk_c_o FOREIGN KEY (c_id) REFERENCES customer (c_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX c_id ON `order` (c_id);
CREATE TABLE role
(
    r_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    r_name VARCHAR(255),
    r_position VARCHAR(255)
);
CREATE TABLE trade
(
    t_id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    t_time DATETIME,
    t_address VARCHAR(255),
    t_detail VARCHAR(255),
    t_outline VARCHAR(255),
    t_remark VARCHAR(255),
    c_id INT(11),
    CONSTRAINT fk_c_t FOREIGN KEY (c_id) REFERENCES customer (c_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE INDEX c_id ON trade (c_id);