public class FilaPessoas {
    private NodePessoa inicio;
    private NodePessoa fim;

    public int getTamanho() {
        return tamanho;
    }

    private int tamanho;

    public FilaPessoas() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    //Retorna a primeira pessoa da fila
    public NodePessoa getInicio() {
        return inicio;
    }

    //Adiciona uma nova pessoa a fila
    public void adicionarPessoa(Pessoa pessoa) {
        NodePessoa novo = new NodePessoa(pessoa);

        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            NodePessoa atual = inicio;
            NodePessoa anterior = null;

            while (atual != null && atual.getPessoa().getPrioridade() >= pessoa.getPrioridade()) {
                anterior = atual;
                atual = atual.getProximo();
            }

            if (anterior == null) {
                novo.setProximo(inicio);
                inicio = novo;
            } else {
                anterior.setProximo(novo);
                novo.setProximo(atual);

                if (atual == null) {
                    fim = novo;
                }
            }
        }
        tamanho++;
    }

    public void removerInicio() {
        if (inicio == null) {
            return; // Se a lista estiver vazia, não faz nada
        }else{
            inicio = inicio.getProximo();
        }

    }

    //Exibe a fila e cada integrante
    public void exibirFila() {
        if (inicio == null) {
            System.out.println("A fila está vazia.");
            return;
        }

        NodePessoa atual = inicio;
        while (atual != null) {
            System.out.println("Pessoa ID: " + atual.getPessoa().getId() + " | Destino: " + atual.getPessoa().getAndarDestino() + " | Prioridade: " + atual.getPessoa().getPrioridade()); // Exibe as informações da pessoa
            atual = atual.getProximo(); // Vai para o próximo nó
        }
    }
}
