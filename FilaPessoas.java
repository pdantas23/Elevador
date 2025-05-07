public class FilaPessoas {
    private NodePessoa inicio;
    private NodePessoa fim;
    private int tamanho;

    public FilaPessoas() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    //Embarque da pessoa com maior prioridade
    public NodePessoa removerPessoaComMaiorPrioridade() {
        if (inicio == null) return null;

        NodePessoa removido = inicio;
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null;
        }
        tamanho--;
        return removido;
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
