public class NodePassageiro {
    public Passageiro passageiro;  // Passageiro no nó
    public NodePassageiro proximo; // Próximo nó na lista

    // Construtor para o nó de passageiro
    public NodePassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
        this.proximo = null;
    }

    // Getters e setters
    public Passageiro getPassageiro() {
        return passageiro;
    }

    //Retorna o próximo passageiro(nó)
    public NodePassageiro getProximo() {
        return proximo;
    }

    //Determina o próximo passageiro(ao desembarcar alguém que não seja o primeiro)
    public void setProximo(NodePassageiro proximo) {
        this.proximo = proximo;
    }
}
