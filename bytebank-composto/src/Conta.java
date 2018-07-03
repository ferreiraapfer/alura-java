/**
 * Classe abstrata Conta
 * 
 * Representa uma conta no banco
 * 
 * @author fernanda
 *
 */
public abstract class Conta {

	/**
	 * Valo do aldo da conta
	 */
	protected double saldo;
	/**
	 * Número da agência da conta
	 */
	private int agencia;
	/**
	 * Número da conta
	 */
	private int numero;
	/**
	 * Cliente da conta
	 */
	private Cliente titular;
	/**
	 * Total de ocorrências dessa classe
	 */
	private static int total; // é o mesma referência para objetos diferentes

	/**
	 * Método Contrutor Conta
	 * 
	 * @param agencia
	 * @param numero
	 */
	public Conta(int agencia, int numero) {
		Conta.total++;

		this.agencia = agencia;
		this.numero = numero;
	}

	/**
	 * Método abstrato deposita
	 * 
	 * @param valor a ser adicionado
	 */
	public abstract void deposita(double valor);

	/**
	 * Método saca
	 * 
	 * Retira um valor do saldo da conta
	 * 
	 * @param valor a ser retirado
	 * @return status da realização do saque
	 */
	public boolean saca(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}

		return false;
	}

	/**
	 * Método transfere
	 * 
	 * Faz a transferência de um valor do saldo para outra conta
	 * 
	 * @param valor a ser transferido
	 * @param destino conta destino
	 * @return status da transferência
	 */
	public boolean transfere(double valor, Conta destino) {

		if (this.saldo >= valor) {
			this.saca(valor);
			destino.deposita(valor);
			return true;
		}

		return false;

	}

	/**
	 * Método getSaldo
	 * @return saldo
	 */
	public double getSaldo() {
		return this.saldo;
	}

	/**
	 * Método getNumero()
	 * @return numero
	 */
	public int getNumero() {
		return this.numero;
	}

	/**
	 * Método setNumero()
	 * @param numero
	 */
	public void setNumero(int numero) {
		if (numero <= 0) {
			System.out.println("Não pode valor menor ou igual a 0");
			return;
		}
		this.numero = numero;
	}

	/**
	 * Método getAgencia()
	 * @return
	 */
	public int getAgencia() {
		return this.agencia;
	}

	/**
	 * Método setAgencia()
	 * @param agencia
	 */
	public void setAgencia(int agencia) {
		if (agencia < 0) {
			System.out.println("Não pode valor menor ou igual a 0");
			return;
		}
		this.agencia = agencia;
	}

	/**
	 * Método setTitular
	 * @param titular
	 */
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	/**
	 * Método getTitular
	 * @return
	 */
	public Cliente getTitular() {
		return this.titular;
	}

	/**
	 * Método getTotal
	 * @return
	 */
	public static int getTotal() {
		return Conta.total;
	}

}
