import java.io.Serializable;

public class Andar implements Serializable {
    int numero;
    private Fila pessoasAguardando;
    private PainelElevador painel;

    Andar proximo;
    Andar anterior;

    public Andar(int numero) {
        this.numero = numero;
        this.pessoasAguardando = new Fila();
        this.painel = new PainelElevador();
        this.proximo = null;
        this.anterior = null;
    }

    public int getNumero() {
        return numero;
    }

    public Fila getPessoasAguardando() {
        return pessoasAguardando;
    }

    public PainelElevador getPainel() {
        return painel;
    }

    public Andar getProximo() {
        return proximo;
    }

    public void setProximo(Andar proximo) {
        this.proximo = proximo;
    }

    public Andar getAnterior() {
        return anterior;
    }

    public void setAnterior(Andar anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "Andar " + numero;
    }
}
