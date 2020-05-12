DROP TABLE IF EXISTS user;
CREATE TABLE user (
                       id                    BIGSERIAL,
                       login                 VARCHAR(30) NOT NULL UNIQUE,
                       password              VARCHAR(30),
                       email                 VARCHAR(30) NOT NULL UNIQUE,
                       token                 VARCHAR(50),
                       approved              BOOL,
                       PRIMARY KEY (id)
);
INSERT INTO user (login, password, email, approved)
VALUES
('login1','pass1','a1@mail.ru',true),
('login2','pass2','a2@mail.ru',true);

DROP TABLE IF EXISTS currency;
CREATE TABLE currency (
                            id              BIGSERIAL,
                            title           VARCHAR(30) NOT NULL,
                            short_title     VARCHAR(10) NOT NULL,
                            precision       INT,
                            index           INT,
                            logo            TEXT,
                            PRIMARY KEY (id)
);

DROP TABLE IF EXISTS address;
CREATE TABLE address(
                           id            BIGSERIAL,
                           id_user       BIGINT,
                           index         INT,
                           address       VARCHAR(30),
                           id_currency   BIGINT,
                           PRIMARY KEY (id),
                           FOREIGN KEY (id_user) REFERENCES user (id),
                           FOREIGN KEY (id_currency) REFERENCES currency (id)
);

DROP TABLE IF EXISTS node;
CREATE TABLE node (
                       id            BIGSERIAL,
                       id_currency   BIGiNT,
                       ip            varchar(16) NOT NULL,
                       port          varchar (6) NOT NULL,
                       PRIMARY KEY (id),
                       FOREIGN KEY (id_currency) REFERENCES currency (id)
);
