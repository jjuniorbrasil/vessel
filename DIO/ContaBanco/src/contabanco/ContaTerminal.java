
package contabanco;

import java.math.BigDecimal;

public class ContaTerminal { 
    private int numero;
    private String agencia;
    private String nomeCliente;
    private BigDecimal saldo;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nOlá, " + nomeCliente + ", obrigado por criar uma conta em nosso banco,\nsua agência é '"
        + agencia + "', conta '" + numero + "' e seu saldo '"+ saldo +"' já está disponível para saque.";
    }

    
}
