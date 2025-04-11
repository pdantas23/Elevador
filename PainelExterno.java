public class PainelExterno {
    boolean botaoDeChamada;

    public PainelExterno() {
        botaoDeChamada = false;
    }

    public void ChamarElevador() {
        botaoDeChamada = true;
        System.out.println("Elevador chamado");
    }
}
