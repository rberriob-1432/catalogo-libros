# Catálogo de Libros en Java

## Descripción

Este proyecto consiste en una aplicación de consola desarrollada en Java para gestionar un catálogo básico de libros. Permite registrar información de diferentes libros y realizar búsquedas utilizando el ISBN o el nombre del autor.

El proyecto aplica conceptos de programación orientada a objetos, separación de responsabilidades, interfaces, arreglos y algoritmos de búsqueda.

## Funcionalidades

- Registrar una cantidad determinada de libros.
- Almacenar información de cada libro:
  - ISBN.
  - Título.
  - Autor.
  - Año de publicación.
- Buscar libros mediante búsqueda lineal por ISBN.
- Buscar libros mediante búsqueda binaria por ISBN.
- Consultar todos los libros asociados a un autor.
- Mostrar los resultados de las búsquedas en consola.
- Utilizar una interfaz para definir las operaciones de acceso al catálogo.

## Tecnologías utilizadas

- **Lenguaje:** Java.
- **Estructuras de datos:** Arreglos.
- **Paradigma:** Programación orientada a objetos.
- **Entorno de desarrollo:** IntelliJ IDEA.
- **Control de versiones:** Git y GitHub.

## Estructura del proyecto

```text
catalogo-libros/
│
├── src/
│   ├── Main.java
│   │
│   ├── model/
│   │   └── Libro.java
│   │
│   ├── presentation/
│   │   └── Consola.java
│   │
│   ├── repository/
│   │   ├── CatalogoRepository.java
│   │   └── CatalogoRepositoryArray.java
│   │
│   └── service/
│       └── CatalogoService.java
│
└── .gitignore
```

## Organización del código

### 1. Main.java

Es el punto de entrada de la aplicación. Inicializa la consola, recibe los libros registrados, crea el repositorio y construye el servicio encargado de las operaciones del catálogo.

### 2. model/Libro.java

Contiene la clase que representa un libro. Define sus atributos principales:

- `isbn`
- `titulo`
- `autor`
- `anio`

También proporciona métodos de acceso y una representación textual mediante `toString()`.

### 3. presentation/Consola.java

Se encarga de la interacción con el usuario mediante la terminal. Solicita los datos de los libros y permite introducir los valores necesarios para realizar las búsquedas.

### 4. repository/CatalogoRepository.java

Define una interfaz que establece las operaciones básicas para acceder al catálogo:

- `cantidad()`: obtiene el número de libros registrados.
- `obtener(int indice)`: consulta un libro por su posición.
- `actualizar(int indice, Libro libro)`: actualiza un libro en una posición determinada.

### 5. repository/CatalogoRepositoryArray.java

Implementa la interfaz `CatalogoRepository` utilizando un arreglo de objetos `Libro` como estructura de almacenamiento.

### 6. service/CatalogoService.java

Contiene la lógica principal de las operaciones del catálogo. Implementa los métodos de búsqueda por ISBN y autor, utilizando los datos proporcionados por el repositorio.

## Algoritmos de búsqueda

### Búsqueda lineal

Recorre los libros uno por uno y compara el ISBN de cada elemento con el valor solicitado. Si encuentra coincidencia, devuelve el libro; de lo contrario, devuelve `null`.

### Búsqueda binaria

Busca un libro mediante el ISBN utilizando los límites de un intervalo y comparaciones con el elemento central. Este método requiere que los ISBN estén organizados para que la búsqueda funcione correctamente.

### Búsqueda por autor

Recorre el catálogo para identificar los libros cuyo autor coincide con el nombre ingresado. Utiliza `equalsIgnoreCase()` para realizar la comparación sin distinguir entre mayúsculas y minúsculas.

Puede devolver varios libros del mismo autor.

## Funcionamiento de la aplicación

1. El programa solicita la cantidad de libros que se van a registrar.
2. Solicita el ISBN, título, autor y año de cada libro.
3. Construye los objetos `Libro`.
4. Almacena los libros en el repositorio basado en arreglos.
5. Solicita un ISBN y realiza una búsqueda lineal.
6. Solicita otro ISBN y realiza una búsqueda binaria.
7. Solicita el nombre de un autor y muestra los libros encontrados.

## Requisitos

- Tener instalado el JDK de Java.
- Disponer de una terminal o un entorno de desarrollo compatible con Java.

## Ejecución del proyecto

Clonar el repositorio:

```bash
git clone https://github.com/rberriob-1432/catalogo-libros.git
```

Ingresar al directorio:

```bash
cd catalogo-libros
```

Compilar los archivos Java:

```bash
javac -d out src/Main.java src/model/Libro.java src/presentation/Consola.java src/repository/CatalogoRepository.java src/repository/CatalogoRepositoryArray.java src/service/CatalogoService.java
```

Ejecutar la aplicación:

```bash
java -cp out Main
```

## Conceptos aplicados

- Programación orientada a objetos.
- Encapsulamiento.
- Interfaces.
- Separación de responsabilidades.
- Arreglos de objetos.
- Búsqueda lineal.
- Búsqueda binaria.
- Recorridos de estructuras de datos.
- Comparación de cadenas de texto.

## Estado del proyecto

El proyecto cuenta con la estructura principal para registrar libros y realizar búsquedas desde consola. La implementación del método `mostrarCatalogo()` en `Consola.java` está pendiente, por lo que actualmente no se encuentra implementada la visualización completa del catálogo.

## Autor

**Raul Alonso Berrio Blanquicett**

Estudiante de Ingeniería de Software.

## Repositorio

[GitHub - catalogo-libros](https://github.com/rberriob-1432/catalogo-libros)