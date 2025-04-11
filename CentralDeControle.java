public class CentralDeControle extends EntidadeSimulavel {
    private ListaElevadores listaElevadores;

    public CentralDeControle(int numElevadores) {
        listaElevadores = new ListaElevadores();

        for (int i = 0; i < numElevadores; i++) {
            Elevador e = new Elevador(i + 1); // ID começa em 1
            listaElevadores.inserir(e);
        }
    }

    @Override
    public void atualizar(int minutoSimulado) {
        NodeElevador atual = listaElevadores.getInicio();
        while (atual != null) {
            atual.getElevador().atualizar(minutoSimulado);
            atual = atual.getProximo();
        }
    }

    public ListaElevadores getElevadores() {
        return listaElevadores;
    }
}
