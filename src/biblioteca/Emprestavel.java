package biblioteca;

public interface Emprestavel {
    void emprestar() throws ItemIndisponivelException;
    void devolver();
    boolean isDisponivel();
}
