package ui;

import estructuras.Validaciones.validaciones;
import java.util.Scanner;
import modelos.Usuario;
import servicios.BibliotecaService;

public class MenuUsuarios {

    private final BibliotecaService bibliotecaService;

    
    Scanner scanner= new Scanner(System.in);

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
            System.out.println("3. Listar usuarios con mas X libros");
            System.out.println("4. Usuarios en espera");
            System.out.println("5. Usuarios registrados");
            System.out.println("0. Volver");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> registrarUsuario();
                case 2 -> buscarUsuario();
                case 3 -> listarUsuariosConMasLibros();
                case 4 -> mostrarUsuariosEnEspera();
                case 5 -> mostrarUsuariosRegistrados();
                case 0 -> {}
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

    private void registrarUsuario() {
        System.out.println("\n=== REGISTRAR NUEVO USUARIO ===");
        int numeroUsuario = bibliotecaService.generarCodigoLibroUnico();// Generar un codigo aleatorio
        String dni = validaciones.readString("DNI: ");
        String nombre = validaciones.readString("Nombre completo: ");
        String direccion = validaciones.readString("Dirección: ");
        String telefono = validaciones.readString("Teléfono: ");
        int librosPrestados = validaciones.readInt("Libros prestados: ");

        if (bibliotecaService.registrarUsuario(numeroUsuario, dni, nombre, direccion, telefono, librosPrestados)) {
            System.out.println("Usuario registrado exitosamente!");
            System.out.println("Codigo generado: " + numeroUsuario);
        } else {
            System.out.println("Error: El número de usuario ya existe o capacidad máxima alcanzada");
        }
    }
    
    private void buscarUsuario() {
        System.out.println("\n=== BUSCAR USUARIO ===");
        int numeroUsuario = validaciones.readInt("Ingrese número de usuario: ");
        Usuario usuario = bibliotecaService.buscarUsuarioPorNumero(numeroUsuario);

        if (usuario != null) {
            System.out.println("\nUSUARIO ENCONTRADO:");
            System.out.println("Número: " + usuario.getNumeroUsuario());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("DNI: " + usuario.getDni());
            System.out.println("Dirección: " + usuario.getDireccion());
            System.out.println("Teléfono: " + usuario.getTelefono());
            System.out.println("Libros prestados: " + usuario.getLibrosPrestados());
        } else {
            System.out.println("Usuario no encontrado");
        }
    }
    

    private void listarUsuariosConMasLibros() {
        System.out.println("\n=== USUARIOS CON MÁS DE X LIBROS ===");
        int cantidadMinima = validaciones.readInt("Ingrese cantidad mínima de libros: ");
        Usuario[] usuarios = bibliotecaService.listarUsuariosConMasDeXLibros(cantidadMinima);

        if (usuarios.length > 0) {
            System.out.println("\nUSUARIOS ENCONTRADOS:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getNumeroUsuario() + " - " + 
                                 usuario.getNombre() + " (" + 
                                 usuario.getLibrosPrestados() + " libros)");
            }
            System.out.println("Total: " + usuarios.length + " usuarios");
        } else {
            System.out.println("No se encontraron usuarios con " + cantidadMinima + " o más libros prestados");
        }
    }
    
    private void mostrarUsuariosEnEspera() {
        System.out.println("\n=== USUARIOS EN ESPERA ===");
        int cantidad = bibliotecaService.getUsuariosEnEspera();
        System.out.println("Usuarios en cola de espera: " + cantidad);
        
        // Opcional: Mostrar detalles de usuarios en espera
        if (cantidad > 0) {
            System.out.println("\n¿Desea atender al siguiente usuario? (s/n)");
            String opcion = validaciones.readString("");
            if (opcion.equalsIgnoreCase("s")) {
                Usuario usuario = bibliotecaService.atenderSiguienteEnEspera();
                if (usuario != null) {
                    System.out.println("Usuario atendido: " + usuario.getNombre());
                }
            }
        }
    }


    public void mostrarUsuariosRegistrados(){
        System.out.println("\n === USUARIOS REGISTRADOS === ");
        Usuario[] usuarios = bibliotecaService.getTodosLosUsuaaruis();
        if(usuarios.length == 0){
            System.out.println("No hay usuarios registrados");
        }else{
            for (Usuario usuario : usuarios) {
                System.out.println("Número: " + usuario.getNumeroUsuario() +
                                   " | Nombre: " + usuario.getNombre() +
                                   " | DNI: " + usuario.getDni() +
                                   " | Dirección: " + usuario.getDireccion() +
                                   " | Teléfono: " + usuario.getTelefono() +
                                   " | Libros prestados: " + usuario.getLibrosPrestados());
            }
            System.out.println("Total: " + usuarios.length + " usuarios");
        }
    }
}