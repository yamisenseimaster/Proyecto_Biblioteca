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

    public boolean registrarUsuario(int numeroUsuario, int dni, String nombre, String direccion, int telefono) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        cantidadUsuarios = 0;
        colaPendientes = new Queue<>();
        pilaOperaciones = new Stack<>();
    }
    
}
