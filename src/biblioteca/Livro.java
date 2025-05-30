package biblioteca;

public class Livro extends ItemBiblioteca implements Emprestavel {
    private boolean disponivel = true;

    public Livro(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public void emprestar() throws ItemIndisponivelException {
        if (!disponivel) throw new ItemIndisponivelException("Livro já emprestado.");
        disponivel = false;
    }

    @Override
    public void devolver() {
        disponivel = true;
    }

    @Override
    public boolean isDisponivel() {
        return disponivel;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro: " + titulo + " | Autor: " + autorOuEditora + " | Disponível: " + disponivel);
    }
}
