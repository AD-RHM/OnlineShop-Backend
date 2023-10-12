package Online_shop_BackEnd;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		if (context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create new account to see list of your orders");
		}
		else {
			printUserOrdersToConsole();
		}
	}
	
	private void printUserOrdersToConsole() {
		Order [] orders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
		if (orders.length == 0 || orders == null) {
			System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order");
		}
		else {
			for(Order order : orders) {
				System.out.println(order);
			}
		}
	}
	
	@Override
	public void printMenuHeader() {
		System.out.println("***** MY ORDERS *****");			
	}

}

