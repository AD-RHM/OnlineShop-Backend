package Online_shop_BackEnd;

import java.util.Scanner;

public class MainMenu implements Menu {

	public static final String MENU_COMMAND = "menu";
	
	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign In"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
			+ "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
			+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
			+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
			"6. Customer List";;

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		while (true) {
			if (context.getMainMenu() == null) {
				context.setMainMenu(this);
			}
			Menu menu = null;
			mainLoop:while (true) {
				printMenuHeader();
				
				Scanner sc = new Scanner(System.in);
				String userInput = sc.next();
				int commandInput = Integer.parseInt(userInput);
				if (userInput.equalsIgnoreCase(Main.EXIT_COMMAND)) {
					System.exit(0);
				}
				else {
					switch (commandInput) {
					case 1:
						menu = new SignUpMenu();
						break mainLoop;
					case 2:
						if (context.getLoggedInUser() == null) {
							menu = new SignInMenu();
						} else {
							menu = new SignOutMenu();
						}
						break mainLoop;
					case 3:
						menu = new ProductCatalogMenu();
						break mainLoop;
					case 4:
						menu = new MyOrdersMenu();
						break mainLoop;
					case 5:
						menu = new SettingsMenu();
						break mainLoop;
					case 6:
						menu = new CustomerListMenu();
						break mainLoop;
					default:
						System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time");
						continue; // continue endless loop
					}
			
				}
						
				} 
			menu.start();
		}
		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** MAIN MENU *****");
		if (context.getLoggedInUser() == null) {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
		} else {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
		}	}

}

