# Sistema de Gestión de Matrículas Escolares
Este proyecto es una API RESTful desarrollada con Spring Boot que permite gestionar el proceso de matrícula en instituciones educativas públicas de Santa Marta, Colombia. Su objetivo es digitalizar y simplificar los trámites administrativos tanto para padres de familia como para personal administrativo, optimizando el registro, consulta y control de estudiantes, cupos y asignaciones.

# 🧩 Funcionalidades principales
- Registro y autenticación de usuarios.

- Gestión de estudiantes y acudientes.

- Registro y administración de instituciones educativas.

- Asignación de cupos escolares según criterios definidos.

- Visualización y seguimiento del estado de las solicitudes de matrícula.

- Control de disponibilidad de cupos por sede y jornada.

# 🛠️ Tecnologías utilizadas
- Java 17

- Spring Boot

- Spring Data JPA

- Base de datos relacional (por ejemplo: PostgreSQL o H2 para pruebas)

- Lombok

- Maven/Gradle


# 🗂️ Estructura del proyecto

├── controllers         # Controladores que manejan las peticiones HTTP

├── dtos                # Clases para la transferencia de datos

├── entities            # Entidades que representan las tablas de la base de datos

├── exceptions          # Manejo de excepciones personalizadas

├── mappers             # Transformaciones entre entidades y DTOs

├── repositories        # Interfaces para acceso a datos con Spring Data

├── services            # Lógica de negocio del sistema

└── FinalProjectApplication.java  # Clase principal de arranque de Spring Boot

# ⚙️ Cómo ejecutar el proyecto
1. Clona el repositorio:
   git clone https://github.com/tu-usuario/nombre-del-repo.git

2. Abre el proyecto en tu IDE (IntelliJ IDEA recomendado).

3. Configura tu base de datos en application.properties o application.yml.

4. Ejecuta la clase FinalProjectApplication.java.



👨‍💻 Autor
Nelson Martinez Hazbum - Ingeniero De Sistemas / Backend Developer
