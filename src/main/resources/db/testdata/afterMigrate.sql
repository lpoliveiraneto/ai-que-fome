delete from usuario;
delete from cozinha;

alter table usuario auto_increment = 1;
alter table cozinha auto_increment = 1;

insert into usuario (nome, email, senha) values('neto', 'leonidespires@gmail.com', 'neto123');
insert into usuario (nome, email, senha) values('João', 'joao.p@gmail.com', 'joao123');

insert into cozinha (nome) values ('Brasileira');
insert into cozinha (nome) values ('Salgados');