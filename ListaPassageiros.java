public class ListaPassageiros {
    private NodePassageiro inicio;
    private NodePassageiro fim;
    public int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public ListaPassageiros() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void remover(NodePassageiro atual) {
        if (atual == null) return;

        // Caso a lista tenha apenas um nó
        if (inicio == fim) {
            inicio = fim = null; // A lista fica vazia
        } else {
            inicio = atual.getProximo(); // Move o início para o próximo nó
            if (inicio != null) {
                inicio.setAnterior(null); // Atualiza a referência anterior do novo nó início
            }
        }
    }

    public void adicionarNoFim(Pessoa pessoa) {
        if (pessoa == null) {
            return;
        } else {
            Passageiro passageiro = new Passageiro(pessoa);
            NodePassageiro novo = new NodePassageiro(passageiro);
            System.out.println("Adicionando Passageiro ID: " + pessoa.getId() + " à lista.");

            if (inicio == null) {
                inicio = fim = novo;
            } else {
                fim.setProximo(novo);
                novo.setAnterior(fim);
                fim = novo;
            }
        }
        tamanho++;
    }

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
            System.out.println("ID: " + atual.getPassageiro().getId());
            atual = atual.getProximo();
        }
    }
}
