package servicios;


// Clase principal que coordina todos los servicios
// esta clase vamos para centralizar todos los servicios como un puente con los demas servicios
public class BibliotecaService {
    private LibroService libroService;
    private UsuarioService usuarioService;
    private OperacionService operacionService;

    public BibliotecaService(int capacidadLibros, int capacidadUsuarios) {
        this.libroService = new LibroService(capacidadLibros);
        this.usuarioService = new UsuarioService(capacidadUsuarios);
        this.operacionService = new OperacionService();
    }

    //  metodos Intermediarios abajos 

    //ejemplo de un metodo intermediario
    //  Métodos para Libros
    //los metodos intermediarios son los que se encargan de llamar a los demas servicios
    public boolean registrarLibro(int codigo, String titulo, String autor, double precio) {
        return libroService.registrarLibro(codigo, titulo, autor, precio);
    }
    public int generarCodigoLibroUnico() {
    return libroService.generarCodigoUnico();
}
}
