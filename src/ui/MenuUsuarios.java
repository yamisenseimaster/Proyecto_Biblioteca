package ui;

import estructuras.Validaciones.validaciones;
import java.util.Scanner;
import modelos.Usuario;
import servicios.BibliotecaService;

public class MenuUsuarios {

    private final BibliotecaService bibliotecaService;
    private Usuario[] arregloUsuarios = new Usuario[50];
    private int totalUsuarios = 0;
    
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
        System.out.println("====== Registrar Usuario ======");
        System.out.println("1) Ingrese el numero de usuario: ");
        int nroDeUsuario = validaciones.generarCodigoUnico(arregloUsuarios);
        scanner.nextLine();//buffer
        String dni = validaciones.validarDni(scanner, "2) Ingrese el DNI: "); //en el método validar dni este aparece cómo integer pero en la clase Usuario aparece cómo String. 
        String nombre = validaciones.readString(" 3) Ingrese nombre: ");
        String direccion = validaciones.readString("4) Ingrese la dirección:");
        String telefono = validaciones.readString(" 5) Ingresar teléfono: ");
        int cantidadLibro = validaciones.readInt(" 6) Ingrese la cantidad de libros prestados: ");
        scanner.nextLine();
            
        // Creamos el objeto Usuario
        Usuario nuevoUsuario = new Usuario(nroDeUsuario, dni, nombre, direccion, telefono);
        nuevoUsuario.setCantidadLibrosPrestados(0);

        // Guardamos en el arreglo si hay espacio
        if (totalUsuarios < arregloUsuarios.length) {
            arregloUsuarios[totalUsuarios] = nuevoUsuario;
            totalUsuarios++;
            System.out.println("Usuario registrado con éxito. Código asignado: " + nroDeUsuario);
        } else {
            System.out.println("No se pueden registrar más usuarios. Límite alcanzado.");
        }
    }
    
    private void buscarUsuario() {
        System.out.println("====== Buscar Usuario ======");
        int codigo = validaciones.readInt("Ingrese el número de usuario a buscar: ");
        boolean encontrado = false;

        for (int i = 0; i < totalUsuarios; i++) {
            if (arregloUsuarios[i].getNumeroUsuario() == codigo) {
                System.out.println("Usuario encontrado:");
                System.out.println(arregloUsuarios[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un usuario con ese código.");
        }
    }
    

    private void listarUsuariosConMasLibros() {
        System.out.println("====== Listar usuarios con más de X libros ======");
        int x = validaciones.readInt("Ingrese el número mínimo de libros: ");
        boolean hayCoincidencias = false;

        for (int i = 0; i < totalUsuarios; i++) {
            if (arregloUsuarios[i].getLibrosPrestados() > x) {
                System.out.println(arregloUsuarios[i]);
                hayCoincidencias = true;
            }
        }

        if (!hayCoincidencias) {
            System.out.println("No hay usuarios con más de " + x + " libros.");
        }
    }
    
    private void mostrarUsuariosEnEspera() { //lo interprete que solo debe mostrar
        System.out.println("====== Usuarios en Espera ======");
        //implementar colas
        if (colaDeEspera.isEmpty()) {
        System.out.println("No hay usuarios en espera.");
        } else {
        System.out.println("=== Usuarios en espera ===");
        for (Usuario usuario : colaDeEspera) {
            System.out.println(usuario);
        }
    }
        
    }


    public void mostrarUsuariosRegistrados() {
        System.out.println("====== Usuarios Registrados ======");

        if (totalUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (int i = 0; i < totalUsuarios; i++) {
                System.out.println(arregloUsuarios[i]);
            }
        }
        
    }
}
