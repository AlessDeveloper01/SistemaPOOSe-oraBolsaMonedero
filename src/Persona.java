public class Persona {

    private String nombre;
    private Bolsa bolsa;
    private Monedero monedero;

    public Persona(String nombre, Bolsa bolsa, Monedero monedero) {
        this.nombre = nombre;
        this.bolsa = bolsa;
        this.monedero = monedero;
    }

    public String getNombre() {
        return nombre;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public Monedero getMonedero() {
        return monedero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public void setMonedero(Monedero monedero) {
        this.monedero = monedero;
    }
    
    public void agregarProducto(Producto producto) {
        bolsa.agregarProducto(producto);
    }

    public void sacarProducto(Producto producto) {
        bolsa.sacarProducto(producto);
    }

    public void totalAPagar() {
        System.out.println("Total a pagar: " + bolsa.calcularPrecioTotal());
    }

    public void comprarProductos() {
        if (bolsa.comprarTodosLosProductos(monedero)) {
            System.out.println("Compra realizada con éxito");
        } else {
            System.out.println("No se pudo realizar la compra");
        }
    }

    public void buscarProducto(String nombre) {
        if (bolsa.seEncuentraElProducto(nombre)) {
            System.out.println("El producto se encuentra en la bolsa");
        } else {
            System.out.println("El producto no se encuentra en la bolsa");
        }
    }

    public void totalDeProductosEnBolsa() {
        System.out.println("Total de productos en la bolsa: " + bolsa.cuantosProductosHayEnLaBolsa());
    }

    public void cuantoProductosHayDe(String nombre) {
        System.out.println("Total de productos en la bolsa: " + bolsa.cuantosProductosHayEnLaBolsa());
    }

    public void cantidadRestanteEnMonedero() {
        System.out.println("Cantidad restante en monedero: " + bolsa.cantidadRestanteDeDinero(monedero));
    }

    public void cantidadDeProductosPorTipo(Producto.Tipo tipo) {
        System.out.println("Cantidad de productos por tipo: " + bolsa.cuantosProductosDeTipo(tipo));
    }

    public void vaciarBolsa() {
        bolsa.vaciarBolsa();
    }

    public void espacioDisponible() {
        if (bolsa.espacioDisponibleParaMasProductos()) {
            System.out.println("Hay espacio disponible");
        } else {
            System.out.println("No hay espacio disponible");
       }
    }
}
