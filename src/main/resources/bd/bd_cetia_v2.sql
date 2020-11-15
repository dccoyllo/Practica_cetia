create database bd_cetia_v2;
use bd_cetia_v2;

create table rol (
idrol int auto_increment primary key not null,
nombre varchar(50) not null
);
-- insercion de rol --
insert into rol
values
(1,"usuario"),
(2, "psicologo"),
(3, "admin");

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
-- insersion de usuarios --
insert into usuario
value
-- insersion de Psicologos--
(1, "julio", "julio", "cetiaadmin@hotmail.com", 'Julio Elías', 'Arce Huaman', 35, 75268945, 2);
INSERT INTO `bd_cetia_v2`.`usuario` (`idusuario`, `cuenta`, `clave`, `correo`, `nombre`, `apellido`, `edad`, `dni`, `idrol`) 
VALUES ('2', 'janet', 'janet', 'janet@gmail.com', 'Janet', 'Aquino Galindo', '15', '97826178', '2');
INSERT INTO `bd_cetia_v2`.`usuario` (`idusuario`, `cuenta`, `clave`, `correo`, `nombre`, `apellido`, `edad`, `dni`, `idrol`) 
VALUES ('3', 'admin', 'admin', 'administrador@gmail.com', 'Jhon David', 'Ccoyllo Rojas', '22', '94566552', '3');

-- insersion de Usuarios --
INSERT INTO `bd_cetia_v2`.`usuario` (`idusuario`, `cuenta`, `clave`, `correo`, `nombre`, `apellido`, `edad`, `dni`, `idrol`) VALUES ('4', 'carla', 'carla', 'carla@gmail.com', 'Carla', 'De la Torre Torres', '29', '58485115', '1');
INSERT INTO `bd_cetia_v2`.`usuario` (`idusuario`, `cuenta`, `clave`, `correo`, `nombre`, `apellido`, `edad`, `dni`, `idrol`) VALUES ('5', 'yerka', 'yerka', 'yerkaacha@gmail.com', 'Yerka', 'Acha Pino', '28', '97885154', '1');
INSERT INTO `bd_cetia_v2`.`usuario` (`idusuario`, `cuenta`, `clave`, `correo`, `nombre`, `apellido`, `edad`, `dni`, `idrol`) VALUES ('6', 'gabriela', 'gabriela', 'gabrielaventura12@gmail', 'Gabriela', 'Ventura Mendez', '30', '99595856', '1');
INSERT INTO `bd_cetia_v2`.`usuario` (`idusuario`, `cuenta`, `clave`, `correo`, `nombre`, `apellido`, `edad`, `dni`, `idrol`) VALUES ('7', 'piero', 'piero', 'pierdodelgado@gmail.com', 'Piero ', 'Delgado Gotardo', '32', '59461584', '1');
INSERT INTO `bd_cetia_v2`.`usuario` (`idusuario`, `cuenta`, `clave`, `correo`, `nombre`, `apellido`, `edad`, `dni`, `idrol`) VALUES ('8', 'estuar', 'estuar', 'estuarlitter@gmail.com', 'Estuar', 'Litter Pierola', '35', '84851515', '1');

create table tipo_publicacion (
idtipopublicacion int auto_increment primary key not null,
nombre varchar(50) not null
);

-- insersion de tipo de publicacion--
insert into tipo_publicacion
values 
(1,"noticia"),	
(2,"educativa"),
(3,"frases y refranes"),
(4,"actividad");
INSERT INTO `bd_cetia_v2`.`tipo_publicacion` (`idtipopublicacion`, `nombre`) VALUES ('5', 'programa');
INSERT INTO `bd_cetia_v2`.`tipo_publicacion` (`idtipopublicacion`, `nombre`) VALUES ('6', 'Dias festivos');


create table psicologo (
idusuario int primary key not null,
especialidad varchar(50) not null,
imagen varchar(100) null,
constraint fk_psicologo_usuario foreign key (idusuario) references usuario(idusuario)
on delete cascade
on update cascade
);

