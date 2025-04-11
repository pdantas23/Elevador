import EstruturaDeDados.ListaEncadeadaSimples;

public class Predio {
    int quantidadeAndares;
    int quantidadeElevadores;
    boolean horarioDePico;
    CentralDeControle centralDeControle;
    ListaEncadeadaSimples listaChegada;

    public Predio(int quantidadeAndares, int quantidadeElevadores, boolean horarioDePico) {
        this.quantidadeAndares = quantidadeAndares;
        this.quantidadeElevadores = quantidadeElevadores;
        this.horarioDePico = horarioDePico;
    }

    public int getQuantidadeElevadores() {
        return quantidadeElevadores;
    }

    public int getAndares() {
        return quantidadeAndares;
    }

    public void quantidadeDeAndares(){
        System.out.println("Quantidade de andares: " + getAndares());
    }

    public void quantidadeDeElevadores(){
        System.out.println("Quantidade de elevadores: " + getQuantidadeElevadores());
    }

}
