ALTER TABLE addresses RENAME TO "address";

ALTER TABLE users RENAME TO "user";

ALTER TABLE currencies RENAME TO "currency";

ALTER TABLE nodes RENAME TO "node";

DROP TABLE IF EXISTS role;
CREATE TABLE role (
                       id                    INT,
                       title                 VARCHAR(20) NOT NULL UNIQUE,
                       PRIMARY KEY (id)
);

ALTER TABLE "user" ADD COLUMN date_exp TIMESTAMP;
ALTER TABLE "user" ADD COLUMN id_role INT;
ALTER TABLE "user" ADD FOREIGN KEY (id_role) REFERENCES role(id);
ALTER TABLE address RENAME COLUMN id_client TO id_user;


