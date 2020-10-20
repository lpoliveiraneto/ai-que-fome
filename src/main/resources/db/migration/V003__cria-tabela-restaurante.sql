CREATE TABLE restaurante(
    id_restaurante BIGINT NOT NULL auto_increment PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    taxa_frete DOUBLE not NULL,
    ativo BIT NOT NULL,
    id_cozinha BIGINT NOT NULL, 

     CONSTRAINT fk_restaurante_cozinha FOREIGN KEY (id_cozinha)
     REFERENCES cozinha(id_cozinha)
)engine = InnoDB DEFAULT CHARSET=UTF8;