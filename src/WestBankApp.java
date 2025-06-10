import java.util.*;

// Clase principal que contiene el método main y la lógica del menú interactivo
public class WestBankApp {
    // Mapas para almacenar clientes por RUT y por número de cuenta
    private static Map<String, Cliente> clientesPorRut = new HashMap<>();
    private static Map<Integer, Cliente> clientesPorCuenta = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    // Método principal (punto de entrada de la aplicación)
    public static void main(String[] args) {
        int opcion;
        // Bucle principal del menú
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1: registrarCliente(); break;
                case 2: verDatosCliente(); break;
                case 3: depositar(); break;
                case 4: girar(); break;
                case 5: consultarSaldo(); break;
                case 6: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    // Muestra el menú de opciones al usuario
    private static void mostrarMenu() {
        System.out.println("\n--- Menú West Bank ---");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Ver datos de cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Girar");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Salir");
    }

    // Permite registrar un nuevo cliente con validaciones
    private static void registrarCliente() {
        System.out.print("Ingrese rut: ");
        String rut = sc.nextLine();
        // Validación de largo del RUT
        if (rut.length() < 11 || rut.length() > 12) {
            System.out.println("El rut debe tener entre 11 y 12 caracteres (incluyendo puntos y guion).");
            return;
        }
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido paterno: ");
        String apPat = sc.nextLine();
        System.out.print("Ingrese apellido materno: ");
        String apMat = sc.nextLine();
        System.out.print("Ingrese domicilio: ");
        String domicilio = sc.nextLine();
        System.out.print("Ingrese comuna: ");
        String comuna = sc.nextLine();
        System.out.print("Ingrese teléfono: ");
        String telefono = sc.nextLine();
        int nroCuenta = leerEntero("Ingrese número de cuenta corriente (9 dígitos): ");
        // Validación de largo del número de cuenta
        if (String.valueOf(nroCuenta).length() != 9) {
            System.out.println("El número de cuenta debe tener 9 dígitos.");
            return;
        }
        // Creación y registro del cliente
        Cliente cliente = new Cliente(rut, nombre, apPat, apMat, domicilio, comuna, telefono, nroCuenta);
        clientesPorRut.put(rut, cliente);
        clientesPorCuenta.put(nroCuenta, cliente);
        System.out.println("¡Cliente registrado exitosamente!");
    }

    // Permite ver los datos de un cliente a partir de su RUT
    private static void verDatosCliente() {
        System.out.print("Ingrese rut del cliente: ");
        String rut = sc.nextLine();
        Cliente cliente = clientesPorRut.get(rut);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }
        cliente.mostrarDatos();
    }

    // Permite depositar dinero en una cuenta corriente
    private static void depositar() {
        int nroCuenta = leerEntero("Ingrese número de cuenta corriente: ");
        Cliente cliente = clientesPorCuenta.get(nroCuenta);
        if (cliente == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        int monto = leerEntero("Ingrese un monto para depositar: ");
        cliente.getCuenta().depositar(monto);
    }

    // Permite girar (retirar) dinero de una cuenta corriente
    private static void girar() {
        int nroCuenta = leerEntero("Ingrese número de cuenta corriente: ");
        Cliente cliente = clientesPorCuenta.get(nroCuenta);
        if (cliente == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        int monto = leerEntero("Ingrese un monto para girar: ");
        cliente.getCuenta().girar(monto);
    }

    // Permite consultar el saldo de una cuenta corriente
    private static void consultarSaldo() {
        int nroCuenta = leerEntero("Ingrese número de cuenta corriente: ");
        Cliente cliente = clientesPorCuenta.get(nroCuenta);
        if (cliente == null) {
            System.out.println("Cuenta no encontrada.");
            return;
        }
        cliente.getCuenta().consultarSaldo();
    }

    // Método auxiliar para leer un número entero desde consola con validación
    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }
}
