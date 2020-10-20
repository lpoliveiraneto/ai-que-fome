CREATE TABLE usuario(
    id_usuario BIGINT NOT NULL auto_increment,
    nome VARCHAR(150) NOT NULL,
    email VARCHAR(200) UNIQUE,
    senha VARCHAR(15),

    primary key (id_usuario)
)engine = InnoDB default charset=utf8;