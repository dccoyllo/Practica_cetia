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
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('2', 'Siente, integran con nosotros', 'Programa que está orientado al trabajo con niños excepcionales y sus familiares; través de este programa buscamos promover la estimulación de diversas áreas, las cuales permitirán desarrollar la autonomía y una adecuada inserción en nuestra sociedad.', 'Sin.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('3', 'SALEY', 'En el año 2012 nuestra región estaba dentro de las regiones de extrema pobreza de nuestro país, con el pasar del tiempo esto fue cambiando, pero no quita el hecho que existen muchas familiar con recursos económicos limitados, es por ello que el CETIA crea este servicio para poder atender a un precio módico o de forma gratuita a personas que tengan escasos recursos económicos.   ', 'salay.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('4', 'UYARIYKIM', 'Ayacucho es una región quechua hablante y es importante brindar un servicio que permita extender el trabajo en salud mental a personas que por la limitación del lenguaje no reciben una atención adecuada. ', 'uyariykim.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('5', 'Gestos de Amor', 'Estará conformado por nuestros pacientes y personas que se quieran sumar, esto nace de la necesidad de poder entregar parte de lo que tenemos a través de proyecciones sociales, en albergues, comunidades y/o poblaciones vulnerables. ', 'gestodeamor.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('6', 'Padres Aliados ', 'El programa PAL (Padres Aliados) busca generar un grupo de padres de familia que sientan la necesidad de trabajar en los diversos problemas que estén pasando con la educación de sus hijos. En éste programa trabajaremos diversos temas que brinden herramientas a los padres de familia para que puedan afrontar las dificultades que se les presenten en la educación de sus hijos y la vida en familia. ', 'pal.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('7', 'VOSE', 'VOSE (voluntarios al Servicio) tiene el objetivo de convocar a estudiantes de psicología que estén interesados en ganar conocimientos y experiencia a través de la participación de las diferentes actividades que el CETIA ofrece. La única condición es que puedan entregar parte de su tiempo y la responsabilidad que implica estás al servicio de nuestros usuarios.', 'vose.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('8', 'Terapia Individual', 'Nuestro objetivo en la terapia individual es ayudar al paciente lograr un conocimiento de sí mismo, ayudándolo a entender sus conductas, sus emociones y como sus pensamientos pueden estando forma a su malestar. Enseñamos al individuo de dominar sus emociones negativas, mejorando su capacidad para tomar decisiones ayudándolo a desarrollar una autoestima sana que te permita relacionarse mejor.', 'terapiaindividual.jpg', '70', 'Servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('9', 'Terapia de Pareja', 'Brindamos el tratamiento clínico psicológico que se da en ambos miembros de una relación sentimental, en su condición de enamorados, novios, esposos, convivientes, separados y/o divorciados, nuestro psicoterapeuta se centrará fundamentalmente en mejorar la comunicación en la relación. De esta manera, se aprenderá a controlar los impulsos y emociones para afrontar y resolver los conflictos que puedan surgir de una manera más eficiente. Además, se enseñará a ver los problemas desde otra perspectiva, intentando relativizar los mismos sin que los personalismos, la soberbia u orgullo pueda distorsionar los juicios de valor.', 'terapiadepareja.jpg', '100', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('10', 'Terapia de Familia', 'Es una forma de psicoterapia donde ayudamos a familias en sus dificultades derivadas de las diferencias entre cada uno de los miembros. Provee recursos a las personas en relaciones cercanas para ayudarse entre sí. Permite a los miembros de la familia expresar y explorar pensamientos difíciles y emociones en un ambiente seguro, entender las experiencias y puntos de vista de cada uno, apreciar las necesidades del otro, y construir en cimientos más firmes y hacer cambios útiles en sus relaciones y sus vidas.', 'terapiafamiliar', '90', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('11', 'Terapia Grupal', 'Brindamos la terapia grupal que se focaliza en las interacciones que se producen en el grupo, el cual se convierte en un espacio para ventilar los problemas de cada uno de los miembros y hallar solución a los mismos. Al igual que la psicoterapia individual, este método de trabajo está dirigido a ayudar a las personas a resolver sus conflictos, reencontrar el equilibrio emocional, estimular su crecimiento personal, potenciar sus habilidades sociales y dotarlas de las herramientas de afrontamiento que necesitan.', 'terapiagrupal', '80', 'servicio', '1');



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

-- vista servicio  -- 

create view nuestroservicio(codigo, titulo, descripcion, imagen, precio, tipo)
as
select idservicio, titulo, descripcion, imagen, precio, tipo from servicio;


-- Super usuario --


