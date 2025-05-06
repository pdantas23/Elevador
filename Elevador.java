public class Elevador extends EntidadeSimulavel {
    private int id;
    private int capacidade;
    private int andarAtual;
    private boolean emMovimento;
    private boolean lotado;
    private double tempoChegada;
    private int gastoDeEnergia;
    private boolean subindo;
    private int pessoasEmbarcadas;
    LisaPassageiros listaPassageiros;

    public Elevador(int id) {
        this.id = id;
        this.capacidade = 4;
        this.andarAtual = 0;
        this.emMovimento = false;
        this.lotado = false;
        this.tempoChegada = 10;
        this.gastoDeEnergia = 0;
        this.pessoasEmbarcadas = 0;
    }

    public Elevador(int id, int capacidade, double tempoChegada) {
        this.id = id;
        this.capacidade = capacidade;
        this.andarAtual = 0;
        this.emMovimento = false;
        this.lotado = false;
        this.tempoChegada = tempoChegada;
        this.gastoDeEnergia = 0;
        this.pessoasEmbarcadas = 0;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }


    public void desembarqueElevador() {
        System.out.println(pessoasEmbarcadas + " pessoas desembarcaram.");
        pessoasEmbarcadas = 0;
        lotado = false;
    }

    public void mostrarAndarAtual() {
        System.out.println("Elevador " + id + " - Andar atual: " + getAndarAtual());
    }

    public int getId() {
        return id;
    }
    public boolean estaVazio() {
        return passageiros == null || passageiros.getInicio() == null;
    }

    @Override
    public void atualizar(int minutoSimulado) {
        System.out.println("Elevador " + id + " processando minuto " + minutoSimulado);
        // Lógica de movimentação, embarque/desembarque pode ser colocada aqui futuramente
    }
}
