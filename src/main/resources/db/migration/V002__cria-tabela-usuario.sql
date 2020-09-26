create table usuario (
    id bigint not null auto_increment,
    nome varchar(150) not null,
    email varchar(200) unique,
    senha varchar(15),

    primary key (id)
)engine = InnoDB default charset=utf8;