package banco;

public class Sucursal {
    private int nroSucursal;
    private String nombreSuc;

    public Sucursal() {
    }

    public Sucursal(int nroSucursal, String nombreSuc) {
        this.nroSucursal = nroSucursal;
        this.nombreSuc = nombreSuc;
    }

    
    public int getNroSucursal() {
        return nroSucursal;
    }

    public void setNroSucursal(int nroSucursal) {
        this.nroSucursal = nroSucursal;
    }

    public String getNombreSuc() {
        return nombreSuc;
    }

    public void setNombreSuc(String nombreSuc) {
        this.nombreSuc = nombreSuc;
    }

    
}
