ALTER TABLE addresses_id_seq RENAME TO "address_id_seq";
ALTER TABLE currencies_id_seq RENAME TO "currency_id_seq";
ALTER TABLE nodes_id_seq RENAME TO "node_id_seq";
ALTER TABLE users_id_seq RENAME TO "user_id_seq";

alter table wallet.user alter column password type varchar(255) using password::varchar(255);

ALTER TABLE "address" add FOREIGN KEY (id_user) REFERENCES wallet.user (id);
ALTER TABLE "address" add FOREIGN KEY (id_currency) REFERENCES currency (id);
ALTER TABLE "node" add FOREIGN KEY (id_currency) REFERENCES currency (id);

INSERT INTO wallet.role (id, title) VALUES (1, 'ROLE_USER');
INSERT INTO wallet.role (id, title) VALUES (2, 'ROLE_ADMIN');
