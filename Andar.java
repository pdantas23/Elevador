public class Andar {
    private int numero;
    private FilaPessoas pessoasAguardando;
    private PainelExterno painel;
    public Andar proximo;
    public Andar anterior;

    //A fila é criada ao instanciar o andar
    public Andar(int numero) {
        this.numero = numero;
        this.pessoasAguardando = new FilaPessoas();
        this.painel = new PainelExterno(numero);
        this.proximo = null;
        this.anterior = null;

        for (int i = 0; i < 10; i++) {
            Pessoa pessoa = Pessoa.gerarPessoaAleatoria(numero);
            pessoasAguardando.adicionarPessoa(pessoa);
        }
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public FilaPessoas getPessoasAguardando() {
        return pessoasAguardando;
    }

    public PainelExterno getPainel() {
        return painel;
    }

    public Andar getProximo() {
        return proximo;
    }

    public void setProximo(Andar proximo) {
        this.proximo = proximo;
    }

    public Andar getAnterior() {
        return anterior;
    }
}

