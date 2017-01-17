// In this example code as new enemy ships were needed
// conditionals were added and then subclasses when
// the original code didn't work.

// With the adapter pattern we can create a new class
// without disturbing any other code. On top of that
// adapters make it easier to swap in code at runtime.
// They also allow you to communicate with code using
// method names that make sense to you.

// ***enemy ship super class olsa da abstract class olmadýðý için 
//kendisinden de instance yaratýlabilir***
public class EnemyShip {

	protected String name;
	private int attackPower;
	protected int spacesMovedPerTurn;
	
	public EnemyShip(int currentLevel) {
		
		if(currentLevel <= 5){
			
			name = "Galax";
			this.attackPower = 5;
			this.spacesMovedPerTurn = 2;
			
		}else if(currentLevel > 5 || currentLevel < 10){
			
			name = "Galaxian";
			this.attackPower = 10;
			this.spacesMovedPerTurn = 3;
			
		} else if(currentLevel > 10) {
			
			name = "Galaxian Prime";
			this.attackPower = 15;
			this.spacesMovedPerTurn = 4;
			
		}
		
	}
	
	public void moveShip(){
		
		System.out.println(name + " moves " + spacesMovedPerTurn + " spaces");
		
	}
	
	public void makeShipAttack(){
		
		System.out.println(name + " does " + attackPower + " damage");
		
	}
	
}


class GalaxianPrime extends EnemyShip{

	public GalaxianPrime(int currentLevel) {
		super(currentLevel);
	}
	
	public void moveShip(){
		
		System.out.println(name + " turns on forcefield and moves " + spacesMovedPerTurn + " spaces");
		
	}
	
}


class Main {
	
	public static void main(String[] args){
		
		EnemyShip level1Ship = new EnemyShip(6);
		
		level1Ship.moveShip();
		level1Ship.makeShipAttack();
		
		EnemyShip primeTime = new GalaxianPrime(15);
		
		primeTime.moveShip();
		primeTime.makeShipAttack();
		
	}
	
}

/*
Galaxian moves 3 spaces
Galaxian does 10 damage
Galaxian turns on forcefield and moves 3 spaces
Galaxian does 10 damage
 */




// This is the interface the client works with
// The adapter makes sure new classes are
// compatible with it

interface Enemy{
	
	public void moveShip();
	
	public void makeShipAttack();
	
}

// **this is the obvious way to use interface without using adapter**
class Galax implements Enemy{

	private int attackPower = 5;
	private int spacesMovedPerTurn = 2;
	
	public void moveShip() {
		
		System.out.println("Galax moves " + spacesMovedPerTurn + " spaces");
		
	}

	public void makeShipAttack() {
		
		System.out.println("Galax does " + attackPower + " damage");
		
	}
	
}

//***This is the adaptee. The Adapter will call the right methods
// with any name here when they are called on the Enemy interface***

class GalaxPrime{
	
	protected String name = "Galaxian Prime";
	private int attackPower = 15;
	protected int spacesMovedPerTurn = 4;
	
	public void turnOnForceField(){
		
		System.out.println(name + " turns on force field");
		
	}
	
	public void warpToSpace(){
		
		System.out.println(name + " warps " + spacesMovedPerTurn + " spaces");
		
	}
	
	public void chargePhasers(){
		
		System.out.println(name + " charges phasers");
		
	}
	
	public void firePhasers(){
		
		System.out.println(name + " fires phasers for " + attackPower + " damage");
		
	}
	
}

// **The adapter can provide completely different 
// actions for the methods implemented

// The adapter contains an object of the same 
// type as adaptee, so all calls sent to 
// the Enemy are sent to methods of the adaptee**

class EnemyAdapter implements Enemy{

	GalaxPrime galaxPrime;
	
	public EnemyAdapter(GalaxPrime galaxPrime) {
		this.galaxPrime = galaxPrime;
	}

	public void moveShip() {
		
		galaxPrime.turnOnForceField();
		galaxPrime.warpToSpace();
		
	}

	public void makeShipAttack() {
		
		galaxPrime.chargePhasers();
		galaxPrime.firePhasers();
		
	}
	
}

class TestEnemyAdapter{
	
	public static void main(String[] args){
		
		Enemy galax = new Galax();
		
		GalaxPrime galaxPrimeAdaptee = new GalaxPrime();
		
		Enemy galaxPrime = new EnemyAdapter(galaxPrimeAdaptee);
		
		// Test a regular Enemy
		
		galax.moveShip();
		galax.makeShipAttack();
		
		System.out.println();
		
		// Test an adapted Enemy
		
		galaxPrime.moveShip();
		galaxPrime.makeShipAttack();
		
	}
	
}
/*
Galax moves 2 spaces
Galax does 5 damage

Galaxian Prime turns on force field
Galaxian Prime warps 4 spaces
Galaxian Prime charges phasers
Galaxian Prime fires phasers for 15 damage
*/