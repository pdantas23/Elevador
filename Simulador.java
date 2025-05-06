public class Simulador {
    private Predio predio;
    private int tempoSimulado = 0;

    public Simulador(int totalAndares, int totalElevadores) {
        this.predio = new Predio(totalAndares, totalElevadores);
    }

    public void iniciar() {
        System.out.println("== INICIANDO SIMULADOR ==");

        while (tempoSimulado < 30) { // Simula 30 ciclos
            System.out.println("\n== CICLO " + tempoSimulado + " ==");

            // Percorre elevadores
            NodeElevador atualElevador = predio.getElevadores().getInicio();
            while (atualElevador != null) {
                Elevador elevador = atualElevador.getElevador();

                if (elevador.estaVazio()) {
                    Andar chamado = predio.buscarAndarComFila();
                    if (chamado != null) {
                        elevador.moverPara(chamado.getNumero());
                        embarcarPessoas(elevador, chamado);
                    }
                } else {
                    int proximoDestino = elevador.getDestinoMaisProximo();
                    elevador.moverPara(proximoDestino);

                    // Desembarque
                    elevador.desembarcarNoAndar(predio.getAndar(proximoDestino));
                }

                atualElevador = atualElevador.getProximo();
            }

            tempoSimulado++;
            try {
                Thread.sleep(1000); // Simula tempo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void embarcarPessoas(Elevador elevador, Andar andar) {
        System.out.println("Elevador " + elevador.getId() + " embarcando no andar " + andar.getNumero());
        FilaPessoas fila = andar.getPessoasAguardando();

        while (!fila.estaVazia() && !elevador.estaLotado()) {
            NodePessoa node = fila.removerPessoaComMaiorPrioridade();
            Pessoa pessoa = node.getPessoa();
            pessoa.entrarElevador();
            elevador.embarcar(pessoa);
            System.out.println("Pessoa " + pessoa.getId() + " embarcou (destino: " + pessoa.getAndarDestino() + ")");
        }
    }
}
