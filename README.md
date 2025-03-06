# 🌸 HolaSpring6CV3 🌸

Este proyecto es una aplicación web construida con Spring Boot. Proporciona una guía clara para instalar y ejecutar la aplicación, así como para desplegarla usando Docker.

## 🚀 Requisitos previos

- ☕ JDK 21 o superior
- 🛠️ Maven 3.6.0 o superior
- 🐳 Docker y Docker Compose

## 📝 Instalación y Ejecución

### 📥 Clonar el repositorio

```bash
git clone https://github.com/gael-marquez/HolaSpring_6CV3.git
cd HolaSpring_6CV3
```

### ⚙️ Configuración de la base de datos

Asegúrate de tener una base de datos MySQL en funcionamiento. Puedes configurar los detalles de la base de datos en el archivo `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tarea2?useSSL=false&serverTimezone=UTC
spring.datasource.username=admin
spring.datasource.password=admin
```

### 🛠️ Construir y ejecutar la aplicación

```bash
mvn clean install
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`.

## 📦 Despliegue usando Docker

### 🏗️ Construir la imagen de Docker

```bash
docker build -t holaspring6cv3 .
```

### 🐳 Crear y ejecutar los contenedores con Docker Compose

Crea un archivo `docker-compose.yml` en el directorio raíz del proyecto con el siguiente contenido:

```yaml
version: '3.8'

services:
  db:
    image: mysql:8.0.28
    container_name: mysql
    environment:
      MYSQL_ROOT_PASSWORD: admin
      MYSQL_DATABASE: tarea2
      MYSQL_USER: admin
      MYSQL_PASSWORD: admin
    ports:
      - "3306:3306"
    networks:
      - spring-network

  spring-app:
    image: holaspring6cv3
    container_name: holaspring6cv3
    build:
      context: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    networks:
      - spring-network

networks:
  spring-network:
    driver: bridge
```

### ▶️ Ejecutar Docker Compose

```bash
docker-compose up
```

La aplicación estará disponible en `http://localhost:8080`.

## 📄 Licencia

Este proyecto está licenciado bajo la Licencia MIT. Ver el archivo [LICENSE](LICENSE) para más detalles.
