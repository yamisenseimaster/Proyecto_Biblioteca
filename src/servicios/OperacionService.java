package servicios;

import modelos.Usuario;
import modelos.Operacion;

import estructuras.pilas.*;
import estructuras.colas.*;


public class OperacionService {
    private Stack<Operacion> pilaAcciones; // Para deshacer
    private Queue<Usuario> colaPendientes; // Usuarios en espera
    
    public OperacionService() {
        pilaAcciones = new Stack<>();
        colaPendientes = new Queue<>();
    }
}