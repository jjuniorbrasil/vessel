package contabanco;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String args[]) {
        Scanner myScan = new Scanner(System.in);
        
        ContaTerminal conta = new ContaTerminal();
        System.out.print("Nome: ");
        conta.setNomeCliente(myScan.nextLine());
        System.out.print("Número: ");
        conta.setNumero(myScan.nextInt());
        System.out.print("Agência: ");
        conta.setAgencia(myScan.next());
        System.out.print("Saldo: ");
        conta.setSaldo(new BigDecimal(myScan.nextInt()));
        
        System.out.println(conta.toString());
    }
}
