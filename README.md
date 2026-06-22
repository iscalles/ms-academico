# ms-academico — Microservicio Académico

Colegio Bernardo O'Higgins · Proyecto Libro de Clases Digital

Microservicio desarrollado por el equipo que gestiona toda la información académica del colegio: cursos, asignaturas, la relación entre ambos, evaluaciones, calificaciones y matrículas de estudiantes. Es consumido por el BFF y se comunica con ms-usuario mediante OpenFeign para obtener datos de usuarios cuando es necesario.

---

## Responsabilidades

- Gestionar cursos y asignaturas del colegio
- Asociar asignaturas a cursos (relación CursoAsignatura)
- Crear y administrar evaluaciones por asignatura
- Registrar y consultar calificaciones de alumnos
- Gestionar matrículas que vinculan a un estudiante con un curso

---

## Requisitos previos

| Herramienta | Versión |
|---|---|
| Java JDK | 21 |
| Maven | 3.8 o superior |
| Oracle Autonomous Database | Wallet configurado |
| ms-usuario | Corriendo en `http://localhost:8081` |

---

## Instalación y ejecución

```bash
# 1. Clonar el repositorio
git clone https://github.com/iscalles/ms-academico.git
cd ms-academico/AcademicoService

# 2. Copiar el wallet de Oracle a la ruta configurada
# El wallet debe estar en:
# src/main/resources/wallet/Wallet_proyectoLibroAsistencia/

# 3. Compilar
mvn clean package -DskipTests

# 4. Ejecutar
mvn spring-boot:run
```

---

## Configuración (`application.properties`)

```properties
spring.application.name=academicoService

# Base de datos Oracle (Autonomous Database)
spring.datasource.url=jdbc:oracle:thin:@proyectolibroasistencia_high?TNS_ADMIN=<ruta-wallet>
spring.datasource.username=ms-academico
spring.datasource.password=<contraseña>
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver

# JPA / Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
spring.jpa.show-sql=true
```

> **Seguridad:** no subir credenciales reales al repositorio.

---

## Endpoints REST

### Cursos (`/cursos`)
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/cursos` | Listar todos los cursos |
| GET | `/cursos/{id}` | Buscar curso por ID |
| POST | `/cursos` | Crear curso |
| PUT | `/cursos/{id}` | Actualizar curso |
| DELETE | `/cursos/{id}` | Eliminar curso |

### Asignaturas (`/asignaturas`)
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/asignaturas` | Listar todas las asignaturas |
| GET | `/asignaturas/{id}` | Buscar asignatura por ID |
| POST | `/asignaturas` | Crear asignatura |
| PUT | `/asignaturas/{id}` | Actualizar asignatura |
| DELETE | `/asignaturas/{id}` | Eliminar asignatura |

### Curso-Asignatura (`/curso-asignatura`)
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/curso-asignatura` | Listar todas las relaciones |
| GET | `/curso-asignatura/{id}` | Buscar por ID |
| POST | `/curso-asignatura` | Asociar asignatura a curso (asigna un docente vía `docenteIdUsuario`) |
| PUT | `/curso-asignatura/{id}` | Actualizar asociación (ej. reasignar docente) |
| DELETE | `/curso-asignatura/{id}` | Eliminar asociación |

### Evaluaciones (`/evaluaciones`)
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/evaluaciones` | Listar todas las evaluaciones |
| GET | `/evaluaciones/{id}` | Buscar evaluación por ID |
| GET | `/evaluaciones/curso-asignatura/{idCursoAsignatura}` | Evaluaciones de una asignatura dictada en un curso específico |
| POST | `/evaluaciones` | Crear evaluación |
| PUT | `/evaluaciones/{id}` | Actualizar evaluación |
| DELETE | `/evaluaciones/{id}` | Eliminar evaluación |

### Calificaciones (`/calificaciones`)
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/calificaciones` | Listar todas las calificaciones |
| GET | `/calificaciones/{id}` | Buscar por ID |
| GET | `/calificaciones/id_evaluacion/{id_evaluacion}` | Calificaciones de una evaluación |
| GET | `/calificaciones/id_matricula/{id_matricula}` | Calificaciones de un alumno matriculado |
| POST | `/calificaciones` | Registrar calificación individual |
| POST | `/calificaciones/lote` | Registrar las calificaciones de varios alumnos para una misma evaluación en una sola petición |
| PUT | `/calificaciones/{id}` | Actualizar calificación |
| DELETE | `/calificaciones/{id}` | Eliminar calificación |

**Body de `POST /calificaciones/lote`:**
```json
{
  "idEvaluacion": 1,
  "creadoPorIdUsuario": 502,
  "detalles": [
    { "idMatricula": 10, "notaCalificacion": 6.2 },
    { "idMatricula": 11, "notaCalificacion": 5.5 }
  ]
}
```

### Matrículas (`/matriculas`)
| Método | Ruta | Descripción |
|---|---|---|
| GET | `/matriculas` | Listar todas las matrículas |
| GET | `/matriculas/{id}` | Buscar matrícula por ID |
| GET | `/matriculas/curso/{idCurso}` | Listar las matrículas (alumnos) de un curso |
| POST | `/matriculas` | Crear matrícula |
| PUT | `/matriculas/{id}` | Actualizar matrícula |
| DELETE | `/matriculas/{id}` | Eliminar matrícula |

---


## Modelo de datos (tablas en `ms_academico`)

| Tabla | Descripción |
|---|---|
| `CURSO` | Cursos del colegio (ej: 1°A, 2°B) |
| `ASIGNATURA` | Asignaturas del plan de estudios (ej: Matemáticas, Lenguaje) |
| `CURSO_ASIGNATURA` | Relación entre un curso y las asignaturas que dicta |
| `EVALUACION` | Evaluaciones definidas por asignatura (nombre, fecha, porcentaje) |
| `CALIFICACION` | Nota obtenida por un alumno en una evaluación específica |
| `MATRICULA` | Relación entre un estudiante y el curso en que está inscrito |

---

## Comunicación con ms-usuario

El microservicio incluye un `UsuarioClient` implementado con OpenFeign que consume el endpoint interno de ms-usuario (`/usuario/interno/{id}`) para obtener datos del usuario cuando se necesita enriquecer respuestas con información personal.

```
ms-academico → OpenFeign → ms-usuario (8081) → /usuario/interno/{id}
```

---

## Patrones de diseño implementados

| Patrón | Implementación |
|---|---|
| **Repository** | Un repositorio JPA por entidad — abstrae el acceso a datos |
| **Service Layer** | Interfaces de servicio con implementaciones separadas (`ServiceImpl`) |
| **DTO** | `*RequestDTO` para entrada y `*ResponseDTO` para salida en calificaciones, evaluaciones, matrículas y curso-asignatura |
| **Proxy (OpenFeign)** | `UsuarioClient` para consultar información de usuarios en ms-usuario |

---

## Tecnologías

- Spring Boot 3.2.12
- Java 21
- Spring Data JPA + Hibernate
- Oracle Autonomous Database (esquema `ms-academico`)
- OpenFeign (comunicación con ms-usuario)
- Maven (arquetipo `spring-boot-starter-parent`)
