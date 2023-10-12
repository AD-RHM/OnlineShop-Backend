package Online_shop_BackEnd;

public interface OrderManagementService {

	void addOrder(Order order);

	Order[] getOrdersByUserId(int userId);

	Order[] getOrders();

}
