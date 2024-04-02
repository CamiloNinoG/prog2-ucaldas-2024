public class Libro {
    private String titulo = "";
    private String isbn = "";
    private String categoria = "";
    private int ejemplares = 0;
    private Autor autor;

    public Libro( String titulo_param, String isbn_param, String categoria_param, int ejemplares_param, Autor autor_param) {
        this.titulo = titulo_param;
        this.isbn = isbn_param;
        this.categoria = categoria_param;
        this.ejemplares = ejemplares_param;
        this.autor = autor_param;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public String toString() {
        return "Título: " + titulo + "\nISBN: " + isbn + "\nCategoría: " + categoria + "\nEjemplares: " + ejemplares + "\nAutor: " + autor.getNombre();
    }
}
