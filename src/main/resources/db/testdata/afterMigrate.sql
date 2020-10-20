delete  from usuario;
delete from cozinha;
delete from restaurante;
delete from estado;
delete from cidade;

alter table usuario auto_increment = 1;
alter table cozinha auto_increment = 1;

insert into usuario(nome, email, senha) values ('neto', 'leonidespires@gmail.com', 'neto123');
insert into usuario(nome, email, senha) values ('joaõ', 'joão.p@gmail.com', 'joao123');

insert into cozinha (nome) values ('Brasileira');
insert into cozinha (nome) values ('Salgados'); 

insert into restaurante (nome, taxa_frete, ativo, id_cozinha) values ('Cozinha do João', 5.5, 1, 1);
insert into restaurante (nome, taxa_frete, ativo, id_cozinha) values ('Neto Cozinha', 4.0, 1, 2);

insert into estado (nome) values ('Maranhão');
insert into estado (nome) values ('Piauí');

insert into cidade (nome, id_estado) values ('São luis', 1);
insert into cidade (nome, id_estado) values ('Teresina', 2);