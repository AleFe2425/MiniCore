# **Backend Mini Core**

¡Bienvenido al proyecto **Backend Mini Core**! Este es un backend desarrollado con **Spring Boot**, diseñado para manejar datos de **departamentos**, **empleados** y **gastos**. Proporciona una API RESTful con operaciones básicas de CRUD y funcionalidades avanzadas como filtrado y agrupamiento de datos.

---

## **Índice**
1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Características Principales](#características-principales)
3. [Tecnologías Utilizadas](#tecnologías-utilizadas)
4. [Arquitectura del Proyecto](#arquitectura-del-proyecto)
5. [Instalación y Configuración](#instalación-y-configuración)
6. [Uso de la API](#uso-de-la-api)
7. [Estructura de Carpetas](#estructura-de-carpetas)
8. [Contribuciones](#contribuciones)
9. [Licencia](#licencia)

---

## **Descripción del Proyecto**
El objetivo de este proyecto es proporcionar un backend robusto que gestione datos de empleados, departamentos y gastos, facilitando operaciones como:
- Crear, leer, actualizar y eliminar registros.
- Filtrar y agrupar gastos por fechas y departamentos.

Es ideal para aplicaciones empresariales o sistemas de gestión de recursos.

---

## **Características Principales**
- **Gestión de empleados, departamentos y gastos** con operaciones CRUD completas.
- **Filtrado avanzado:** Filtra gastos por rango de fechas.
- **Agrupamiento:** Agrupa gastos por departamentos.
- **API RESTful pública:** Sin autenticación para facilitar pruebas.
- **CORS habilitado:** Compatible con cualquier frontend.
- **Configuración Stateless:** Ideal para aplicaciones basadas en tokens.

---

## **Tecnologías Utilizadas**
- **Java 17**
- **Spring Boot 3**
  - Spring Web
  - Spring Security
  - Spring Data JPA
- **H2 Database** (para pruebas, ajustable a MySQL u otros motores)
- **Maven** como gestor de dependencias

---

## **Arquitectura del Proyecto**
El proyecto sigue una arquitectura basada en capas:
1. **Controladores:** Manejan las rutas de la API.
2. **Servicios:** Implementan la lógica de negocio.
3. **Repositorios:** Interactúan directamente con la base de datos.
4. **Modelos:** Representan las tablas de la base de datos.

---

## **Instalación y Configuración**

Sigue estos pasos para ejecutar el proyecto localmente:

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/BackendMiniCore.git
   cd BackendMiniCore
2. **Configura las dependencias con Maven:**
   ```bash
   mvn clean install
3. **Ejecuta el servidor:**
   ```bash
   mvn spring-boot:run
4. **Accede a la API:**
El servidor estará disponible en: http://localhost:8080

---

## **Uso de la API**
**Endpoints disponibles:**
1. **Departamento.**
- GET /departamento: Listar todos los departamentos.
- POST /departamento: Registrar un nuevo departamento.
2. **Empleado**
- GET /empleado: Listar todos los empleados.
- POST /empleado: Registrar un nuevo empleado.
3. **Gasto**
- GET /gasto: Listar todos los gastos.
- POST /gasto: Registrar un nuevo gasto.
- PUT /gasto/{idGasto}: Actualizar un gasto por ID.
- DELETE /gasto/{idGasto}: Eliminar un gasto por ID.
- GET /gasto/filtrar: Filtrar y agrupar gastos por fechas y departamentos.
4. **Parámetros:**
- fechaInicio: Fecha de inicio (formato yyyy-MM-dd).
- fechaFin: Fecha de fin (formato yyyy-MM-dd).
5. **Ejemplo de Filtro**
    ```bash
    GET http://localhost:8080/gasto/filtrar?fechaInicio=2023-01-01&fechaFin=2023-12-31

---


## **Estructura de Carpetas**
    ```bash


    BackendMiniCore/
    ├── src/
    │   ├── main/
    │   │   ├── java/com/example/BackendMiniCore/
    │   │   │   ├── Config/          # Configuraciones de seguridad y CORS
    │   │   │   ├── Controlador/     # Controladores REST
    │   │   │   ├── Modelos/         # Representación de las tablas de la base de datos
    │   │   │   ├── Repositorio/     # Interfaces para operaciones en la base de datos
    │   │   │   ├── Servicios/       # Lógica de negocio
    │   │   │   └── BackendMiniCoreApplication.java # Punto de entrada
    │   └── test/                    # Pruebas unitarias (pendientes)


---

## **Anexos**

1. - Video Explicación Minicore: https://youtu.be/2nwsDCX2G8w
2. - GithubFrontend: https://github.com/AleFe2425/Proyecto-MiniCore.git
3. - Minicore Deployado: https://proyecto-mini-core.vercel.app/
