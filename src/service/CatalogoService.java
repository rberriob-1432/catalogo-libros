package service;

import model.Libro;
import repository.CatalogoRepository;

public class CatalogoService {

    private CatalogoRepository repository;

    public CatalogoService(CatalogoRepository repository) {
        this.repository = repository;
    }

    public Libro buscarLineal(String isbn) {

        for (int i = 0; i < repository.cantidad(); i++) {
            Libro libro = repository.obtener(i);

            if (libro.getIsbn().equals(isbn))
                return libro;
        }

        return null;
    }

    public void ordenarPorISBN() {

        for (int i = 1; i < repository.cantidad(); i++) {
            Libro actual = repository.obtener(i);
            int j = i - 1;

            while (j >= 0 &&
                    repository.obtener(j).getIsbn().compareTo(actual.getIsbn()) > 0) {

                repository.actualizar(j + 1, repository.obtener(j));
                j--;
            }

            repository.actualizar(j + 1, actual);
        }
    }


    public Libro buscarBinaria(String isbn) {

        int inicio = 0;
        int fin = repository.cantidad() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            Libro libro = repository.obtener(medio);
            int comparacion = libro.getIsbn().compareTo(isbn);

            if (comparacion == 0) return libro;
            if (comparacion < 0) inicio = medio + 1;
            else fin = medio - 1;
        }

        return null;
    }


    public Libro[] buscarPorAutor(String autor) {

        int cantidad = 0;

        for (int i = 0; i < repository.cantidad(); i++) {
            if (repository.obtener(i).getAutor().equalsIgnoreCase(autor))
                cantidad++;
        }

        Libro[] encontrados = new Libro[cantidad];
        int posicion = 0;

        for (int i = 0; i < repository.cantidad(); i++) {
            Libro libro = repository.obtener(i);

            if (libro.getAutor().equalsIgnoreCase(autor))
                encontrados[posicion++] = libro;
        }

        return encontrados;
    }
}
