package util;

public class CurrencyConverter {
	
	public static final double IOF = 0.06;
	
	public static double dollarToReal(double dollarPrice, double dollarsToBeBought) {
		double amount = dollarPrice * dollarsToBeBought;
		double transactionIOF = amount * IOF;
		return amount + transactionIOF;
	}
}
