package dao;
import banco.Sucursal;
import java.util.List;
import java.sql.*;

public class sucursalDAO extends DAO implements ISucursalDAO{
    private List<Sucursal> sucursales;
    private static sucursalDAO instance;
    
    public synchronized static sucursalDAO getInstance() {
        if ( instance == null ){
            instance = new sucursalDAO();
        }
        return instance;
    }
    
    public void deleteSucursal(Sucursal suc){
        try{
            connect();
            ps = c.prepareStatement("DELETE FROM sucursal WHERE idsucursal = ?");
            ps.setInt(1, suc.getNroSucursal());
            ps.execute();
            disconnect(c);
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
