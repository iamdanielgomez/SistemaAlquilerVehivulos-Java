package servicio;

import modelo.*;
import java.util.ArrayList;

public class SistemaAlquiler {

    // Listas del sistema
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Alquiler> alquileres;

    // Constructor
    public SistemaAlquiler() {
        vehiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        alquileres = new ArrayList<>();
    }

    // Registrar vehículo
    public void registrarVehiculo(Vehiculo vehiculo) {

        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca())) {
                System.out.println("La placa ya está registrada.");
                return;
            }
        }

        vehiculos.add(vehiculo);
        System.out.println("Vehículo registrado correctamente.");
    }

    // Mostrar todos los vehículos
    public void mostrarVehiculos() {

        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

    // Buscar vehículo por placa
    public Vehiculo buscarVehiculo(String placa) {

        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }

        return null;
    }

    // Mostrar vehículos disponibles
    public void mostrarDisponibles() {

        boolean encontrado = false;

        for (Vehiculo v : vehiculos) {
            if (v.isDisponible()) {
                System.out.println(v);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay vehículos disponibles.");
        }
    }

    // Registrar cliente
    public void registrarCliente(Cliente cliente) {

        for (Cliente c : clientes) {
            if (c.getIdCliente() == cliente.getIdCliente()) {
                System.out.println("El cliente ya está registrado.");
                return;
            }
        }

        clientes.add(cliente);
        System.out.println("Cliente registrado correctamente.");
    }

    // Buscar cliente por ID
    public Cliente buscarCliente(int idCliente) {

        for (Cliente c : clientes) {
            if (c.getIdCliente() == idCliente) {
                return c;
            }
        }

        return null;
    }

    // Realizar alquiler
    public void realizarAlquiler(int idAlquiler, int idCliente,
                                 String placa, int dias) {

        if (dias <= 0) {
            System.out.println("Los días deben ser mayores a cero.");
            return;
        }

        for (Alquiler a : alquileres) {
            if (a.getIdAlquiler() == idAlquiler) {
                System.out.println("El ID del alquiler ya existe.");
                return;
            }
        }

        Cliente cliente = buscarCliente(idCliente);
        Vehiculo vehiculo = buscarVehiculo(placa);

        if (cliente == null) {
            System.out.println("El cliente no está registrado.");
            return;
        }

        if (vehiculo == null) {
            System.out.println("El vehículo no existe.");
            return;
        }

        if (!vehiculo.isDisponible()) {
            System.out.println("El vehículo no está disponible.");
            return;
        }

        Alquiler alquiler = new Alquiler(
                idAlquiler, cliente, vehiculo, dias
        );

        alquileres.add(alquiler);
        vehiculo.alquilarVehiculo();

        System.out.println("Alquiler realizado correctamente.");
        System.out.println(alquiler);
    }

    // Registrar devolución
    public void registrarDevolucion(int idAlquiler) {

        for (Alquiler a : alquileres) {

            if (a.getIdAlquiler() == idAlquiler) {

                if (a.getEstado().equals("Finalizado")) {
                    System.out.println("Este alquiler ya fue finalizado.");
                    return;
                }

                a.finalizarAlquiler();
                a.getVehiculo().devolverVehiculo();

                System.out.println("Devolución registrada correctamente.");
                return;
            }
        }

        System.out.println("No se encontró el alquiler.");
    }

    // Consultar alquiler
    public void consultarAlquiler(int idAlquiler) {

        for (Alquiler a : alquileres) {

            if (a.getIdAlquiler() == idAlquiler) {
                System.out.println(a);
                return;
            }
        }

        System.out.println("No se encontró el alquiler.");
    }

    // Calcular costo del alquiler
    public void calcularCosto(int idAlquiler) {

        for (Alquiler a : alquileres) {

            if (a.getIdAlquiler() == idAlquiler) {
                System.out.println("Costo total: $" + a.getCostoTotal());
                return;
            }
        }

        System.out.println("No se encontró el alquiler.");
    }

    // Mostrar vehículos alquilados
    public void mostrarVehiculosAlquilados() {

        boolean encontrado = false;

        for (Vehiculo v : vehiculos) {

            if (!v.isDisponible()) {
                System.out.println(v);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay vehículos alquilados.");
        }
    }

    // Mostrar historial de alquileres
    public void mostrarHistorial() {

        if (alquileres.isEmpty()) {
            System.out.println("No hay alquileres registrados.");
            return;
        }

        for (Alquiler a : alquileres) {
            System.out.println(a);
            System.out.println("--------------------------");
        }
    }
}
