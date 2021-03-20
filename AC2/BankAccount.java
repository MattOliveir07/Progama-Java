package AC2;



public class BankAccount {
	private static int lastAccountNumber = 1000; // Último número utilizado de conta
	private String proprietario;
	private int accountNumber; // número da conta
	private double saldoConta; // saldo da conta
	public double totalCPMF = 0; 
	public BankAccount(String proprietario) {
		
	// chama outro construtor dessa classe com os valores owner e 0, para saldo
	this(proprietario, 0);
	}
	
	
	public BankAccount(String proprietario, double saldoConta) {
	accountNumber = lastAccountNumber++;
	this.saldoConta = saldoConta;
	this.proprietario = proprietario;
	}
	
	public void deposit(double valor) {
	double newSaldoConta = saldoConta + valor;
	saldoConta = newSaldoConta;
	}
	
	public void saque(double valor) {
	double CPMF = 0.0;
	CPMF = valor*0.25/100;
	double newSaldoConta = (saldoConta - valor) - CPMF;
	saldoConta = newSaldoConta;
	totalCPMF  += CPMF;
	System.out.println("CPMF " + totalCPMF);
	
	}
	
	public double getBalance() {
	return saldoConta;
	}
	
	public int getAccountNumber() {
	return accountNumber;
	}
	
	public void transfer(double valor, BankAccount target) {
		this.saldoConta = saldoConta - valor;
		target.saldoConta = target.saldoConta + valor;

		}
	/*
	private static String checkName(String proprietario) {
		return proprietario;
		// instruções do método a ser desenvolvido
		}
	
	private static String makePassword() {
		return owner;
		// instruções do método a ser desenvolvido
		}*/

	public String toString() {
	return "Conta de " + proprietario + " - Saldo de R$ " + saldoConta;
	}
	
}







