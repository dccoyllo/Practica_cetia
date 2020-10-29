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
(1, "admin", "admin", "cetiaadmin@hotmail.com", null, null, null, null, 2);

create table tipo_publicacion (
idtipopublicacion int auto_increment primary key not null,
nombre varchar(50) not null
);

insert into tipo_publicacion
values 
(1,"noticia"),	
(2,"educativa"),
(3,"frases y refranes");

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

create table publicacion(
idpublicacion int auto_increment primary key not null,
titulo varchar(100) not null,
fecha date not null,
descripcion varchar(1000) null,
idtipopublicacion int not null,
constraint fk_publicacion_tipo_publicacion foreign key (idtipopublicacion) references tipo_publicacion(idtipopublicacion)
on delete cascade
on update cascade
);

create table psic_publ(
idpsic_publi int auto_increment primary key not null,
idusuario int not null,
idpublicacion int not null,
constraint fk_psic_publ_psicologo foreign key (idusuario) references psicologo(idusuario),
constraint fk_psic_publ_publicacion foreign key (idpublicacion) references publicacion(idpublicacion)
on delete cascade
on update cascade
);

create table actividad (
idactividad int auto_increment primary key not null,
fecha date not null,
titulo varchar(100) not null,
descripcion varchar(1000) null,
imagen varchar(100) null
);

create table psic_act(
idpsic_act int auto_increment primary key not null,
idactividad int not null,
idusuario int not null,
constraint fk_psic_act_actividad foreign key(idactividad) references actividad(idactividad),
constraint fk_psic_act_psicologo foreign key (idusuario) references psicologo(idusuario)
on delete cascade
on update cascade
);

create table servicio(
idservicio int auto_increment primary key not null,
titulo varchar(100) not null,
descripcion varchar(1000) null,
imagen varchar(100) null,
precio double not null
);

create table psic_serv(
idpsic_serv int auto_increment primary key not null,
idusuario int not null,
idservicio int not null,
constraint fk_psic_serv_psicologo foreign key (idusuario) references psicologo(idusuario),
constraint fk_psic_serv_servicio foreign key (idservicio) references servicio(idservicio)
on delete cascade
on update cascade
);

create table reservacion (
idreservacion int auto_increment primary key not null,
fecha date not null,
hora time not null,
precio double not null,
atencion boolean null, 
idservicio int not null

);

create table usu_reser(
idusu_reser int auto_increment primary key not null,
idusuario int not null,
idreservacion int not null,
constraint fk_usu_reser_usuario foreign key (idusuario) references usuario(idusuario),
constraint fk_usu_reser_reservacion foreign key (idreservacion) references reservacion(idreservacion)
on delete cascade
on update cascade
);

create view login(user_id, user_cuenta, user_clave, user_rol)
as
select idusuario, cuenta, clave, idrol from usuario;