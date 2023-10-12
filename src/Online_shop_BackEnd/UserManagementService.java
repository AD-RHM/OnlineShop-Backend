package Online_shop_BackEnd;

public interface UserManagementService {
	
	String registerUser(User user);

	User[] getUsers();

	User getUserByEmail(String userEmail);

}
