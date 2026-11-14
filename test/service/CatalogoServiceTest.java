
package service;

import model.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.CatalogoRepositoryArray;

import static org.junit.jupiter.api.Assertions.*;

class CatalogoServiceTest {

    private CatalogoService service;

    private Libro libro1;
    private Libro libro2;
    private Libro libro3;
    private Libro libro4;

    @BeforeEach
    void configurar() {
        libro1 = new Libro("300", "Clean Code",
                "Robert Martin", 2008);

        libro2 = new Libro("100", "Effective Java",
                "Joshua Bloch", 2018);

        libro3 = new Libro("400", "Clean Architecture",
                "Robert Martin", 2017);

        libro4 = new Libro("200", "Design Patterns",
                "Erich Gamma", 1994);

        CatalogoRepositoryArray repository =
                new CatalogoRepositoryArray(
                        new Libro[]{libro1, libro2, libro3, libro4}
                );

        service = new CatalogoService(repository);
    }

    // =========================
    // BUSQUEDA LINEAL
    // =========================

    @Test
    void debeEncontrarLibroMedianteBusquedaLineal() {
        Libro resultado = service.buscarLineal("300");

        assertSame(libro1, resultado);
    }

    @Test
    void debeRetornarNullCuandoISBNNoExisteEnBusquedaLineal() {
        Libro resultado = service.buscarLineal("999");

        assertNull(resultado);
    }

    @Test
    void debeBuscarLibroEnElUltimoIndice() {
        Libro resultado = service.buscarLineal("200");

        assertSame(libro4, resultado);
    }

    // =========================
    // ORDENAMIENTO POR ISBN
    // =========================

    @Test
    void debeOrdenarLibrosPorISBNAscendente() {
        service.ordenarPorISBN();

        assertEquals("100", service.buscarLineal("100").getIsbn());
        assertEquals("200", service.buscarLineal("200").getIsbn());
        assertEquals("300", service.buscarLineal("300").getIsbn());
        assertEquals("400", service.buscarLineal("400").getIsbn());
    }

    @Test
    void debeMantenerOrdenCorrectoAlOrdenarNuevamente() {
        service.ordenarPorISBN();
        service.ordenarPorISBN();

        assertEquals("100", service.buscarLineal("100").getIsbn());
        assertEquals("200", service.buscarLineal("200").getIsbn());
        assertEquals("300", service.buscarLineal("300").getIsbn());
        assertEquals("400", service.buscarLineal("400").getIsbn());
    }

    // =========================
    // BUSQUEDA BINARIA
    // =========================

    @Test
    void debeEncontrarLibroMedianteBusquedaBinaria() {
        service.ordenarPorISBN();

        Libro resultado = service.buscarBinaria("300");

        assertSame(libro1, resultado);
    }

    @Test
    void debeRetornarNullCuandoISBNNoExisteEnBusquedaBinaria() {
        service.ordenarPorISBN();

        Libro resultado = service.buscarBinaria("999");

        assertNull(resultado);
    }

    @Test
    void debeEncontrarPrimerLibroMedianteBusquedaBinaria() {
        service.ordenarPorISBN();

        Libro resultado = service.buscarBinaria("100");

        assertSame(libro2, resultado);
    }

    @Test
    void debeEncontrarUltimoLibroMedianteBusquedaBinaria() {
        service.ordenarPorISBN();

        Libro resultado = service.buscarBinaria("400");

        assertSame(libro3, resultado);
    }

    // =========================
    // BUSQUEDA POR AUTOR
    // =========================

    @Test
    void debeEncontrarTodosLosLibrosDeUnAutor() {
        Libro[] resultados = service.buscarPorAutor("Robert Martin");

        assertEquals(2, resultados.length);
        assertSame(libro1, resultados[0]);
        assertSame(libro3, resultados[1]);
    }

    @Test
    void debeIgnorarMayusculasYMinusculasEnAutor() {
        Libro[] resultados = service.buscarPorAutor("ROBERT MARTIN");

        assertEquals(2, resultados.length);
    }

    @Test
    void debeRetornarArregloVacioCuandoAutorNoExiste() {
        Libro[] resultados = service.buscarPorAutor("Autor desconocido");

        assertNotNull(resultados);
        assertEquals(0, resultados.length);
    }

}
