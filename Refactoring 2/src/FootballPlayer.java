public class FootballPlayer {
	
	private String name = "";
	private double[] fortyYardDashTimes = null;
	
	public String getName() {return name;}
	
	public double[] get40YardDashTimes(){ return fortyYardDashTimes; }
	
	FootballPlayer(String name, double[] fortyYardDashTimes) {
		 
		this.name = name;

		this.fortyYardDashTimes = fortyYardDashTimes;
//		constructora double type pass edilseydi a�a��daki gibi yaz�labilirdi:
//		this.fortyYardDashTimes[10]=fortyYardDashTimes;
		
//		name = "asfd"; // local var; program� etkilemez
//		this.name= "asdf"; // global var ve program� etkiler
	}

}