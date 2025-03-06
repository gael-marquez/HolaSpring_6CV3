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

## 📷 Capturas de pantalla y pruebas
Registro de usuario:
![image](https://github.com/user-attachments/assets/76276fdf-3f11-4464-98cc-93e689526130)
Inicio de sesión:
![image](https://github.com/user-attachments/assets/8f141733-045c-414e-8172-461f8b476c3a)
Pantalla de inicio para usuario:
![image](https://github.com/user-attachments/assets/352e6026-ac6f-48d7-8216-191ee0b2a526)
Pantalla de editar perfil:
![image](https://github.com/user-attachments/assets/b9c6a6fc-9a1c-4ed7-ba7c-8c31fdb4a863)

Cambiar contraseña:

![image](https://github.com/user-attachments/assets/c400942e-8402-4787-b9af-ac986c97e488)

Agregar imagen:

![image](https://github.com/user-attachments/assets/ce74d827-5497-4218-b6ad-6c5dfb53b122)

Pantalla de administrador:
![image](https://github.com/user-attachments/assets/e87264b8-5864-4dca-929b-ebd109d1286f)

Panel de administración:
![image](https://github.com/user-attachments/assets/feb6f8d8-a86a-44c8-8f41-522516c90a99)

Agregar usuario desde panel:
![image](https://github.com/user-attachments/assets/ba61a97e-dc13-44de-b2db-8c25eef272dd)

Usuario agregado:
![image](https://github.com/user-attachments/assets/8cf0a405-e7f5-4e71-af98-f09c95c655cf)

Eliminar usuario "brandon":
![image](https://github.com/user-attachments/assets/d65346f2-b3dc-4581-b973-90294fad34ef)

Eliminado:
![image](https://github.com/user-attachments/assets/5c106a79-7ce7-4897-b9f4-65837d8bbb45)










