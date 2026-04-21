# Proyecto Microservicios Cafeteria

Guia rapida para levantar, detener y limpiar el entorno completo en Windows (PowerShell).

## 1) Arranque limpio (reset total recomendado)

Ejecuta estos comandos cuando quieras empezar desde cero.

```powershell
# 1. Detener y borrar contenedores/volumenes de infra y servicios
cd C:\ms\ProyectosMS2026\infra
docker compose down -v --remove-orphans

cd C:\ms\ProyectosMS2026\services\catalogo
docker compose down -v --remove-orphans
docker compose -f docker-compose-dev.yml down -v --remove-orphans

cd C:\ms\ProyectosMS2026\services\producto
docker compose down -v --remove-orphans
docker compose -f docker-compose-dev.yml down -v --remove-orphans

cd C:\ms\ProyectosMS2026\services\pedido
docker compose down -v --remove-orphans
docker compose -f docker-compose-dev.yml down -v --remove-orphans

# 2. (Opcional) borrar imagenes dangling/cache de build
docker image prune -f
docker builder prune -f
```

## 2) Liberar puertos en Windows (si algo quedo colgado)

Puertos usados en este proyecto:
- Infra (host): `7072`, `7082`, `7092`
- Infra (apps en local): `7071`, `7081`, `7091`
- Servicios (local): `8081` (catalogo), `9091` (producto), `9093` (pedido)
- MySQL dev/prod host: `3307`, `3391`, `3393`, `3394`

Para identificar y matar un proceso por puerto:

```powershell
# Ver proceso usando un puerto (ejemplo 9091)
Get-NetTCPConnection -LocalPort 9091 -State Listen | Select-Object LocalPort, OwningProcess

# Matar proceso por PID (ejemplo)
Stop-Process -Id <PID> -Force
```

## 3) Levantar DEV (mismo orden de clase)

Abrir 6 terminales (si levantas tambien catalogo).

### Terminal 1 - Config Server
```powershell
cd C:\ms\ProyectosMS2026\infra\config-server
mvn spring-boot:run
```

### Terminal 2 - Registry Server (Eureka)
```powershell
cd C:\ms\ProyectosMS2026\infra\registry-server
mvn spring-boot:run
```

### Terminal 3 - Gateway
```powershell
cd C:\ms\ProyectosMS2026\infra\gateway
mvn spring-boot:run
```

### Terminal 4 - Producto (DB dev + app)
```powershell
cd C:\ms\ProyectosMS2026\services\producto
docker compose -f docker-compose-dev.yml up -d
mvn spring-boot:run
```

### Terminal 5 - Pedido (DB dev + app)
```powershell
cd C:\ms\ProyectosMS2026\services\pedido
docker compose -f docker-compose-dev.yml up -d
mvn spring-boot:run
```

### Terminal 6 - Catalogo (opcional, pero recomendado)
```powershell
cd C:\ms\ProyectosMS2026\services\catalogo
docker compose -f docker-compose-dev.yml up -d
mvn spring-boot:run
```

## 4) Levantar PROD (Docker)

### 4.1 Infra (Docker)
```powershell
cd C:\ms\ProyectosMS2026\infra
docker compose up -d config-server
docker compose up -d registry-server
docker compose up -d gateway
```

### 4.2 Servicios (Docker)
```powershell
cd C:\ms\ProyectosMS2026\services\catalogo
copy .env.example .env
docker compose up -d

cd C:\ms\ProyectosMS2026\services\producto
copy .env.example .env
docker compose up -d

cd C:\ms\ProyectosMS2026\services\pedido
copy .env.example .env
docker compose up -d
```

## 5) Detener todo

### Detener DEV
Si los servicios Java estan en `mvn spring-boot:run`, detener con `Ctrl + C` en cada terminal.

Luego bajar las DB de dev:

```powershell
cd C:\ms\ProyectosMS2026\services\catalogo
docker compose -f docker-compose-dev.yml down

cd C:\ms\ProyectosMS2026\services\producto
docker compose -f docker-compose-dev.yml down

cd C:\ms\ProyectosMS2026\services\pedido
docker compose -f docker-compose-dev.yml down
```

### Detener PROD
```powershell
cd C:\ms\ProyectosMS2026\services\catalogo
docker compose down

cd C:\ms\ProyectosMS2026\services\producto
docker compose down

cd C:\ms\ProyectosMS2026\services\pedido
docker compose down

cd C:\ms\ProyectosMS2026\infra
docker compose down
```

## 6) URLs utiles

### Infra
- Config Server (host): `http://localhost:7072`
- Eureka (host): `http://localhost:7082`
- Gateway (host): `http://localhost:7092`

### Servicios directos (DEV local)
- Catalogo: `http://localhost:8081`
- Producto: `http://localhost:9091`
- Pedido: `http://localhost:9093`

### Swagger via Gateway (DEV/PROD)
- Catalogo: `http://localhost:7092/catalogo/swagger-ui/index.html`
- Producto: `http://localhost:7092/producto/swagger-ui/index.html`
- Pedido: `http://localhost:7092/pedido/swagger-ui/index.html`

### Endpoints principales via Gateway
- Catalogo API: `http://localhost:7092/api/v1/categorias`
- Producto API: `http://localhost:7092/api/v1/productos`
- Pedido API: `http://localhost:7092/api/v1/pedidos`

## 7) Verificacion rapida

```powershell
# Estado de contenedores
docker ps

# Probar salud basica por gateway
curl http://localhost:7092/api/v1/productos
curl http://localhost:7092/api/v1/pedidos
```
