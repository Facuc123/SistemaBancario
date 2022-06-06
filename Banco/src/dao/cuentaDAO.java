package dao;
import banco.Cliente;
import java.util.ArrayList;
import java.util.List;
import banco.Cuenta;
import java.sql.SQLException;
import java.sql.*;


public class cuentaDAO extends DAO implements ICuentaDAO{
    List<cuentaDAO> cuentas;
    private static cuentaDAO instance;
    
    private cuentaDAO() {
        this.cuentas = new ArrayList<>();
    }
    
    public synchronized static cuentaDAO getInstance(){
        if(instance == null) {
            instance = new cuentaDAO();
        }
        return instance;
    }
    
    public void addCuenta(Cuenta cu, Cliente cl){
        
        try{
            connect();
            ps = c.prepareStatement("insert into cuenta (nroCuenta,CBU,saldo,cliente_idCliente,tipoDeCuenta,tipoDeMoneda,sucursal_idsucursal) values (?,?,?,?,?,?,?)");
            ps.setInt(1, cu.getId());
            ps.setString(2, cu.getCBU());
            ps.setDouble(3, cu.getSaldo());
            ps.setInt(4, cu.getCliente().getIdCliente());
            ps.setString(5, cu.getTipoCuenta());
            ps.setString(6, cu.getTipoMoneda());
            ps.setInt(7, cu.getCliente().getidSucursal());
            ps.executeUpdate();
            disconnect(c);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public Cuenta consultaSaldo(int a){
        try{
            connect();
            ps = c.prepareStatement("Select cliente_idcliente, saldo from cuenta where cliente_idcliente = ?");
            ps.setInt(1, a);            
            ResultSet res = ps.executeQuery();
            while(res.next()){
               Cuenta cu = new Cuenta();
               cu.setId(res.getInt("cliente_idCliente"));
               cu.setSaldo(res.getFloat("saldo"));               
               return cu;
             }
            disconnect(c);
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public void realizarDeposito(int id, double monto){
        try{
            connect();
            ps = c.prepareStatement("update cuenta set saldo = ? where cliente_idcliente = ?");
            ps.setDouble(1, monto);
            ps.setInt(2, id);
            ps.executeUpdate();
            disconnect(c);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    
    public void extraerDinero(int id, double monto){
        
        try{
        connect();
        ps = c.prepareStatement("update cuenta set saldo = ? where cliente_idcliente = ?");
        ps.setDouble(1, monto);
        ps.setInt(2, id);
        ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}