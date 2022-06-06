package service;
import dao.clienteDAO;
import banco.Cliente;
import banco.Cuenta;
import banco.Sucursal;
import java.util.Scanner;

public class ClienteService implements IClienteService{
    
    private clienteDAO clienteDao;

    public ClienteService() {
        this.clienteDao = clienteDAO.getInstance();
    }
    
    @Override
    public void addCliente(Cliente cl){
    clienteDao.addCliente(cl);
    }
    
    @Override
    public void listar(int a){     
        clienteDao.listarUnaSucursal(a);
    }
    
    @Override
    public void listarTodo(){
         clienteDao.listarClientes();
    }
}
