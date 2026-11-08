package repository;

import model.Libro;

public class CatalogoRepositoryArray implements CatalogoRepository {

    private Libro[] libros;

    public CatalogoRepositoryArray(Libro[] libros) {
        this.libros = libros;
    }

    @Override
    public int cantidad() {
        return libros.length;
    }

    @Override
    public Libro obtener(int indice) {
        return libros[indice];
    }

    @Override
    public void actualizar(int indice, Libro libro) {
        libros[indice] = libro;
    }
}
