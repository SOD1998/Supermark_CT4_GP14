DROP DATABASE IF EXISTS supermark;
CREATE DATABASE supermark CHARACTER SET utf8mb4;
USE supermark;

CREATE TABLE domicilio ( 
id INT auto_increment NOT NULL PRIMARY KEY,
localidad VARCHAR(30) NOT NULL,
barrio VARCHAR(20) NOT NULL,
calle VARCHAR(30) NOT NULL,
Num_casa INT,
Num_piso INT,
Num_depto INT
);

create table usuario (
id int auto_increment not null primary key,
nombre varchar(30) not null,
apellido varchar (30) not null,
email varchar(50) not null unique,
clave varchar (15) not null,
fecha_de_nacimiento date,
id_domicilio int,
rol tinyint,
foreign key (id_domicilio) references domicilio(id)
);

CREATE TABLE tarjeta (
Num_tarjeta BIGINT NOT NULL primary key,
Cod_seguridad INT NOT NULL,
vencimiento DATE NOT NULL,
titular VARCHAR(16) NOT NULL,
banco Varchar(20) not null,
tipo ENUM('CRÉDITO', 'DÉBITO'),
id_usuario int not null,
foreign key (id_usuario) references usuario(id)
);

CREATE TABLE producto (
id INT auto_increment NOT NULL PRIMARY KEY,
nombre VARCHAR (10) NOT NULL,
marca VARCHAR (10) NOT NULL,
vencimiento DATE,
stock INT,
precio float NOT NULL
);
 
CREATE TABLE carrito (
id INT NOT NULL auto_increment primary key,
id_producto INT NOT NULL,
id_usuario INT NOT NULL,
cantidad INT NOT NULL,
FOREIGN KEY (id_producto) references producto(id),
FOREIGN KEY (id_usuario) REFERENCES usuario(id)
);
 
 CREATE TABLE comprobante (
id INT NOT NULL auto_increment primary key,
total float,
fecha_emision timestamp,
tipo varchar (1),
id_usuario INT NOT NULL,
id_tarjeta bigint not null,
FOREIGN KEY (id_usuario) REFERENCES usuario(id),
foreign key (id_tarjeta) references tarjeta(Num_tarjeta)
);
 
CREATE TABLE detalle (
id INT NOT NULL auto_increment PRIMARY KEY,
id_producto INT NOT NULL,
cantidad INT NOT NULL,
id_comprobante int NOT NULL,
FOREIGN KEY (id_producto) references producto(id),
FOREIGN KEY (id_comprobante) REFERENCES comprobante(id)
);

create table envios(
id int not null primary key,
id_comprobante int not null,
id_domicilio int not null,
foreign key (id_comprobante) references comprobante(id)
);


insert into domicilio values (1,'Tartagal', 'San Jose', 'Necochea',null,null,null),
(2,'Tartagal', 'San Jose', 'Richieri',null,null,null),
(3,'Mosconi', 'Centro', '9 de julio',null,null,null),
(4,'Aguaray', 'San Juan', '25 de mayo',null,null,null);

insert into usuario values (1,'Selim', 'Dahan', 'selimomardahan@gmail.com', '123456','1998-02-06',1,1),
(2,'Milagro','Molina','milagromolina__19@hotmail.com','qwerty','1999-12-19',2,1),
(3,'Luis','Correa','luiscorrea@outlook.com','asdfgh','1995-01-01',4,1),
(4,'Yanina', 'Molina', 'yaninamolina@yahoo.com', 'zxcvbn','2001-01-11',2,0),
(5,'Lila', 'Dahan', 'lilamariadahan@gmail.com', '123457','1988-08-06',1,0),
(6,'Raul', 'Dahan', 'rauldahan87@gmail.com', '123457','1987-05-25',1,0),
(7,'Victor', 'Rodriguez', 'vrodriguez@gmail.com', '098765','1994-10-18',3,0);

insert into tarjeta values (1234567,1234, '2027-01-02', 'Yanina Molina', 'Nación','DÉBITO',4),
(1234568,1235, '2026-03-04', 'Lila Dahan', 'Macro','CRÉDITO',5),
(1234569,1236, '2025-05-06', 'Lila Dahan', 'Brubank','DÉBITO',5),
(1234570,1237, '2024-07-08', 'Victor Rodriguez', 'Nación','CRÉDITO',7);

insert into producto values (1,'Mate','Marolio','2023-01-02',60,39.99),
(2,'Cafe','Marolio','2024-10-20',100,279.99),
(3,'Harina','Marolio','2022-07-17',80,144.99),
(4,'Palmitos','Marolio','2025-01-02',60,339.99),
(5,'Yerba','Marolio','2022-09-11',50,179.99),
(6,'Mermelada','Marolio','2024-08-16',0,124.99),
(7,'Cacao','Marolio','2021-12-19',15,124.99),
(8,'Picadillo','Marolio','2022-02-06',0,54.99),
(9,'Pate','Marolio','2023-07-09',100,49.99),
(10,'Caballa','Marolio','2025-05-25',200,299.99),
(11,'Arroz','Marolio','2023-06-17',250,104.99),
(12,'Arvejas','Marolio','2023-06-20',30,84.99),
(13,'Sardinas','Marolio','2026-06-13',150,249.99),
(14,'Atun','Marolio','2024-02-24',200,199.99),
(15,'Choclo','Marolio','2022-01-01',50,84.99),
(16,'Lentejas','Marolio','2023-11-11',40,84.99);

insert into carrito values (1,10,5,6),
(2,13,5,10),
(3,14,5,5),
(4,5,4,8),
(5,15,7,7),
(6,11,5,12),
(7,11,4,9),
(8,16,7,11),
(9,15,7,3);

insert into comprobante values (1,1000.00,null,'A',4,1234567),
(2,2000.00,null,'A',5,1234568),
(3,1000.00,null,'A',5,1234569);
#(4,1000.00,null,'C',7,1234570);

insert into detalle values (1,5,8,1),
(2,11,9,1),
#(3,15,7,4),
#(4,16,11,4),
#(5,15,3,4),
(6,10,6,2),
(7,13,10,2),
(8,11,12,3),
(9,14,5,3);

insert into envios values (1,1,2),
(2,2,1),
(3,3,1);
#(4,4,3);
