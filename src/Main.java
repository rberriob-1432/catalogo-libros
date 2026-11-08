
import model.Libro;
import repository.CatalogoRepository;
import repository.CatalogoRepositoryArray;
import service.CatalogoService;
import presentation.Consola;

public class Main {

    public static void main(String[] args) {

        Consola consola = new Consola();

        Libro[] libros = consola.leerLibros();

        CatalogoRepository repository =
                new CatalogoRepositoryArray(libros);

        CatalogoService service =
                new CatalogoService(repository);

        consola.ejecutar(service);
    }
}
