public class App {
    public static void main(String[] args) throws Exception {
        ControleTeleSena c = new ControleTeleSena();

        c.verificaGanhador(); // os ganhadores que acertaram os números
        c.ExibeGanhadores(); // exibe os dados para saberem quem ganhou
        c.VendasELucro(); // relatorio para o silvio santos saber quanto faturou

    }
}
