// ***Each product represents a leaf (file) in the ProductGroup***

public class Product extends ProductComponent{

	private String productName;
	private double productPrice;
	
	public Product(String productName, double productPrice) {
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductName() { return productName;}

//	not used
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() { return productPrice; }

//	not used
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
//	**this method is called by productgroup class**
	void displayProductInfo() {
		
		System.out.println(getProductName() + " $" + getProductPrice());
		
	}

}