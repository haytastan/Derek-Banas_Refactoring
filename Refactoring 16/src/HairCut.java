// When new features are needed it is a bad idea to
// add new code to older classes. This would make
// compact easy to understand classes complicated
// because they would break the Single responsibility 
// principle.

// The decorator pattern instead places each special
// case behavior (Embellishment) into its own class.

// By using the decorator pattern we'll also satisfy
// another SOLID principle being the Interface segregation 
// principle, by using many specific interfaces rather 
// than one general purpose interface.

public interface HairCut {
	
	public String getDescription();
	
	public double getCost();
	
}

/////****Bad Style****//////
class CalculateHairCut implements HairCut{

	enum HairCutOptions { BASIC_CUT, PERM, HAIR_FROSTING };
	
	HairCutOptions optionPicked;
	
	CalculateHairCut(HairCutOptions options){
		
		optionPicked = options;
		
	}
	
	public String getDescription() {
		
		if(optionPicked == HairCutOptions.PERM){
			
			return "\nAdd Chemicals and Put Hair in Rollers";
			
		} else if(optionPicked == HairCutOptions.HAIR_FROSTING){
				
			return "\nAdd Chemicals and Put Hair in Foil";
				
		} else return "Trim the Hair";
		
	}

	public double getCost() {

		if(optionPicked == HairCutOptions.PERM){
			
			return 10.0;
			
		} else if(optionPicked == HairCutOptions.HAIR_FROSTING){
				
			return 5.0;
				
		} else return 3.0;
	}
	
	public static void main(String[] args) {
//		***main metod class dýþýnda olsaydý, enumun CalculateHairCut classý 
//		dýþýnda baþlý baþýna enum class olarak deklare edilmesi gerekirdi***
		
		HairCut calc = new CalculateHairCut(HairCutOptions.BASIC_CUT);
		
		System.out.println(calc.getDescription());
		
		System.out.println(calc.getCost());
		
	}
	
}
/*
Trim the Hair
3.0
*/



/////***True Style***//////
// The Decorator will allow you to add features
// while keeping them completely separated in
// their own class

abstract class HairCutDecorator implements HairCut{
	
	protected HairCut hairCut;
	
	// The decorator will be able to dynamically customize
	// HairCuts
	
	HairCutDecorator(HairCut hairCut){
		
		this.hairCut = hairCut;
		
	}
	
	public String getDescription(){
		
		return hairCut.getDescription();
		
	}
	
	public double getCost(){
		
		return hairCut.getCost();
		
	}
	
}

// This represents the basic HairCut that was originally
// used all of the time before the upgrade

class RegularHairCut implements HairCut{

	public String getDescription() {
		
		return "Trim the Hair";
		
	}


	public double getCost() {
		
		return 10.00;
		
	}
	
}

// With the decorator we can easily add additional
// features and calculations without changing 
// the code that already exists

class Perm extends HairCutDecorator{

	Perm(HairCut hairCut) {
		super(hairCut);
	}
	
//	***we add additional description to the regular haircut***
	public String getDescription() {
		
		return hairCut.getDescription() + "\nAdd Chemicals and Put Hair in Rollers";
		
	}

// ***adds additional cost to the regular hair cut***
	public double getCost() {
		
		return hairCut.getCost() + 75.00;
		
	}
	
}

class TestHairCut{
	
	public static void main(String[] args){
		
//		***added feature is perm and core part is regularhaircut***
		HairCut permAndCut = new Perm(new RegularHairCut());
//		***"new Perm(new Perm(new RegularHairCut()))" denseydi
//		print ilginç olacaktý: önce Perme ait metodlar çaðýrýlacaktý,
//		ardýndan RegularHairCuta ait metodlar çaðýrýlacaktý***
		
		System.out.println("Services");
		
		System.out.println(permAndCut.getDescription());
		
		System.out.println("Price: $" + permAndCut.getCost());
		
	}
	
}
/*
Services
Trim the Hair
Add Chemicals and Put Hair in Rollers
Price: $85.0
*/