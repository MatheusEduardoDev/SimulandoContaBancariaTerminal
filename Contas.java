package simulandoContaBancaria; 

import java.util.ArrayList;

public class Contas {

    public static ArrayList<ContaBancaria> conta;

    public static ArrayList<ContaBancaria> getConta() {
        if (conta == null) {
            conta = new ArrayList<>();
        }
        return conta;
    }

    public void criarConta(ContaBancaria contaB, String nome) {
        contaB.setNumero((int) (Math.random() * 9999));
        contaB.setNomeCliente(nome);
        getConta().add(contaB);
    }

    public void verContas() {
        for (int i = 0; i < conta.size(); i++) {
            System.out.print("Conta: " + conta.get(i).getNumero());
            System.out.print(" Proprietario: " + conta.get(i).getNomeCliente());
            System.out.print(" Saldo: " + conta.get(i).getSaldo());
            System.out.println(" Agencia: " + conta.get(i).getAgencia());
        }
    }
}
