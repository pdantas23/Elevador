import java.io.Serializable;

public class PainelElevador implements Serializable {
    private boolean botaoSubirAtivado;
    private boolean botaoDescerAtivado;

    public PainelElevador() {
        this.botaoSubirAtivado = false;
        this.botaoDescerAtivado = false;
    }

    //Metodo subir - botão interno
    public void pressionarSubir() {
        botaoSubirAtivado = true;
    }

    //Metodo descer - botão interno
    public void pressionarDescer() {
        botaoDescerAtivado = true;
    }

    //Retorna se o botão subir foi ativado
    public boolean isBotaoSubirAtivado() {
        return botaoSubirAtivado;
    }

    //Retorna se o botão descer foi ativado
    public boolean isBotaoDescerAtivado() {
        return botaoDescerAtivado;
    }
}
