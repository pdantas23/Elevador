public class NodeElevador {
    Elevador elevador;
    NodeElevador proximo;

    public NodeElevador(Elevador elevador) {
        this.elevador = elevador;
        this.proximo = null;
    }

    //Retorna o nóElevador
    public Elevador getElevador() {
        return elevador;
    }

    //Retorna o próximo do nóElevador
    public NodeElevador getProximo() {
        return proximo;
    }
}