-- insersion de psicologo--
insert into psicologo
value
(1, "Psicologo", "usuario/x2.jpg");
INSERT INTO `bd_cetia_v2`.`psicologo` (`idusuario`, `especialidad`, `imagen`) VALUES ('2', 'Psicologa infantil', 'usuario/x1.jpg');


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
-- insercion de publicacion --
INSERT INTO `bd_cetia_v2`.`publicacion` (`idpublicacion`, `titulo`, `fecha`, `hora`, `descripcion`, `imagen`, `idtipopublicacion`, `idusuario`) VALUES ('1', 'Programa Vose', '20-11-14', '20:42', 'Pues ésta es tu oportunidad para que puedas pertenecer al programa VOSE (Voluntarios al Servicio).', '/publicacion/vose.png', '5', '1');
INSERT INTO `bd_cetia_v2`.`publicacion` (`idpublicacion`, `titulo`, `fecha`, `hora`, `descripcion`, `imagen`, `idtipopublicacion`, `idusuario`) VALUES ('2', 'Voluntariado en Psicología', '2020-11-13', '15:24', 'trabaja con nosotros, unete y ayuda', '/publicacion/voluntariadoenpsicologia.jpg', '4', '2');
INSERT INTO `bd_cetia_v2`.`publicacion` (`idpublicacion`, `titulo`, `fecha`, `hora`, `descripcion`, `imagen`, `idtipopublicacion`, `idusuario`) VALUES ('3', 'Día Mundial de las Habilidades de la Juventud', '2020-11-02', '9:52', 'La resolución expresa preocupación por el elevado número de jóvenes desempleados y reconoce que el fomento de la adquisición de habilidades por los jóvenes mejoraría su capacidad de tomar decisiones con conocimiento de causa en relación con la vida y el trabajo y los empoderaría de manera que puedan acceder al mercado laboral en evolución.', '/publicacion/diadelajuventud_n.png', '6', '2');
INSERT INTO `bd_cetia_v2`.`publicacion` (`idpublicacion`, `titulo`, `fecha`, `hora`, `descripcion`, `imagen`, `idtipopublicacion`, `idusuario`) VALUES ('4', 'Dia Mundial del agua', '2020-03-22', '8:00', 'El agua, elemento necesario para la supervivencia de todo ser vivo. muchas veces la derrochamos y malgastamos con acciones innecesarias. El tomar conciencia es indispensable para poder valorar este recurso que en un momento fue ilimitado, pero con el transcurrir de los años junto con la conducta del ser humano, este recurso se fue limitando.', '/publicacion/diamundialdelagua.png', '6', '2');
INSERT INTO `bd_cetia_v2`.`publicacion` (`idpublicacion`, `titulo`, `fecha`, `hora`, `descripcion`, `imagen`, `idtipopublicacion`, `idusuario`) VALUES ('5', 'Dia internacional de la Mujer ', '2020-03-08', '8:00', '\"Para una mujer con grandes sueños ni siquiera el cielo es el límite…esa es mi filosofía de vida, y lo más seguro es que fue también la de muchas mujeres en el pasado que se convirtieron en artistas de la transformación y líderes de la revolución, pues supieron proyectar el futuro de un milenio, logrando marcar hitos con grandes actuaciones, haciendo más y observando menos, siendo pioneras y protagonistas de cambios en el mundo".', '/publicacion/Felizdiainternacionalde lamujer.png', '6', '2');



