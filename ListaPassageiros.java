public class ListaPassageiros {
    private NodePassageiro inicio;
    private NodePassageiro fim;

    public ListaPassageiros() {
        this.inicio = null;
        this.fim = null;
    }

    //Funcão desembarque
    /*public void remover(Passageiro passageiro) {
        NodePassageiro atual = inicio;
        NodePassageiro anterior = null;

        while (atual != null) {
            if (atual.getPassageiro() == passageiro) {
                if (anterior == null) {
                    inicio = atual.getProximo(); // Remove o primeiro nó
                } else {
                    anterior.setProximo(atual.getProximo()); // Remove o nó intermediário
                }

                if (atual == fim) {
                    fim = anterior; // Se for o último nó, ajusta o ponteiro do fim
                }
                return; // Passa a controlar a remoção
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }*/

    //Primeiro passageiro a embarcar
    public NodePassageiro getInicio() {
        return inicio;
    }

    // Verifica se a o elevador está vazio
    public boolean isEmpty() {
        return inicio == null;
    }

    // Metodo para mostrar os passageiros embarcados
    public void mostrarPassageiros() {
        NodePassageiro atual = inicio;
        while (atual != null) {
            System.out.println(atual.getPassageiro());
            atual = atual.getProximo();
        }
    }
}
