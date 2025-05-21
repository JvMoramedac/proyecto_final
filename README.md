# 🐾 Sistema de Gestión de Adopción de Animales 🐶🐱

¡Bienvenidos al **Sistema de Gestión de Adopción de Animales**! 🎉 Esta aplicación de escritorio, desarrollada con mucho cariño en Java, ayuda a los centros de adopción a gestionar mascotas y adopciones de forma sencilla e intuitiva. Con una interfaz gráfica amigable y una base de datos robusta, ¡hace que encontrar un hogar para cada peludito sea más fácil que nunca! 🏡

---

## 📋 Tabla de Contenidos
- [🌟 Descripción](#-descripción)
- [💻 Programación](#-programación)
- [🗄️ Base de Datos](#-base-de-datos)
- [🛠️ Entorno de Desarrollo](#-entorno-de-desarrollo)
- [🚀 Instalación](#-instalación)
- [🐕 Uso](#-uso)
- [🤝 Contribución](#-contribución)
- [📜 Licencia](#-licencia)

---

## 🌟 Descripción

El **Sistema de Gestión de Adopción de Animales** es una herramienta diseñada para centros de adopción que quieren organizar su trabajo con estilo. 🐾 Permite:

- **Registrar adopciones** con datos del adoptante y la mascota. 📝
- **Gestionar mascotas**: agregar, modificar o eliminar información de los animalitos. 🐕
- **Ver listas** de mascotas disponibles en tablas interactivas. 📊
- **Guardar un historial** de cambios para mantener todo bajo control. 🕒

Con una interfaz gráfica creada en Java Swing y una base de datos MySQL, esta app combina funcionalidad con un diseño claro para que todos puedan usarla sin complicaciones. 😊

---

## 💻 Programación

¡El corazón de nuestra app está en su código! 🖥️ Aquí te contamos cómo lo hicimos brillar:

- **Interfaz Gráfica (GUI)**: Usamos **Java Swing** para crear una interfaz súper amigable. 🖼️ Ventanas con botones, campos de texto y tablas hacen que gestionar mascotas sea tan fácil como acariciar a un gatito. Incluye un fondo personalizado para darle un toque especial. ✨
- **Manejo de Eventos**: Cada clic cuenta. 🖱️ Los botones y tablas responden a tus acciones gracias a controladores de eventos que conectan la interfaz con la lógica, como abrir formularios o cargar datos al seleccionar una mascota.
- **Conexión a Base de Datos**: Con **JDBC** y el driver de MySQL, la app se comunica con la base de datos como si fueran viejos amigos. 🗣️ Todo está encapsulado en una clase dedicada para mantener las cosas ordenadas.
- **Persistencia de Datos**: Implementamos operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar) para manejar mascotas y adopciones. Desde agregar un nuevo perrito hasta actualizar su información, todo se guarda de forma segura. 🔒
- **Principios de POO**: Usamos **encapsulación** para organizar el código en clases claras, **herencia** para las ventanas gráficas, y **polimorfismo** para manejar eventos de forma flexible. ¡Todo bien estructurado en el paquete `Adopcion_de_animales`! 🧩

---

## 🗄️ Base de Datos

Nuestra base de datos es el hogar donde guardamos toda la información de las mascotas y sus adopciones. 🏠 Aquí los detalles:

- **SGBD Elegido**: **MySQL 8.0**, porque es confiable, fácil de configurar y perfecto para nuestro proyecto. ✅
- **Esquema de Datos**: Diseñamos un modelo relacional normalizado con tres tablas:
  - **`mascotas`**: Guarda el chip, nombre, edad, especie y raza de cada animalito. 🐶
  - **`adopcion`**: Registra los datos del adoptante (nombre, DNI, teléfono) y la mascota adoptada. 👨‍👩‍👧
  - **`historial_cambios_nuevo`**: Almacena los cambios en los datos de las mascotas, como un diario de sus aventuras. 📖
- **Scripts SQL**: Creamos scripts para:
  - **Estructura** (DDL): Tablas con claves primarias y restricciones. 🛠️
  - **Datos de Ejemplo** (DML): Mascotas adorables como "Luna" (un labrador) o "Miau" (un siamés). 🐾
- **Procedimientos Almacenados**: Incluimos un procedimiento para registrar adopciones, verificando que la mascota exista antes de guardarla y eliminarla de la lista. 🛡️
- **Disparadores (Triggers)**: Un trigger mágico ✨ guarda automáticamente los cambios en las mascotas (nombre, edad, especie, raza) en el historial con la fecha exacta.
- **Modelado Complejo**: Usamos relaciones entre tablas y estamos listos para añadir un campo JSON en `mascotas` para datos extras, como el historial médico. 📈

---

## 🛠️ Entorno de Desarrollo

¡Prepara tu entorno para dar vida a esta app! 🚧 Aquí te explicamos cómo:

- **Requisitos**:
  - **Java (JDK 8+)**: Para correr el código. ☕
  - **MySQL 8.0+**: Nuestra base de datos. 🗃️
  - **MySQL Connector/J**: El driver para conectar Java con MySQL (descárgalo desde el sitio oficial de MySQL). 🔗
  - **IDE**: Eclipse (con WindowBuilder para diseñar la interfaz), IntelliJ IDEA o NetBeans. 🖥️
  - **Git**: Para control de versiones. 🌳
  - **JUnit**: Para pruebas unitarias (descarga el JAR desde el sitio de JUnit). 🧪

- **Configuración**:
  1. Clona el repositorio desde GitHub. 📂
  2. Configura MySQL con la base de datos `centro_de_adopcon` y sus tablas. 🗄️
  3. Añade `mysql-connector-java.jar` y `junit.jar` al proyecto en tu IDE. 🔧
  4. Coloca la imagen `fondoprincipal.jpg` en la carpeta `/imagenes`. 🖼️
  5. ¡Ejecuta la app desde `adopciones.java` y empieza a gestionar mascotas! 🐕

- **Control de Versiones**: Usamos **Git** y **GitHub** con ramas como `main` (para la versión estable) y `develop` (para nuevas ideas). Cada cambio tiene un commit claro, como "Añade trigger para historial". 🌟
- **Pruebas Unitarias**: Creamos pruebas con **JUnit** para verificar la conexión a la base de datos y las operaciones CRUD. ¡Todo funciona como un reloj! ⏱️
- **Depuración y Refactorización**: Usamos el depurador del IDE para cazar errores y refactorizamos el código para que sea limpio y fácil de mantener. 🧹
- **Calidad de Código**: Seguimos las convenciones de Java, con nombres claros y un código que se lee como una historia. 📚
- **Documentación**:
  - **JavaDoc**: Cada clase y método público tiene su explicación detallada. 📖
  - Este **README.md** te guía para configurar y usar la app, incluyendo cómo añadir el driver JDBC. 📋

---

## 🚀 Instalación

1. Clona el repositorio desde GitHub. 📥
2. Configura MySQL con la base de datos y tablas (¡usa nuestros Scripts SQL!). 🗄️
3. Añade los JARs de MySQL y JUnit al proyecto. 🔗
4. Coloca `fondoprincipal.jpg` en `/imagenes`. 🖼️
5. Ejecuta `adopciones.java` desde tu IDE. ¡Listo para adoptar! 🐾

---

## 🐕 Uso

1. Abre la app ejecutando `adopciones.java`. 🖥️
2. En la ventana principal, elige:
   - **Gestionar Mascotas**: Añade o modifica los datos de un perrito o gatito. 🐶
   - **Registrar Adopción**: Completa los datos del adoptante y la mascota. 🏡
3. Usa las tablas para seleccionar mascotas y los formularios para ingresar información. 📊
4. Los cambios se guardan automáticamente en el historial. 🕒

---

## 🤝 Contribución

¡Queremos que te unas al equipo! 🙌 Sigue estos pasos:
1. Haz un fork del repositorio. 🍴
2. Crea una rama: `feature/tu-idea-genial`. 🌟
3. Commitea tus cambios con mensajes claros. ✍️
4. Haz push y abre un Pull Request en GitHub. 🚀

---

## 📜 Licencia

Este proyecto está licenciado bajo la **MIT License**. ¡Siéntete libre de usarlo y compartirlo! 😊
