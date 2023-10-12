package Online_shop_BackEnd;

public interface ProductManagementService {
	
	Product[] getProducts();

	Product getProductById(int productIdToAddToCart);

}
