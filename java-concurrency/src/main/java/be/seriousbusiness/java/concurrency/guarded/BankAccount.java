package be.seriousbusiness.java.concurrency.guarded;

public interface BankAccount {
	/**
	 * Get the cardholder's name
	 * @return
	 */
	String getName();
	
	/**
	 * Get the bank account number
	 * @return
	 */
	String getNumber();
	
	/**
	 * Get the available amount of money.
	 * @return
	 */
	double getAmount();
	
	/**
	 * Verify the bank account's code
	 * @param code
	 * @return
	 */
	boolean isValid(final int code);
}
