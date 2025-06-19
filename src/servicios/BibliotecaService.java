package servicios;


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

    //  metodos Intermediarios abajos 
}
