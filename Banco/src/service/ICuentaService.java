package service;

import banco.Cliente;
import banco.Cuenta;


public interface ICuentaService {
    
    public void addCuenta(Cliente cl, Cuenta cu);
    
    public void consultaSaldo(int a);
    
    public void realizarDeposito(int idCliente, double monto);
     
    public void extraerDinero(int idCliente, double monto);
    
    public void realizarTransferencia(int idCliente1, double monto, int idCliente2);
}
