CREATE TABLE clientes(
	id serial primary key,
	nome varchar(50) not null,
	data_nascimento date not null
);

insert into clientes (nome, data_nascimento) values ('Antonio Mauricio','1998-06-24');
insert into clientes (nome, data_nascimento) values ('Paola Fernandes','1977-11-17');
insert into Clientes (nome, data_nascimento) values ('Tiago Ferreira','2000-12-02');