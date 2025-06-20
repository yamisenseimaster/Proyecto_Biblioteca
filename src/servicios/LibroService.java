package servicios;
import modelos.Libro;
import estructuras.arboles.*;
import estructuras.listaEnlazadas.*;
public class LibroService {
    private Libro[] arregloLibros;
    private BinarySearchTree<Libro> arbolLibros;
    private int cantidadLibros;

    public LibroService(int capacidad) {
        arregloLibros = new Libro[capacidad];
        arbolLibros = new BinarySearchTree<>();
        cantidadLibros = 0;
    }
    
    //Aqui implementamos lo que dijo el profe  registrar en ambas estructura
    public boolean registrarLibro(int codigo, String titulo, String autor, double precio) {
        if (cantidadLibros >= arregloLibros.length) {
            return false; // Arreglo lleno
        }
        
        // creamos un metodo para ver si ya existe el codigo
        if (buscarPorCodigo(codigo) != null) {
            return false;
        }

        
        Libro nuevoLibro = new Libro(codigo, titulo, autor, precio, true);
        arregloLibros[cantidadLibros++] = nuevoLibro;
        arbolLibros.add(nuevoLibro);
        return true;
    }

    // Busca un libro por código (usando el árbol binario)
    public Libro buscarPorCodigo(int codigo) {
        Libro libroTemp = new Libro(codigo, "", "", 0.0, true);
        return arbolLibros.get(libroTemp);
    }

    public int generarCodigoUnico(){
        int  codigo;
        do {
            codigo = (int) (Math.random() *1000);
        } while (buscarPorCodigo(codigo) != null);
        return codigo;
    }

}