package service;
import banco.Cliente;
import banco.Cuenta;
import dao.cuentaDAO;
import java.util.Scanner;

public class CuentaService implements ICuentaService{
    
    private cuentaDAO cuentaDao;
    
    private static long MAX = 999999999999999999L;
    private static long MIN = 100000000000000000L;

    
    public CuentaService(){
        this.cuentaDao = cuentaDAO.getInstance();
    }
    
    public void addCuenta(Cliente cl, Cuenta cu){
        cu.setCBU(String.valueOf(Math.floor(Math.random()*(MIN-MAX+1)+MAX)));
        cuentaDao.addCuenta(cu, cl);
    }
    
    public void consultaSaldo(int a){
        Cuenta cu = new Cuenta();
        cu = cuentaDao.consultaSaldo(a);
        System.out.println(cu.toStringConsulta());
    }
    
    public void realizarDeposito(int idCliente, double monto){
        Cuenta cu = new Cuenta();
        cu = cuentaDao.consultaSaldo(idCliente);
        monto = monto + cu.getSaldo();
        cuentaDao.realizarDeposito(idCliente, monto);
}
    public void extraerDinero(int idCliente, double monto){
        Cuenta cu = new Cuenta();
        cu = cuentaDao.consultaSaldo(idCliente);
        monto = cu.getSaldo() - monto;
        cuentaDao.extraerDinero(idCliente,monto);
    }
    
    public void realizarTransferencia(int idCliente1, double monto, int idCliente2){
        Cuenta cu1 = new Cuenta();
        Cuenta cu2 = new Cuenta();
        double aux;
        cu1 = cuentaDao.consultaSaldo(idCliente1);
        cu2 = cuentaDao.consultaSaldo(idCliente1);
        aux = cu1.getSaldo() - monto;
        monto = cu2.getSaldo() + monto;
        cuentaDao.extraerDinero(idCliente1,aux);
        cuentaDao.realizarDeposito(idCliente2,monto);
    }
}
