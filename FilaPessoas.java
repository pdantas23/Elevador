public class FilaPessoas {
    private NodePessoa inicio;
    private NodePessoa fim;
    private int tamanho;

    public FilaPessoas() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void inserirComPrioridade(Pessoa pessoa) {
        NodePessoa nova = new NodePessoa(pessoa);

        // Caso a fila esteja vazia
        if (inicio == null) {
            inicio = fim = nova;
        } else {
            NodePessoa atual = inicio;
            NodePessoa anterior = null;

            // Encontra o local correto com base na prioridade
            while (atual != null && pessoa.getPrioridade() <= atual.getPessoa().getPrioridade()) {
                anterior = atual;
                atual = atual.getProximo();
            }

            if (anterior == null) {
                // Inserção no início
                nova.setProximo(inicio);
                inicio = nova;
            } else {
                // Inserção no meio ou fim
                anterior.setProximo(nova);
                nova.setProximo(atual);

                if (atual == null) {
                    fim = nova;
                }
            }
        }

        tamanho++;
    }

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

    public boolean estaVazia() {
        return inicio == null;
    }

    public int tamanho() {
        return tamanho;
    }

    public NodePessoa getInicio() {
        return inicio;
    }

    public void imprimirFila() {
        NodePessoa atual = inicio;
        while (atual != null) {
            Pessoa p = atual.getPessoa();
            System.out.println("Pessoa " + p.getId() + " (Prioridade " + p.getPrioridade() +
                    ", Destino " + p.getAndarDestino() + ")");
            atual = atual.getProximo();
        }
    }
}
