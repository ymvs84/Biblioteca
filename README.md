# Sistema de Gestión de Biblioteca

Este es un programa en Python que simula un sistema de gestión de biblioteca. Permite agregar libros, prestarlos, devolverlos, mostrar el inventario y buscar libros por ISBN.

## Funcionalidades

- **Agregar libros**: Permite ingresar nuevos libros al inventario.
- **Prestar libros**: Cambia el estado de un libro a "no disponible" si está disponible.
- **Devolver libros**: Cambia el estado de un libro a "disponible" si estaba prestado.
- **Mostrar libros**: Muestra la lista completa de libros con su estado de disponibilidad.
- **Buscar libros**: Busca un libro por su ISBN y muestra sus detalles.

## Estructura del Código

El programa está compuesto por una clase `Libro` y una función `main()`:

### Clase `Libro`

- **Atributos**:
  - `titulo`: Título del libro.
  - `autor`: Autor del libro.
  - `isbn`: Número de ISBN del libro.
  - `disponible`: Estado de disponibilidad del libro (inicia en `True`).

- **Métodos**:
  - `agregar(cls)`: Método de clase que solicita al usuario los datos de un nuevo libro y devuelve una instancia de `Libro`.
  - `prestar(self)`: Cambia el estado del libro a no disponible si está disponible.
  - `devolver(self)`: Cambia el estado del libro a disponible si estaba prestado.
  - `mostrar(cls, libros)`: Método de clase que muestra en pantalla la lista de todos los libros con sus datos y su estado.
  - `buscar(cls, libros, isbn)`: Método de clase que busca en la lista el libro cuyo ISBN coincida con el ingresado y muestra sus datos y estado.

### Función `main()`

- Maneja el flujo del programa a través de un menú interactivo.
- Utiliza una lista `inventario` para almacenar objetos `Libro`.
- Procesa las opciones del usuario y ejecuta las acciones correspondientes.

## Uso

Para ejecutar el programa, simplemente ejecuta el archivo Python en tu entorno de desarrollo o en la terminal:

```bash
python nombre_del_archivo.py