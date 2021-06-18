ALTER SEQUENCE wallet_sequence OWNED BY wallet.id;

ALTER TABLE wallet ALTER COLUMN id SET DEFAULT nextval('wallet_sequence');

--Insert into Wallet

insert into wallet (coin_id, user_id, coinamount, investedamount)
values (1, 2, 1.345, 15734);

insert into wallet (coin_id, user_id, coinamount, investedamount)
values (2, 2, 56.45, 11258.67);