create database hospital;

create table paciente (
id integer NOT NULL auto_increment,
nome varchar(50) NOT NULL,
cpf char(11) NOT NULL,
endereco varchar(100),
telefone char(11),
convenio varchar(10),
PRIMARY KEY (id),
UNIQUE (cpf),
UNIQUE (telefone)
);

create table consultorio (
id integer NOT NULL auto_increment,
numero integer (2) NOT NULL,
tipo varchar(20),
PRIMARY KEY (id),
UNIQUE (numero)
);

create table leito (
id integer NOT NULL auto_increment,
numero integer (2) NOT NULL,
tipo varchar(20),
PRIMARY KEY (id),
UNIQUE (numero)
);

create table ambulatorio (
id integer NOT NULL auto_increment,
numero integer (2) NOT NULL,
PRIMARY KEY (id),
UNIQUE (numero)
);

create table funcionarioHospital (
id integer NOT NULL auto_increment,
nome varchar(50) NOT NULL,
cpf char(11) NOT NULL,
telefone char(11),
funcao varchar(20),
horario varchar(50),
salario double(7, 2),
PRIMARY KEY (id),
UNIQUE (cpf)
);

create table medico (
id integer NOT NULL auto_increment,
nome varchar(50) NOT NULL,
cpf char(11) NOT NULL,
telefone char(11),
funcao varchar(20),
horario varchar(50),
salario double(7, 2),
crm integer(10) NOT NULL,
especialidade varchar(20),
horarioPlantao varchar(50),
PRIMARY KEY (id),
UNIQUE (cpf)
);

create table enfermeiro (
id integer NOT NULL auto_increment,
nome varchar(50) NOT NULL,
cpf char(11) NOT NULL,
telefone char(11),
funcao varchar(20),
horario varchar(50),
salario double(7, 2),
registro integer(10),
horarioPlantao varchar(50),
idLeito integer,
idAmbulatorio integer,
PRIMARY KEY (id),
UNIQUE (cpf)
);

create table consulta (
id integer NOT NULL auto_increment,
relatorioPaciente varchar(4300) NOT NULL,
tratamento varchar(4300),
periodoDeExames varchar(30),
idConsultorio integer NOT NULL,
idMedico integer NOT NULL,
idPaciente integer NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (idConsultorio) REFERENCES consultorio(id),
FOREIGN KEY (idMedico) REFERENCES medico(id),
FOREIGN KEY (idPaciente) REFERENCES paciente(id)
);

create table internacao (
id integer NOT NULL auto_increment,
medicacao varchar(50),
dataEntrada char(10) NOT NULL,
horarioEntrada char(5) NOT NULL,
dataSaida char(10),
horarioSaida char(5),
idLeito integer,
idPaciente integer NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (idLeito) REFERENCES leito(id),
FOREIGN KEY (idPaciente) REFERENCES paciente(id)
);

create table observacao (
id integer NOT NULL auto_increment,
medicacao varchar(50),
dataEntrada char(10) NOT NULL,
horarioEntrada char(5) NOT NULL,
dataSaida char(10),
horarioSaida char(5),
idAmbulatorio integer,
idPaciente integer,
PRIMARY KEY (id),
FOREIGN KEY (idAmbulatorio) REFERENCES ambulatorio(id),
FOREIGN KEY (idPaciente) REFERENCES paciente(id)
);