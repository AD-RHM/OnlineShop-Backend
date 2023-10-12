package Online_shop_BackEnd;

import java.util.Arrays;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	private Order[] orders;
	int lastIndexOforderAdded = 0;
	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if (order != null) {
			if (orders.length <= lastIndexOforderAdded) {
				orders = Arrays.copyOf(orders, orders.length << 1);
				orders[lastIndexOforderAdded++] = order;
			} else {
				orders[lastIndexOforderAdded++] = order;
			}
		}
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		int countOrdersById = 0;
		for (Order order : getOrders()) {
			if (userId == order.getCustomerId()) {
				countOrdersById++;
			}
		}
		Order[] ordersById = new Order[countOrdersById];
		int indexListOrderById = 0;
		for(Order order : getOrders()) {
			if (userId == order.getCustomerId()) {
				ordersById[indexListOrderById] = order;
				indexListOrderById++;
			}
		}
		return ordersById;
	}

	@Override
	public Order[] getOrders() {
		int indexNotNullOrders = 0;
		for (Order order : orders) {
			if (order != null) {
				indexNotNullOrders++;
			}
		}
		Order[] ordersList = new Order[indexNotNullOrders];
		int counterOfOrdersList = 0;
		for (Order order : orders) {
			if (order != null) {
				ordersList[counterOfOrdersList] = order;
				counterOfOrdersList++;
			}
		}
		return ordersList;
	}

	void clearServiceState() {
		orders = new Order[DEFAULT_ORDER_CAPACITY];
		lastIndexOforderAdded = 0;
	}

}
