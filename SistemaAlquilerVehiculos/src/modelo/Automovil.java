package modelo;

public class Automovil extends Vehiculo{
    private int numeroPuertas;
    private String tipoCombustible;

    public Automovil(String marca, String modelo, String color, String placa, int numeroPuertas, String tipoCombustible) {
        super(marca, modelo, color, placa);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
    }
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public String getTipoCombustible(){
        return tipoCombustible;
    }
    @Override
    public String toString() {
        return super.getVehiculo() +
                ", Número de puertas: " + numeroPuertas +
                ", Tipo de combustible: " + tipoCombustible;
    }
}
