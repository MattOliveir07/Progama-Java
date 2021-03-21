package AC2;

/*  Matheus de Jesus Oliveira
	Gabriela Rodrigues Oliveira Lima
	Alessandro Lira Novaes
*/

import java.util.InputMismatchException;
import java.util.Random;

public class BankAccount {
	private static int lastAccountNumber = 1000; // Último número utilizado de conta
	private String owner;
	private int accountNumber; // número da conta
	private double balance; // saldo da conta
	public double totalCPMF = 0; 
	public BankAccount(String owner) {
		
	// chama outro construtor dessa classe com os valores owner e 0, para saldo
	this(owner, 0);
	}
	
	
	public BankAccount(String owner, double saldoConta) {
	accountNumber = lastAccountNumber++;
	this.balance = saldoConta;
	this.owner = owner;
	}
	
	public void deposit(double amount) {
	double newSaldoConta = balance + amount;
	balance = newSaldoConta;
	}
	
	public void saque(double amount) {
	double CPMF = 0.0;
	CPMF = amount*0.25/100;
	double newSaldoConta = (balance - amount) - CPMF;
	balance = newSaldoConta;
	totalCPMF  += CPMF;
	System.out.println("Total CPMF " + totalCPMF);
	
	}
	
	public double getBalance() {
	return balance;
	}
	
	public int getAccountNumber() {
	return accountNumber;
	}
	
	public void transfer(double amount, BankAccount target) {
		this.balance = balance - amount;
		target.balance = target.balance + amount;

		}

	private static String checkName(String owner) {
		if(owner.matches("*.\\d.*")){
			throw new InputMismatchException("O nome contem numeros");
		}else {
			return owner;
		}
	}
	private static String makePassword() {
		Random geradorDeNumeros = new Random();
		int primeiraLetra = 97;
		int ultimaLetra = 122;
		int tamanhoDaString = 3;
		String letras = geradorDeNumeros.ints(primeiraLetra, ultimaLetra + 1)
				.limit(tamanhoDaString)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();
		StringBuilder senha = new StringBuilder();

		senha.append(letras);
		for(int i = 0; i<=3; i++) {
			int parteNumericaDaSenha = geradorDeNumeros.nextInt(9);
			senha.append(String.valueOf(parteNumericaDaSenha));

		}
		return senha.toString();
		
		}

	public String toString() {
	return "Conta de " + owner + " - Saldo de R$ " + balance;
	
	}
	
}







