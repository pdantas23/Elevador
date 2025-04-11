package EstruturaDeDados;

public class ListaEncadeadaSimples {
        Node head;

    public ListaEncadeadaSimples() {
        head = null;
    }

    public void inseririnicio(Object valor) {
        Node novoNo = new Node(valor);
        novoNo.proximo = head;
        head = novoNo;
    }
}

