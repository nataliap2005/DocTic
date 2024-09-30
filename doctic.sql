CREATE TABLE usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    numDocumento INT UNIQUE NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    direccion VARCHAR(45) NULL,
    ciudadOrigen VARCHAR(45) NOT NULL,
    depOrigen VARCHAR(45) NOT NULL,
    nombreUsuario VARCHAR(45) NOT NULL,
    correoE VARCHAR(45) NOT NULL,
    pSecreta VARCHAR(45) NOT NULL,
    rSecreta VARCHAR(45) NOT NULL
);

CREATE TABLE categoria (
    idCategoria INT PRIMARY KEY AUTO_INCREMENT, 
    nombreCategoria VARCHAR(100) NOT NULL UNIQUE,
    subIdCategoria INT NULL, 
    FOREIGN KEY (subIdCategoria) REFERENCES categoria(idCategoria)
);

CREATE TABLE documento (
    idDocumento INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(500) NOT NULL,
    fechaPub DATE NOT NULL,
    nombre VARCHAR(59) NOT NULL,
    url VARCHAR(2048) NOT NULL,
    estado ENUM ('publico', 'privado') NOT NULL,
    idCategoria INT NULL,
    FOREIGN KEY (idCategoria) REFERENCES categoria(idCategoria) ON DELETE CASCADE
);

CREATE TABLE comentario (
    idComentario INT PRIMARY KEY,
    subIdComentario INT NULL,
    textComentario VARCHAR(500) NOT NULL,
    fecha DATE NOT NULL,
    idUsuario INT NOT NULL,
    idDocumento INT NOT NULL,
    FOREIGN KEY (subIdComentario) REFERENCES comentario(idComentario),
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE,
    FOREIGN KEY (idDocumento) REFERENCES documento(idDocumento) ON DELETE CASCADE
);

CREATE TABLE visualiza (
    idVisualiza INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL, 
    hora TIME NOT NULL,
    idDocumento INT NOT NULL,
    idUsuario INT NOT NULL,
    FOREIGN KEY(idDocumento) REFERENCES documento(idDocumento) ON DELETE CASCADE,
    FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE
);

CREATE TABLE descarga (
    idDescarga INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    idDocumento INT NOT NULL,
    idUsuario INT NOT NULL,
    FOREIGN KEY (idDocumento) REFERENCES documento(idDocumento) ON DELETE CASCADE,
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE
);

CREATE TABLE publica (
    idPublica INT PRIMARY KEY AUTO_INCREMENT,
    fechaPub DATE NOT NULL,
    idDocumento INT NOT NULL,
    idUsuario INT NOT NULL,
    rol ENUM("publicador", "coautor"),
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE,
    FOREIGN KEY (idDocumento) REFERENCES documento(idDocumento) ON DELETE CASCADE
);

CREATE TABLE valora ( 
    idValora INT PRIMARY KEY AUTO_INCREMENT,
    valoracion INT NOT NULL, 
    fechaValoracion DATE NOT NULL, 
    idUsuario INT NOT NULL, 
    idDocumento INT NOT NULL, 
    CHECK (valoracion BETWEEN 1 AND 5), 
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE,
    FOREIGN KEY (idDocumento) REFERENCES documento(idDocumento) ON DELETE CASCADE
);

CREATE TABLE contrasena ( 
    idHistorial INT PRIMARY KEY AUTO_INCREMENT,
    idUsuario INT NOT NULL, 
    contrasena VARCHAR(45) NOT NULL UNIQUE,
    fecha DATE NOT NULL, 
    estado ENUM('activa', 'inactiva') NOT NULL, 
    FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE
);