create table servicio(
idservicio int auto_increment primary key not null,
titulo varchar(100) not null,
descripcion varchar(1000) null,
imagen varchar(100) null,
precio double not null,
tipo varchar(50) not null, 
idusuario int not null,
constraint fk_servicio_usuario foreign key (idusuario) references usuario(idusuario)
on delete cascade
on update cascade
);
-- insertar servicios --
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('1', 'Psique Kids ', 'El programa Psique-Kids está orientado al trabajo con niños y se da de forma grupal; lo que se busca a través de este programa es trabajar de manera integral diversos aspectosen los niños.', '/servicio/Psiquekids.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('2', 'Siente, integran con nosotros', 'Programa que está orientado al trabajo con niños excepcionales y sus familiares; través de este programa buscamos promover la estimulación de diversas áreas, las cuales permitirán desarrollar la autonomía y una adecuada inserción en nuestra sociedad.', '/servicio/Sin.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('3', 'SALEY', 'En el año 2012 nuestra región estaba dentro de las regiones de extrema pobreza de nuestro país, con el pasar del tiempo esto fue cambiando, pero no quita el hecho que existen muchas familiar con recursos económicos limitados, es por ello que el CETIA crea este servicio para poder atender a un precio módico o de forma gratuita a personas que tengan escasos recursos económicos.', '/servicio/salay.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('4', 'UYARIYKIM', 'Ayacucho es una región quechua hablante y es importante brindar un servicio que permita extender el trabajo en salud mental a personas que por la limitación del lenguaje no reciben una atención adecuada. ', '/servicio/uyariykim.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('5', 'Gestos de Amor', 'Estará conformado por nuestros pacientes y personas que se quieran sumar, esto nace de la necesidad de poder entregar parte de lo que tenemos a través de proyecciones sociales, en albergues, comunidades y/o poblaciones vulnerables. ', '/servicio/gestodeamor.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('6', 'Padres Aliados ', 'El programa PAL (Padres Aliados) busca generar un grupo de padres de familia que sientan la necesidad de trabajar en los diversos problemas que estén pasando con la educación de sus hijos. En éste programa trabajaremos diversos temas que brinden herramientas a los padres de familia para que puedan afrontar las dificultades que se les presenten en la educación de sus hijos y la vida en familia. ', '/servicio/pal.png', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('7', 'VOSE', 'VOSE (voluntarios al Servicio) tiene el objetivo de convocar a estudiantes de psicología que estén interesados en ganar conocimientos y experiencia a través de la participación de las diferentes actividades que el CETIA ofrece. La única condición es que puedan entregar parte de su tiempo y la responsabilidad que implica estás al servicio de nuestros usuarios.', '/servicio/vose.jpg', '0', 'Programa', '2');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('8', 'Terapia Individual', 'Nuestro objetivo en la terapia individual es ayudar al paciente lograr un conocimiento de sí mismo, ayudándolo a entender sus conductas, sus emociones y como sus pensamientos pueden estando forma a su malestar. Enseñamos al individuo de dominar sus emociones negativas, mejorando su capacidad para tomar decisiones ayudándolo a desarrollar una autoestima sana que te permita relacionarse mejor.', '/servicio/terapiaindividual.jpg', '70', 'Servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('9', 'Terapia de Pareja', 'Brindamos el tratamiento clínico psicológico que se da en ambos miembros de una relación sentimental, en su condición de enamorados, novios, esposos, convivientes, separados y/o divorciados, nuestro psicoterapeuta se centrará fundamentalmente en mejorar la comunicación en la relación. De esta manera, se aprenderá a controlar los impulsos y emociones para afrontar y resolver los conflictos que puedan surgir de una manera más eficiente. Además, se enseñará a ver los problemas desde otra perspectiva, intentando relativizar los mismos sin que los personalismos, la soberbia u orgullo pueda distorsionar los juicios de valor.', '/servicio/terapiadepareja.jpg', '100', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('10', 'Terapia de Familia', 'Es una forma de psicoterapia donde ayudamos a familias en sus dificultades derivadas de las diferencias entre cada uno de los miembros. Provee recursos a las personas en relaciones cercanas para ayudarse entre sí. Permite a los miembros de la familia expresar y explorar pensamientos difíciles y emociones en un ambiente seguro, entender las experiencias y puntos de vista de cada uno, apreciar las necesidades del otro, y construir en cimientos más firmes y hacer cambios útiles en sus relaciones y sus vidas.', '/servicio/terapiafamiliar.jpg', '90', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('11', 'Terapia Grupal', 'Brindamos la terapia grupal que se focaliza en las interacciones que se producen en el grupo, el cual se convierte en un espacio para ventilar los problemas de cada uno de los miembros y hallar solución a los mismos. Al igual que la psicoterapia individual, este método de trabajo está dirigido a ayudar a las personas a resolver sus conflictos, reencontrar el equilibrio emocional, estimular su crecimiento personal, potenciar sus habilidades sociales y dotarlas de las herramientas de afrontamiento que necesitan.', '/servicio/terapiagrupal.jpg', '80', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('12', 'Terapia del Lenguaje', 'Contamos con terapia del lenguaje o terapia del habla, es el tratamiento correspondiente para corregir problemas en el habla o dificultades de aprendizaje y uso del lenguaje, siendo los menores los pacientes con mayor incidencia, debido a que es en la edad temprana donde el lenguaje se aprende y desarrolla. Las dificultades del habla se refieren a los problemas   de fonación,  en  otras   palabras, la producción de los sonidos.', '/servicio/terapiadelenguaje.jpg', '60', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('13', 'Terapia Ocupacional ', 'Donde ayudamos a personas a lo largo de sus vidas a participar en las actividades y tareas que quieren y necesitan realizar por medio de la utilización terapéutica de actividades diarias (ocupaciones). Algunas intervenciones comunes en terapia ocupacional incluyen ayudar a niños en situación de discapacidad a participar en la escuela y situaciones sociales, ayudar a las personas que se están recuperando de lesiones y proporcionar servicios para adultos mayores que están experimentando cambios cognitivos y físicos.', '/servicio/terapiaocupacional.jpg', '120', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('14', 'Terapia de Aprendizaje', 'A través de este tipo de terapia brindamos al escolar que reciba las herramientas necesarias para construir su conocimiento a partir de su propio aprendizaje y experiencia previa. Este tipo de terapia abarca conceptos, procedimientos y actitudes.', '/servicio/terapiadeaprendizaje.jpg', '69', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('15', 'Terapia de Atención Concentración y Memoria', 'Va dirigido a nuestros niños y adultos en los que se quiera promover el desarrollo de habilidades atencionales. Siendo estas habilidades indispensables para la labor académica, y para muchas actividades que desarrollamos los seres humanos en la vida diaria. De igual forma, para niños y adultos con problemas de atención (TDA-H).', '/servicio/terapiaenatencion.jpg', '80', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('16', 'Terapia Racional Emotiva', 'Nos enfocamos en resolver problemas emocionales y conductuales mediante un modelo de intervención activo-directivo, filosófico y empírico, representado por la secuencia A-B-C, encaminado a la reestructuración cognitiva.', '/servicio/terapiaracional.jpg', '69', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('17', 'Terapia de Relajación', 'Brindamos esta terapia que ayuda a reducir tanto la tensión muscular como la general, disminuye la presión sanguínea y controla el dolor. Puede incluir la tensión y relajación de los músculos en todo el cuerpo. Se puede usar utilizando imagino logia guiada (enfocando la mente en imágenes positivas) y meditación (enfocando el pensamiento).', '/servicio/terapiaderelajacion.jpg', '150', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('18', 'Terapia de Duelo', 'En la terapia de duelo ayudamos al proceso individual de cada doliente: trata de ir descubriendo junto a él de qué están hechos los bloqueos que experimenta, cómo afronta el dolor y cómo lo gestiona, etc. En la terapia de duelo se busca ante todo la aceptación del dolor, que inevitablemente tiene que estar presente. Lo habitual es que tanto el doliente que acude a terapia como su entorno tiendan a evitar, distraer o bloquear el dolor, lo que acaba complicando el proceso.', '/servicio/terapiadeduelo.jpg', '120', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('19', 'Terapia Breve ', 'Nuestro nuevo modelo de terapia busca solucionar los problemas de la manera más rápida, eficiente y menos dolorosa. Busca atacar el problema que determine el paciente como el causante de su conflicto \"aquí y ahora\".', '/servicio/terapiabreve.jpg', '45', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('20', 'Entrenamiento en Habilidades Sociales', 'Brindamos un procedimiento de intervención que integra un conjunto de técnicas derivadas de las teorías de aprendizaje social, de la psicología social, de la terapia de conducta y de la modificación de conducta, y que se aplica para que las personas adquieran habilidades que les permitan mantener interacciones más satisfactorias en las diferentes áreas sociales de su vida.', '/servicio/Entrenamientoenhabilidades.jpg', '145', 'servicios', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('21', 'Drama Terapia', 'Brindamos DRAMATERAPIA que es el empleo del arte dramático creativo para lograr objetivos terapéuticos tales como la sensación de alivio, integración física y emocional, desarrollo de la personalidad. El drama terapia se sirve del teatro como instrumento, gracias al cual, podemos acercarnos a los problemas emocionales del paciente. Dicho \"instrumento\" son propuestas de ejercicios, improvisaciones teatrales y finalmente trabajo en base a obras de teatro. En el contenido de sus guiones aparecen problemas humanos, conflictos, dificultades y alegrías.', '/servicio/terapiadrama.jpg', '99', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('22', 'Arte Terapia', 'Brindamos este tipo de terapia artística que consiste en la utilización del arte como vía terapéutica para sanar trastornos psicológicos, tratar miedos, bloqueos personales, traumas del pasado y otros trastornos. Pero, aparte de los fines meramente terapéuticos, la Arte terapia es una técnica de desarrollo personal, de autoconocimiento y de expresión emocional. Por tanto, no es necesario poseer ningún trastorno psicológico, sino simplemente sentir la necesidad de explorarnos a través del arte.', '/servicio/arteterapia.jpg', '110', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('23', 'Atención Temprana', 'Nuestro servicio de atención temprana va enfocada a niños desde el nacimiento hasta el inicio escolar. El objetivo es favorecer el óptimo desarrollo del niño, tratando los efectos de una alteración o deficiencia, facilitando las opciones de integración familiar y social.', '/servicio/atenciontemprana.jpg', '85', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('24', 'Orientacion Vocacional', 'Nuestro servicio de orientación vocacional permite explorar e identificar creencias, percepciones, emociones, pensamientos y actividades que manifiestan y realizan los estudiantes durante su formación académica, profesional, personal, familiar y espiritual. El cual ayuda a definir la elección profesional de una persona. A través del asesoramiento y otras herramientas como la aplicación de pruebas estandarizadas, se pueden reconocer las habilidades más sobresalientes y las áreas del saber en las cuales una persona puede tener mayores probabilidades de éxito según sus preferencias e intereses.', '/servicio/orientacionvocacional.jpg', '75', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('25', 'Escuela Para Padres', 'A través de la Escuela de Padres propiciamos momentos de análisis y reflexión; identificando y analizando las diferentes etapas que cumple una familia, se promueve la comunicación entre los integrantes y con el entorno de la comunidad educativa, así mismo, se identifican las situaciones problemáticas que se crean en el interior del núcleo familiar teniendo en cuenta los distintos roles y funciones.', '/servicio/escuelaparapadres.jpg', '89', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('26', 'Consejería y Tutoría', 'CONSEJERÍA: Ofrecemos ayuda al estudiante que de una u otra manera requiere de una orientación ya sea pedagógica o psicológica (interviene en los mecanismos complejos y múltiples variables del proceso de aprendizaje de cada estudiante, para mantenerlos motivados, atentos y autónomos) TUTORÍA: Brindamos acompañamiento académico durante la formación de los estudiantes, tendiente a mejorar su rendimiento académico, lograr los perfiles de egreso, desarrollar hábitos de estudio y trabajo', '/servicio/Consejeriaytutoria.jpg', '70', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('27', 'Gimnasia Cerebral', 'Brindamos la “gimnasia cerebral” que una técnica que propone generar nuevas conexiones neuronales para lograr el equilibrio y mejorar el aprendizaje. Denominada “brain gym” o “gimnasia cerebral”, busca detectar y equilibrar las tensiones que se acumulan a lo largo de la vida en el área de aprendizaje y también en el desarrollo de la creatividad y el logro de metas.', '/servicio/gimnasiacerebral.jpg', '85', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('28', 'Talleres Cursos de Actualización', 'Nuestros talleres y cursos de capacitación son complementos que fortalecen las capacidades de profesionales o estudiantes universitarios sobre un tema específico. En este servicio brindamos las herramientas necesarias con profesionales preparados, para los participantes puedan adquirir nuevos conocimientos, basándonos en teorías y experiencias de nuestros ponentes.', '/servicio/talleresycursosdeactualizacion.jpg', '80', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('29', 'Evaluación 360°', 'Es una herramienta de gestión de talento humano que consiste en una evaluación integral la cual se utiliza para medir las competencias de los colaboradores en una empresa. Esta evaluación se basa en las relaciones que tiene el empleado, de tal manera que la retroalimentación es un factor clave para evaluar el desempeño de los trabajadores, los equipos y las organizaciones en la que se encuentran.', '/servicio/evaluacion360.jpg', '75', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('30', 'Selección de Personal ', 'Nuestra tarea es comprender tanto necesidades como posibilidades, para orientar al cliente sobre la mejor forma posible de dar solución a su pedido. La tarea de selección de personal implica contar con conocimientos sobre dos campos: sobre la organización o empresa, y sobre el contexto social del que forma parte, con el fin de satisfacer a la primera de acuerdo a las posibilidades existentes en el segundo. A partir de allí, el psicólogo realizará una lectura diagnóstica y pronóstica de candidatos posibles, considerando sus aspectos actuales y potenciales.', '/servicio/selecciondepersonal.jpg', '85', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('31', 'Ludoterapia', 'Usamos ludoterapia como un medio de comunicación y expresión entre el paciente y el terapeuta; especialmente para combatir problemas de tipo emocional. La ludoterapia ayuda al niño a entender de una mejor forma su comportamiento y solucionar todos los problemas que tenga para adaptarse. El juego que se brinda es fundamental en los niños y adolescentes, este es un medio de exploración del entorno en el cual habita e interactúa con ellos y los ayuda a comprender las cuestiones que tienen en mente.', '/servicio/ludoterapia.jpg', '95', 'servicio', '1');
INSERT INTO `bd_cetia_v2`.`servicio` (`idservicio`, `titulo`, `descripcion`, `imagen`, `precio`, `tipo`, `idusuario`) VALUES ('32', 'Modificación Conductual ', 'Nuestra tarea en modificación de conducta tiene como objetivo promover el cambio a través de técnicas de intervención psicológicas para mejorar el comportamiento de las personas, de forma que desarrollen sus potencialidades y las oportunidades disponibles en su medio, optimicen su ambiente, y adopten actitudes valoraciones y conductas útiles para adaptarse a lo que no puede cambiarse. El área de la modificación de conducta es el diseño y aplicación de métodos de intervención psicológicas que permitan el control de la conducta para producir el bienestar, la satisfacción y la competencia personal.', '/servicio/modificacionconductual.jpg', '85', 'servicio', '1');


create table reservacion (
idreservacion int auto_increment primary key not null,
fecha date not null,
hora time not null,
precio double not null,
atencion varchar(30) null,
idservicio int not null,
idusuario int not null, 
constraint fk_reservacion_usuario foreign key (idusuario) references usuario(idusuario),
constraint fk_reservacion_servicio foreign key (idservicio) references servicio(idservicio)
on delete cascade
on update cascade
);

-- insertar reservacion--
INSERT INTO `bd_cetia_v2`.`reservacion` (`idreservacion`, `fecha`, `hora`, `precio`, `atencion`, `idservicio`, `idusuario`) VALUES ('1', '2020-12-01', '9:00', '70', 'pendiente', '8', '4');
INSERT INTO `bd_cetia_v2`.`reservacion` (`idreservacion`, `fecha`, `hora`, `precio`, `atencion`, `idservicio`, `idusuario`) VALUES ('2', '2020-11-14', '17:00', '90', 'cancelado', '10', '5');
INSERT INTO `bd_cetia_v2`.`reservacion` (`idreservacion`, `fecha`, `hora`, `precio`, `atencion`, `idservicio`, `idusuario`) VALUES ('3', '2020-11-01', '10:00', '150', 'atendido', '17', '6');
INSERT INTO `bd_cetia_v2`.`reservacion` (`idreservacion`, `fecha`, `hora`, `precio`, `atencion`, `idservicio`, `idusuario`) VALUES ('4', '2020-11-20', '15:30', '120', 'pendiente', '13', '7');
INSERT INTO `bd_cetia_v2`.`reservacion` (`idreservacion`, `fecha`, `hora`, `precio`, `atencion`, `idservicio`, `idusuario`) VALUES ('5', '2020-12-01', '10:00', '70', 'pendiente', '8', '8');

-- vistas de login --
create view login(user_id, user_cuenta, user_clave, user_rol)
as
select idusuario, cuenta, clave, idrol from usuario;

-- vistas publicacion  --
create view vista_publicacion(nombre, apellido, especialidad, imagen)
as 
select pu.nombre, pu.apellido, ps.especialidad, ps.imagen
from usuario as pu
inner join psicologo as ps
on ps.idusuario = pu.idusuario;

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


