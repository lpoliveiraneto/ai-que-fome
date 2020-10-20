CREATE TABLE cidade(
    id_cidade BIGINT NOT NULL auto_increment PRIMARY KEY,
    nome varchar(150) NOT NULL,
    id_estado BIGINT NOT NULL,

    CONSTRAINT fk_cidade_estado FOREIGN KEY (id_estado)
     REFERENCES estado(id_estado)
)engine = InnoDB DEFAULT CHARSET=UTF8;