import EstruturaDeDados.ListaEncadeadaSimples;

public class CentralDeControle {
    int tipoComportamento;
    Predio predio;
    ListaEncadeadaSimples listaElevadores; // Usando ListaSimples no lugar de List/ArrayList

    public CentralDeControle(Predio predio, int numElevadores) {
        this.predio = predio;
        this.listaElevadores = new ListaEncadeadaSimples(); // Inicializa a lista

        for (int i = 0; i < numElevadores; i++) {
            // Cria um elevador (capacidade 4, total de andares 10, começa no andar 1)
            Elevador e = new Elevador(4, 10, 1, predio);

            // Adiciona o elevador na ListaSimples
            listaElevadores.inseririnicio(e);
        }
    }
}
     /**public void iniciarCentralDeControle(){
         System.out.println("Iniciando central de controle");

         if(predio.horarioDePico == true){
             System.out.println("O horário atual é de pico.");
             tipoComportamento = 1;
             elevador.gastoDeEnergia = 3;
         }else{
             System.out.println("O horário atual não é de pico.");
             tipoComportamento = 2;
         }
     }
}*/