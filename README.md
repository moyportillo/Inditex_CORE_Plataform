# Proyecto de Gestión de Precios - Inditex Core Ecommerce

Este proyecto es una aplicación Spring Boot que ofrece un servicio REST para gestionar y consultar precios de productos de diferentes marcas. Está desarrollado con arquitectura hexagonal y utiliza una base de datos en memoria H2. La aplicación permite realizar consultas sobre los precios aplicables en un rango de fechas para productos y marcas específicas.

## Características

- **Lenguaje:** Java 21 (JDK 21)
- **Framework:** Spring Boot
- **Arquitectura:** Hexagonal
- **Base de Datos:** H2 en memoria
- **Documentación:** Swagger
- **Pruebas:** JUnit y Mockito

## Funcionalidades

- Consultar precios de productos para diferentes marcas y periodos de tiempo.
- Endpoints REST que aceptan como parámetros la fecha, el identificador del producto y el identificador de la marca.
- Gestión de prioridades para tarifas coincidentes.

## Tecnologías

- **JDK:** 21
- **Spring Boot:** 3.x
- **Base de Datos:** H2 en memoria
- **Pruebas:** JUnit y Mockito
- **Documentación:** Swagger

## Base de Datos

La base de datos utilizada es H2 en memoria, inicializada con datos de ejemplo para facilitar las pruebas. A continuación, se muestra la estructura de la tabla `PRICES`:

| BRAND_ID | START_DATE          | END_DATE            | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURRENCY |
|----------|---------------------|---------------------|------------|------------|----------|-------|----------|
| 1        | 2020-06-14 00:00:00 | 2020-12-31 23:59:59 | 1          | 35455      | 0        | 35.50 | EUR      |
| 1        | 2020-06-14 15:00:00 | 2020-06-14 18:30:00 | 2          | 35455      | 1        | 25.45 | EUR      |
| 1        | 2020-06-15 00:00:00 | 2020-06-15 11:00:00 | 3          | 35455      | 1        | 30.50 | EUR      |
| 1        | 2020-06-15 16:00:00 | 2020-12-31 23:59:59 | 4          | 35455      | 1        | 38.95 | EUR      |

## Documentación API

El proyecto incluye documentación de la API utilizando **Swagger**. Para acceder a la documentación generada por Swagger, inicia la aplicación y navega a:
http://localhost:8080/swagger-ui.html

## Pruebas

El proyecto utiliza **JUnit** y **Mockito** para realizar pruebas unitarias y de integración. Algunas pruebas de ejemplo incluyen:

- **Prueba 1:** Realizar una petición a las 10:00 del día 14 para el producto 35455 y la marca 1 (ZARA).
- **Prueba 2:** Realizar una petición a las 16:00 del día 14 para el producto 35455 y la marca 1 (ZARA).
- **Prueba 3:** Realizar una petición a las 21:00 del día 14 para el producto 35455 y la marca 1 (ZARA).
- **Prueba 4:** Realizar una petición a las 10:00 del día 15 para el producto 35455 y la marca 1 (ZARA).
- **Prueba 5:** Realizar una petición a las 21:00 del día 16 para el producto 35455 y la marca 1 (ZARA).

Los cuales se encuentran en el archivo **InditexCorePlataformApplicationTests** de la carpeta Test.

## Configuración

- **Base de datos:** H2
- **Swagger:** Documentación en `/swagger-ui.html`

### Requisitos

- JDK 21
- Maven

### Ejecución

1. Clona el repositorio
2. Ejecuta `mvn clean install` para construir el proyecto
3. Ejecuta `mvn spring-boot:run` para iniciar la aplicación
