
package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibroTest {

    @Test
    void debeCrearLibroCorrectamente() {
        Libro libro = new Libro(
                "9780132350884",
                "Clean Code",
                "Robert C. Martin",
                2008
        );

        assertEquals("9780132350884", libro.getIsbn());
        assertEquals("Robert C. Martin", libro.getAutor());
    }

    @Test
    void debeRepresentarLibroComoTexto() {
        Libro libro = new Libro(
                "9780132350884",
                "Clean Code",
                "Robert C. Martin",
                2008
        );

        assertEquals(
                "9780132350884 | Clean Code | Robert C. Martin | 2008",
                libro.toString()
        );
    }
}
