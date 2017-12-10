create database sistemaPredial
default character set utf8
default collate utf8_general_ci;

use sistemaPredial;

CREATE TABLE usuario(
		usuario VARCHAR(18) NOT NULL,
        senha VARCHAR(18) NOT NULL,
        PRIMARY KEY(usuario)
  )DEFAULT CHARACTER SET = utf8;

INSERT USUARIO VALUES('admin@predio.com','admin');

CREATE TABLE empresa 
(
  CNPJ 			VARCHAR(18) 	NOT NULL,
  RazaoSocial 	VARCHAR(30) 	NOT NULL,
  temperatura 	VARCHAR(2) 	    NOT NULL,
  HoraInicio 	TIME 			NOT NULL DEFAULT '00:00:00',
  HoraFim 		TIME 			NOT NULL DEFAULT '00:00:00',
  horaArInicio  time			not null default '00:00:00',
  horaArFim		time			not null default '00:00:00',
  PRIMARY KEY (CNPJ)
  )DEFAULT CHARACTER SET = utf8;
    