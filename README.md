# 📚 Sistema de Gestión de Biblioteca (JavaFX Edition)

<div align="center">

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/GUI-JavaFX-4285F4?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/DB-MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Pattern](https://img.shields.io/badge/Architecture-MVC_%2B_DAO-purple?style=for-the-badge)

**Aplicación de escritorio robusta para la gestión de inventario bibliotecario.**
Implementa persistencia de datos real, patrón de diseño MVC y conexión segura a bases de datos.

</div>

---

## 🚀 Características Técnicas

Este proyecto demuestra competencias en desarrollo de software empresarial:

* **Arquitectura MVC:** Separación clara entre Modelo (Datos), Vista (FXML) y Controlador (Lógica).
* **Patrón DAO (Data Access Object):** Abstracción de la capa de persistencia para consultas SQL limpias.
* **Singleton:** Gestión eficiente de la conexión a base de datos para evitar fugas de recursos.
* **JavaFX Moderno:** Interfaz gráfica reactiva definida en FXML.
* **Clean Code:** Uso de **Lombok** para reducir el código boilerplate.

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 17 (LTS)
* **Build Tool:** Maven
* **Interfaz:** JavaFX 17
* **Base de Datos:** MySQL 8.0
* **Librerías:** Lombok, MySQL Connector/J

## ⚙️ Configuración e Instalación

### 1. Requisitos Previos
* JDK 17 o superior.
* MySQL Server (XAMPP o Docker).
* IntelliJ IDEA (Recomendado).

### 2. Base de Datos
Ejecuta el siguiente script en tu cliente MySQL para preparar el entorno:

```sql
CREATE DATABASE IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    disponible BOOLEAN DEFAULT TRUE
);

INSERT INTO libros (isbn, titulo, autor) VALUES 
('978-0134685991', 'Effective Java', 'Joshua Bloch');

```

### 3. Ejecución

Clona el repositorio y ejecuta con Maven:

```bash
git clone [https://github.com/ymvs84/Biblioteca.git](https://github.com/ymvs84/Biblioteca.git)
mvn clean javafx:run

```

---

**Autor:** Yago Menéndez
*Desarrollador Backend & Cloud*