package ui;

import servicios.BibliotecaService;
import estructuras.Validaciones.validaciones;

public class MenuOperaciones {
    
     private final BibliotecaService bibliotecaService;

    public MenuOperaciones(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {
            validaciones.clearScreen();
            System.out.println("=== OPERACIONES ===");
            System.out.println("1. Registrar prestamo");
            System.out.println("2. Registrar devolución");
            System.out.println("3. Deshacer ultima operacion");
            System.out.println("4. Atender usuarios en espera");
            System.out.println("0. Volver");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> registrarPrestamo();
                case 2 -> registrarDevolucion();
                case 3 -> deshacerOperacion();
                case 4 -> atenderPendientes();
                case 0 -> {}
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

    private void registrarPrestamo() {
        
    }

    private void registrarDevolucion() {
        
    }

    private void deshacerOperacion() {
        
    }

    private void atenderPendientes() {
        
    }
}