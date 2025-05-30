package biblioteca;

public class Revista extends ItemBiblioteca implements Emprestavel {
    private boolean disponivel = true;

    public Revista(String titulo, String editora) {
        super(titulo, editora);
    }

    @Override
    public void emprestar() throws ItemIndisponivelException {
        if (!disponivel) throw new ItemIndisponivelException("Revista já emprestada.");
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
        System.out.println("Revista: " + titulo + " | Editora: " + autorOuEditora + " | Disponível: " + disponivel);
    }
}
