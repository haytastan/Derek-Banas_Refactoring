public class Cook {
	
	public static void main(String[] args){
		
		Sandwich customer1 = new Hamburger();
		
		customer1.makeSandwich();
		
		Sandwich customer2 = new VeggieSub();
		
		customer2.makeSandwich();
		
	}

}
/*

------NEW ORDER------

The Bun is Cut
Hamburger Added
Lettuce, onions & Tomatoes Added
Special Sauce Added
The Sandwich is Wrapped

------NEW ORDER------

The Bun is Cut
Lettuce, onions & Tomatoes Added
Vinegar and Oil Added
The Sandwich is Wrapped
*/