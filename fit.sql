create database fit;
use fit;

create table alunos
(
id int auto_increment primary key,
nome varchar(255),
cpf varchar(45),
endereco varchar(45),
telefone varchar(45),
peso int
);

alter table alunos add column peso int;
alter table alunos modify column cpf long;
select * from alunos;

create table tipo_plano
(
id int auto_increment primary key,
tipo_plano varchar(45),
alunos_id int,
foreign key (alunos_id) references alunos (id)
);

create table pagamentos
(
id int auto_increment primary key,
nome varchar(45),
tipoplano varchar(45),
valor int,
pago varchar(45)
);
drop table pagamentos;

select * from pagamentos;

create table tipo_plano_pagamentos
(
id int auto_increment primary key,
tipo_plano_id int,
pagamentos_id int,
foreign key (pagamentos_id) references pagamentos (id),
foreign key (tipo_plano_id) references tipo_plano (id)
);

create table controle_de_presenca
(
id int auto_increment primary key,
nome varchar(45),
dia int,
mes varchar(45),
presenca varchar(45)
);

select * from controle_de_presenca;
drop table controle_de_presenca;
alter table controle_de_presenca add column nome varchar(45);

create table treinos
(
id int auto_increment primary key,
aluno varchar(45),
dia varchar(45),
treino varchar(45),
alunos_id int,
foreign key (alunos_id) references alunos (id)
);

create table evolucao
(
id int auto_increment primary key,
peso_inicial varchar(45),
peso_final varchar(45),
alunos_id int,
foreign key (alunos_id) references alunos (id)
);


CREATE TABLE usuario (
  id int AUTO_INCREMENT primary key,
  login varchar(30),
  senha varchar(30)
);

INSERT INTO usuario (login, senha) VALUES
("Raquel", "1010"),
("Breno","1010");

select * from alunos;

CREATE TABLE presencas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    aluno_id INT NOT NULL,
    data_presenca DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (aluno_id) REFERENCES alunos(id)
);

