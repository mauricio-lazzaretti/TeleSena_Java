public class Helper {
    public static int[] preencheConjunto(){
        int inseridos = 0;
        int[] conjunto = new int[25];
        while(inseridos < 25){
            int insercao = (int) ((Math.random() * 60) + 1); // numero aleatorio que vai ser posto no conjunto
            if(!estaDuplicado(conjunto, insercao)){ // verifica se o numero sorteado ja existe no array
                conjunto[inseridos] = insercao;
                inseridos++;
            }
        }
        return conjunto;
    }

    public static int[] AddNumArray(int[] array){

        int[] novoArray = new int[array.length + 1]; // cria um array com uma posição a mais
        for (int i = 0; i < array.length; i++) { // o novo array fica igual, mas com uma posição para ser preenchida
            novoArray[i] = array[i];
        }
        
        int novoNum = 0;
        boolean jaExiste = true;

        while(jaExiste){
            novoNum = (int) ((Math.random() * 60) + 1); // numero aleatorio que vai ser posto no conjunto

            jaExiste = estaDuplicado(novoArray, novoNum);
                
        }

        novoArray[novoArray.length -1] = novoNum; // se ele não exister dentro do conjunto, é adicionado

        return novoArray;
    }

    public static boolean estaDuplicado(int[] array, int numeroVerifica){

        for (int numero : array) { //intera o array
            if(numero == numeroVerifica){return true;} // se houver repetição, retorna true
        }
        return false; // se não houver repetição, retorna false
    }

    public static boolean NomesDuplicados(int[] array, int numeroVerifica, int ate){

        for (int i = 0; i < ate; i++) { //vai ir apenas até onde tem numeros inseridos
            if(array[i] == numeroVerifica){return true;} // se houver repetição, retorna true
        }
        return false; // se não houver repetição, retorna false
    }
}
