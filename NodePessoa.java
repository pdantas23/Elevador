public class NodePessoa {
    private Pessoa pessoa;
    private NodePessoa proximo;

    public NodePessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.proximo = null;
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
}