public class TurnConditionalIntoMethods {
	
	static int bagOver70lbs(){
//		**method not used for being too simple**
		
		return 200;
		
	}
	
	static int bagUnder50lbs(int bagNumber){
		
		return (bagNumber < 1)?25:35;
//		**1 bag has an index of 0**
		
	}
	
	static int bag50To70lbs(int bagNumber){
		
		return (bagNumber < 2)?100:150;
		
	}
	
	public static void main(String[] args){
		
		int[]bagWeight = new int[]{25,55,75};
//		**there is 1 item from 25 kg bag, 2 items from 55 kg bag and 3 items from 55 kg bag (?)**
		
		int numberOfBags = bagWeight.length;
		
		int bagFees = 0; // ***local var için statik kw kullanýlamaz. 
//		this kw global variable ý nitelemek için kullanýlýr. (statik metod içerisinde this kw zaten kullanýlamaz)
//		local var olan bagFees, aþaðýdaki += iþlemleri ile adeta bir statik variable konumuna düþmüþ***
		
		for(int i = 0; i < numberOfBags; i++){
		
			if(i < 1){
				
				if(bagWeight[i] < 50){
					
					if(i == 0) {bagFees+= 25;} else {bagFees+= 35;}
					
				} else if(bagWeight[i] < 70){
					
					if(i == 0) {bagFees+= 100;} else if(i == 1){bagFees+= 150;} else {bagFees+= 200;}
					
				} else { bagFees+= 200; }
				
			} else if(i >= 0 && bagWeight[i] < 70){
				
				if(i == 1) {bagFees+= 100;} else {bagFees+= 150;}
			
			} else {
				
				bagFees+= 200;
				
			}
		
		}
		
		System.out.println("Bag Fees: $" + bagFees);
		
		
		
		
		// ***more understandable***
		
		bagFees = 0; // **resetlenmesi önemli**
		
		for(int theBag = 0; theBag < numberOfBags; theBag++){
			
			if(bagWeight[theBag] < 50){
				
//				**theBag represents bag number when pass to bagUnder50lbs method**				
				bagFees += bagUnder50lbs(theBag);
//				**alt**:
//				bagFees += (theBag < 1)?25:35;
				
			} else if(bagWeight[theBag] < 70){
					
				bagFees += bag50To70lbs(theBag);
					
			} else {
					
				bagFees += 200;
					
			}
			
		}
		
		System.out.println("Bag Fees: $" + bagFees);
		
		
		
		
//		***much more understandable with else sta gone, 
//		since options of if statement is not as likely to occur as each other.
//		bag weight being less than 50 lbs is more likely to occur than other 2 options.
//		code also becomes more readable.***
		
		bagFees = 0;  // resetlenmesi önemli
		
		for(int theBag = 0; theBag < numberOfBags; theBag++){
			
			if(bagWeight[theBag] < 50) bagFees += bagUnder50lbs(theBag);
			
			if(bagWeight[theBag] < 70 && bagWeight[theBag] >= 50) 
				
				bagFees += bag50To70lbs(theBag);
				
			if(bagWeight[theBag] >= 70) bagFees += 200;
			
		}
		
		System.out.println("Bag Fees: $" + bagFees);
		
	}

}
/*
Bag Fees: $325
Bag Fees: $325
Bag Fees: $325
*/