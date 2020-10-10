create database bd_cetia;
use bd_cetia;

create table Paciente(
idpaciente int(11) not null primary key auto_increment,
nombre varchar(50) not null,
apellido varchar(50) not null,
dni int(8) not null,
direccion varchar(100) not null
);

create table Psicologo(
idpsicologo int(11) primary key not null auto_increment,
nombre varchar(100) not null,
apellido varchar(100) not null,
dni int(8) not null,
email varchar(100) not null,
foto varchar(500) not null,
especialidad varchar(100) not null
 );
create table Formulario (
idformulario int(11) primary key not null auto_increment,
titulo varchar(100) not null,
descripcion varchar(500) not null,
fecha_creada date not null,
idpsicologo int(11) not null,

CONSTRAINT pk_Formulario_Psicologo FOREIGN KEY (idpsicologo) REFERENCES Psicologo(idpsicologo)
);
create table Resolviendo(
idresolviendo int(11) primary key not null,
idpaciente int(11) not null,
idformulario int(11) not null,
CONSTRAINT pk_Resolviendo_Paciente FOREIGN KEY (idpaciente) REFERENCES Paciente(idpaciente),
CONSTRAINT pk_Resolviendo_Formulario FOREIGN KEY (idformulario) REFERENCES Formulario(idformulario)
);

create table Pregunta(
idpregunta int(11) primary key not null,
nombre varchar(100) not null,
puntaje int not null,
respuesta varchar(500),
idformulario int(11) not null,
CONSTRAINT pk_Pregunta_Formulario FOREIGN KEY (idformulario) REFERENCES Formulario(idformulario)
);
