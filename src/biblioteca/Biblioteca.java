package biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ItemBiblioteca> itens;

    public Biblioteca() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado na biblioteca.");
        } else {
            System.out.println("Itens na biblioteca:");
            for (ItemBiblioteca item : itens) {
            	System.out.println();
                System.out.print("- " + item.getTitulo());
                if (item instanceof Livro) {
                	Livro l = (Livro) item;
	                if (!l.isDisponivel()) {
	                	System.out.println(" está emprestado!");
	                }
                }
                else if (item instanceof Revista){
                	Revista r = (Revista) item;
	                if (!r.isDisponivel()) {
	                	System.out.println(" está emprestado!");
	                }
                }
            }
        }
    }

    public void emprestarItem(String titulo) throws ItemNaoEncontradoException, ItemIndisponivelException {
        for (ItemBiblioteca item : itens) {
            if (item.getTitulo().equalsIgnoreCase(titulo) && item instanceof Emprestavel) {
                ((Emprestavel) item).emprestar();
                System.out.println("Item emprestado: " + titulo);
                return;
            }
        }
        throw new ItemNaoEncontradoException("Item não encontrado ou não emprestável.");
    }

    public void devolverItem(String titulo) throws ItemNaoEncontradoException, ItemIndisponivelException {
    	Livro l = null;
    	Revista r = null;
    	for (ItemBiblioteca item : itens) {
        	if (item instanceof Livro) {
            	l = (Livro) item;
            }
            else if (item instanceof Revista){
            	r = (Revista) item;
            }
        	if (l != null) {
        		if (l.isDisponivel()) {
        			throw new ItemIndisponivelException("Livro não disponível para devolução.");
        		}
        	}
        	if (r != null) {
        		if (r.isDisponivel()) {
        			throw new ItemIndisponivelException("Revista não disponível para devolução.");
        		}
        	}
            if (item.getTitulo().equalsIgnoreCase(titulo) && item instanceof Emprestavel) {
                ((Emprestavel) item).devolver();
                System.out.println("Item devolvido: " + titulo);
                return;
            }
        }
        throw new ItemNaoEncontradoException("Item não encontrado.");
    }
}
