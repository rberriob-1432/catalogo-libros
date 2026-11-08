package repository;

import model.Libro;

public interface CatalogoRepository {

    int cantidad();

    Libro obtener(int indice);

    void actualizar(int indice, Libro libro);
}
