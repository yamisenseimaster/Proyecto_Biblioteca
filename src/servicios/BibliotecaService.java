package servicios;

import estructuras.listaEnlazadas.SimpleLinkedList;
import modelos.Libro;
import modelos.Usuario;

//a clase BibliotecaService funciona como un "puente" entre la interfaz de usuario (los menús) y la lógica interna del sistema. 
//Centraliza los servicios: Tiene instancias de LibroService, UsuarioService y OperacionService.
//De esta forma, los menús no interactúan directamente con los servicios internos, sino siempre a través de BibliotecaService, lo que facilita el mantenimiento y la organización del sistema.

// Clase principal que coordina todos los servicios
public class BibliotecaService {
    private LibroService libroService;
    private UsuarioService usuarioService;
    private OperacionService operacionService;

    public BibliotecaService(int capacidadLibros, int capacidadUsuarios) {
        this.libroService = new LibroService(capacidadLibros);
        this.usuarioService = new UsuarioService(capacidadUsuarios);
        this.operacionService = new OperacionService();
    }

    // Métodos que usarán los menús:
    public Libro buscarLibroPorCodigo(int codigo) {
    return libroService.buscarPorCodigo(codigo);
    }

    public SimpleLinkedList<Libro> buscarLibrosPorAutor(String autor) {
        return libroService.buscarLibrosPorAutor(autor);
    }
    //  Métodos para Libros
    public boolean registrarLibro(int codigo, String titulo, String autor, double precio) {
        return libroService.registrarLibro(codigo, titulo, autor, precio);
    }
    // public Libro[] obtenerCatalogo() {
    //     return libroService.obtenerCatalogo();
    // }

    public String mostrarCatalogoCompleto() {
        return libroService.mostrarCatalogoCompleto();
    }

    public int getUsuariosEnEspera() {
        return usuarioService.getUsuariosEnEspera();
    }

    public Usuario atenderSiguienteEnEspera() {
        return usuarioService.atenderSiguienteEnEspera();
    }

    public boolean deshacerUltimaOperacion() {
        return operacionService.deshacerUltimaOperacion();
    }

    public boolean registrarUsuario(int numeroUsuario, String dni, String nombre, String direccion, String telefono) {
        return usuarioService.registrarUsuario(numeroUsuario, dni, nombre, direccion, telefono);
    }

    public Usuario buscarUsuarioPorNumero(int numeroUsuario) {
        return usuarioService.buscarPorNumero(numeroUsuario);
    }

    public Usuario[] listarUsuariosConMasDeXLibros(int cantidadMinima) {
        return usuarioService.listarUsuariosConMasDeXLibros(cantidadMinima);
    }

    // Registrar devolución de libro
    public boolean devolverLibro(int numeroUsuario, int codigoLibro) {
        Usuario usuario = usuarioService.buscarPorNumero(numeroUsuario);
        Libro libro = libroService.buscarPorCodigo(codigoLibro);
        if (usuario == null || libro == null) {
            return false;
        }
        return operacionService.registrarDevolucion(usuario, libro);
    }

    
    public void prestarLibro(int numeroUsuario, int codigoLibro) {
        Usuario usuario = usuarioService.buscarPorNumero(numeroUsuario);
        Libro libro = libroService.buscarPorCodigo(codigoLibro);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }
        operacionService.registrarPrestamo(usuario, libro); 
    }

    public double calcularMontoTotalPrestamos() {
        return libroService.montoLibrosPrestados();
    }

    public Usuario[] getTodosLosUsuaaruis(){
        return usuarioService.getTodosLosUsuarios();
    }
    public int generarCodigoLibroUnico() {
    return libroService.generarCodigoUnico();
        
    }   

    


}
