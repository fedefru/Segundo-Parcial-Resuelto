package sample;

public class Cliente {

    public Cliente(String nombre, String domicilio, long cuit, long dni, int precio, String material) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.dni = dni;
        this.precio = precio;
        this.material = material;
    }

    private String nombre;
    private String domicilio;
    private long cuit;
    private long dni;
    private int precio;
    private String material;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
