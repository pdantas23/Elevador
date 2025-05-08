import java.io.Serializable;
import java.util.Random;

public class PainelExterno implements Serializable {
    private int andar;
    private boolean botao;
    ListaElevadores listaElevadores;

    // Construtor que inicializa o andar do painel
    public PainelExterno(int numero) {
        this.andar = numero;  // Atribui o valor passado para a variável andar
        this.botao = false;  // Inicializa o botão como não pressionado
    }

    // Metodo que chama o elevador (pressionar o botão)
    public Elevador pressionarBotao(Andar andarDestino, ListaElevadores listaElevadores) {
        Random random = new Random();

        NodeElevador nodeElevador = listaElevadores.getInicio();
        int tamanho = listaElevadores.getTamanho();

        if (nodeElevador == null) {
            System.out.println("Nenhum elevador disponível.");
            return null;
        }

        int elevadorEscolhidoIndex = random.nextInt(tamanho);
        int contador = 0;

        while (nodeElevador != null) {
            if (contador == elevadorEscolhidoIndex) {
                Elevador elevadorEscolhido = nodeElevador.getElevador();

                System.out.println("Botão pressionado no andar " + andarDestino.getNumero() +
                        ". Elevador " + elevadorEscolhido.getId() + " foi chamado.");

                elevadorEscolhido.moverParaAndar(andarDestino);
                elevadorEscolhido.setAndarAtual(andarDestino); // Atualiza o estado interno do elevador

                return elevadorEscolhido; // <- retorna o elevador usado
            }
            nodeElevador = nodeElevador.getProximo();
            contador++;
        }

        return null; // caso algo dê errado
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
