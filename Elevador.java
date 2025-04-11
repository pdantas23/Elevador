class Elevador {
    int pessoasEmbarcadas;
    int quantidadeDePessoasFila;
    int capacidade;
    int andarAtual;
    int gastoDeEnergia;
    boolean emMovimento;
    boolean lotado;
    double tempoChegada;
    Predio predio;

    public int getandarAtual() {
        return andarAtual;
    }

    public void setandarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public Elevador(int capacidade, double tempoChegada, int quantidadeDePessoasFila, Predio predio) {
        this.capacidade = capacidade;
        andarAtual = 0;
        emMovimento = false;
        lotado = false;
        this.tempoChegada = tempoChegada;
        this.quantidadeDePessoasFila = quantidadeDePessoasFila;
        this.gastoDeEnergia = 0;
        pessoasEmbarcadas = 0;
        this.predio = predio;
    }

    public void embarqueElevador() {

        if (quantidadeDePessoasFila + pessoasEmbarcadas == capacidade) {
            lotado = true;
            System.out.println(pessoasEmbarcadas + " pessoas embarcaram. Elevador lotado.");
            quantidadeDePessoasFila = 0;
            return;
        }

        if (quantidadeDePessoasFila + pessoasEmbarcadas > capacidade) {
            capacidade = capacidade - pessoasEmbarcadas;
            pessoasEmbarcadas = capacidade;
            lotado = true;
            System.out.println((pessoasEmbarcadas) + " pessoas embarcaram. Elevador lotado. Espere o próximo.");
            pessoasEmbarcadas = capacidade;
            quantidadeDePessoasFila = quantidadeDePessoasFila - pessoasEmbarcadas;

        } else {
            System.out.println("Há " + (capacidade - pessoasEmbarcadas) +" vagas restantes.");
            pessoasEmbarcadas += quantidadeDePessoasFila;
            quantidadeDePessoasFila = quantidadeDePessoasFila - pessoasEmbarcadas;
            System.out.println(pessoasEmbarcadas + " pessoas embarcaram.");
        }
    }
    public void desembarqueElevador() {
        System.out.println(pessoasEmbarcadas + " desembarcaram");
        pessoasEmbarcadas = 0;
    }

    public void elevadorEmMovimento() {
            emMovimento = true;
            gastoDeEnergia += pessoasEmbarcadas;
            System.out.println("Elevador em movimento. Gasto de energia: " + gastoDeEnergia + " unidades.");

            if(predio.horarioDePico == true){
                gastoDeEnergia = 3;
            }else{
                gastoDeEnergia = 0;
            }
    }
    public void mostrarAndarAtual() {
        System.out.println("Andar atual: " + getandarAtual());
    }
}
