public class TestBonusCalculator {

	public static void main(String[] args){
		
		// We can have completely different calculations performed
		// on completely different objects just by defining a
		// new concrete Visitor
		
		//	*Calculate Quarterly Bonus*		
		Visitor yearlyBonusCalculator = new YearlyBonusVisitor();
		// *alt: YearlyBonusVisitor yearlyBonusCalculator = new YearlyBonusVisitor();*
		
		Visitable bradTrainee = new SalesTrainee(5, 1, 20000);
		Visitable tomSalesman = new Salesman(150000, 62);
		Visitable rossBoss = new Boss(1000000, 1200, 4000000);
		// *alt: Boss rossBoss = new Boss(1000000, 1200, 4000000);*
		
		System.out.println("YEARLY BONUS");
		
		System.out.println(bradTrainee.accept(yearlyBonusCalculator));
		System.out.println(tomSalesman.accept(yearlyBonusCalculator));
		System.out.println(rossBoss.accept(yearlyBonusCalculator));
		
		// *Calculate Quarterly Bonus*		
		Visitor quarterlyBonusCalculator = new QuarterlyBonusVisitor();
		
		bradTrainee = new SalesTrainee(1, 0, 20000);
		tomSalesman = new Salesman(30000, 22);
		rossBoss = new Boss(200000, 300, 11000);
		
		System.out.println("\nQUARTERLY BONUS");
		
		System.out.println(bradTrainee.accept(quarterlyBonusCalculator));
		System.out.println(tomSalesman.accept(quarterlyBonusCalculator));
		System.out.println(rossBoss.accept(quarterlyBonusCalculator));
		
	}
	
}
/*
YEARLY BONUS
Trainees Yearly Bonus
2000.0
Salesmans Yearly Bonus
18000.0
Bosses Yearly Bonus
40000.0

QUARTERLY BONUS
Trainees Yearly Bonus
200.0
Salesmans Yearly Bonus
900.0
Bosses Yearly Bonus
10000.0
*/