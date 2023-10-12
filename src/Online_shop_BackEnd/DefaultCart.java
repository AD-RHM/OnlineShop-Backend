package Online_shop_BackEnd;

import java.util.Arrays;

public class DefaultCart implements Cart {

	private static int CAPACITÉ_OF_CART = 10;
	private Product[] products;
	private int indexOfLastProductAdded;
	{
		products = new Product [CAPACITÉ_OF_CART];
	}
	
	@Override
	public boolean isEmpty() {
		for(Product product : products) {
			if (product != null) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void addProduct(Product product) {
		if (products.length <= indexOfLastProductAdded) {
			products = Arrays.copyOf(products, CAPACITÉ_OF_CART << 1);
		}
		products[indexOfLastProductAdded++] = product;
	}

	@Override
	public Product[] getProducts() {
		int notNullProducts = 0;
		for(Product product : products) {
			if (product != null) {
				notNullProducts++;
			}
		}
		Product[] listOfproducts = new Product[notNullProducts];
		int counter = 0;
		for(Product product: products) {
			if (product != null) {
				listOfproducts[counter] = product;
				counter++;
			}
		}
		return listOfproducts;
	}

	@Override
	public void clear() {
		indexOfLastProductAdded = 0;
		products = new Product [CAPACITÉ_OF_CART];
	}

}
