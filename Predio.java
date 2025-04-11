public class Predio extends EntidadeSimulavel {
    int quantidadeAndares;
    boolean horarioDePico;

    CentralDeControle centralDeControle;
    ListaAndares listaAndares;

    public Predio(int quantidadeAndares, int quantidadeElevadores, boolean horarioDePico) {
        this.quantidadeAndares = quantidadeAndares;
        this.horarioDePico = horarioDePico;

        this.centralDeControle = new CentralDeControle(quantidadeElevadores);
        this.listaAndares = new ListaAndares();

        for (int i = 0; i < quantidadeAndares; i++) {
            listaAndares.inserirFim(new Andar(i));
        }
    }

    @Override
    public void atualizar(int minutoSimulado) {
        centralDeControle.atualizar(minutoSimulado);
    }
}