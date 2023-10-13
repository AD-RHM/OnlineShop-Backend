package Online_shop_BackEnd;

import java.util.Arrays;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;

	private String creditCardNumber;
	private Product[] products;
	private int customerId;

	@Override
	public boolean isCreditCardNumberValid(String creditCardNumber) {
		return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER
				&& !creditCardNumber.contains(" ") 
				&& Long.parseLong(creditCardNumber) > 0;
	}

	@Override
	public void setCreditCardNumber(String userInput) {
		if (isCreditCardNumberValid(userInput)) {
			this.creditCardNumber = userInput;
		}

	}

	@Override
	public void setProducts(Product[] products) {
		int indexForNotNullProducts = 0;
		for (Product product : products) {
			if (product != null) {
				indexForNotNullProducts++;
			}
		}
		Product[] newProductsList = new Product[indexForNotNullProducts];
		int index = 0;
		for (Product product : products) {
			if (product != null) {
				newProductsList[index] = product;
				index++;
			}
		}
		this.products = newProductsList;
	}

	@Override
	public void setCustomerId(int customerId) {
		this.customerId = customerId;

	}

	@Override
	public int getCustomerId() {
		return customerId;
	}

	@Override
	public String toString() {
		return "DefaultOrder [creditCardNumber=" + creditCardNumber + ", products=" + Arrays.toString(products)
				+ ", customerId=" + customerId + "]";
	}

}
