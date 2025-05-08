public class ListaAndares {
    Andar primeiro;
    Andar ultimo;

    public ListaAndares() {
        primeiro = null;
        ultimo = null;
    }

    //Insere os andares no fim da lista
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
    //Retorna o primeiro andar
    public Andar getPrimeiro() {
        return primeiro;
    }

    //Metodo para buscar o andar pelo número
    public Andar getAndarPorNumero(int numero) {
        Andar atual = primeiro;
        while (atual != null) {
            if (atual.getNumero() == numero) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;  // Se não encontrar o andar
    }
}
