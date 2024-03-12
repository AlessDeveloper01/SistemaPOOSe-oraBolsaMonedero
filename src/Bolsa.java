public class Bolsa {

    private int capacidad;
    private Producto[] productos;
    private int cantidad;


    public Bolsa(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new Producto[capacidad];
        this.cantidad = -1;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean espacioDisponible() {
        return cantidad < capacidad;
    }

    public void agregarProducto(Producto producto) {
        if (espacioDisponible()) {
            cantidad++;
            productos[cantidad] = producto;
        }
    }

    public void sacarProducto(Producto producto) {
        for (int i = 0; i <= cantidad; i++) {
            if (productos[i] == producto) {
                for (int j = i; j < cantidad; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[cantidad] = null;
                cantidad--;
                break;
            }
        }
    }

    public int calcularPrecioTotal() {
        int precioTotal = 0;
        for (int i = 0; i < cantidad; i++) {
            precioTotal += productos[i].getPrecio();
        }
        return precioTotal;
    }

    public boolean comprarTodosLosProductos(Monedero monedero) {
        boolean purchased = false;
        int totalPrice = calcularPrecioTotal();

        if (monedero.getSaldo() >= totalPrice) {
            for (int i = 0; i <= cantidad; i++) {
                monedero.setSaldo(monedero.getSaldo() - productos[i].getPrecio());
                sacarProducto(productos[i]);
            }
            purchased = true;
        } else if (monedero.getSaldo() >= productos[0].getPrecio()) {
            monedero.setSaldo(monedero.getSaldo() - productos[0].getPrecio());
            sacarProducto(productos[0]);
            purchased = true;
        }

        return purchased;
    }
    
    public boolean seEncuentraElProducto(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            String nombreCompleto = productos[i].getNombre();
            if (nombreCompleto.equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public int cuantosProductosHayEnLaBolsa() {
        int cant = 0;
        for (int i = 0; i < cantidad; i++) {
            if (productos[i] != null) {
                cant++;
            }
        }

        return cant + 1;
    }

    public int cantidadEnEspecificoDeUnProducto(String nombre) {
        int cant = 0;
        for (int i = 0; i < cantidad; i++) {

            String nombreCompleto = productos[i].getNombre();
            if (nombreCompleto.equals(nombre)) {
                cant++;
            }
        }
        return cant;
    }

    public int cantidadRestanteDeDinero(Monedero monedero) {
        return monedero.getSaldo();
    }

    public int cuantoHaGastadoHastaElMomento() {
        int total = 0;
        for (int i = 0; i < cantidad; i++) {
            total += productos[i].getPrecio();
        }
        return total;
    }

    public int cuantosProductosDeTipo(Producto.Tipo tipo) {
        int cant = 0;
        for (int i = 0; i <= cantidad; i++) {
            if (productos[i].getTipo().equals(tipo)) {
                cant++;
            }
        }
        return cant;
    }

    public boolean espacioDisponibleParaMasProductos() {
        return cantidad < capacidad;
    }

    public void vaciarBolsa() {
        for (int i = 0; i < cantidad; i++) {
            productos[i] = null;
        }
        cantidad = -1;
    }

}
