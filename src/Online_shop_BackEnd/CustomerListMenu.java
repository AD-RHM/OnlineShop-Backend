package Online_shop_BackEnd;

public class CustomerListMenu implements Menu {

	//private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		//context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		printMenuHeader();
		User [] custumersList = userManagementService.getUsers();
		if (custumersList.length == 0) {
			System.out.println("Unfortunately, there are no customers.");
		}
		else {
			for(User user : custumersList) {
				System.out.println(user.getFirstName() + " | " + user.getLastName() + " | " + user.getEmail() + " | " + user.getId());
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** USERS *****");		
	}

}
