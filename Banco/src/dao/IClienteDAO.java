package dao;

import banco.Cliente;



public interface IClienteDAO {
    
    public void addCliente(Cliente cl);
    
    public void listarClientes();
    
    public void listarUnaSucursal(int idSucursal);
}
