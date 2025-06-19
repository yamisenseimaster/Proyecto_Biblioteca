package servicios;

import modelos.Usuario;
import modelos.Operacion;

import estructuras.pilas.*;
import estructuras.colas.*;
//Gestión de préstamos/devoluciones (pila + cola)
// Reversión de operaciones (desapilar de la pila y revertir estado).

// Atención de usuarios en espera (desencolar de la cola).

public class OperacionService {
    private Stack<Operacion> pilaAcciones; // Para deshacer
    private Queue<Usuario> colaPendientes; // Usuarios en espera
    
    public OperacionService() {
        pilaAcciones = new Stack<>();
        colaPendientes = new Queue<>();
    }
}