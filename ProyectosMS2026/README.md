
# 🚀 Proyecto de Microservicios - Java 21 ## 📌 Descripción Sistema basado en arquitectura de microservicios desarrollado con **Java 21** y **Spring Boot**, organizado en módulos de infraestructura y servicios de negocio. --- ## 🛠️ Tecnologías utilizadas * ☕ Java 21 * 🌱 Spring Boot * 🌐 Spring Cloud * 🐳 Docker * 📦 Maven * 🗄️ MySQL * 🔎 Eureka Server * 🚪 API Gateway * 📄 Swagger --- ## 📂 Estructura del proyecto
bash
ProyectosMS2026/
│
├── infra/
│   ├── config-server/
│   ├── registry-server/
│   └── gateway/
│
├── services/
│   ├── catalogo/
│   └── producto/
│
├── docker-compose.yml
└── README.md
--- ## ⚙️ Componentes del sistema ### 🔹 Infraestructura * **config-server** → Configuración centralizada * **registry-server** → Registro de servicios (Eureka) * **gateway** → Punto de entrada a los microservicios --- ### 🔹 Microservicios * **catalogo** → Gestión de catálogo * **producto** → Gestión de productos --- ## ▶️ Orden de ejecución (IMPORTANTE) Ejecutar en este orden: ### 1. Config Server
bash
cd infra/config-server
mvn spring-boot:run
--- ### 2. Registry Server (Eureka)
bash
cd ../registry-server
mvn spring-boot:run
Abrir en navegador:
http://localhost:7081
--- ### 3. API Gateway
bash
cd ../gateway
mvn spring-boot:run
--- ### 4. Microservicios #### Catalogo
bash
cd ../../services/catalogo
mvn spring-boot:run
#### Producto
bash
cd ../producto
mvn spring-boot:run
--- ## 🐳 Ejecución con Docker Desde la raíz:
bash
docker-compose up -d
--- ## 📡 Ejemplo de endpoints ### Producto
GET    /api/v1/productos
GET    /api/v1/productos/{id}
POST   /api/v1/productos
PUT    /api/v1/productos/{id}
DELETE /api/v1/productos/{id}
--- ## 📄 Swagger Disponible en:
http://localhost:9091/swagger-ui.html
--- ## ⚠️ Recomendaciones * Ejecutar primero la infraestructura * Verificar puertos disponibles * Configurar correctamente application.yml * Revisar logs en caso de error --- ## 👨‍💻 Autor **Heiner Apaza Apaza** Ingeniería de Sistemas - UPeU --- ## ⭐ Buenas prácticashttps://github.com/heinerapaza19/pack-microsericios/tree/main/ProyectosMS2026 * Separación por capas * Arquitectura de microservicios * Configuración centralizada * Uso de API Gateway * Contenerización con Docker ---
