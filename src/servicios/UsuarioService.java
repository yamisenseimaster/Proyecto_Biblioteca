package servicios;

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
        if(cantidadUsuarios >= arregloUsuarios.length(){
            return false;
        }
    if(buscarPorNumeroUsuario(numeroUsuario) != null){
        return false;
    }
    Usuario nuevoUsuario = new Usuario(numeroUsuario, dni, nombre, direccion, telefono, 0); 
    arregloUsuario[cantidadUsuarios++] = nuevoLibro;
    arbolUsuarios.add(nuevoLibro);
    return true;
    }

    public Usuario buscarPorUsuario(int numeroUsuario){
        Usuario usuarioTemp = new Usuario(numeroUsuario, "", "", "", "", 0);
        return arbolLibros.get(libroTemp);
    }
    
    public int generarNumeroUsuarioUnico(){
        int  numeroUsuario;
        do {
            numeroUsuario = (int) (Math.random() *1000);
        } while (buscarPorCodigo(numeroUsuario) != null);
        return numeroUsuario;
    }


}
