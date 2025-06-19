package servicios;
import modelos.Libro;
import estructuras.arboles.*;
import estructuras.listaEnlazadas.*;;
public class LibroService {
    private Libro[] arregloLibros;
    private BinarySearchTree<Libro> arbolLibros;
    private int cantidadLibros;

    public LibroService(int capacidad) {
        arregloLibros = new Libro[capacidad];
        arbolLibros = new BinarySearchTree<>();
        cantidadLibros = 0;
    }
    
}