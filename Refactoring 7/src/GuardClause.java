//// **The Guard Clause makes the normal path of execution clear
//// by eliminating the ins and outs of using else statements
//		
//// If we thought it was just as likely that a bag would weigh
//// less than 50 lbs as if it weighed over 70 lbs we wouldn't
//// use the guard clause.**
//		
//		bagFees = 0;
//		
//		for(int theBag = 0; theBag < numberOfBags; theBag++){
//			
//			if(bagWeight[theBag] < 50){ bagFees += bagUnder50lbs(theBag); }
//			
//			if(bagWeight[theBag] < 70 && bagWeight[theBag] >= 50) {
//				
//				bagFees += bag50To70lbs(theBag);
//				
//			}
//			
//			if(bagWeight[theBag] >= 70) { bagFees += 200; }
//			
//		}
//		
//		System.out.println("Bag Fees: $" + bagFees);
//		
//		
//	}
//	
//	// Rather than what you see above they are normally used in 
//	// a method like this
//			
//	int getBagPrice(double[] weight, int theBag){	
//			
//		if(weight[theBag] < 50) return bagUnder50lbs(theBag);
//			
//		if(weight[theBag] < 70) return bag50To70lbs(theBag);
//			
//		if(weight[theBag] >= 70) return 200;
//		
//		return 200;
//			
//	}