package be.seriousbusiness.java.concurrency.guarded;

public class SimpleBankAccount implements BankAccount{
	private String name,number;
	private double amount;
	private int code;
	
	public SimpleBankAccount(final String name,final String number,final int code) throws IllegalArgumentException {
		setName(name);
		setNumber(number);
		setCode(code);
	}
	
	private void setName(final String name) throws IllegalArgumentException{
		if(name==null || name.isEmpty()){
			throw new IllegalArgumentException("The name is null or empty");
		}
		this.name=name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	private void setNumber(final String number) throws IllegalArgumentException{
		if(number==null || number.isEmpty()){
			throw new IllegalArgumentException("The number is null or empty");
		}
		this.number=number;
	}

	@Override
	public String getNumber() {
		return number;
	}
	
	/**
	 * Add an amount of money to this bank account
	 * @param amount
	 */
	protected void deposit(final double amount){
		this.amount+=amount;
	}
	
	/**
	 * Withdraw an amount of money from this bank account
	 * @param amount
	 * @throws IllegalArgumentException when 
	 */
	protected void withdraw(final double amount) throws IllegalArgumentException{
		if(amount<0 || this.amount<amount){
			throw new IllegalArgumentException("The amount is negative or not enough money is available on this bank account");
		}
		this.amount-=amount;
	}

	@Override
	public double getAmount() {
		return amount;
	}
	
	private void setCode(final int code) throws IllegalArgumentException{
		if(code<1000 || code>9999){
			throw new IllegalArgumentException("The code is negative or not between 1000 and 9999");
		}
		this.code=code;
	}

	@Override
	public boolean isValid(int code) {
		return this.code==code;
	}
	
	@Override
	public String toString(){
		return name + " - " + number + " - " + amount + " EUR";
	}

}
