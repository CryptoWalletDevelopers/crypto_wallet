ALTER TABLE address RENAME TO address_tbl;
ALTER TABLE addresses_id_seq RENAME TO "address_tbl_id_seq";

ALTER TABLE wallet.role RENAME TO role_tbl;

ALTER TABLE currency RENAME TO "currency_tbl";
ALTER TABLE currencies_id_seq RENAME TO "currency_tbl_id_seq";

ALTER TABLE node RENAME TO "node_tbl";
ALTER TABLE nodes_id_seq RENAME TO "node_tbl_id_seq";

ALTER TABLE wallet.user RENAME TO user_tbl;
ALTER TABLE users_id_seq RENAME TO "user_tbl_id_seq";

alter table wallet.user_tbl alter column password type varchar(255) using password::varchar(255);

ALTER TABLE "address_tbl" add FOREIGN KEY (id_user) REFERENCES user_tbl (id);
ALTER TABLE "address_tbl" add FOREIGN KEY (id_currency) REFERENCES currency_tbl (id);
ALTER TABLE "node_tbl" add FOREIGN KEY (id_currency) REFERENCES currency_tbl (id);

INSERT INTO wallet.role_tbl (id, title) VALUES (1, 'ROLE_USER');
INSERT INTO wallet.role_tbl (id, title) VALUES (2, 'ROLE_ADMIN');
