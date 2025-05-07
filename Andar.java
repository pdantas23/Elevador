public class Andar {
    private int numero;
    private FilaPessoas pessoasAguardando;
    private PainelElevador painel;
    public Andar proximo;
    public Andar anterior;

    //A fila é criada ao instanciar o andar
    public Andar(int numero) {
        this.numero = numero;
        this.pessoasAguardando = new FilaPessoas();
        this.painel = new PainelElevador();
        this.proximo = null;
        this.anterior = null;

        for (int i = 0; i < 10; i++) {
            Pessoa pessoa = Pessoa.gerarPessoaAleatoria(numero);
            pessoasAguardando.adicionarPessoa(pessoa);
        }
    }

    //Retorna o andar
    public int getNumero() {
        return numero;
    }

    //Retorna a fila de pessoas aguardando no andar
    public FilaPessoas getPessoasAguardando() {
        return pessoasAguardando;
    }

    //Retorna o painel do elevador
    public PainelElevador getPainel() {
        return painel;
    }

    //Retorna o próximo andar
    public Andar getProximo() {
        return proximo;
    }

}

