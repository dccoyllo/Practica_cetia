create database bd_cetia_v2;
use bd_cetia_v2;

create table rol (
idrol int auto_increment primary key not null,
nombre varchar(50) not null
);
insert into rol
values
(1,"usuario"),
(2, "psicologo");

create table usuario(
idusuario int auto_increment primary key not null,
cuenta varchar(50) not null unique,
clave varchar(50) not null,
correo varchar(50) null unique,
nombre varchar(50) null,
apellido varchar(50) null,
edad int(2) null,
dni int(8) null unique,
idrol int not null,
constraint fk_rol_usuario foreign key(idrol) references rol(idrol)
on delete cascade
on update cascade
);
insert into usuario
value
(1, "admin", "admin", "cetiaadmin@hotmail.com", 'Julio Elías', 'Arce Huaman', 35, 75268945, 2);
INSERT INTO `bd_cetia_v2`.`usuario` (`idusuario`, `cuenta`, `clave`, `correo`, `nombre`, `apellido`, `edad`, `dni`, `idrol`) 
VALUES ('2', 'janet', 'janet', 'janet@gmail.com', 'Janet', 'Aquino Galindo', '15', '97826178', '2');


create table tipo_publicacion (
idtipopublicacion int auto_increment primary key not null,
nombre varchar(50) not null
);

insert into tipo_publicacion
values 
(1,"noticia"),	
(2,"educativa"),
(3,"frases y refranes"),
(4,"actividad");

create table psicologo (
idusuario int primary key not null,
especialidad varchar(50) not null,
imagen varchar(100) null,
constraint fk_psicologo_usuario foreign key (idusuario) references usuario(idusuario)
on delete cascade
on update cascade
);
insert into psicologo
value
(1, "administrador", "/img/psicologo");
INSERT INTO `bd_cetia_v2`.`psicologo` (`idusuario`, `especialidad`, `imagen`) VALUES ('2', 'Psicologa infantil', '');

create table publicacion(
idpublicacion int auto_increment primary key not null,
titulo varchar(100) not null,
fecha date not null,
hora time not null,
descripcion varchar(1000) null,
imagen varchar(200) not null,
idtipopublicacion int not null,
idusuario int not null,
constraint fk_publicacion_tipo_publicacion foreign key (idtipopublicacion) references tipo_publicacion(idtipopublicacion),
constraint fk_publicacion_psicologo foreign key (idusuario) references psicologo(idusuario)
on delete cascade
on update cascade
);


create table servicio(
idservicio int auto_increment primary key not null,
titulo varchar(100) not null,
descripcion varchar(1000) null,
imagen varchar(100) null,
precio double not null,
tipo varchar(50) not null, 
idusuario int not null,
constraint fk_servicio_psicologo foreign key (idusuario) references psicologo(idusuario)
on delete cascade
on update cascade
);
-- insertar servicios --
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('1', 'Psique Kids ', 'El programa Psique-Kids está orientado al trabajo con niños y se da de forma grupal; lo que se busca a través de este programa es trabajar de manera integral diversos aspectosen los niños.', 'psiquekids.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('2', 'Siente, integran con nosotros', 'Programa que está orientado al trabajo con niños excepcionales y sus familiares; través de este programa buscamos promover la estimulación de diversas áreas, las cuales permitirán desarrollar la autonomía y una adecuada inserción en nuestra sociedad.', 'Sin.jpg', '0', 'programa', '2');



create table reservacion (
idreservacion int auto_increment primary key not null,
fecha date not null,
hora time not null,
precio double not null,
atencion boolean null, 
idservicio int not null,
idusuario int not null, 
constraint fk_reservacion_usuario foreign key (idusuario) references usuario(idusuario)
on delete cascade
on update cascade
);

-- vistas de login --
create view login(user_id, user_cuenta, user_clave, user_rol)
as
select idusuario, cuenta, clave, idrol from usuario;

-- vistas de reservacion --
create view detallereservacion(idservicio,fecha, hora, precio,servicio,nombreusuario, apellidousuario, dniusuario)
as 
select res.idreservacion, res.fecha, res.hora, res.precio, ser.titulo, us.nombre, us.apellido, us.dni
from reservacion as res
inner join servicio ser 
on ser.idservicio = res.idservicio
inner join usuario as us
on us.idusuario = res.idusuario;

-- vistas publicacion  --


-- vista de psicologos--
create view nuestro_equipo(nombre, apellido, especialidad, foto)
as
select us.nombre, us.apellido, ps.especialidad, ps.imagen
from usuario as us
inner join psicologo as ps
on ps.idusuario=us.idusuario;

<<<<<<< HEAD
-- vista servicio  -- 

create view nuestroservicio(codigo, titulo, descripcion, imagen, precio, tipo)
as
select idservicio, titulo, descripcion, imagen, precio, tipo from servicio;
=======
-- vista servicio psicologo -- 
-- create view 

-- select * from servicio
-- vista activid psicologo --
>>>>>>> 0521f2b6f272c72670646107d6c5783c8c3f8911


-- Super usuario --


