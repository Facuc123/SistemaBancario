package banco;

public class Empleado extends Persona{
    private int legajo;
    private int idSucursal;

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Empleado() {
    }

    public Empleado(int legajo, int idSucursal) {
        this.legajo = legajo;
        this.idSucursal = idSucursal;
    }

    public Empleado(int legajo, int idSucursal, String nombre, String nroTelefono, String email) {
        super(nombre, nroTelefono, email);
        this.legajo = legajo;
        this.idSucursal = idSucursal;
    }
    
    
}
