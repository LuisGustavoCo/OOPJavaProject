package biblioteca;

public abstract class ItemBiblioteca {
    protected String titulo;
    protected String autorOuEditora;

    public ItemBiblioteca(String titulo, String autorOuEditora) {
        this.titulo = titulo;
        this.autorOuEditora = autorOuEditora;
    }

    public String getTitulo() {
        return titulo;
    }

    public abstract void exibirInfo();
}
