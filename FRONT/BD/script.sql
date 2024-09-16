create database bd_jugadores;
use bd_jugadores;

create table tb_posicion
(
cod_po int primary key auto_increment,
nom_po varchar(50)
);

create table tb_jugador
(
cod_ju int primary key auto_increment,
nom_ju varchar(50),
ape_ju varchar(50),
apo_ju varchar(40),
naci_ju varchar(60),
club_ju varchar(60),
edad_ju int,
sue_ju float,
cod_po int references tb_posicion
);

insert into tb_posicion values(1, 'Delantero');
insert into tb_posicion values(2, 'Mediocampista');
insert into tb_posicion values(3, 'Portero');
insert into tb_posicion values(4, 'Defensa');

insert into tb_jugador values(1, 'Leonel', 'Messi', 'Pulga', 'Argentino', 'Inter de Miami', 37, 800000, 1);
insert into tb_jugador values(2, 'Cristiano', 'Ronaldo', 'Bicho', 'Portugues', 'Al - Nassr', 39, 1000000, 1);
insert into tb_jugador values(3, 'James', 'Rodriguez', 'El Señor de las Asistencias', 'Colombiano', 'Rayo Vallecanode Madrid', 33, 90000, 2);
insert into tb_jugador values(4, 'Paolo', 'Guerreo', 'Depredador', 'Peruano', 'Alianza Lima', 40, 50000, 1);
insert into tb_jugador values(5, 'Julian', 'Alvarez', 'Araña', 'Argentino', 'Altetico de Madrid', 24, 500000, 1);
insert into tb_jugador values(6, 'Vinícius', 'Júnior', 'Mago', 'Brasileño', 'Real Madrid', 24, 900000, 1);
insert into tb_jugador values(7, 'Robert ', 'Lewandowski', 'Lewangoalski', 'Poloca', 'Barcelona', 36, 700000, 1);

select j.cod_ju, j.nom_ju, j.ape_ju, j.apo_ju, j.naci_ju, j.club_ju, j.edad_ju, j.sue_ju, p.nom_po from tb_jugador j inner join tb_posicion p on j.cod_po=p.cod_po;

create table tb_empleado
(
cod_emp int primary key auto_increment,
nom_emp varchar(30),
ape_emp varchar(30),
login_emp varchar(20),
clav_emp varchar(15)
);

insert into tb_empleado values(1,'Ana','Soto Ayala','ana','123');
insert into tb_empleado values(2,'Luis','Palomino Castro','luis','456');