public class Elevador extends EntidadeSimulavel {
    private int id;
    private int capacidadeMaxima;
    private int andarAtual;
    private boolean emMovimento;
    private boolean lotado;
    private double tempoChegada;
    private int gastoDeEnergia;
    private boolean subindo;
    private int pessoasEmbarcadas;
    ListaPassageiros listaPassageiros;

    public Elevador(int id) {
        this.id = id;
        this.capacidadeMaxima = 4;
        this.andarAtual = 0;
        this.emMovimento = false;
        this.lotado = false;
        this.tempoChegada = 10;
        this.gastoDeEnergia = 0;
        this.pessoasEmbarcadas = 0;
        this.listaPassageiros = new ListaPassageiros();

    }

    //Retorna o andar atual do elevador
    public int getAndarAtual() {
        return andarAtual;
    }

    //Metodo para desembarque
    public void desembarcarPessoas(Andar andarAtual) {
        NodePassageiro atual = listaPassageiros.getInicio();

        while (atual != null) {
            Pessoa passageiro = atual.getPessoa(); // Aqui pegamos o passageiro corretamente
            if (passageiro != null) {  // Verificamos se o passageiro não é nulo antes de fazer qualquer operação
                System.out.println("Passageiro ID: " + passageiro.getId() + " está sendo desembarcado no andar " + andarAtual.getNumero());

                NodePassageiro proximo = atual.getProximo(); // Salva o próximo passageiro antes de removê-lo
                listaPassageiros.remover(atual);  // Remove o passageiro da lista
                atual = proximo;  // Avança para o próximo passageiro
            } else {
                System.out.println("Passageiro nulo encontrado, mas não removido.");
                atual = atual.getProximo(); // Passa para o próximo caso o passageiro seja nulo
            }
        }
    }

    //Metodo para embarcar
    public void embarcarPessoas(Elevador elevador, Andar andar) {
        FilaPessoas fila = andar.getPessoasAguardando();
        int tentativas = fila.getTamanho(); // controla quantas pessoas vamos verificar

        NodePessoa atual = fila.getInicio(); // começa pela primeira pessoa da fila

        int embarcados = listaPassageiros.getTamanho(); // começa com a quantidade de pessoas no elevador

        System.out.println("Tentando embarcar pessoas. Capacidade atual: " + embarcados);
        for (int i = 0; i < tentativas; i++) {
            if (listaPassageiros.getTamanho() >= capacidadeMaxima) {
                System.out.println("Elevador cheio, não pode embarcar mais pessoas.");
                break;
            }

            if (atual == null) {
                System.out.println("Não há mais pessoas na fila.");
                break;
            }

            Pessoa pessoa = atual.getPessoa();
            System.out.println("Embarcando pessoa ID: " + pessoa.getId() + " com destino para andar: " + pessoa.getAndarDestino());

            listaPassageiros.adicionarNoFim(pessoa);
            fila.removerInicio();  // remove a pessoa da fila
            embarcados++; // incrementa o número de embarcados

            atual = fila.getInicio(); // reinicia o ponteiro para o novo início
        }

        System.out.println("Embarque finalizado. Total de passageiros embarcados: " + listaPassageiros.getTamanho());
    }

    //Retorna o id do elevador
    public int getId() {
        return id;
    }

    //Retorna a lista de passageiros
    public ListaPassageiros getListaPassageiros() {
        return listaPassageiros;
    }

    //Verifica se o elevador está vazio
    public boolean estaVazio() {
        return listaPassageiros.getInicio() == null;
    }

    //Verifica se não embarcarão mais pessoas que a capacidade
    private boolean embarcarPessoasMaxima() {
        return listaPassageiros.getTamanho() >= capacidadeMaxima;
    }

    //Simulação do elevador
    @Override
    public void atualizar(int minutoSimulado) {
        System.out.println("Elevador " + id + " processando minuto " + minutoSimulado);
    }
}
