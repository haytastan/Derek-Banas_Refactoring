// Each concrete visitor type will implement
// the Visitor interface. Here we define every
// instance of method overloading needed

interface Visitor {
	
	public double visit(SalesTrainee trainee);
	public double visit(Salesman salesman);
	public double visit(Boss boss);
//	***yukarýdaki metodlarýn argumentinde type olarak Visitable kullanmak isteseydik 
//	1. metod overloading yapamayacak ve her metoda farklý isim vermek zorunda kalacaktýk
//	2. Visitable classýnda (boss, salesman ve salestrainee classlarýnda kullanýlan) 
//	yeni metodlar tanýmlamak zorunda olacaktýk***

}