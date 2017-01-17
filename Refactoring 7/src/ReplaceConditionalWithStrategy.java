// ***Conditional logic is often used to decide which 
// algorithm to use.

// The strategy design pattern is used to dynamically
// change the algorithm used by an object at run time
// which makes it great for eliminating conditionals

// You create subclasses for each algorithm and then 
// the right algorithm is used at run time. This is
// another example of how you can replace conditionals
// with Polymorphism (bonus kýsmý için)***

public class ReplaceConditionalWithStrategy {

	public static void main(String[] args){
//		***note that we cud also ignore Salesman & Secretary subclasses 
//		and cud only have Employee class for every object we create (better design).
//		that wouldn't change anything about what we print now with subclasses***
		Employee salesman = new Salesman(15000.00);
		
		Employee secretary = new Secretary(25000.00);
		
		System.out.println("Salesman Pay: $" + salesman.getPay());
		System.out.println("Secretary Pay: $" + secretary.getPay());
		
		// ***You can add a bonus to a salesman's salary at run time***
		salesman.setBonusOption(new GetsBonus());
		
		System.out.println("Salesman's New Pay: $" + salesman.getPay());
		
		// You could also set set Bonus type in the constructor
		Employee salesTrainee = new Salesman(15000.00, new GetsBonus());
		
		System.out.println("Sales Trainee Pay: $" + salesTrainee.getPay());
		
		salesman.setBonusOption(new NoBonus());
		
		System.out.println("Salesman's Former Pay: $" + salesman.getPay());
		
	}
	
}

class Employee{
	
	protected double salary = 0.0;
	
	// We use an instance of the Pay interface
	// Employee doesn't care what Pay does
	// This allows the capabilities of objects to change
	// at run time
		
	public Pay payType = new NoBonus(); // *default*
//	***bonus belirlemede conditional sta yerine poly kullanýlmýþ
//	cond sta version: String payType = "NoBonus"; ***
	
	Employee(double salary){
		
		this.salary = salary;
		
	}
	
	Employee(double salary, Pay payType) {
		this.salary = salary;
		this.payType = payType;
	}
	
//	**if we wanna change bonus later on**
	public void setBonusOption(Pay newPayType){
		
		payType = newPayType;
		
	}
	
	public double getPay(){
		
		return payType.getPay(this.salary);
//		***cond sta kullanýlmýþ olsaydý bir metodu çaðýrýp hem paytype'ý 
//		hem de salary'yi pass ederdi: method(this.payType, this.salary)
//		method içerisinde is conditional statement olurdu***
		
	}
	
}

// By implementing Pay classes can easily change 
// pay amount without effecting the program

interface Pay{
	
	double getPay(double salary);
	
}

class GetsBonus implements Pay{

	public double getPay(double salary) {
		return salary + (salary * .15);
	}
	
}

class NoBonus implements Pay{
	
	public double getPay(double salary) {
		return salary;
	}
	
}

// ***Adding new pay structures has little effect***

class Bonus20Per implements Pay{
	
	public double getPay(double salary) {
		return salary + (salary * .20);
	}
	
}

class Salesman extends Employee{

	Salesman(double salary) {
		super(salary);
	}

	public Salesman(double salary, Pay payType) {
		
		super(salary);
		setBonusOption(payType);
		
	}

}

class Secretary extends Employee{

	Secretary(double salary) {
		super(salary);
	}
	
	Secretary(double salary, Pay payType) {
		
		super(salary);
		setBonusOption(payType);
		
	}
	
}
/*
Salesman Pay: $15000.0
Secretary Pay: $25000.0
Salesman's New Pay: $17250.0
Sales Trainee Pay: $17250.0
Salesman's Former Pay: $15000.0
*/