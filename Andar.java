class Andar {
    int numero;
    int capacidade;
    boolean lotado;
    boolean andarPrioritario;

    public Andar(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        lotado = false;
        andarPrioritario = false;
    }
}
