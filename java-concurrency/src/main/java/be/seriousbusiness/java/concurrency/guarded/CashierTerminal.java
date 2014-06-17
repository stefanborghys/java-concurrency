package be.seriousbusiness.java.concurrency.guarded;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CashierTerminal extends Thread {
	private static final Logger LOGGER=LoggerFactory.getLogger(SimpleBank.class);
	private Bank<SimpleBankAccount> bank;
	private SimpleBankAccount bankAccount;
	private int code;
	private Queue<Double> amounts;
	
	public CashierTerminal(final Bank<SimpleBankAccount> bank,final SimpleBankAccount bankAccount,final int code){
		this.bank=bank;
		this.bankAccount=bankAccount;
		this.code=code;
		this.amounts=new LinkedList<Double>();
	}

	@Override
	public void run() {
		while(true){
			if(isInterrupted()){
				break;
			}
			final Double amount=amounts.poll();
			if(amount!=null){
				bank.collectDebt(bankAccount.getNumber(),code,amount);
				LOGGER.info("{}",bankAccount);
			}
		}
	}
	
	public void addDebt(final double amount){
		amounts.add(amount);
	}

}
