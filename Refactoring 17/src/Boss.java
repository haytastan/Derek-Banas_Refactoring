public class Boss implements Visitable{
	
	private double totalSalesAmount;
	private int newCustomers;
	private double officeExpenses;

	public Boss(double totalSalesAmount, int newCustomers, double officeExpenses) {
		this.totalSalesAmount = totalSalesAmount;
		this.newCustomers = newCustomers;
		this.officeExpenses = officeExpenses;
	}

	public double accept(Visitor visitor){
		
//		***with this kw, passes the relevant object created in main method***
		return visitor.visit(this);
		
	}
//	***without using this kw (also need to modify main method):***
//	public double accept(Visitor visitor, Visitable v){
//		
//		return visitor.visit((Boss) v);
//		
//	}
	
	// Getters & Setters
	public double getTotalSalesAmount() {
		return totalSalesAmount;
	}
	public void setTotalSalesAmount(double totalSalesAmount) {
		this.totalSalesAmount = totalSalesAmount;
	}
	public int getNewCustomers() {
		return newCustomers;
	}
	public void setNewCustomers(int newCustomers) {
		this.newCustomers = newCustomers;
	}
	public double getOfficeExpenses() {
		return officeExpenses;
	}
	public void setOfficeExpenses(double officeExpenses) {
		this.officeExpenses = officeExpenses;
	}
}