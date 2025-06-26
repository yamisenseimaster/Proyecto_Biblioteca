package ui;

import servicios.BibliotecaService;
import modelos.Usuario;
import estructuras.Validaciones.validaciones;
import modelos.Libro;

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
            System.out.println("1. Registrar préstamo");
            System.out.println("2. Registrar devolución");
            System.out.println("3. Deshacer última operación");
            System.out.println("4. Atender usuarios en espera");
            System.out.println("0. Volver");
            opcion = validaciones.readInt("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarPrestamo();
                case 2 -> registrarDevolucion();
                case 3 -> deshacerOperacion();
                case 4 -> atenderPendientes();
                case 0 -> {}
                default -> System.out.println("Opción inválida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

    private void registrarPrestamo() {
        int numeroUsuario = validaciones.readInt("Número de usuario: ");
        int codigoLibro = validaciones.readInt("Código del libro: ");
        Usuario usuario = bibliotecaService.buscarUsuarioPorNumero(numeroUsuario);
        Libro libro = bibliotecaService.buscarLibroPorCodigo(codigoLibro);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        bibliotecaService.prestarLibro(numeroUsuario, codigoLibro);
        System.out.println("Préstamo registrado (o usuario en espera si el libro no está disponible).");
    }

    private void registrarDevolucion() {
        int numeroUsuario = validaciones.readInt("Número de usuario: ");
        int codigoLibro = validaciones.readInt("Código del libro: ");
        // Suponiendo que tienes un método devolverLibro en BibliotecaService
        boolean exito = bibliotecaService.devolverLibro(numeroUsuario, codigoLibro);
        if (exito) {
            System.out.println("Devolución registrada correctamente.");
        } else {
            System.out.println("No se pudo registrar la devolución (verifique datos o estado del libro).");
        }
    }

    private void deshacerOperacion() {
        boolean exito = bibliotecaService.deshacerUltimaOperacion();
        if (exito) {
            System.out.println("Última operación deshecha correctamente.");
        } else {
            System.out.println("No hay operaciones para deshacer.");
        }
    }

    private void atenderPendientes() {
        int enEspera = bibliotecaService.getUsuariosEnEspera();
        if (enEspera == 0) {
            System.out.println("No hay usuarios en espera.");
            return;
        }
        Usuario usuario = bibliotecaService.atenderSiguienteEnEspera();
        if (usuario != null) {
            System.out.println("Usuario atendido: " + usuario);
        } else {
            System.out.println("No se pudo atender al siguiente usuario.");
        }
    }
}