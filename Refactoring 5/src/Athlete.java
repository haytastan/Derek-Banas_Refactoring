// ***using singleton design pattern with reflection
//singleton restricts a class to 1 object 
//(if it has 3 subclasses then 3 objects cud be created though)***
import java.lang.reflect.Method;

public class Athlete {
	
	private String athleteName = "";
	
	public String getAthleteName() {
		return athleteName;
	}

	public void setAthleteName(String athleteName){ this.athleteName = athleteName; }
	
	public static Athlete getInstance(){
		return null;
	}

	
}

class GoldWinner extends Athlete{
	
	// Set to null to signify that an instance of
	// type GoldWinner doesn't exist
	
	private static GoldWinner goldAthlete = null; // **static olmas�na dikkat**
	// * **GoldWinner yerine Athlete yaz�labilir miydi ***
	
	// ***Constructor is set to private to keep other
	// classes from creating an instance of GoldWinner***
	private GoldWinner(String athleteName){
		
		setAthleteName(athleteName);
		
	}
	
	// Creates 1 instance of GoldWinner (Simple Singleton)
	
	public static GoldWinner getInstance(String athleteName){ // **static olmas�na dikkat**
		
		// **If an instance of GoldWinner doesn't exist
		// create one
//		and return in either case**
		if(goldAthlete == null){
			
			goldAthlete = new GoldWinner(athleteName);
			
		} 
		
		return goldAthlete;
		
	}
	
}

class SilverWinner extends Athlete{
	
	private static SilverWinner silverAthlete = null;
	
	private SilverWinner(String athleteName){ 
		
		setAthleteName(athleteName);
		
	}
	
	public static SilverWinner getInstance(String athleteName){
		
		if(silverAthlete == null){
			
			silverAthlete = new SilverWinner(athleteName);
			
		} 
		
		return silverAthlete;
		
	}
	
}

class BronzeWinner extends Athlete{
	
	private static BronzeWinner bronzeAthlete = null;
	
	private BronzeWinner(String athleteName){ 
		
		setAthleteName(athleteName);
		
	}
	
	public static BronzeWinner getInstance(String athleteName){
		
		if(bronzeAthlete == null){
			
			bronzeAthlete = new BronzeWinner(athleteName);
			
		} 
		
		return bronzeAthlete;
		
	}
	
}

// ***returns the correct subclass based on the type of subclass asked for***
class MedalFactory{
	
	public Athlete getMedal(String medalType, String athleteName){
		
		try {
			
			// **Define the type of the parameter that will be passed 
			// to the method I create below**
			
			Class[] athleteNameParameter = new Class[]{String.class};
			
			// **forName returns a class object with the String that is
			// passed to it (medalType). getMethod returns the (getInstance) method provided 
			// the second parameter defines the type of parameter passed
			// to the method**
			
			Method getInstanceMethod =  Class.forName(medalType).getMethod("getInstance", athleteNameParameter);
			
//			***package kullan�lm�� olsayd� kodun formatlanmas� gerekecekti:***
//			String packageName = this.getClass().getPackage().getName();
//			Method getInstanceMethod = Class.forName(packageName + �.� + medalType).getMethod(�getInstance�, athleteNameParameter);
			
//			**Create an array with the parameter values.
//			we actually didnt need to create this object array since string is already object**
			Object[] params = new Object[]{new String(athleteName)};
			
			// **Pass the parameters to method getInstance and return
			// a subclass of type Athlete (casted from object to Athlete).
			// with invoke(), calls the method**
			
			return (Athlete) getInstanceMethod.invoke(null, params); 
			
//			***nihai olarak medaltype isimli class i�inde getInstance isimli (parameter type� 
//			string olan) metod yarat�yoruz ve params isimli argumenti bu metoda pass ediyoruz.
//			ard�ndan metodu return ediyoruz: GoldWinner.getInstance("Dave Thomas") (?)***
		}
		
//		***exception triggered if a class that doesnt exist is attempted to be created***
		catch(Exception e){
			
			throw new IllegalArgumentException("Invalid Medal Type");
		
		}
		
	}
	
}

class TestMedalWinner{
	
	public static void main(String[] args){
		
		MedalFactory medalFactory = new MedalFactory();
		
//		***GoldWinner class ismi, Dave Thomas ise parameter ismi***
		Athlete goldWinner = medalFactory.getMedal("GoldWinner", "Dave Thomas");
//		***yukar�daki ifade yerine, Athlete goldWinner = new GoldWinner("Dave Thomas");
//		yazmamam�z�n sebebi constructor�n private olmas�.
//		ancak, Athlete goldWinner = GoldWinner.getInstance("Dave Thomas"); yaz�labilirdi (?)***
		Athlete silverWinner = medalFactory.getMedal("SilverWinner", "Mac McDonald");
		Athlete bronzeWinner = medalFactory.getMedal("BronzeWinner", "David Edgerton");
		
		Athlete goldWinner2 = medalFactory.getMedal("GoldWinner", "Ray Kroc");
		
		System.out.println("Gold Medal Winner: " + goldWinner.getAthleteName());
		System.out.println("Silver Medal Winner: " + silverWinner.getAthleteName());
		System.out.println("Bronze Medal Winner: " + bronzeWinner.getAthleteName());
		
		// ***Even though I tried to create a new Object of type GoldWinner
		// it was rejected and the original object remained***
		
		System.out.println("Gold Medal Winner: " + goldWinner2.getAthleteName());
		
	}
	
}
/*
Gold Medal Winner: Dave Thomas
Silver Medal Winner: Mac McDonald
Bronze Medal Winner: David Edgerton
Gold Medal Winner: Dave Thomas
*/