package modelo;

import java.util.Objects;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;

    // Constructor
    public Cliente(int idCliente, String nombre, String apellido,
                   String telefono, String correo) {

        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    // Mostrar información del cliente
    @Override
    public String toString() {
        return "ID del cliente: " + idCliente +
                "\nNombre: " + nombre +
                "\nApellido: " + apellido +
                "\nTeléfono: " + telefono +
                "\nCorreo: " + correo;
    }

    // Comparar clientes por ID
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Cliente cliente = (Cliente) obj;

        return idCliente == cliente.idCliente;
    }

    // Generar código hash
    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }
}
