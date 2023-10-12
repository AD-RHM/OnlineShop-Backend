package Online_shop_BackEnd;

import java.util.Scanner;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your first name: ");
		String firstName = sc.next();
		System.out.print("Please, enter your last name: ");
		String lastName = sc.next();
		System.out.print("Please, enter your password: ");
		String password = sc.next();
		System.out.print("Please, enter your email: ");
		sc = new Scanner(System.in);
		String email = sc.nextLine();
		
		User newUser = new DefaultUser(firstName,lastName,password,email);
		
		String errorMessage = userManagementService.registerUser(newUser);
		if (errorMessage.isEmpty() || errorMessage == null) {
			context.setLoggedInUser(newUser);
			System.out.println("New user is created");
		}
		else {
			System.out.println(errorMessage);
		}
		
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN UP *****");	
	}

}
