package modelo;

public class Motocicleta extends Vehiculo{
    private int cilindrada;
    private String tipo_Motocicleta;

    public Motocicleta(String marca, String modelo, String color, String placa, int cilindrada, String tipo_Motocicleta) {
        super(marca, modelo, color, placa);
        this.cilindrada = cilindrada;
        this.tipo_Motocicleta = tipo_Motocicleta;
    }

    public int getCilindrada(){
        return cilindrada;
    }

    public String getTipo_Motocicleta(){
        return tipo_Motocicleta;
    }

    @Override
    public String toString() {
        return super.getVehiculo() +
                ", Cilindrada: " + cilindrada + "cc" +
                ", Tipo de moticicleta: " + tipo_Motocicleta;
    }
}
