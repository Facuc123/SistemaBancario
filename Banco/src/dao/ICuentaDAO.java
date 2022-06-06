package dao;

import banco.Cliente;
import banco.Cuenta;


public interface ICuentaDAO {
    
    public void addCuenta(Cuenta cu, Cliente cl);
     
    public Cuenta consultaSaldo(int a);
    
    public void realizarDeposito(int id, double monto);
    
    public void extraerDinero(int id, double monto);
}
