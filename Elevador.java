public class Elevador extends EntidadeSimulavel {
    private int id;
    private int capacidadeMaxima;
    private Andar andarAtual;
    ListaPassageiros listaPassageiros;
    ListaAndares listaAndares;

    ListaElevadores listaElevadores;

    public Elevador(int id) {
        this.id = id;
        this.capacidadeMaxima = 4;
        this.listaPassageiros = new ListaPassageiros();
    }

    public void setListaAndares(ListaAndares listaAndares) {
        this.listaAndares = listaAndares;
        this.andarAtual = listaAndares.getPrimeiro(); // Agora é seguro acessar
    }

    public void setListaElevadores(ListaElevadores listaElevadores) {
        this.listaElevadores = listaElevadores;
    }

    public void moverParaAndar(Andar andarDestino) {
        System.out.println("Elevador " + id + " começando do térreo.");

        // Encontre o andar de destino na lista de andares
        Andar destino = listaAndares.getAndarPorNumero(andarDestino.getNumero());

        // Laço para mover o elevador até o andar desejado
        while (andarAtual != destino) {
            if (andarAtual.getNumero() < andarDestino.getNumero()) {
                // Movendo o elevador para o próximo andar
                System.out.println("Elevador " + id + " subindo para o andar " + andarAtual.getNumero());
                andarAtual = andarAtual.proximo;  // Avança para o próximo andar
            } else {
                // Movendo o elevador para o andar anterior
                System.out.println("Elevador " + id + " descendo para o andar " + andarAtual.getNumero());
                andarAtual = andarAtual.anterior;  // Retrocede para o andar anterior (caso o destino seja menor)
            }
        }
        andarAtual = destino;
        System.out.println("Elevador " + id + " chegou ao andar " + andarDestino.getNumero());
    }

    //Metodo para chamar um elevador aleatorio
    public Elevador getElevadorAleatorio() {
        int tamanho = listaElevadores.getTamanho();
        int elevadorAleatorio = (int) (Math.random() * tamanho);  // Seleciona um elevador aleatório
        NodeElevador node = listaElevadores.getInicio();
        for (int i = 0; i < elevadorAleatorio; i++) {
            node = node.getProximo();
        }
        return node.getElevador();
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
    public void embarcarPessoas(Elevador elevador, Andar andarAtual) {
        FilaPessoas fila = this.andarAtual.getPessoasAguardando();
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
        this.andarAtual = andarAtual;
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

    //Retorna o andar atual do elevador
    public Andar getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(Andar proximoAndar) {
        this.andarAtual = andarAtual;
    }
}
