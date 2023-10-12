package Online_shop_BackEnd;

public interface User {
	
	String getFirstName();

	String getLastName();

	String getPassword();

	String getEmail();

	int getId();

	void setPassword(String newPassword);

	void setEmail(String newEmail);
}
