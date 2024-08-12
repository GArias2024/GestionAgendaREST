
-- Contactos
INSERT INTO TABLE_CONTACTOS (cod_id, val_nombre, val_apellidos, val_email) VALUES
(1, 'Ana', 'Gómez Vargas', 'ana.gomez@example.com'),
(2, 'Luis', 'Martínez Arrieta', 'luis.martinez@example.com'),
(3, 'Carlos', 'Pérez Martínez', 'carlos.perez@example.com'),
(4, 'María', 'Rodríguez Gutiérrez', 'maria.rodriguez@example.com'),
(5, 'Sofía', 'García Reyes', 'sofia.garcia@example.com'),
(6, 'Miguel', 'Fernández Martínez', 'miguel.fernandez@example.com'),
(7, 'Isabella', 'Torres García', 'isabella.torres@example.com'),
(8, 'Juan', 'Mendoza Arrieta', 'juan.mendoza@example.com'),
(9, 'Camila', 'Hernández Martínez', 'camila.hernandez@example.com'),
(10, 'Mateo', 'Morales García', 'mateo.morales@example.com'),
(11, 'Valeria', 'Jiménez Gutiérrez', 'valeria.jimenez@example.com'),
(12, 'Andrés', 'Ramírez Reyes', 'andres.ramirez@example.com'),
(13, 'Natalia', 'Ortíz Martínez', 'natalia.ortiz@example.com'),
(14, 'Daniel', 'Vargas Arrieta', 'daniel.vargas@example.com'),
(15, 'Luisa', 'Gutiérrez Vargas', 'luisa.gutierrez@example.com'),
(16, 'Jorge', 'Castro García', 'jorge.castro@example.com'),
(17, 'Paola', 'Cruz Gutiérrez', 'paola.cruz@example.com'),
(18, 'Felipe', 'Reyes Bermúdez', 'felipe.reyes@example.com'),
(19, 'Laura', 'Suárez Gutiérrez', 'laura.suarez@example.com'),
(20, 'Sebastián', 'Mora Martínez', 'sebastian.mora@example.com'),
(21, 'Gabriela', 'Sánchez Reyes', 'gabriela.sanchez@example.com'),
(22, 'Alejandro', 'Álvarez Vargas', 'alejandro.alvarez@example.com'),
(23, 'Daniela', 'Salazar Gutiérrez', 'daniela.salazar@example.com'),
(24, 'Ricardo', 'Lozano Martínez', 'ricardo.lozano@example.com'),
(25, 'Elena', 'Arrieta Gutiérrez', 'elena.arrieta@example.com'),
(26, 'Oscar', 'Cárdenas García', 'oscar.cardenas@example.com'),
(27, 'Verónica', 'Rojas Arrieta', 'veronica.rojas@example.com'),
(28, 'Santiago', 'Castillo Vargas', 'santiago.castillo@example.com'),
(29, 'Catalina', 'Bermúdez García', 'catalina.bermudez@example.com'),
(30, 'Antonio', 'García Arrieta', 'antonio.garcia@example.com');


-- Usuarios
INSERT INTO TABLE_USUARIO (USERNAME, PASSWORD_HASH, ROLE) VALUES ('admin', '$2a$12$SCUOg9RMM3rNU8KUflvYMOqCPjY3kZ66a.9wRCOcUT5A3jL.DehEq', 'ADMIN');
INSERT INTO TABLE_USUARIO (USERNAME, PASSWORD_HASH, ROLE) VALUES ('user', '$2a$12$vbEnAUoHvKLMY8divCDY3O91CXzT0Dpn5wTLiKhc9GCsqnR8Zc2/C', 'USER');
