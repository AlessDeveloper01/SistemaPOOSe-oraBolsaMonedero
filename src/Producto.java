public class Producto {
    
    public enum Tipo {
        VERDURA,
        ABARROTE
    }
    
    private Tipo tipo;
    private String nombre;
    private int precio;

    public Producto(Tipo tipo, String nombre, int precio) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
