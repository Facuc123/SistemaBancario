package dao;
import banco.Empleado;

public class empleadoDAO extends DAO implements IEmpleadoDAO{
    
    private static empleadoDAO instance;
    
    public static empleadoDAO getInstance(){
        if( instance == null ){
            instance = new empleadoDAO();
        }
        return instance;
    }
    
    public void addEmpleado(Empleado em){
        try{
            connect();
            ps = c.prepareStatement("insert into empleado (?,?,?,?,?);");
            ps.setInt(0, em.getLegajo());
            ps.setString(1, em.getNombre());
            ps.setString(3, em.getNroTelefono());
            ps.setString(4, em.getEmail());
            ps.setInt(5, em.getIdSucursal());
            ps.executeQuery();
            disconnect(c);
            
        }catch(Exception e){
            System.out.println(e);
        }
    
    }
 
}