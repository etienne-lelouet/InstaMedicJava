---1
drop database if exists intervention;
create database intervention;

use intervention ;

create table client (
	idclient int (3) not null auto_increment,
	nom varchar(20),
	prenom varchar (20),
	adressse varchar(20),
	primary key(idclient)
	);
	
create table technicien (
	idtech int (3) not null auto_increment,
	nom varchar(20),
	prenom varchar (20),
	competence varchar(100),
	primary key(idtech)
	);
	
create table intervention (
	idinter int (3) not null auto_increment,
	description varchar(100),
	dateinter date,
	montant float,
	idclient int(3) not null,
	idtech int(3) not null,
	primary key(idinter),
	foreign key(idclient) references client(idclient),
	foreign key(idtech) references technicien(idtech)
	);
	
create table user (
	login varchar(20) not null,
	mdp varchar (100) not null,
	droits enum ("admin","user","autre"),
	primary key(login)
	);
	
insert into user values ("admin","123","admin");

insert into client values (null, "Ruben", "Thibault","rue de paris"),
(null, "Alicia","Laurene","rue de lyon");

insert into technicien values (null,"Alicia","thibault","BDD");
insert into technicien values (null,"Alpha","FaFa","java");
insert into technicien values (null,"Sergio","Laurene","PHP");

create view vueGlobale as (
	select C.nom as nomClient, T.nom as nomTech, T.prenom as prenomTech, I.dateInter, I.montant
	from client C, Technicien T, Intervention I
	where C.idclient = I.idclient
	and T.idtech = I.idtech
	);
	
insert into intervention values (null, "Intervention 1", "2018-01-15",200,1,1);