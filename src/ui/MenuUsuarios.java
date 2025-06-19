package ui;

import servicios.BibliotecaService;
import estructuras.Validaciones.validaciones;

public class MenuUsuarios {
    private final BibliotecaService bibliotecaService;
    

    public MenuUsuarios(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {
            validaciones.clearScreen();
            System.out.println("=== GESTION DE USUARIOS ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Listar usuarios con X libros");
            System.out.println("4. Usuarios en espera");
            System.out.println("5. Deshacer ultima operacion");
            System.out.println("0. Volver");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> registrarUsuario();
                case 2 -> buscarUsuario();
                case 3 -> listarUsuariosConMasLibros();
                case 4 -> mostrarUsuariosEnEspera();
                case 5 -> deshacerOperacion();
                case 0 -> {}
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

    private void registrarUsuario() {
        
    }
    
    private void listarUsuariosConMasLibros() {
        
    }
    private void buscarUsuario() {
        
    }


    private void mostrarUsuariosEnEspera() {
        
    }


    private void deshacerOperacion() {
        
    }
}