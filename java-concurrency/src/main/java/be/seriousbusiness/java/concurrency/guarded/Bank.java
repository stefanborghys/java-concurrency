package be.seriousbusiness.java.concurrency.guarded;

/**
 * Describes a Bank maintaining bank accounts.</br>
 * It's responsible for the creation and retrieval of bank accounts.</br>
 * The bank manages the transfer of money onto a bank account or between two bank accounts.
 * @author seriousbusiness
 *
 * @param <A>
 */
public interface Bank<A extends BankAccount> {
	/**
	 * Creates a new BankAccount.
	 * @param name
	 * @param code
	 * @return
	 */
	A createAccount(final String name,final int code);
	
	/**
	 * Retrieve a BankAccount by number and correct code.
	 * @param number
	 * @param code
	 * @return
	 */
	A getAccount(final String number,final int code);
	
	/**
	 * Deposit an amount of money onto by using the bank account's number
	 * @param number
	 * @param amount
	 */
	void depositMoney(final String number,final double amount);
	
	/**
	 * Ask the bank to collect a debt for a given bank account number and amount.
	 * @param creditorNumber
	 * @param creditorCode
	 * @param amount
	 * @return
	 */
	boolean collectDebt(final String creditorNumber,final int creditorCode,final double amount);
	
	/**
	 * Pay a debt with a given bank account number.
	 * @param debitorNumber
	 * @param debitorCode
	 * @return
	 */
	boolean payDebt(final String debitorNumber,final int debitorCode);
	
}
