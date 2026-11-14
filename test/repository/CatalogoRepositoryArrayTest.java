
package repository;

import model.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoRepositoryArrayTest {

    private CatalogoRepositoryArray repository;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    void configurar() {
        libro1 = new Libro("100", "Libro A", "Autor A", 2020);
        libro2 = new Libro("200", "Libro B", "Autor B", 2021);

        repository = new CatalogoRepositoryArray(
                new Libro[]{libro1, libro2}
        );
    }

    @Test
    void debeRetornarCantidadDeLibros() {
        assertEquals(2, repository.cantidad());
    }

    @Test
    void debeObtenerLibroPorIndice() {
        assertSame(libro1, repository.obtener(0));
        assertSame(libro2, repository.obtener(1));
    }

    @Test
    void debeActualizarLibroEnUnaPosicion() {
        Libro nuevoLibro = new Libro(
                "300", "Libro C", "Autor C", 2022
        );

        repository.actualizar(0, nuevoLibro);

        assertSame(nuevoLibro, repository.obtener(0));
    }

    @Test
    void debeLanzarExcepcionAlConsultarIndiceInvalido() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> repository.obtener(5)
        );
    }

    @Test
    void debeLanzarExcepcionAlActualizarIndiceInvalido() {
        Libro nuevoLibro = new Libro(
                "300", "Libro C", "Autor C", 2022
        );

        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> repository.actualizar(5, nuevoLibro)
        );
    }
}
