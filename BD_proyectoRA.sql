create database BD_proyectoRA;
use BD_proyectoRA;

create table tb:grados(
id IINT PRIMARY KEY,
nombre VARCHAR(50)
);

CREATE TABLE tb_alumno(
id INT PRIMARY KEY,
nombre VARCHAR(50),
id_grado INT,
foreign key (id_grado) references tb_grado(id)
) ;

create table tb_notas(
id INT primary key,
id_alumno int,
registro varchar (20),
nota decimal (10, 2),
foreign key (id_alumno) references tb_alumnos(id)
);

insert into tb_grados (id, nombre) VALUES
(1,'primer grado'),
(2,'segundo grado'),
(3,'tercer grado'),
(4,'cuarto grado'),
(5,'Quinto grado');

insert into tb_alumnos (id, nombre, id_grado) VALUES
(1,'juan Perez',1),
(2,'Maria Gomez',2),
(3,'Carlos Lopez',1),
(4,'Ana Rodriguez',3),
(5,'Pedro Sanches',2);

insert into tb_notas (id, id_nombre, registro, nota) VALUES
(1,1,'antes de RA',17.5 ),
(2,2,'segundo grado',18.6),
(3,3,'tercer grado',15.6),
(4,4,'cuarto grado',13.8),
(5,5,'Quinto grado',16.9);




