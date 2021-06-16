ALTER SEQUENCE wallet_sequence OWNED BY wallet.id;
ALTER SEQUENCE trade_sequence OWNED BY trade.id;

ALTER TABLE wallet ALTER COLUMN id SET DEFAULT nextval('wallet_sequence');
ALTER TABLE trade ALTER COLUMN id SET DEFAULT nextval('trade_sequence');

--Insert into Wallet
insert into wallet (coin_id, user_id, coinamount, investedamount)
values (22, 2, 3563.78, 3563.78);

insert into wallet (coin_id, user_id, coinamount, investedamount)
values (1, 2, 1.345, 15734);

insert into wallet (coin_id, user_id, coinamount, investedamount)
values (2, 2, 56.45, 11258.67);

-- Insert into Trades
insert into trade (fiat_amount, token_amount, coin_id, wallet_id)
values (3563.78, 3563.78, 22, 1);

insert into trade (fiat_amount, token_amount, coin_id, wallet_id)
values (15734, 1.345, 1, 2);

insert into trade (fiat_amount, token_amount, coin_id, wallet_id)
values (11258.67, 56.45, 1, 3);