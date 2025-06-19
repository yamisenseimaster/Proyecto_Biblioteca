package servicios;

import modelos.Operacion;
import modelos.Usuario;

import estructuras.colas.*;
import estructuras.pilas.*;;

public class UsuarioService {
    private int cantidadUsuarios;
    
    private Usuario[] arregloUsuarios;
    private Queue<Usuario> colaPendientes;
    private Stack<Operacion> pilaOperaciones;


    public UsuarioService(int capacidadUsuarios) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        cantidadUsuarios = 0;
        colaPendientes = new Queue<>();
        pilaOperaciones = new Stack<>();
    }

    public UsuarioService(int capacidadUsuarios, Queue<Usuario> colaPendientes, Stack<Operacion> pilaOperaciones) {
        arregloUsuarios = new Usuario[capacidadUsuarios];
        cantidadUsuarios = 0;
        colaPendientes = new Queue<>();
        pilaOperaciones = new Stack<>();
    }
    
}
