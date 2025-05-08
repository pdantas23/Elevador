public class Simulador {
    private Predio predio;
    private int tempoSimulado = 0;

    public Simulador(int totalAndares, int totalElevadores) {
        this.predio = new Predio(totalAndares, totalElevadores);
    }

    //Teste da criação dos andares, elevadores e filas
    public void iniciar() {
        // Exibindo andares e suas filas
        System.out.println("Andares e suas filas:");
        Andar andarAtual = predio.getListaAndares().getPrimeiro();
        while (andarAtual != null) {
            System.out.println("- Andar " + andarAtual.getNumero());
            andarAtual.getPessoasAguardando().exibirFila();
            andarAtual = andarAtual.getProximo();
        }

        // Exibindo elevadores disponíveis
        System.out.println("\nElevadores disponíveis:");
        NodeElevador elevadorAtual = predio.getCentralDeControle().getElevadores().getInicio();
        while (elevadorAtual != null) {
            System.out.println("- Elevador ID: " + elevadorAtual.getElevador().getId());
            elevadorAtual = elevadorAtual.getProximo();
        }


        // Obtendo o primeiro elevador e o primeiro andar
        NodeElevador elevador1 = predio.getCentralDeControle().getElevadores().getInicio();
        Elevador elevador = elevador1.getElevador();
        Andar primeiroAndar = predio.getListaAndares().getPrimeiro();

        System.out.println("\nElevador vazio? " + elevador.estaVazio());

        // Teste de embarque
        System.out.println("\nIniciando o embarque...");
        elevador.embarcarPessoas(elevador, primeiroAndar);
        System.out.println("\nEmbarque concluído!");

        System.out.println("\nElevador vazio? " + elevador.estaVazio());

        // Mostrar os passageiros embarcados
        System.out.println("\nPessoas embarcadas: ");
        elevador.listaPassageiros.mostrarPassageiros();

        // Determina o próximo andar
        Andar proximoAndar = predio.getListaAndares().getPrimeiro().getProximo();

        // Teste de desembarque no próximo andar
        System.out.println("\nIniciando o desembarque no próximo andar...");
        if (elevador1 != null && proximoAndar != null) {
            elevador1.getElevador().desembarcarPessoas(proximoAndar);  // Desembarca pessoas no próximo andar
        }
        System.out.println("\nDesembarque concluído!");

        System.out.println("Elevador vazio? " + elevador.estaVazio());

    }
}