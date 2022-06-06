package service;

import banco.Cliente;


public interface IClienteService {
    
    public void addCliente(Cliente cl);
     
    public void listar(int a);
    
    public void listarTodo();
}
