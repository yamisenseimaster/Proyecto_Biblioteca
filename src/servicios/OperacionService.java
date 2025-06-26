package servicios;

import modelos.Usuario;
import modelos.Libro;
import modelos.Operacion;
import estructuras.pilas.*;

import java.time.LocalDate;

import estructuras.colas.*;
//Gestión de préstamos/devoluciones (pila + cola)
// Reversión de operaciones (desapilar de la pila y revertir estado).

// Atención de usuarios en espera (desencolar de la cola).
public class OperacionService {
    private Stack<Operacion> pilaAcciones; // Para deshacer
    private Queue<Usuario> colaPendientes; // Usuarios en espera

    public OperacionService() {
        pilaAcciones = new Stack<>(100);
        colaPendientes = new Queue<>();
    }

    public void registrarPrestamo(Usuario usuario, Libro libro) {
        if (libro.isDisponible()) {
            Operacion op = new Operacion(
                "PREST-" + System.currentTimeMillis(),
                "PRÉSTAMO",
                libro,
                usuario,
                LocalDate.now()
            );
            pilaAcciones.push(op);
            libro.setDisponible(false);
            usuario.setLibrosPrestados(usuario.getLibrosPrestados() + 1);
        } else {
            colaPendientes.add(usuario); // Añade a la cola de espera
        }
    }


    
    public boolean registrarDevolucion(Usuario usuario, Libro libro) {
        if (!libro.isDisponible() && usuario.getLibrosPrestados() > 0) {
            Operacion op = new Operacion(
                "DEV-" + System.currentTimeMillis(),
                "DEVOLUCIÓN",
                libro,
                usuario,
                java.time.LocalDate.now()
            );
            pilaAcciones.push(op);
            libro.setDisponible(true);
            usuario.setLibrosPrestados(usuario.getLibrosPrestados() - 1);
            return true;
        }
        return false;
    }

   
    public boolean deshacerUltimaOperacion() {
        if (pilaAcciones.isEmpty()) return false;
        Operacion ultima = pilaAcciones.pop();
        Libro libro = ultima.getLibro();
        Usuario usuario = ultima.getUsuario();
        if ("PRÉSTAMO".equals(ultima.getTipo())) {
            libro.setDisponible(true);
            usuario.setLibrosPrestados(usuario.getLibrosPrestados() - 1);
        } else if ("DEVOLUCIÓN".equals(ultima.getTipo())) {
            libro.setDisponible(false);
            usuario.setLibrosPrestados(usuario.getLibrosPrestados() + 1);
        }
        return true;
    }

    // Obtener cantidad de usuarios en espera
    public int getUsuariosEnEspera() {
        return colaPendientes.size();
    }

    // Atender siguiente usuario en espera
    public Usuario atenderSiguienteEnEspera() {
        if (colaPendientes.isEmpty()) return null;
        return colaPendientes.remove();
    }
}