package be.seriousbusiness.java.concurrency.guarded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuardedBlockExample {
	private static final Logger LOGGER=LoggerFactory.getLogger(GuardedBlockExample.class);
	
	public static void main(final String[] args){
		final Bank<SimpleBankAccount> bank=new SimpleBank();
		SimpleBankAccount karen=bank.createAccount("Karen",1234);
		SimpleBankAccount erik=bank.createAccount("Erik",3333);
		SimpleBankAccount elke=bank.createAccount("Elke",5555);
		bank.depositMoney(karen.getNumber(),2000.0);
		bank.depositMoney(erik.getNumber(),500.99);
		bank.depositMoney(elke.getNumber(),300.24);
		LOGGER.debug("> {}",karen);
		LOGGER.debug("> {}",erik);
		LOGGER.debug("> {}",elke);
		final CashierTerminal cashierTerminal=new CashierTerminal(bank,erik,3333);
		cashierTerminal.addDebt(20.14);
		cashierTerminal.addDebt(34.20);
		cashierTerminal.addDebt(70.99);
		cashierTerminal.start();
		bank.payDebt(karen.getNumber(),1234);
		LOGGER.debug("> {}",karen);
		bank.payDebt(elke.getNumber(),5555);
		LOGGER.debug("> {}",elke);
		//cashierTerminal.interrupt();
	}
}
