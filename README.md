# Agenda - API para la Gestión de Contactos

## Descripción
La API de Agenda permite la gestión de contactos, proporcionando operaciones CRUD sobre una base de datos de contactos. La API incluye características de seguridad, validación y limitación de peticiones.

## Autenticación
La API utiliza **Spring Security** para autenticación básica. Asegúrate de incluir las credenciales de usuario en las cabeceras de tus solicitudes.

## Requisitos
Tener instalado javaJDK 22.



## Dependencias del Proyecto

### Spring Boot Starters
- **`spring-boot-starter-data-jpa`**: Para la persistencia de datos utilizando JPA/Hibernate.
- **`spring-boot-starter-web`**: Para construir aplicaciones web basadas en REST.
- **`spring-boot-starter-security`**: Para añadir seguridad a la API.
- **`spring-boot-starter-validation`**: Para la validación de datos entrantes.
- **`spring-boot-starter-aop`**: Para la programación orientada a aspectos.
- **`spring-boot-starter-test`**: Para las pruebas de la aplicación.

### Base de Datos
- **`h2`**: Base de datos en memoria para pruebas y desarrollo.

### Documentación
- **`springdoc-openapi-starter-webmvc-ui`** y **`springdoc-openapi-ui`**: Para la generación automática de documentación OpenAPI (Swagger UI).

### Control de Tasa de Peticiones
- **`bucket4j-core`**: Para limitar el número de peticiones a la API.

### Formato YAML
- **`jackson-dataformat-yaml`**: Para manejar datos en formato YAML.



## Estructura del Proyecto

- **Controladores (controller)**: Define los endpoints de la API.
- **Servicios (services)**: Contiene la lógica de negocio.
- **Repositorios (repository)**: Interactúa con la base de datos.
- **Aspectos (aspect)**: Contiene clases relacionadas con la programación orientada a aspectos (AOP).
- **Modelos (model)**: Define las entidades de la base de datos.
- **Data Transfer Object (dto)**: Contiene los objetos de transferencia de datos.
- **Excepciones (exception)**: Maneja las excepciones personalizadas.
- **Configuraciones (config)**: Contiene configuraciones personalizadas, como la configuración de swagger y la limitación de peticiones.
- **Seguridad (security)**: Contiene configuraciones personalizadas de Spring security, como la configuración de autenticacion.
- **Documentacion (docs)**: Contiene la documentacion de la aplicacion para el cliente.



## Documentacion Swagger
*Para probar los servicios y acceder a su documentacion:*
  ~~~
    http://localhost:8080/agenda/swagger-ui.html
  ~~~


## Consola H2
*Para probar los servicios y acceder a su documentacion:*
  ~~~
    http://localhost:8080/agenda/h2-console
  ~~~



## Usuarios creados de Prueba

### Usuarios y Contraseñas

- **Usuario de Prueba 1**
  - **Nombre de Usuario**: `user`
  - **Contraseña**: `user`

- **Usuario de Prueba 2**
  - **Nombre de Usuario**: `admin`
  - **Contraseña**: `admin`



## Scripts Principales
*Para compilar el proyecto, ejecuta el siguiente comando en la consola:*
  ~~~
    mvn clean install
  ~~~

*Para ejecutar la aplicación, usa el siguiente comando:*
  ~~~
    mvn spring-boot:run
  ~~~




