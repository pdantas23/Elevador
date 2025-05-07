public class Simulador {
    private Predio predio;
    private int tempoSimulado = 0;

    public Simulador(int totalAndares, int totalElevadores) {
        this.predio = new Predio(totalAndares, totalElevadores);
    }

    //Teste da criação dos andares, elevadores e filas
    public void iniciar() {
        System.out.println("Andares e suas filas:");
        Andar andarAtual = predio.getListaAndares().getPrimeiro();
        while (andarAtual != null) {
            System.out.println("- Andar " + andarAtual.getNumero());
            andarAtual.getPessoasAguardando().exibirFila();
            andarAtual = andarAtual.getProximo();
        }

        System.out.println("\nElevadores disponíveis:");
        NodeElevador elevadorAtual = predio.getCentralDeControle().getElevadores().getInicio();
        while (elevadorAtual != null) {
            System.out.println("- Elevador ID: " + elevadorAtual.getElevador().getId());
            elevadorAtual = elevadorAtual.getProximo();
        }
    }
}