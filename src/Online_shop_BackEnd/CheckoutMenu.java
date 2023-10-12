package Online_shop_BackEnd;

import java.util.Scanner;

public class CheckoutMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}
	
	@Override
	public void start() {
		while (true) {
			printMenuHeader();
			Scanner sc = new Scanner(System.in);
			String creditCard = sc.next();
			if (!createOrder(creditCard)) {
				continue;
			}
			context.getSessionCart().clear();
			break;
		}
	}
	public boolean createOrder(String creditCard) {
		Order order = new DefaultOrder();
		if (!order.isCreditCardNumberValid(creditCard)) {
			return false;
		}
		order.setCreditCardNumber(creditCard);
		order.setProducts(context.getSessionCart().getProducts());
		order.setCustomerId(context.getLoggedInUser().getId());
		orderManagementService.addOrder(order);
		return true;
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** CHECKOUT *****");
		System.out.print(
				"Enter your credit card number without spaces and press enter if you confirm purchase: ");
	}

}
