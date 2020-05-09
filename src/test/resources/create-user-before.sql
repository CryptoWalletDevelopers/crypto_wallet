delete from "wallet-test".wallet."user";

insert into "wallet-test".wallet."user" (login, password, email, approved, token) values
('first',   '123', 'first@mail.ru',  true, 'PWAPLZvFTXf01'),
('second',  '123', 'second@mail.ru', true, 'PWAPLZvFTXf02'),
('third',   '123', 'third@mail.ru',  true, 'PWAPLZvFTXf03'),
('four',    '123', 'four@mail.ru',   true, 'PWAPLZvFTXf04');