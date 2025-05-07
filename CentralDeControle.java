public class CentralDeControle extends EntidadeSimulavel {
    private ListaElevadores listaElevadores;

    //Cria a lista de elevadores
    public CentralDeControle() {
        listaElevadores = new ListaElevadores();
    }

    //Adiciona o elevador a lista de elevadores
    public void adicionarElevador(Elevador elevador) {
        listaElevadores.inserir(elevador);
    }

    //Atualiza o elevador atual na simulação
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
