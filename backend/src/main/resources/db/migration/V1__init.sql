CREATE EXTENSION IF NOT EXISTS pgcrypto;

create sequence coin_sequence start 1 increment 1;
create sequence user_sequence start 1 increment 1;
create sequence wallet_sequence start 1 increment 1;

create table coin
(
    id int8 not null,
    coingeckoid varchar(255),
    name varchar(255),
    shortname varchar(255),
    primary key (id)
);

create table crypto_user
(
    id int8 not null,
    email varchar(255),
    name varchar(255),
    password varchar(255),
    user_group varchar(255),
    primary key (id)
);

create table wallet
(
    id int8 not null,
    coinamount bigint default 0,
    investedamount bigint default 0,
    coin_id int8 not null,
    user_id int8 not null,
    primary key (id)
);

alter table if exists crypto_user add constraint UK_kqycrhiuhxqw0ktyw9dlm4qtl unique (email);
alter table if exists crypto_user add constraint UK_mrv2s8u7fnidwf549wywf64fi unique (name);
alter table if exists wallet add constraint FKaf946fq3pm5p8x8puh4qljyd3 foreign key (coin_id) references coin;
alter table if exists wallet add constraint FKs1onsswuj9pvn1421t5i5gt73 foreign key (user_id) references crypto_user;