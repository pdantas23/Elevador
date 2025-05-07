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
    ListaPassageiros listaPassageiros;

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

    //Retorna o andar atual do elevador
    public int getAndarAtual() {
        return andarAtual;
    }

    //Retorna o id do elevador
    public int getId() {
        return id;
    }

    //Verifica se o elevador está vazio
    public boolean estaVazio() {
        if(listaPassageiros == null) {
            return true;
        }
        return false;
    }

    //Simulação do elevador
    @Override
    public void atualizar(int minutoSimulado) {
        System.out.println("Elevador " + id + " processando minuto " + minutoSimulado);
    }
}
