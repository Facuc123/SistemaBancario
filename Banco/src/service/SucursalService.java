package service;

import banco.Sucursal;
import dao.sucursalDAO;
import java.util.Scanner;

public class SucursalService {
    private sucursalDAO sucursalDao;
    
    public SucursalService() {
        this.sucursalDao = sucursalDAO.getInstance();
    }
    
    public void deleteSucursal(){
        Scanner sc = new Scanner(System.in);
        Sucursal suc = new Sucursal();
        System.out.println("Ingrese el id de la sucursal: ");
     
        suc.setNombreSuc(sc.nextLine());
        sucursalDao.deleteSucursal(suc);
    }
}
