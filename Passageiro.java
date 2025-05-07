public class Passageiro {
    private int andarDestino;
    private boolean subindo;


    public Passageiro(int andarDestino) {
        this.andarDestino = andarDestino;
        this.subindo = subindo;
    }

    // Getter para o andar de destino
    public int getAndarDestino() {
        return andarDestino;
    }

    // Setter para o andar de destino
    public void setAndarDestino(int andarDestino) {
        this.andarDestino = andarDestino;
    }

    // Getter para saber se o passageiro quer subir ou descer
    public boolean isSubindo() {
        return subindo;
    }

    // Setter para definir a intenção de subir ou descer
    public void setSubindo(boolean subindo) {
        this.subindo = subindo;
    }
}
