DROP TABLE IF EXISTS reservas;
DROP TABLE IF EXISTS facultades;
DROP TABLE IF EXISTS investigador;
DROP TABLE IF EXISTS equipos;

CREATE TABLE facultades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

INSERT INTO facultades (nombre) VALUES 
    ('Facultad de Ciencias'),
    ('Facultad de Ingenieria'),
    ('Facultad de Medicina'),
    ('Facultad de Artes'),
    ('Facultad de Derecho');


CREATE TABLE investigadores (
    dni VARCHAR(8) PRIMARY KEY,
    nombre_apellidos VARCHAR(255) NOT NULL,
    id_facultad INT NOT NULL,
    dni_profesor CHAR(9) NOT NULL,
    FOREIGN KEY (id_facultad) REFERENCES facultad(id),
    FOREIGN KEY (Odni_profesor) REFERENCES profesores(dni) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO investigadores (dni, nombre_apellidos, id_facultad, dni_profesor) VALUES 
    ('12345678', 'Juan Perez', 1, 'P12345678'),
    ('87654321', 'Maria Lopez', 2, 'P87654321'),
    ('23456789', 'Pedro Ramirez', 3, 'P23456789'),
    ('98765432', 'Luisa Martinez', 4, 'P98765432'),
    ('34567890', 'Ana Sanchez', 5, 'P34567890');


CREATE TABLE equipos (
    num_serie CHAR(4) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_facultad INT NOT NULL,
    dni_profesor CHAR(9) NOT NULL,
    FOREIGN KEY (id_facultad) REFERENCES facultad(id),
    FOREIGN KEY (dni_profesor) REFERENCES profesores(dni) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO equipos (num_serie, nombre, id_facultad, dni_profesor) VALUES 
    ('E101', 'Equipo 1', 1, 'P12345678'),
    ('E102', 'Equipo 2', 2, 'P87654321'),
    ('E103', 'Equipo 3', 3, 'P23456789'),
    ('E104', 'Equipo 4', 4, 'P98765432'),
    ('E105', 'Equipo 5', 5, 'P34567890');

CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dni_investigador VARCHAR(8) NOT NULL,
    num_equipo CHAR(4) NOT NULL,
    comienzo DATETIME NOT NULL,
    fin DATETIME NOT NULL,
    FOREIGN KEY (dni_investigador) REFERENCES investigador(dni) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (num_equipo) REFERENCES equipo(num_serie) ON DELETE CASCADE ON UPDATE CASCADE,
);

INSERT INTO reservas (dni_investigador, num_equipo, comienzo, fin, dni_profesor) VALUES 
    ('12345678', 'E101', '2023-10-25 09:00:00', '2023-10-25 12:00:00', 'P12345678'),
    ('87654321', 'E102', '2023-10-25 10:00:00', '2023-11-25 13:00:00', 'P87654321'),
    ('23456789', 'E103', '2023-10-25 11:00:00', '2023-11-25 14:00:00', 'P23456789'),
    ('98765432', 'E104', '2023-10-25 12:00:00', '2023-11-25 15:00:00', 'P98765432'),
    ('34567890', 'E105', '2023-10-25 13:00:00', '2023-11-25 16:00:00', 'P34567890');
