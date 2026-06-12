public class ControleTeleSena{
    private Pessoa[] pessoas;
    private Pessoa[] ganhadores;
    private int qtdGanhadores; //

    public ControleTeleSena(){
        pessoas = new Pessoa[20];
        ganhadores = new Pessoa[20];
        this.qtdGanhadores = 0;

        for (int index = 0; index < pessoas.length; index++) {
            pessoas[index] = new Pessoa(); 
        }
        this.qtdGanhadores = 0;

    }

    public int[] numerosSorteioTeleSena(){
        return Helper.preencheConjunto(); // sorteia os números da telesena sem repetir nenhum
    }

    public void ExibeNumeroSorteados(int[] nums){
        System.out.println("Números Sorteados:");
        for (int num : nums) {
            //try{ Thread.sleep(200); } catch(Exception e){}

            System.out.print(num+" - "); // imprime todos os números sorteados
        }
        System.out.print("\n\n");
    }

    private int gerenciaTotalVendas(){ // retorna o numero de vendas da teleSena
        int qtdTotal = 0;
        for (Pessoa pessoa : this.pessoas) {
            qtdTotal += pessoa.getListaTele().length;
        }
        return qtdTotal;
    }

    public Pessoa[] verificaGanhador(){

        int[]numerosSorteio = numerosSorteioTeleSena(); // faz o sorteio ao vivo na televvisão

        while(qtdGanhadores == 0)
        {

            ExibeNumeroSorteados(numerosSorteio); //mostra cada bolinha pro público

            for (Pessoa pessoa : this.pessoas) // intera todas as pessoas
            {
                TeleSena[] listaTele = pessoa.getListaTele();
                for (TeleSena teleSena : listaTele) { // todos os jogos de cada pessoa

                    int contadorDeAcertosC1 = 0;
                    int contadorDeAcertosC2 = 0;

                    int[] numerosEscolhidosC1 = teleSena.getNumerosTeleSena1(); // pega cada conjunto de numeros chutados pela pessoa
                    int[] numerosEscolhidosC2 = teleSena.getNumerosTeleSena2();

                    for (int num : numerosEscolhidosC1) { //numeros que a pessoa apostou
                        if(Helper.estaDuplicado(numerosSorteio, num)){ //publico confere um jogo
                            contadorDeAcertosC1++;
                        }
                    }

                    for (int num : numerosEscolhidosC2) { //numeros que a pessoa apostou
                        if(Helper.estaDuplicado(numerosSorteio, num)){ // publico confere outro jogo
                            contadorDeAcertosC2++;
                        }
                    }

                    if(contadorDeAcertosC1 == 25 || contadorDeAcertosC2 == 25){ //se tiver acertado 25 em qualquer um, leva o premio
                        boolean jaConsta = false;

                        for (int index = 0; index < qtdGanhadores; index++) { // verifica se a pessoa ja consta na lista de ganhadores
                            if(ganhadores[index] == pessoa){
                                jaConsta = true;
                                break;
                            }
                        }

                        if(!jaConsta){ // se a pessoa não consta, pode ser adicionada a lista
                            this.ganhadores[qtdGanhadores] = pessoa;
                            qtdGanhadores++;
                        }
                    }
                }
            }

            if(qtdGanhadores == 0) {
                System.out.println("Nenhum ganhador ainda... sorteando mais um número!\n");
                try{ Thread.sleep(500); } catch(Exception e){} // uma respirada para ajudar na visualização
                numerosSorteio = Helper.AddNumArray(numerosSorteio); // se não houver ganhadores, ele recorre ao helper que add um numero aleatorio a mais no array
            }
        }
        return ganhadores;
    }

    public void ExibeGanhadores(){
        double totalVendas = gerenciaTotalVendas() * TeleSena.valorDeVenda; //multiplica pelo valor de cada telesena
        double premio = totalVendas * 0.8 / this.qtdGanhadores; // 80% do valor é o premio

        System.out.println("===== GANHADORES DA TELESENA =====");
        try{ Thread.sleep(2000); } catch(Exception e){} // pausa de 2 seg para dar um suspense

        System.out.println(this.qtdGanhadores+ (this.qtdGanhadores == 1 ? " sortudo foi vencedor" :  " sortudos foram vencedores")+" dessa edição!!!");
        System.out.println(this.qtdGanhadores == 1 ? "E O NOME DELE É..." : "E O NOME DELES É...");
        
        try{ Thread.sleep(2000); } catch(Exception e){} // pausa de 2 seg para dar um suspense DE NOVO

        for (int i = 0; i < this.qtdGanhadores; i++) 
        {
            Pessoa pessoa = ganhadores[i];
            pessoa.setValorPremiado(premio);
            System.out.printf("Nome do %d° ganhador: %s \n", i+1, pessoa.getNome());
            System.out.printf("Premio do %d° ganhador: R$ %.2f%n", i+1, pessoa.getValorPremiado());           
           // System.out.println();
        }
        System.out.println("=======================================\n");
    }

    public void VendasELucro(){
        double totalVendas = gerenciaTotalVendas() * TeleSena.valorDeVenda; //multiplica pelo valor de cada telesena
        double lucro = totalVendas * 0.2; // 20% do valor é o lucro

        System.out.println("========== DADOS SILVIO SANTOS ==========");
        
        System.out.printf("Total arrecadado: %.2f%n", totalVendas);
        System.out.printf("Total de lucro: %.2f%n", lucro);     
        System.out.println("Unidades vendidas: "+ gerenciaTotalVendas());       
        
        System.out.println("=======================================");
    }
}