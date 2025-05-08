public class Predio extends EntidadeSimulavel {
    private int quantidadeAndares;
    private CentralDeControle centralDeControle;
    private ListaAndares listaAndares;

    //Instancia a central de controle, a lista de andares e adiciona os elevadores a central de controle
    public Predio(int quantidadeAndares, int quantidadeElevadores) {
        this.quantidadeAndares = quantidadeAndares;

        this.centralDeControle = new CentralDeControle();
        this.listaAndares = new ListaAndares();

        for (int i = 0; i < quantidadeAndares; i++) {
            listaAndares.inserirFim(new Andar(i));
        }

        for (int i = 0; i < quantidadeElevadores; i++) {
            Elevador e = new Elevador(i + 1);
            e.setListaAndares(listaAndares);
            centralDeControle.adicionarElevador(e);
        }
    }

    // Metodo para acessar a lista de andares
    public ListaAndares getListaAndares() {
        return this.listaAndares;
    }

    @Override
    public void atualizar(int minutoSimulado) {
        // Atualiza o estado dos elevadores através da CentralDeControle
        centralDeControle.atualizar(minutoSimulado);
    }

    //Retorna a central de controle
    public CentralDeControle getCentralDeControle() {
        return centralDeControle;
    }

    public Andar getAndar(int andarEscolhido) {
        Andar atual = listaAndares.getPrimeiro();
        while (atual != null) {
            if (atual.getNumero() == andarEscolhido) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null; // Caso não encontre o andar
    }
}