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
            andarAtual.getPessoasAguardando().exibirFila();  // Exibindo pessoas aguardando
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

        // Simulação de pressionamento do botão em um andar aleatório
        int andarEscolhido = (int) (Math.random() * 6) + 3;  // Escolhendo um andar aleatório entre 3 e 9
        Andar andarDeDestino = predio.getListaAndares().getAndarPorNumero(andarEscolhido);  // Obtendo o objeto Andar

        if (andarDeDestino != null) {
            PainelExterno painelExterno = andarDeDestino.getPainel();

            // Chamando o elevador através do botão do painel e recebendo o elevador selecionado
            Elevador elevadorEscolhido = painelExterno.pressionarBotao(andarDeDestino, predio.getCentralDeControle().getElevadores());

            System.out.println("\nElevador " + elevadorEscolhido.getId() + " foi chamado para o andar " + andarEscolhido);

            // Teste de embarque
            System.out.println("\nIniciando o embarque...");
            elevadorEscolhido.embarcarPessoas(elevadorEscolhido, elevadorEscolhido.getAndarAtual());
            System.out.println("\nEmbarque concluído!");

            // Mostrar os passageiros embarcados
            System.out.println("\nPessoas embarcadas: ");
            elevadorEscolhido.getListaPassageiros().mostrarPassageiros();

            // Teste de desembarque no próximo andar
            System.out.println("\nIniciando o desembarque no próximo andar...");
            Andar proximoAndar = elevadorEscolhido.getAndarAtual().getProximo();

            if (proximoAndar != null) {
                elevadorEscolhido.setAndarAtual(proximoAndar);  // Atualiza o andar atual para simular o movimento
                elevadorEscolhido.desembarcarPessoas(proximoAndar);  // Desembarca as pessoas
            } else {
                System.out.println("Não há próximo andar para desembarque.");
            }

            System.out.println("\nDesembarque concluído!");
            System.out.println("Elevador vazio? " + elevadorEscolhido.estaVazio());

        } else {
            System.out.println("Erro: andar " + andarEscolhido + " não encontrado.");
        }
    }
}