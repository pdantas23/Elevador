public class Fila {
    private NodePessoa inicio;
    private NodePessoa fim;

    public Fila() {
        inicio = null;
        fim = null;
    }

    public void enfileirar(Pessoa pessoa) {
        NodePessoa novoNo = new NodePessoa(pessoa);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
            return;
        }

        if (pessoa.getPrioridade() < inicio.getPessoa().getPrioridade()) {
            novoNo.setProximo(inicio);
            inicio = novoNo;
            return;
        }

        NodePessoa atual = inicio;
        NodePessoa anterior = null;

        while (atual != null && pessoa.getPrioridade() >= atual.getPessoa().getPrioridade()) {
            anterior = atual;
            atual = atual.getProximo();
        }

        novoNo.setProximo(atual);
        if (anterior != null) {
            anterior.setProximo(novoNo);
        }

        if (novoNo.getProximo() == null) {
            fim = novoNo;
        }
    }

    public Pessoa desenfileirar() {
        if (inicio == null) return null;

        Pessoa pessoa = inicio.getPessoa();
        inicio = inicio.getProximo();
        if (inicio == null) fim = null;

        return pessoa;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void imprimirFila() {
        NodePessoa atual = inicio;
        System.out.println("Fila:");
        while (atual != null) {
            Pessoa p = atual.getPessoa();
            System.out.println("  - Pessoa ID: " + p.getId() + ", Origem: " + p.getAndarOrigem() + ", Destino: " + p.getAndarDestino());
            atual = atual.getProximo();
        }
    }
}
