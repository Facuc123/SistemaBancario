package dao;

import java.util.List;
import banco.Cuenta;
import banco.Cliente;
import java.util.ArrayList;
import java.sql.*;

public class clienteDAO extends DAO implements IClienteDAO{
    
    private List<Cliente> clientes;
    private List<Cuenta> cuentas;

    private static clienteDAO instance;
    
    private clienteDAO(){
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();
    }
    
    public synchronized static clienteDAO getInstance(){
        if ( instance == null ){
            instance = new clienteDAO();
        }
        return instance;
    }
    
    public void addCliente(Cliente cl) {
        try{
            connect();
            ps = c.prepareStatement("INSERT INTO CLIENTE (nombre, telefono, email, domicioLegal, sucursal)VALUES(?,?,?,?,?)");
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getNroTelefono());
            ps.setString(3, cl.getEmail());
            ps.setString(4, cl.getDomicilioLegal());
            ps.setInt(5, cl.getidSucursal());
            ps.execute();
            disconnect(c);
        }catch( SQLException e ){
            System.out.println(e);
        }
        
    }
    
    public void listarClientes(){
        
        try{
            connect();
            ps = c.prepareStatement("select * from cliente order by sucursal");
            ResultSet res = ps.executeQuery();
            while(res.next()){
                Cliente clien = new Cliente();
                clien.setIdCliente(res.getInt("idCliente"));
                clien.setNombre(res.getString("nombre"));
                clien.setNroTelefono(res.getString("telefono"));
                clien.setEmail(res.getString("email"));
                clien.setDomicilioLegal(res.getString("domicioLegal"));
                clien.setidSucursal(res.getInt("sucursal"));
                System.out.println(clien.toString());
       

            }
            disconnect(c);
        }catch( SQLException e ){
            System.out.println(e);
        }
    }
    
    public void listarUnaSucursal(int idSucursal) {
        try{
            connect();
            ps = c.prepareStatement("select * from cliente where sucursal = ?;");
            ps.setInt(1, idSucursal);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                Cliente clien = new Cliente();
                clien.setIdCliente(res.getInt("idCliente"));
                clien.setNombre(res.getString("nombre"));
                clien.setNroTelefono(res.getString("telefono"));
                clien.setEmail(res.getString("email"));
                clien.setDomicilioLegal(res.getString("domicioLegal"));
                clien.setidSucursal(res.getInt("sucursal"));
                System.out.println(clien.toString());
            }
            disconnect(c);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
