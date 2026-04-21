CREATE TABLE roles (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(100),
                       apellido VARCHAR(100),
                       celular VARCHAR(20),
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       rol_id BIGINT NOT NULL,
                       CONSTRAINT fk_user_rol FOREIGN KEY (rol_id) REFERENCES roles(id)
);