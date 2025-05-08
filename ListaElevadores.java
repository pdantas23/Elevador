public class ListaElevadores {
    private NodeElevador head;
    public int tamanho;

    public ListaElevadores() {
        head = null;
        tamanho = 0;
    }

    //Adiciona um elevador a lista
    public void inserir(Elevador elevador) {
        NodeElevador novoNo = new NodeElevador(elevador);

        if (head == null) {
            head = novoNo;
        } else {
            NodeElevador atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    public int getTamanho() {
        return tamanho;
    }

    //Retorna o primeiro elevador da lista
    public NodeElevador getInicio() {
        return head;
    }
}

