
package presentation;

import java.util.Scanner;
import model.Libro;
import service.CatalogoService;

public class Consola {

    private Scanner scanner = new Scanner(System.in);

    public Libro[] leerLibros() {

        System.out.print("Cantidad de libros: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        Libro[] libros = new Libro[cantidad];

        for (int i = 0; i < cantidad; i++) {

            System.out.println("\nLibro " + (i + 1));

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Titulo: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor: ");
            String autor = scanner.nextLine();

            System.out.print("Año: ");
            int anio = Integer.parseInt(scanner.nextLine());

            libros[i] = new Libro(isbn, titulo, autor, anio);
        }

        return libros;
    }

    public void ejecutar(CatalogoService service) {

        System.out.println("\nCATALOGO ORIGINAL");
        mostrarCatalogo(service);

        System.out.print("\nISBN para busqueda lineal: ");
        mostrarLibro(service.buscarLineal(scanner.nextLine()));

        service.ordenarPorISBN();

        System.out.println("\nCATALOGO ORDENADO");
        mostrarCatalogo(service);

        System.out.print("\nISBN para busqueda binaria: ");
        mostrarLibro(service.buscarBinaria(scanner.nextLine()));

        System.out.print("\nAutor para buscar: ");
        mostrarLibros(service.buscarPorAutor(scanner.nextLine()));
    }

    private void mostrarCatalogo(CatalogoService service) {

    }

    private void mostrarLibro(Libro libro) {
        System.out.println(libro != null ? libro : "Libro no encontrado.");
    }

    private void mostrarLibros(Libro[] libros) {

        if (libros.length == 0) {
            System.out.println("No se encontraron libros.");
            return;
        }

        for (Libro libro : libros)
            System.out.println(libro);
    }
}
