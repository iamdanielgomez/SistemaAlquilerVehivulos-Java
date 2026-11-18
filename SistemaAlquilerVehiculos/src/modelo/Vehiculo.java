package modelo;
import java.util.Objects;

public class Vehiculo {

    private String marca;
    private String modelo;
    private String color;
    private String placa;

    // Constructor
    public Vehiculo(String marca, String modelo, String color, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.placa = placa;
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
        return getVehiculo();
    }
}
