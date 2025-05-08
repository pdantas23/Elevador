import java.io.Serializable;

public class PainelExterno implements Serializable {
    private int andar;
    private boolean botao; // Andar onde o painel está localizado

    // Construtor que inicializa o andar do painel
    public PainelExterno(int numero) {
        this.andar = numero;  // Atribui o valor passado para a variável andar
        this.botao = false;  // Inicializa o botão como não pressionado
    }

    // Metodo que chama o elevador (pressionar o botão)
    public void pressionarBotao(Elevador elevador) {
        botao = true;
        System.out.println("Botão do painel externo pressionado no andar " + andar);
    }

    // Metodo para retornar o andar do painel
    public int getAndar() {
        return andar; // Retorna o andar onde o painel está localizado
    }

    // Método para verificar o estado do botão
    public boolean isBotaoPressionado() {
        return botao;
    }
}
