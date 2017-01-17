import java.util.ArrayList;
import java.util.Iterator;

//***Each ProductGroup represents a folder in the ProductGroup***
public class ProductGroup extends ProductComponent{
	
// ***we wanna store every product and product group inside the list
//	which has a type of superclass***	
	ArrayList<ProductComponent> productComponents = new ArrayList<ProductComponent>();
	
	private String productGroupName;

	public ProductGroup(String productGroupName) {
		this.productGroupName = productGroupName;
	}

	public void add(ProductComponent newProductComponent) {
		
		productComponents.add(newProductComponent);
		
	}
	
//	not used
	public void remove(ProductComponent newProductComponent) {
		
		productComponents.remove(newProductComponent);
		
	}

//	not used
//	we get the procuct component asking for an index
	public ProductComponent getProductComponent(int componentIndex) {
		
		return productComponents.get(componentIndex);
		
	}

	public String getProductGroupName() { return productGroupName; }
	
//	***this method prints out the productgroup (folder;subclass) name as well as 
//	all the products (file;subclass) stored within that specific productgroup***
	public void displayProductInfo() {
		
		System.out.println(getProductGroupName()); 
		// ***prints "All Products, Produce and Cereal" individually***
		
//		***Cycle through and print every product in this specific Product Group.
//		for loop reads easier than iteration***
		for(ProductComponent pc: productComponents){ 
			//**ProductComponent is of superclass type so its subclasses are called**
			pc.displayProductInfo(); // **calls itself or displayProductInfo method of product class**
//		**productComponents listesinin 3 elemanlý olduðu anlaþýlýyor 
//			ama sýrayla 2 elemanýn (produce ve cereal) içinde de iteration yapýlýyor**

		}
		
//		alt: iterator
//		Iterator<ProductComponent> productIterator = productComponents.iterator();
//		
//		while(productIterator.hasNext()){
//			
//			ProductComponent productInfo = productIterator.next();
//			
//			productInfo.displayProductInfo();
//			
//		}
		
		System.out.println();
		
	}

}