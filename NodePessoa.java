public class NodePessoa {
    private Pessoa pessoa;
    private NodePessoa proximo;

    public NodePessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.proximo = null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public NodePessoa getProximo() {
        return proximo;
    }

    public void setProximo(NodePessoa proximo) {
        this.proximo = proximo;
    }
}