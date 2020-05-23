SET SCHEMA 'wallet';

ALTER TABLE "user" ALTER COLUMN password TYPE VARCHAR(70);

ALTER TABLE "address" ALTER COLUMN address TYPE VARCHAR(50);

INSERT INTO role(id,title) VALUES (1,'ROLE_USER'),
                                  (2, 'ROLE_ADMIN');

INSERT INTO "user" (id, login, password , email, approved,id_role)
VALUES (1,'login1', '$2a$10$SFWw4JuUVrRckR/Y4SZtm.zTPlDFlBz3YddCvX22eHtiM/q2mN5BW','email1@mail.ru',true,1);

INSERT INTO currency (id, title, short_title, precision, index) VALUES (1,'TRON','TRX', 6, 195),
                                                                       (2,'ETHER','ETH',18,60),
                                                                       (3,'BITCOIN','BTC',8,0);

INSERT INTO address (id_user, index, address, id_currency)
VALUES (1,0,'TKmdnkRurAxJyd1VeE8BLGmY5oaH2UBfLn',1);