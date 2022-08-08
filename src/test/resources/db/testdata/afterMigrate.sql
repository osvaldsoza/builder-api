set foreign_key_checks = 0;

delete from cliente;
delete from cliente;

set foreign_key_checks = 1;

alter table cliente auto_increment = 1;
alter table cliente auto_increment = 1;

insert into cliente (nome) values ('Saske Uchiha');
insert into cliente (nome) values ('Naruto Uzumaki');

insert into cliente (nome, tipo,cliente_id) values ('Popo','CACHORRO',1);
insert into cliente (nome, tipo,cliente_id) values ('Milk','GATO',1);
insert into cliente (nome, tipo,cliente_id) values ('Anakin','GATO',2);