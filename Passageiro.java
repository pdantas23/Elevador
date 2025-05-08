public class Passageiro extends Pessoa {

    public Passageiro(Pessoa pessoa) {
        super(pessoa.getId(), pessoa.getAndarOrigem(), pessoa.getAndarDestino(), pessoa.getPrioridade());
        setDentroElevador(true); // Já marca como dentro do elevador
    }

    public Pessoa getPessoa() {
        // Retorna o objeto da classe Pessoa original que o Passageiro representa
        return new Pessoa(getId(), getAndarOrigem(), getAndarDestino(), getPrioridade());
    }


    @Override
    public String toString() {
        return "Passageiro ID: " + getId() +
                ", Origem: " + getAndarOrigem() +
                ", Destino: " + getAndarDestino() +
                ", Prioridade: " + getPrioridade();
    }
}
