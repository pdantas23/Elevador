public class NodePessoa {
    private Pessoa pessoa;
    private NodePessoa proximo;
    public NodePessoa anterior;

    public NodePessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.proximo = null;
        this.anterior = null;
    }

    //Retorna a Pessoa
    public Pessoa getPessoa() {
        return pessoa;
    }

    //Retorna o próximo do nóPessoa
    public NodePessoa getProximo() {
        return proximo;
    }

    //Determina o próximo do nóPessoa
    public void setProximo(NodePessoa proximo) {
        this.proximo = proximo;
    }

    public void setAnterior(NodePessoa anterior) {
        this.anterior = anterior;
    }
}