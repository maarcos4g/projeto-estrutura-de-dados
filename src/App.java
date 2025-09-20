import models.Conta;

public class App {
    public static void main(String[] args) throws Exception {
        Conta conta = new Conta(12345679, "Marcos Paulo Cardoso dos Santos", "000.000.000-00", "Corrente");
        System.out.println(conta.toString());
    }
}
