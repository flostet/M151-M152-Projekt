insert into crypto_user (id, name, email, password, user_group)
values (1, 'admin', 'admin@admin.ch', crypt('secret', gen_salt('bf', 8)), 'ADMIN');

insert into crypto_user (id, name, email, password, user_group)
values (2, 'testli', 'testli@testli.ch', crypt('secret', gen_salt('bf', 8)), 'USER');