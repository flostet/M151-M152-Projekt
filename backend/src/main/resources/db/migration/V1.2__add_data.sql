ALTER SEQUENCE coin_sequence OWNED BY coin.id;

ALTER TABLE coin ALTER COLUMN id SET DEFAULT nextval('coin_sequence');


-- Add Coins to coin table
insert into coin (coingeckoid, name, shortname)
values ('bitcoin', 'Bitcoin', 'btc');

insert into coin (coingeckoid, name, shortname)
values ('ethereum', 'Ethereum', 'eth');

insert into coin (coingeckoid, name, shortname)
values ('tether', 'Tether', 'usdt');

insert into coin (coingeckoid, name, shortname)
values ('binancecoin', 'Binance Coin', 'bnb');

insert into coin (coingeckoid, name, shortname)
values ('cardano', 'Cardano', 'ada');

insert into coin (coingeckoid, name, shortname)
values ('dogecoin', 'Dogecoin', 'doge');

insert into coin (coingeckoid, name, shortname)
values ('ripple', 'XRP', 'xrp');

insert into coin (coingeckoid, name, shortname)
values ('usd-coin', 'USD Coin', 'usdc');

insert into coin (coingeckoid, name, shortname)
values ('polkadot', 'Polkadot', 'dot');

insert into coin (coingeckoid, name, shortname)
values ('uniswap', 'Uniswap', 'uni');

insert into coin (coingeckoid, name, shortname)
values ('bitcoin-cash', 'Bitcoin Cash', 'bch');

insert into coin (coingeckoid, name, shortname)
values ('litecoin', 'Litecoin', 'ltc');

insert into coin (coingeckoid, name, shortname)
values ('solana', 'Solana', 'sol');

insert into coin (coingeckoid, name, shortname)
values ('chainlink', 'Chainlink', 'link');

insert into coin (coingeckoid, name, shortname)
values ('binance-usd', 'Binance USD', 'busd');

insert into coin (coingeckoid, name, shortname)
values ('matic-network', 'Polygon', 'matic');

insert into coin (coingeckoid, name, shortname)
values ('internet-computer', 'InternetComputer', 'icp');

insert into coin (coingeckoid, name, shortname)
values ('theta-token', 'THETA', 'theta');

insert into coin (coingeckoid, name, shortname)
values ('stellar', 'Stellar', 'xlm');

insert into coin (coingeckoid, name, shortname)
values ('vechain', 'VeChain', 'vet');

insert into coin (coingeckoid, name, shortname)
values ('safemoon', 'SafeMoon', 'safemoon');

insert into coin (coingeckoid, name, shortname)
values ('schweizerfranken', 'Schweizer Franken', 'chf');