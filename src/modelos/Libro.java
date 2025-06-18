package modelos;

public class Libro implements Comparable<Libro> {
    private String codigo;      // Único
    private String titulo;
    private String autor;
    private double precio;
    private boolean disponible; // true/false

    public Libro(String codigo, String titulo, String autor, double precio, boolean disponible) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    
    
    @Override
    public int compareTo(Libro otro) {
        return this.codigo.compareTo(otro.codigo);
    }
    @Override
    public String toString() {
        return String.format("[%s] %s - %s ($%.2f) %s", 
            codigo, titulo, autor, precio, disponible ? "Disponible" : "Prestado");
    }

}
