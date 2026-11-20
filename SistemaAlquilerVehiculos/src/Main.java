import modelo.*;
import servicio.SistemaAlquiler;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static SistemaAlquiler sistema = new SistemaAlquiler();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n==================================");
            System.out.println("   SISTEMA DE ALQUILER DE VEHICULOS");
            System.out.println("==================================");
            System.out.println("1. Registrar automóvil");
            System.out.println("2. Registrar camión");
            System.out.println("3. Registrar motocicleta");
            System.out.println("4. Registrar cliente");
            System.out.println("5. Mostrar todos los vehículos");
            System.out.println("6. Mostrar vehículos disponibles");
            System.out.println("7. Realizar alquiler");
            System.out.println("8. Registrar devolución");
            System.out.println("9. Consultar alquiler");
            System.out.println("10. Calcular costo de alquiler");
            System.out.println("11. Mostrar vehículos alquilados");
            System.out.println("12. Mostrar historial de alquileres");
            System.out.println("0. Salir");
            System.out.println("==================================");

            opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {

                case 1:
                    registrarAutomovil();
                    break;

                case 2:
                    registrarCamion();
                    break;

                case 3:
                    registrarMotocicleta();
                    break;

                case 4:
                    registrarCliente();
                    break;

                case 5:
                    sistema.mostrarVehiculos();
                    break;

                case 6:
                    sistema.mostrarDisponibles();
                    break;

                case 7:
                    realizarAlquiler();
                    break;

                case 8:
                    registrarDevolucion();
                    break;

                case 9:
                    consultarAlquiler();
                    break;

                case 10:
                    calcularCosto();
                    break;

                case 11:
                    sistema.mostrarVehiculosAlquilados();
                    break;

                case 12:
                    sistema.mostrarHistorial();
                    break;

                case 0:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    // Registrar automóvil
    public static void registrarAutomovil() {

        System.out.println("\n--- REGISTRAR AUTOMÓVIL ---");

        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        String color = leerTexto("Color: ");
        String placa = leerTexto("Placa: ");
        int puertas = leerEntero("Número de puertas: ");
        String combustible = leerTexto("Tipo de combustible: ");

        Automovil auto = new Automovil(
                marca, modelo, color, placa, puertas, combustible
        );

        sistema.registrarVehiculo(auto);
    }

    // Registrar camión
    public static void registrarCamion() {

        System.out.println("\n--- REGISTRAR CAMIÓN ---");

        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        String color = leerTexto("Color: ");
        String placa = leerTexto("Placa: ");
        int puertas = leerEntero("Número de puertas: ");
        String combustible = leerTexto("Tipo de combustible: ");

        Camion camion = new Camion(
                marca, modelo, color, placa, puertas, combustible
        );

        sistema.registrarVehiculo(camion);
    }

    // Registrar motocicleta
    public static void registrarMotocicleta() {

        System.out.println("\n--- REGISTRAR MOTOCICLETA ---");

        String marca = leerTexto("Marca: ");
        String modelo = leerTexto("Modelo: ");
        String color = leerTexto("Color: ");
        String placa = leerTexto("Placa: ");
        int cilindrada = leerEntero("Cilindrada (cc): ");
        String tipo = leerTexto("Tipo de motocicleta: ");

        Motocicleta moto = new Motocicleta(
                marca, modelo, color, placa, cilindrada, tipo
        );

        sistema.registrarVehiculo(moto);
    }

    // Registrar cliente
    public static void registrarCliente() {

        System.out.println("\n--- REGISTRAR CLIENTE ---");

        int id = leerEntero("ID del cliente: ");
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");
        String telefono = leerTexto("Teléfono: ");
        String correo = leerTexto("Correo electrónico: ");

        Cliente cliente = new Cliente(
                id, nombre, apellido, telefono, correo
        );

        sistema.registrarCliente(cliente);
    }

    // Realizar alquiler
    public static void realizarAlquiler() {

        System.out.println("\n--- REALIZAR ALQUILER ---");

        int idAlquiler = leerEntero("ID del alquiler: ");
        int idCliente = leerEntero("ID del cliente: ");
        String placa = leerTexto("Placa del vehículo: ");
        int dias = leerEntero("Cantidad de días: ");

        sistema.realizarAlquiler(
                idAlquiler, idCliente, placa, dias
        );
    }

    // Registrar devolución
    public static void registrarDevolucion() {

        System.out.println("\n--- REGISTRAR DEVOLUCIÓN ---");

        int idAlquiler = leerEntero("ID del alquiler: ");

        sistema.registrarDevolucion(idAlquiler);
    }

    // Consultar alquiler
    public static void consultarAlquiler() {

        System.out.println("\n--- CONSULTAR ALQUILER ---");

        int idAlquiler = leerEntero("ID del alquiler: ");

        sistema.consultarAlquiler(idAlquiler);
    }

    // Calcular costo
    public static void calcularCosto() {

        System.out.println("\n--- CALCULAR COSTO ---");

        int idAlquiler = leerEntero("ID del alquiler: ");

        sistema.calcularCosto(idAlquiler);
    }

    // Leer números enteros con validación
    public static int leerEntero(String mensaje) {

        while (true) {

            System.out.print(mensaje);

            try {
                int numero = Integer.parseInt(scanner.nextLine());

                return numero;

            } catch (NumberFormatException e) {
                System.out.println("Error: debes ingresar un número entero.");
            }
        }
    }

    // Leer textos
    public static String leerTexto(String mensaje) {

        String texto;

        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Este campo no puede estar vacío.");
            }

        } while (texto.isEmpty());

        return texto;
    }
}
