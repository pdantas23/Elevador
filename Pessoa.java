import java.util.Random;

public class Pessoa {
    private int id;
    private int andarOrigem;
    private int andarDestino;
    private boolean dentroElevador;
    private int prioridade;

    public Pessoa(int id, int origem, int destino, int prioridade) {
        this.id = id;
        this.andarOrigem = origem;
        this.andarDestino = destino;
        this.dentroElevador = false;
        this.prioridade = prioridade;
    }

    // Metodo para gerar pessoas aleatórias
    public static Pessoa gerarPessoaAleatoria(int andarOrigem) {
        Random random = new Random();
        int id = random.nextInt(1000); // Gerando ID aleatório
        int destino = gerarDestinoValido(andarOrigem); // Gerar um destino válido
        int prioridade = random.nextInt(3) + 1; // Prioridade aleatória entre 1 e 3

        return new Pessoa(id, andarOrigem, destino, prioridade);
    }

    // Metodo para garantir que o destino não seja o mesmo que o andar de origem
    private static int gerarDestinoValido(int origem) {
        int destino;
        Random random = new Random();

        do {
            destino = random.nextInt(10); // Destino aleatório entre 0 e 10
        } while (destino == origem); // Garante que o destino não seja o andar atual (origem)

        return destino;
    }

    //Retorna a id da pessoa criada
    public int getId() {
        return id;
    }

    //Retorna o andar de destino
    public int getAndarDestino() {
        return andarDestino;
    }

    //Retorna se a pessoa está no elevador ou não
    public boolean isDentroElevador() {
        return dentroElevador;
    }

    //Determina que a pessoa está dentro do elevador
    public void setDentroElevador(boolean dentroElevador) {
        this.dentroElevador = dentroElevador;
    }

    //Retorna a prioridade
    public int getPrioridade() {
        return prioridade;
    }
}