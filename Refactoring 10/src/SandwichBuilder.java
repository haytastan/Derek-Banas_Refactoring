// This is the builder abstract class. It defines
// all the methods that each Sandwich object must
// contain. What these methods do is completely
// up to the subclass that extends the builder
//***Sandwich ile SandwichArtist arasýnda aracý class rolünde***
abstract class SandwichBuilder {
	
	Sandwich sandwich;
	
	public Sandwich getSandwich(){ return sandwich; }
	
	public void makeSandwich(){ sandwich = new Sandwich(); }
	
	public abstract void buildBread();
	public abstract void buildVegetables();
	public abstract void buildMeat();
	public abstract void buildCheese();
	public abstract void buildCondiments();
	
}

class BLTBuilder extends SandwichBuilder {

	// Methods that make this different from other Sandwich Objects
	
	public void buildBread() {
		
		sandwich.setBread("White Bread");
		
	}

	public void buildVegetables() {
		
		sandwich.setVegetables("Lettuce Tomato");
		
	}

	public void buildMeat() {
		
		sandwich.setMeat("Bacon");
		
	}

	public void buildCheese() {
		
		sandwich.setCheese("White Bread");
		
	}

	public void buildCondiments() {
		
		sandwich.setCondiments("Mayonnaise");
		
	}
	
}

// The Director which assigns the type of Sandwich to build
// and then calls all of the initialization methods

class SandwichArtist { 
// ***amacýmýz sandwich objecti bu class içerisine yaratmadan sandwichbuilder
//	 classý vasýtasýyla sandwich object ve metodlarý ile iletiþim kurmak***
	
	private SandwichBuilder sandwichBuilder;
	
	public void setSandwichBuilder(SandwichBuilder sandwichBuilder){
		
		this.sandwichBuilder = sandwichBuilder;
		
	}
	
	public Sandwich getSandwich(){ return sandwichBuilder.getSandwich(); }
	
	// Initializes the Sandwich object
	
	public void takeSandwichOrder(){
		
		sandwichBuilder.makeSandwich(); //***initializes sandwich object***
		
//		***invokes methods related to sandwich object initialized above***
		sandwichBuilder.buildBread();
		sandwichBuilder.buildVegetables();
		sandwichBuilder.buildMeat();
		sandwichBuilder.buildCheese();
		sandwichBuilder.buildCondiments();
		
	}
	
}

class TestBuilder{
	
	public static void main(String[] args){
		
		// **The director has methods for assigning the
		// Sandwich to build, initializes it and provides
		// the Object to who asks for it 
		//	(through SandwichBuilder class)**
		SandwichArtist paul = new SandwichArtist();
		
//		**designate the specific Sandwich object 
//		we want to build (but we dont initialize yet)**
		SandwichBuilder bltBuilder = new BLTBuilder();
		
		// ***inside sandwich artist class, initializes SandwichBuilder object and
		// (indirectly) assigns the specific Sandwich to build 
		//	(without initializing the sandwich yet)***
		paul.setSandwichBuilder(bltBuilder);
		
		// ***Initialize sandwich object and invoke methods in the new object***
		paul.takeSandwichOrder();
		
		// Provide (brings the object here) the specific Sandwich object
		Sandwich bltSandwich = paul.getSandwich();
		
		// Print out info on the Sandwich Object (calls toString method)
		System.out.println(bltSandwich);
		
	}

}
/*
 White Bread Lettuce Tomato Bacon White Bread Mayonnaise
 */