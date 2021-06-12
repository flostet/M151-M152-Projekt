ALTER SEQUENCE coin_sequence OWNED BY coin.id;
ALTER SEQUENCE wallet_sequence OWNED BY wallet.id;
ALTER SEQUENCE trade_sequence OWNED BY trade.id;

ALTER TABLE coin ALTER COLUMN id SET DEFAULT nextval('coin_sequence');
ALTER TABLE wallet ALTER COLUMN id SET DEFAULT nextval('wallet_sequence');
ALTER TABLE trade ALTER COLUMN id SET DEFAULT nextval('trade_sequence');

-- Add Coins to coin table
insert into coin (id, coingeckoid, name, shortname)
values (1, 'bitcoin', 'Bitcoin', 'btc');

insert into coin (id, coingeckoid, name, shortname)
values (2, 'ethereum', 'Ethereum', 'eth');

insert into coin (id, coingeckoid, name, shortname)
values (3, 'tether', 'Tether', 'usdt');

insert into coin (id, coingeckoid, name, shortname)
values (4, 'binancecoin', 'Binance Coin', 'bnb');

insert into coin (id, coingeckoid, name, shortname)
values (5, 'cardano', 'Cardano', 'ada');

insert into coin (id, coingeckoid, name, shortname)
values (6, 'dogecoin', 'Dogecoin', 'doge');

insert into coin (id, coingeckoid, name, shortname)
values (7, 'xrp', 'XRP', 'xrp');

insert into coin (id, coingeckoid, name, shortname)
values (8, 'usdcoin', 'USD Coin', 'usdc');

insert into coin (id, coingeckoid, name, shortname)
values (9, 'polkadot', 'Polkadot', 'dot');

insert into coin (id, coingeckoid, name, shortname)
values (10, 'uniswap', 'Uniswap', 'uni');

insert into coin (id, coingeckoid, name, shortname)
values (11, 'bitcoincash', 'Bitcoin Cash', 'bch');

insert into coin (id, coingeckoid, name, shortname)
values (12, 'litecoin', 'Litecoin', 'ltc');

insert into coin (id, coingeckoid, name, shortname)
values (13, 'solana', 'Solana', 'sol');

insert into coin (id, coingeckoid, name, shortname)
values (14, 'chainlink', 'Chainlink', 'link');

insert into coin (id, coingeckoid, name, shortname)
values (15, 'binanceusd', 'Binance USD', 'busd');

insert into coin (id, coingeckoid, name, shortname)
values (16, 'polygon', 'Polygon', 'matic');

insert into coin (id, coingeckoid, name, shortname)
values (17, 'internetcomputer', 'InternetComputer', 'icp');

insert into coin (id, coingeckoid, name, shortname)
values (18, 'theta', 'THETA', 'theta');

insert into coin (id, coingeckoid, name, shortname)
values (19, 'stellar', 'Stellar', 'xlm');

insert into coin (id, coingeckoid, name, shortname)
values (20, 'vechain', 'VeChain', 'vet');

insert into coin (id, coingeckoid, name, shortname)
values (21, 'safemoon', 'SafeMoon', 'safemoon');

insert into coin (id, coingeckoid, name, shortname)
values (22, 'schweizerfranken', 'Schweizer Franken', 'chf');

-- INSERT WALLET
INSERT INTO wallet(id, coinamount, investedamount, coin_id, user_id)
VALUES (1, 45345, 45345, 22, 2);

INSERT INTO wallet(id, coinamount, investedamount, coin_id, user_id)
VALUES (2, 1, 15234, 1, 2);

INSERT INTO wallet(id, coinamount, investedamount, coin_id, user_id)
VALUES (3, 1, 200, 2, 2);

-- INSERT TRADES
INSERT INTO trade(id, fiat_amount, token_amount, coin_id, wallet_id)
VALUES (1, 45345, 45345, 22, 1);

INSERT INTO trade(id, fiat_amount, token_amount, coin_id, wallet_id)
VALUES (2, 15234, 1, 1, 2);

INSERT INTO trade(id, fiat_amount, token_amount, coin_id, wallet_id)
VALUES (3, 200, 1, 2, 3);