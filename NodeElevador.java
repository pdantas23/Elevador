public class NodeElevador {
    Elevador elevador;
    NodeElevador proximo;

    public NodeElevador(Elevador elevador) {
        this.elevador = elevador;
        this.proximo = null;
    }

    public Elevador getElevador() {
        return elevador;
    }

    public void setElevador(Elevador elevador) {
        this.elevador = elevador;
    }

    public NodeElevador getProximo() {
        return proximo;
    }

    public void setProximo(NodeElevador proximo) {
        this.proximo = proximo;
    }
}
