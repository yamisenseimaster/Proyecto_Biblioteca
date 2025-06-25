package servicios;
import estructuras.arboles.*;
import estructuras.colas.*;
import estructuras.pilas.*;
import modelos.Operacion;
import modelos.Usuario;;

public class UsuarioService {  
    private Usuario[] arregloUsuarios;
    private BinarySearchTree<Usuario> arbolUsuarios;
    private Queue<Usuario> colaPendientes;
    private Stack<Operacion> pilaOperaciones;
    private int cantidadUsuarios;

    public UsuarioService(int capacidadUsuarios) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        arbolUsuarios = new BinarySearchTree<>();
        colaPendientes = new Queue<>();
        pilaOperaciones = new Stack<>();
        cantidadUsuarios = 0;
    }

    public boolean registrarUsuario(int numeroUsuario, String dni, String nombre, String direccion, String telefono) {
        if(cantidadUsuarios >= arregloUsuarios.length){
            return false;
        }
    if(buscarPorNumeroUsuario(numeroUsuario) != null){
        return false;
    }
    Usuario nuevoUsuario = new Usuario(numeroUsuario, dni, nombre, direccion, telefono); 
    arregloUsuarios[cantidadUsuarios++] = nuevoUsuario;
    arbolUsuarios.add(nuevoUsuario);
    return true;
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


}
