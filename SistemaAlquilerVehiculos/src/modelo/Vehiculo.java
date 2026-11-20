package modelo;

import java.util.Objects;

public class Vehiculo {

    private String marca;
    private String modelo;
    private String color;
    private String placa;

    // Estado de disponibilidad del vehículo
    private boolean disponible;

    // Constructor
    public Vehiculo(String marca, String modelo, String color, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.placa = placa;
        this.disponible = true;
    }

    // Método para obtener la información del vehículo
    public String getVehiculo() {
        return "Marca: " + marca +
                ", Modelo: " + modelo +
                ", Color: " + color +
                ", Placa: " + placa;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getPlaca() {
        return placa;
    }

    // Consultar disponibilidad
    public boolean isDisponible() {
        return disponible;
    }

    // Alquilar vehículo
    public void alquilarVehiculo() {
        if (disponible) {
            disponible = false;
        }
    }

    // Devolver vehículo
    public void devolverVehiculo() {
        if (!disponible) {
            disponible = true;
        }
    }

    // Obtener tarifa diaria
    protected double getTarifaDiaria() {
        return 500.0;
    }

    // Calcular costo del alquiler
    public double calcularCosto(int dias) {

        if (dias <= 0) {
            throw new IllegalArgumentException(
                    "Los días deben ser mayores a cero."
            );
        }

        return getTarifaDiaria() * dias;
    }

    // Comparar dos vehículos
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vehiculo vehiculo = (Vehiculo) obj;

        return Objects.equals(placa, vehiculo.placa);
    }

    // Generar código hash
    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    // Convertir información del vehículo a texto
    @Override
    public String toString() {
        return getVehiculo() +
                ", Disponible: " +
                (disponible ? "Sí" : "No");
    }
}
