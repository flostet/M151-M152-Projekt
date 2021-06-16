-- CREATE SCRIPT

create table coin (id int8 not null, coingeckoid varchar(255) not null, name varchar(255) not null, shortname varchar(255) not null, primary key (id));

create table crypto_user (id int8 not null, email varchar(255) not null, fiat_wallet bigint default 0, name varchar(255) not null, password varchar(255) not null, user_group varchar(255) not null, primary key (id))

create table trade (id int8 not null, fiat_amount int8 not null, token_amount int8 not null, coin_id int8 not null, wallet_id int8 not null, primary key (id))

create table wallet (id int8 not null, coinamount bigint default 0, investedamount bigint default 0, coin_id int8 not null, user_id int8 not null, primary key (id))


-- INSERT SCRIPT

insert into coin (coingeckoid, name, shortname) values ('bitcoin', 'Bitcoin', 'btc');

insert into coin (coingeckoid, name, shortname) values ('ethereum', 'Ethereum', 'eth');

insert into coin (coingeckoid, name, shortname) values ('tether', 'Tether', 'usdt');

insert into coin (coingeckoid, name, shortname) values ('binancecoin', 'Binance Coin', 'bnb');

insert into coin (coingeckoid, name, shortname) values ('cardano', 'Cardano', 'ada');

insert into coin (coingeckoid, name, shortname) values ('dogecoin', 'Dogecoin', 'doge');

insert into coin (coingeckoid, name, shortname) values ('xrp', 'XRP', 'xrp');

insert into coin (coingeckoid, name, shortname) values ('usdcoin', 'USD Coin', 'usdc');

insert into coin (coingeckoid, name, shortname) values ('polkadot', 'Polkadot', 'dot');

insert into coin (coingeckoid, name, shortname) values ('uniswap', 'Uniswap', 'uni');

insert into coin (coingeckoid, name, shortname) values ('bitcoincash', 'Bitcoin Cash', 'bch');

insert into coin (coingeckoid, name, shortname) values ('litecoin', 'Litecoin', 'ltc');

insert into coin (coingeckoid, name, shortname) values ('solana', 'Solana', 'sol');

insert into coin (coingeckoid, name, shortname) values ('chainlink', 'Chainlink', 'link');

insert into coin (coingeckoid, name, shortname) values ('binanceusd', 'Binance USD', 'busd');

insert into coin (coingeckoid, name, shortname) values ('polygon', 'Polygon', 'matic');

insert into coin (coingeckoid, name, shortname) values ('internetcomputer', 'InternetComputer', 'icp');

insert into coin (coingeckoid, name, shortname) values ('theta', 'THETA', 'theta');

insert into coin (coingeckoid, name, shortname) values ('stellar', 'Stellar', 'xlm');

insert into coin (coingeckoid, name, shortname) values ('vechain', 'VeChain', 'vet');

insert into coin (coingeckoid, name, shortname) values ('safemoon', 'SafeMoon', 'safemoon');

insert into coin (coingeckoid, name, shortname) values ('schweizerfranken', 'Schweizer Franken', 'chf');


-- INSERT WALLET

INSERT INTO wallet(coinamount, investedamount, coin_id, user_id)
VALUES (45345, 45345, 22, 2);

INSERT INTO wallet(coinamount, investedamount, coin_id, user_id)
VALUES (1, 15234, 1, 2);

INSERT INTO wallet(coinamount, investedamount, coin_id, user_id)
VALUES (1, 200, 2, 2);




-- INSERT TRADES

INSERT INTO trade(fiat_amount, token_amount, coin_id, wallet_id)
VALUES (45345, 45345, 22, 1);

INSERT INTO trade(fiat_amount, token_amount, coin_id, wallet_id)
VALUES (15234, 1, 1, 1);

INSERT INTO trade(fiat_amount, token_amount, coin_id, wallet_id)
VALUES (200, 1, 2, 3);