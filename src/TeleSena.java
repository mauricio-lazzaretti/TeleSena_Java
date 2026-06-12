public class TeleSena{
    public static final Double valorDeVenda = 10.0; // é o valor que vai ser vendida a teleSena

    // os numeros escolhidos pelo comprador
    private int[] numerosTeleSena1; 
    private int[] numerosTeleSena2;

    public TeleSena(){
        numerosTeleSena1 = Helper.preencheConjunto();//ja instancia sorteando os numeros dos jogos
        numerosTeleSena2 = Helper.preencheConjunto();
    }

    public int[] getNumerosTeleSena1() {
        return numerosTeleSena1;
    }
    public int[] getNumerosTeleSena2() {
        return numerosTeleSena2;
    }
    
}