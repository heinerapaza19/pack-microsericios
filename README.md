
# 🚀 Proyecto de Microservicios - Spring Boot + Java 21

## 📌 Descripción
Este proyecto está basado en una arquitectura de microservicios desarrollada con Java 21, Spring Boot y Maven, siguiendo buenas prácticas de desarrollo backend moderno. El sistema está dividido en módulos de infraestructura y servicios de negocio, lo que permite escalabilidad, mantenimiento independiente y despliegue por componentes.

## 🏗️ Arquitectura del Proyecto
ProyectosMS2026/
│
├── infra/
│   ├── config-server/ → Servidor de configuración centralizada
│   ├── registry-server/ → Eureka Server (registro de microservicios)
│   └── gateway/ → API Gateway (entrada única del sistema)
│
├── services/
│   ├── catalogo/ → Microservicio de catálogo
│   ├── producto/ → Microservicio de productos
│   └── otros-servicios/ → Servicios adicionales del sistema

## 🛠️ Tecnologías utilizadas

- ☕ Java 21  
- 🌱 Spring Boot  
- ☁️ Spring Cloud (Eureka, Gateway, Config Server)  
- 📦 Maven  
- 🐳 Docker (opcional)  
- 📮 Swagger / Postman para pruebas de APIs  
- 💻 Visual Studio Code  
- 🧠 IntelliJ IDEA  

## ⚙️ Características del sistema

- 🧩 Arquitectura de microservicios  
- 🔗 Comunicación entre servicios mediante REST APIs  
- 🧭 Registro y descubrimiento de servicios con Eureka  
- 🚪 API Gateway como punto de entrada único  
- ⚙️ Configuración centralizada con Spring Cloud Config  
- 🚀 Despliegue independiente por cada microservicio

## 📚 ¿Qué aprenderás con este proyecto?

Con este proyecto aprenderás a:

- 🏗️ Diseñar arquitecturas de microservicios profesionales  
- 🌐 Desarrollar APIs REST con Spring Boot  
- ☁️ Usar Spring Cloud (Eureka, Gateway y Config Server)  
- 📦 Manejar proyectos con Maven  
- 🧱 Organizar proyectos backend en capas y módulos  
- 🧠 Implementar buenas prácticas en Java moderno  
- 🔄 Entender la comunicación entre servicios distribuidos  

## 🚀 Cómo ejecutar el proyecto
1. Clonar el repositorio:
   git clone https://github.com/tuusuario/ProyectosMS2026.git

2. Levantar primero la infraestructura:
   - config-server
   - registry-server
   - gateway

3. Luego ejecutar los microservicios:
   - catalogo
   - producto
   - otros servicios

## 🔥 Requisitos
- Java 21 instalado
- Maven configurado
- IntelliJ IDEA o Visual Studio Code
- Postman para pruebas de APIs

## 👨‍💻 Autor

🚀 Proyecto desarrollado con fines educativos para el aprendizaje de arquitectura de microservicios con Spring Boot y Java moderno.

💡 Diseñado para practicar buenas prácticas, modularización y desarrollo backend profesional con Java 21.

📲 Sígueme en TikTok: @heinerdev
## 📌 Nota
Este sistema es un proyecto de práctica enfocado en arquitectura backend moderna y buenas prácticas de desarrollo.
