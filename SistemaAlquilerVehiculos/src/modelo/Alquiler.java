
package modelo;

public class Alquiler {

    private int idAlquiler;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int dias;
    private double costoTotal;
    private String estado;

    // Constructor
    public Alquiler(int idAlquiler, Cliente cliente,
                    Vehiculo vehiculo, int dias) {

        this.idAlquiler = idAlquiler;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;
        this.costoTotal = vehiculo.calcularCosto(dias);
        this.estado = "Activo";
    }

    // Getters
    public int getIdAlquiler() {
        return idAlquiler;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int getDias() {
        return dias;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public String getEstado() {
        return estado;
    }

    // Finalizar alquiler
    public void finalizarAlquiler() {
        estado = "Finalizado";
    }

    // Mostrar información
    @Override
    public String toString() {
        return "ID del alquiler: " + idAlquiler +
                "\nCliente: " + cliente +
                "\nVehículo: " + vehiculo +
                "\nDías alquilados: " + dias +
                "\nCosto total: $" + costoTotal +
                "\nEstado: " + estado;
    }
}
