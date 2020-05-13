delete from "wallet-test".wallet."user";

insert into "wallet-test".wallet."user" (login, password, email, approved, token) values
('first',  '123', 'first@mail.ru',  true, 'PWAPLZvFTXf01'),
('second', '123', 'second@mail.ru', true, 'PWAPLZvFTXf02'),
('third',  '123', 'third@mail.ru',  true, 'PWAPLZvFTXf03'),
('fourth', '123', 'fourth@mail.ru', true, 'PWAPLZvFTXf04'),
('fifth',  '123', 'fifth@mail.ru',  true, 'PWAPLZvFTXf05');