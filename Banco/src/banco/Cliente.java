package banco;

import java.util.List;


public class Cliente extends Persona{
    private int idCliente;
    private String domicilioLegal;
    private int idSucursal;
    private List<Cuenta> cuentas;

    
    public Cliente() {
    }

  
    public Cliente(int idCliente, String domicilioLegal, int idSucursal, List<Cuenta> cuentas, String nombre, String nroTelefono, String email) {
        super(nombre, nroTelefono, email);
        this.idCliente = idCliente;
        this.domicilioLegal = domicilioLegal;
        this.idSucursal = idSucursal;
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "cliente{" + "idCliente=" + idCliente + ", domicilioLegal=" + domicilioLegal 
            + ", idSucursal=" + idSucursal + ", cuentas=" + cuentas + " nombre=" + getNombre() + " telefono=" + getNroTelefono() + " email=" + getEmail() + '}';
    }
    
    
    public String getDomicilioLegal() {
        return domicilioLegal;
    }

    public void setDomicilioLegal(String domicilioLegal) {
        this.domicilioLegal = domicilioLegal;
    }

    public int getidSucursal() {
        return idSucursal;
    }

    public void setidSucursal(int Sucursal) {
        this.idSucursal = Sucursal;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
}
