package servicios;
import estructuras.arboles.*;
import estructuras.colas.*;
import modelos.Usuario;;

public class UsuarioService {  
    private Usuario[] arregloUsuarios;
    private BinarySearchTree<Usuario> arbolUsuarios;
    private Queue<Usuario> colaPendientes;
    private int cantidadUsuarios;

    public UsuarioService(int capacidadUsuarios) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        arbolUsuarios = new BinarySearchTree<>();
        colaPendientes = new Queue<>();
        cantidadUsuarios = 0;
    }

    public UsuarioService(int capacidadUsuarios, Queue<Usuario> colaPendientes) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        cantidadUsuarios = 0;
        colaPendientes = new Queue<>();
    }

    // Registra un nuevo usuario
    public boolean registrarUsuario(int numeroUsuario, String dni, String nombre, String direccion, String telefono) {
        if (cantidadUsuarios >= arregloUsuarios.length) {
            return false; // Arreglo lleno
        }
        
        if (buscarPorNumero(numeroUsuario) != null) {
            return false; // Número de usuario ya existe
        }

        Usuario nuevoUsuario = new Usuario(numeroUsuario, dni, nombre, direccion, telefono);
        arregloUsuarios[cantidadUsuarios++] = nuevoUsuario;
        return true;
    }

    // Busca usuario por número (búsqueda lineal)
    public Usuario buscarPorNumero(int numeroUsuario) {
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (arregloUsuarios[i].getNumeroUsuario() == numeroUsuario) {
                return arregloUsuarios[i];
            }
        }
        return null;
    }

    public Usuario buscarPorNumeroUsuario(int numeroUsuario){
        Usuario usuarioTemp = new Usuario(numeroUsuario, "", "", "", "");
        return arbolUsuarios.get(usuarioTemp);
    }
    
    public int generarNumeroUsuarioUnico(){
        int  numeroUsuario;
        do {
            numeroUsuario = (int) (Math.random() *1000);
        } while (buscarPorNumeroUsuario(numeroUsuario) != null);
        return numeroUsuario;
    }

    // Devuelve un arreglo con todos los usuarios registrados
    public Usuario[] getTodosLosUsuarios() {
        Usuario[] usuarios = new Usuario[cantidadUsuarios];
        int i = 0;
        for (Usuario usuario : arregloUsuarios) {
            if (i >= cantidadUsuarios) {
                break;
            }
            usuarios[i] = usuario;
            i++;
        }
        return usuarios;
    }

    // Lista usuarios con X o más libros prestados
    public Usuario[] listarUsuariosConMasDeXLibros(int cantidadMinima) {
        int contador = 0;
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (arregloUsuarios[i].getLibrosPrestados() >= cantidadMinima) {
                contador++;
            }
        }

        Usuario[] resultado = new Usuario[contador];
        int index = 0;
        for (int i = 0; i < cantidadUsuarios; i++) {
            if (arregloUsuarios[i].getLibrosPrestados() >= cantidadMinima) {
                resultado[index++] = arregloUsuarios[i];
            }
        }
        return resultado;
    }

    // Atiende al siguiente usuario en espera
    public Usuario atenderSiguienteEnEspera() {
        return colaPendientes.poll();
    }

    // Métodos auxiliares
    public int getCantidadUsuarios() {
        return cantidadUsuarios;
    }

    public boolean estaLleno() {
        return cantidadUsuarios >= arregloUsuarios.length;
    }

    public int getUsuariosEnEspera() {
        return colaPendientes.size();
    }

}
