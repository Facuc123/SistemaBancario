package banco;

public class Cuenta {
    private int id;
    private double saldo;
    private String CBU;
    private String tipoCuenta;
    private String tipoMoneda;
    private Cliente cliente;

    public Cuenta() {
    }

    public String toStringConsulta() {
        return "cuenta{" + "id=" + id + ", saldo=" + saldo + '}';
    }

    @Override
    public String toString() {
        return "cuenta{" + "id=" + id + ", saldo=" + saldo + ", CBU=" + CBU + ", tipoCuenta=" + tipoCuenta + ", tipoMoneda=" + tipoMoneda + ", cliente=" + cliente + '}';
    }

    
    
    public Cuenta(int id, double saldo, String CBU, String tipoCuenta, String tipoMoneda, Cliente cliente) {
        this.id = id;
        this.saldo = saldo;
        this.CBU = CBU;
        this.tipoCuenta = tipoCuenta;
        this.tipoMoneda = tipoMoneda;
        this.cliente = cliente;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCBU() {
        return CBU;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
