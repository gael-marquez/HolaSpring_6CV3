# HolaSpring_6CV3 🚀

## Descripción 📄
Este proyecto es un sistema de busqueda y recomendación de películas y libros usando API's, como OpenLibrary.org y OMDB.

## Requisitos previos 🛠️
- Java 11 o superior
- Maven
- Docker (opcional, solo si deseas ejecutar el proyecto en un contenedor)

## Instalación y ejecución 🚀

### Clonar el repositorio 📥
```bash
git clone https://github.com/gael-marquez/HolaSpring_6CV3.git
cd HolaSpring_6CV3
```

### Compilar el proyecto ⚙️
```bash
mvn clean install
```

### Ejecutar el proyecto localmente 🖥️
```bash
mvn spring-boot:run
```

### Ejecutar el proyecto en Docker 🐳
```bash
docker build -t holaspring .
docker run -p 8080:8080 holaspring
```

## Estructura del proyecto 📁
- `src/main/java`: Código fuente en Java
- `src/main/resources`: Archivos de configuración y recursos estáticos
- `src/test/java`: Pruebas unitarias

## Comentarios relevantes 💬
- Asegúrate de tener configurado el entorno de desarrollo con Java y Maven antes de ejecutar el proyecto.
- Puedes utilizar Docker para ejecutar el proyecto en un contenedor y evitar problemas de configuración en tu máquina local.

## Autor ✍️
Gael Alejandro Marquez Rodriguez
