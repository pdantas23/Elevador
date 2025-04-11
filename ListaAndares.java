public class ListaAndares {
    Andar primeiro;
    Andar ultimo;

    public ListaAndares() {
        primeiro = null;
        ultimo = null;
    }

    public void inserirFim(Andar novo) {
        if (primeiro == null) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            novo.anterior = ultimo;
            ultimo = novo;
        }
    }

    public Andar getPrimeiro() {
        return primeiro;
    }

    public void imprimir() {
        Andar atual = primeiro;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.proximo;
        }
    }
}
