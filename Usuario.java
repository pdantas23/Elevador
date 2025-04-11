class Usuario {
    enum Prioridade {
        ALTA, MEDIA, BAIXA
    }

    int destino;
    Prioridade prioridade;
    double tempoChegada;

    public Usuario(int destino, Prioridade prioridade) {
        this.destino = destino;
        this.prioridade = prioridade;
        this.tempoChegada = 0;
    }
}
