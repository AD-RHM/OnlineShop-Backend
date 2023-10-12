package Online_shop_BackEnd;

import java.util.Scanner;

public class SettingsMenu implements Menu {

	private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		Menu menu = null;
		mainLoop:while (true) {
			if (context.getLoggedInUser() == null) {
				System.out.println("Please, log in or create new account to change your account settings");
				new MainMenu().start();
			}
			else {
				System.out.println(SETTINGS);
				System.out.print(
						"Please, enter option or type 'menu' to navigate back to the main menu: ");
				String input = userInput();
				if (input.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
					menu = new MainMenu();
					break mainLoop;
				}
				int settingsInput = Integer.parseInt(input);
				switch (settingsInput) {
				case 1:
					menu = new ChangePasswordMenu();
					break;
				case 2:
					menu = new ChangeEmailMenu();
					break;
				default:
					System.out.println("Only 1, 2 is allowed. Try one more time");
					continue;
				}
				
			}
			
		}
		menu.start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SETTINGS *****");	
	}
	
	private String userInput() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}

}

