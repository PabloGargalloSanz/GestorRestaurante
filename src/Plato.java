public class Plato {
    
    private String codigo;
    private String nombre;
    private Double precio;

    //Constructor
    public Plato(String codigo, String nombre, Double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Double getPrecio() { return this.precio; }
}
