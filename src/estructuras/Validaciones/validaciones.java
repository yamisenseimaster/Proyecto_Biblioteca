package estructuras.Validaciones;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; // Importa la clase JOptionPane
import javax.swing.JOptionPane; // Importa la clase DateTimeException
import modelos.Usuario;

public class validaciones {
    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String PATRON_EMAIL = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private static final String PATRON_TELEFONO = "^\\+?[0-9]{10,15}$"; // Ejemplo para validar número de teléfono

    private static final Scanner scanner = new Scanner(System.in);

    // Limpiar la pantalla
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Pausa el programa
    public static void pause() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }

    // Leer un entero
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese solo números enteros.");
            }
        }
    }

    

    // Leer un double
    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese solo números decimales (double).");
            }
        }
    }

    /// Leer un string
    public static String readString(String message) {
    while (true) {
        System.out.print(message);
        String input = scanner.nextLine();
        if (!input.trim().isEmpty()) {
            return input;
        } else {
            System.out.println("Por favor, ingrese un texto válido (no vacío).");
        }
    }
}

    public static boolean readBoolean(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Entrada inválida. Ingrese 'true' o 'false'");
        }
    }
    
    
    public static int validarNumero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.printf(mensaje);
            String input = scanner.nextLine();
            try {
                if (esTextoVacio(input)) {
                    System.out.println("La entrada no puede estar vacía.");
                } else {
                    int num = Math.abs(Integer.parseInt(input));
                    return num;
                }
            } catch (Exception e) {
                System.out.println("Error, debe contener solo números");
            }
        }
    }

    public static String validarTextoIngresado(Scanner scanner, String mensaje) {
        do {
            System.out.printf(mensaje);
            String input = scanner.nextLine();

            if (!esTextoVacio(input)) {
                if (!esSoloCaracteres(input)) {
                    System.out.println("El texto ingresado no contiene solo caracteres");
                    System.out.println("Ingresa nuevamente");
                } else {
                    return input;
                }
            } else {
                System.out.println("El campo está vacío, ingrese un texto válido");
            }
        } while (true);

    }

    public static boolean esSoloCaracteres(String texto) {
        String alfb = "^[a-zA-Z(\\s]+$";
        Pattern pattern = Pattern.compile(alfb);
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    public static boolean esTextoVacio(String input) {
        if (input == null || input.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean validarLongitud(String texto, int min, int max) {
        int longitud = texto.length();
        return longitud >= min && longitud <= max;
    }

    public static boolean verificarRepetidoEnArray(String[] listaElementos, String input) {
        for (String elemento : listaElementos) {
            if (input.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static LocalDate validarFormatoFecha(Scanner input, String formato, String mensaje) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(formato);
        do {
            System.out.printf(mensaje);
            String fechaIngresada = input.nextLine();
            try {
                LocalDate fecha = LocalDate.parse(fechaIngresada, formatoFecha);
                return fecha;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Use el formato yyyy-MM-dd.");
            }
        } while (true);

    }

    public static int validarNumIntEnVentana(String mensaje) {
        do {

            try {
                String date = JOptionPane.showInputDialog(mensaje);

                if (esTextoVacio(date)) {
                    JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía.");
                } else {
                    int num = Integer.parseInt(date);
                    return num;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, debe contener solo números");
            }
        } while (true);

    }

    public static double validarNumDoubleEnVentana(String mensaje) {
        do {
            try {
                String input = JOptionPane.showInputDialog(mensaje);

                if (esTextoVacio(input)) {
                    JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía.");
                } else {
                    double num = Double.parseDouble(input);
                    return num;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, debe contener solo números");
            }
        } while (true);

    }

    public static String validarTextoVentana(String mensaje) {
        do {
            String input = JOptionPane.showInputDialog(mensaje);

            if (!esTextoVacio(input)) {
                if (!esSoloCaracteres(input)) {
;
                } else {
                    return input;
                }
            } else {
                JOptionPane.showMessageDialog(null, "El campo está vacío. Ingrese un valor.");

            }

        } while (true);
    }

    public static LocalDate validarFormatoFechaVentana(String mensaje) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        do {
            String fechaIngresada = JOptionPane.showInputDialog(mensaje);
            if (esTextoVacio(fechaIngresada)) {
                JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía.");
            } else {
                try {
                    LocalDate fecha = LocalDate.parse(fechaIngresada, formatoFecha);
                    return fecha;
                } catch (DateTimeException e) {
                    JOptionPane.showMessageDialog(null, "Fecha no válida. Use el formato yyyy-MM-dd.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (true);

    }

    public static boolean validarNumeroEnRango(int numero, int min, int max) {
        return numero >= min && numero <= max;
    }

    public static boolean validarFechaNoPasada(LocalDate fecha) {
        return !fecha.isBefore(LocalDate.now());
    }

    public static String validarMail(Scanner scanner, String mensaje) {
        do {
            System.out.printf(mensaje);
            String input = scanner.nextLine();
            boolean tieneArroba = false;
            for (int i = 0; i < input.length(); i++) {
                char caracter = input.charAt(i);
                if (caracter == '@') {
                    tieneArroba = true;
                    if (input.charAt(0) != '@' && input.charAt(input.length() - 1) != '@') {
                        return input;
                    } else {
                        System.out.println("Mail inválido.El '@' no puede estar al principio ni al final");
                    }
                }
            }
            if (!tieneArroba) {
                System.out.println("Mail inválido. Debe tener una '@'");
            }

        } while (true);

    }

    public static Integer validarDni(Scanner scanner, String mensaje) {
        do {
            System.out.printf(mensaje);
            String input = scanner.nextLine();
            try {
                if (input.length() == 9 || !input.isEmpty()) {
                    int dni = Integer.parseInt(input);
                    return dni;
                } else {
                    System.out.println("La longitud debe ser de 9 digitos");
                }
            } catch (Exception e) {
                System.out.println("Formato inválido");
            }
        } while (true);
    }

    public static boolean validarTextoVacio(String url) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarTextoVacio'");
    }

    //validar código de usuario

    public static boolean codigoExiste(int codigo, Usuario[] arregloUsuarios) {
        for (Usuario usuario : arregloUsuarios) {
            if (usuario.getNumeroUsuario() == codigo) {
                return true;
            }
        }
        return false;
    }

    public static int generarCodigoUnico(Usuario[] arregloUsuarios) {
        int codigo;
        do {
            codigo = (int) (Math.random() * 90000) + 10000; // 5 dígitos
        } while (codigoExiste(codigo, arregloUsuarios));
        return codigo;
    }
}

