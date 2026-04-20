# 🚀 Proyecto de Microservicios - Java 21

## 📌 Descripción

Este proyecto implementa una arquitectura de microservicios utilizando **Java 21** y el ecosistema de **Spring Boot**.
El objetivo es gestionar diferentes servicios de forma independiente, escalable y mantenible.

---

## 🛠️ Tecnologías utilizadas

* ☕ Java 21
* 🌱 Spring Boot
* 🌐 Spring Cloud
* 🐳 Docker
* 📦 Maven
* 🗄️ MySQL
* 🔎 Eureka Server (Service Discovery)
* 🚪 API Gateway
* 📄 Swagger / OpenAPI

---

## 📂 Estructura del proyecto

```
ProyectosMS2026/
│
├── config-server/
├── registry-server/
├── gateway/
├── services/
│   ├── producto/
│   ├── user/
│   └── otros-servicios/
│
└── docker-compose.yml
```

---

## ⚙️ Configuración del entorno

### 🔹 Requisitos

* Java 21 instalado
* Maven instalado
* Docker y Docker Compose
* Git

---

## ▶️ Ejecución del proyecto

### 1. Clonar repositorio

```
git clone https://github.com/heinerapaza19/pack-microsericios.git
cd pack-microsericios
```

---

### 2. Levantar Config Server

```
cd infra/config-server
mvn spring-boot:run
```

---

### 3. Levantar Eureka Server

```
cd ../registry-server
mvn spring-boot:run
```

Acceder:

```
http://localhost:7081
```

---

### 4. Levantar API Gateway

```
cd ../gateway
mvn spring-boot:run
```

---

### 5. Levantar microservicios

Ejemplo:

```
cd services/producto
mvn spring-boot:run
```

---

## 🐳 Ejecución con Docker

Desde la raíz del proyecto:

```
docker-compose up -d
```

---

## 📡 Endpoints principales

### Producto

```
GET /api/v1/productos
GET /api/v1/productos/{id}
POST /api/v1/productos
PUT /api/v1/productos/{id}
DELETE /api/v1/productos/{id}
```

---

## 📄 Documentación API

Swagger disponible en:

```
http://localhost:9091/swagger-ui.html
```

---

## 🧪 Pruebas

Puedes usar:

* Postman
* Thunder Client (VS Code)

---

## 👨‍💻 Autor

**Heiner Apaza Apaza**
Estudiante de Ingeniería de Sistemas - UPeU

---

## 📌 Notas

* Asegúrate de que los puertos no estén ocupados
* Configura correctamente la base de datos en `application.yml`
* Ejecuta primero los servicios de infraestructura

---

## ⭐ Buenas prácticas implementadas

* Separación por microservicios
* Uso de API Gateway
* Service Discovery con Eureka
* Configuración centralizada
* Contenerización con Docker

---

## 📞 Soporte

Si tienes problemas, revisa logs o verifica que todos los servicios estén activos correctamente.

---
