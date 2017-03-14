// Each concrete visitor type will implement
// the Visitor interface. Here we define every
// instance of method overloading needed

interface Visitor {
	
	public double visit(SalesTrainee trainee);
	public double visit(Salesman salesman);
	public double visit(Boss boss);
//	***yukar�daki metodlar�n argumentinde type olarak Visitable kullanmak isteseydik 
//	1. metod overloading yapamayacak ve her metoda farkl� isim vermek zorunda kalacakt�k
//	2. Visitable class�nda (boss, salesman ve salestrainee classlar�nda kullan�lan) 
//	yeni metodlar tan�mlamak zorunda olacakt�k***

}