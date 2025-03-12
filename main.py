"""
Sistema de Gestión de Biblioteca
"""

class Libro:
    def __init__(self, titulo, autor, isbn):
        self.titulo = titulo
        self.autor = autor
        self.isbn = isbn
        self.disponible = True  # El libro inicia disponible

    @classmethod
    def agregar(cls):
        """
        Solicita al usuario los datos de un nuevo libro y devuelve una instancia de Libro.
        """
        titulo = input("Título: ")
        autor = input("Autor: ")
        isbn = input("ISBN: ")
        return cls(titulo, autor, isbn)

    def prestar(self):
        """
        Cambia el estado del libro a no disponible si se encuentra disponible.
        En caso contrario, muestra un mensaje indicando que ya está prestado.
        """
        if self.disponible:
            self.disponible = False
            print("Libro prestado con éxito.")
        else:
            print("El libro ya está prestado.")

    def devolver(self):
        """
        Cambia el estado del libro a disponible si estaba prestado.
        En caso contrario, muestra un mensaje indicando que ya estaba disponible.
        """
        if not self.disponible:
            self.disponible = True
            print("Libro devuelto con éxito.")
        else:
            print("El libro ya estaba disponible.")

    @classmethod
    def mostrar(cls, libros):
        """
        Muestra en pantalla la lista de todos los libros con sus datos y su estado.
        """
        if not libros:
            print("No hay libros registrados.")
        else:
            for libro in libros:
                disp = "Sí" if libro.disponible else "No"
                print(f"- {libro.titulo} ({libro.autor}) - ISBN: {libro.isbn} - Disponible: {disp}")

    @classmethod
    def buscar(cls, libros, isbn):
        """
        Busca en la lista el libro cuyo ISBN coincida con el ingresado.
        Muestra sus datos y el estado (disponible o no).
        Devuelve la instancia del libro encontrado o None si no se encuentra.
        """
        for libro in libros:
            if libro.isbn == isbn:
                disp = "Sí" if libro.disponible else "No"
                print(f"- {libro.titulo} ({libro.autor}) - ISBN: {libro.isbn} - Disponible: {disp}")
                return libro
        print("Libro no encontrado.")
        return None


def main():
    inventario = []  # Lista para almacenar objetos Libro

    print("Bienvenido al Sistema de Gestión de Biblioteca")

    while True:
        print("\nMenú:")
        print("1. Agregar libro")
        print("2. Prestar libro")
        print("3. Devolver libro")
        print("4. Mostrar libros")
        print("5. Buscar")
        print("6. Salir")

        opcion = input("Elige una opción: ").strip()

        if opcion == "1":
            # Agregar un nuevo libro
            nuevo_libro = Libro.agregar()
            inventario.append(nuevo_libro)
            print("Libro agregado con éxito.")

        elif opcion == "2":
            # Prestar libro: se solicita el ISBN y se busca el libro
            isbn = input("Ingresa el ISBN: ")
            libro = Libro.buscar(inventario, isbn)
            if libro:
                libro.prestar()

        elif opcion == "3":
            # Devolver libro: se solicita el ISBN y se busca el libro
            isbn = input("Ingresa el ISBN: ")
            libro = Libro.buscar(inventario, isbn)
            if libro:
                libro.devolver()

        elif opcion == "4":
            # Mostrar todos los libros
            Libro.mostrar(inventario)

        elif opcion == "5":
            # Buscar un libro por ISBN
            isbn = input("Ingresa el ISBN: ")
            Libro.buscar(inventario, isbn)

        elif opcion == "6":
            print("Saliendo del programa. ¡Hasta luego!")
            break

        else:
            print("Opción inválida. Por favor, elige una opción del menú.")

if __name__ == "__main__":
    main()