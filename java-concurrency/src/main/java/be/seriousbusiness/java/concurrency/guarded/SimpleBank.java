package be.seriousbusiness.java.concurrency.guarded;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBank implements Bank<SimpleBankAccount> {
	private static final Logger LOGGER=LoggerFactory.getLogger(SimpleBank.class);
	private Set<SimpleBankAccount> bankAccounts;
	private boolean waiting,collected,refused;
	private double amount;
	
	public SimpleBank(){
		this.bankAccounts=new HashSet<SimpleBankAccount>();
		this.waiting=false;
		this.collected=false;
		this.refused=false;
	}

	@Override
	public SimpleBankAccount createAccount(final String name,final int code) throws IllegalArgumentException {
		try {
			Thread.sleep(1000); // Sleep 1 second, so the Bank Account number is always unique
		} catch (final InterruptedException e) {
			LOGGER.error("The SimpleBank was interrupted during the creation of a BankAccount",e);
		}
		final SimpleBankAccount bankAccount=new SimpleBankAccount(name,String.valueOf(System.currentTimeMillis()),code);
		bankAccounts.add(bankAccount);
		return bankAccount;
	}

	@Override
	public SimpleBankAccount getAccount(final String number,final int code) {
		for(final SimpleBankAccount bankAccount : bankAccounts){
			if(bankAccount.getNumber().equals(number) && bankAccount.isValid(code)){
				return bankAccount;
			}
		}
		throw new IllegalArgumentException("The given BankAccount could not be found");
	}

	@Override
	public void depositMoney(final String number,final double amount) {
		for(final SimpleBankAccount bankAccount : bankAccounts){
			if(bankAccount.getNumber().equals(number)){
				bankAccount.deposit(amount);
			}
		}
	}

	@Override
	public synchronized boolean collectDebt(final String creditorNumber,final int creditorCode,
			final double amount) throws IllegalArgumentException {
		final SimpleBankAccount bankAccount=getAccount(creditorNumber,creditorCode);
		if(bankAccount==null){
			throw new IllegalArgumentException("Invalid bank account");
		}
		waiting=true;
		this.amount=amount;
		while(waiting && !collected && !refused){
			try {
				LOGGER.info("Waiting for payment of {} EUR to {}",amount,bankAccount.getName());
				wait();
			} catch (final InterruptedException e) {
				LOGGER.error("A debt could not be collected",e);
				return false;
			}
		}
		bankAccount.deposit(amount);
		waiting=false;
		collected=false;
		this.amount=0.0;
		notifyAll(); // Wake up all threads waiting on this SimpleBank's monitor
		return true;
	}

	@Override
	public synchronized boolean payDebt(final String debitorNumber,final int debitorCode) {
		final SimpleBankAccount bankAccount=getAccount(debitorNumber,debitorCode);
		if(bankAccount==null){
			throw new IllegalArgumentException("Invalid bank account");
		}
		if(waiting){
			try{
				bankAccount.withdraw(amount);
				this.collected=true;
				this.refused=false;
				LOGGER.error("Debt of {} EUR payed by {}",amount,bankAccount.getName());
			}catch(final IllegalArgumentException e){
				this.collected=false;
				this.refused=true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		final StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("BankAccounts:").append("\n");
		for(final BankAccount bankAccount : bankAccounts){
			stringBuilder.append(bankAccount).append("\n");
		}
		return stringBuilder.toString();
	}

}
