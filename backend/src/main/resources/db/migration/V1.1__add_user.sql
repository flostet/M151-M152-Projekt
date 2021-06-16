ALTER SEQUENCE user_sequence OWNED BY crypto_user.id;

ALTER TABLE crypto_user ALTER COLUMN id SET DEFAULT nextval('user_sequence');

insert into crypto_user (name, email, password, user_group)
values ('admin', 'admin@admin.ch', crypt('secret', gen_salt('bf', 8)), 'ADMIN');

insert into crypto_user (name, email, password, user_group)
values ('testli', 'testli@admin.ch', crypt('secret', gen_salt('bf', 8)), 'USER');