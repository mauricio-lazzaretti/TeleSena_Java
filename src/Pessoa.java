public class Pessoa {
    private String nome; // nome da pessoa
    private TeleSena[] listaTele; //teleSenas compradas
    private Double valorPremiado;
    private static int[] indicesUsados = new int[20]; // lista para fazer uma verificação de duplicidade de pessoas(nomes)
    private static int qtdIndices = 0;
    
    public Pessoa(){
        String[] bancoDeNomes = //os nomes que vão ser sorteados aleatoriamente
        {
            "Walter", "Jesse", "Rick", "Daryl", "Michonne",
            "Ragnar", "Lagertha", "Yuji", "Satoru", "Matt",
            "Harry", "Roger", "Amanda", "Felipe", "Camila",
            "Lucas", "Juliana", "Bruno", "Fernanda", "Thiago"
        };
 
        int indice;
        do{
            indice = (int) (Math.random() * 20); // do 0 ao 19, que é exatamente o espaço do array de 20 posic

        }while(Helper.NomesDuplicados(indicesUsados, indice, qtdIndices)); // usa a verificação de duplicidade utilizando o helper

        indicesUsados[qtdIndices] = indice;
        qtdIndices++;

        String nomeBatizado = bancoDeNomes[indice];// pega o nome do banco no indice aleatorio

        this.nome = nomeBatizado; // seta o nome no atributo

        int qtdTeleSenas = (int) (Math.random() * 15) + 1; // sorteia a quantidade de telesenas de 1 a 15(máximo)

        this.listaTele = new TeleSena[qtdTeleSenas];

        for (int index = 0; index < listaTele.length; index++) {
            listaTele[index] = new TeleSena(); // instancia as telesenas na lista
        }
    }

    public String getNome() {
        return nome;
    }

    public TeleSena[] getListaTele() {
        return listaTele;
    }

    public void setValorPremiado(Double valorPremiado) {
        this.valorPremiado = valorPremiado;
    }

    public Double getValorPremiado() {
        return valorPremiado;
    }

    
}
