package strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicola on 28/06/17.
 */
class Customer {

	private List<Double> drinks;
	private BillingStrategy strategy;

	public Customer(final BillingStrategy strategy) {
		this.drinks = new ArrayList<Double>();
		this.strategy = strategy;
	}

	public void add(final double price, final int quantity) {
		drinks.add(strategy.getActPrice(price*quantity));
	}

	// Payment of bill
	public void printBill() {
		double sum = 0;
		for (Double i : drinks) {
			sum += i;
		}
		System.out.println("Total due: " + sum);
		drinks.clear();
	}

	// Set Strategy
	public void setStrategy(final BillingStrategy strategy) {
		this.strategy = strategy;
	}

}
