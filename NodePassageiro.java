public class NodePassageiro {
    public Passageiro passageiro; // Utiliza apenas Passageiro, que já é uma extensão de Pessoa
    public NodePassageiro anterior;
    public NodePassageiro proximo;

    // Construtor para o nó de passageiro
    public NodePassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
        this.proximo = null;
        this.anterior = null;
    }

    // Retorna o passageiro
    public Passageiro getPassageiro() {
        return passageiro;
    }

    // Retorna a pessoa (Passageiro) armazenada no nó
    public Pessoa getPessoa() {
        return passageiro; // Como Passageiro é uma subclasse de Pessoa, podemos retornar diretamente
    }

    // Determina o próximo passageiro (nó)
    public void setProximo(NodePassageiro proximo) {
        this.proximo = proximo;
    }

    // Retorna o próximo passageiro (nó)
    public NodePassageiro getProximo() {
        return proximo;
    }

    // Retorna o nó anterior
    public NodePassageiro getAnterior() {
        return anterior;
    }

    // Define o nó anterior
    public void setAnterior(NodePassageiro anterior) {
        this.anterior = anterior;
    }
}
