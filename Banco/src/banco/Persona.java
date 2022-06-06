package banco;

public abstract class Persona {
    private String nombre;
    private String nroTelefono;
    private String email;

    public Persona() {
    }

    public Persona(String nombre, String nroTelefono, String email) {
        this.nombre = nombre;
        this.nroTelefono = nroTelefono;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "persona{" + "nombre=" + nombre + ", nroTelefono=" + nroTelefono + ", email=" + email + '}';
    }
    
    
    
}
