// **Type safety is very important. 
// We want to eliminate all operations on values that 
// are not of the appropriate data type by protecting
// the program from bad input.
// We can do this by replacing primitive types with classes.
// we are gonna use proxy design pattern**
public class ATMAccess {
	
	// Define a type safe field 
	
	private ATMCardState cardState;
	
	private void setState(ATMCardState cardState){
		
		this.cardState = cardState;
		
	}
	
	public ATMAccess() {
		
		// Create type safe assignment
		
		setState(ATMCardState.CARD_ENTERED);
		
	}
	
	public String getState() { 
		
		// REPLACED return state; 
		
		return cardState.toString();
		
	} 
	
	// 1. Encapsulation is used
	
	public void verifyCard(int cardNumber) {
		
		if (getState().equals(ATMCardState.CARD_ENTERED.toString())){
			
			if(cardNumber == ATMCardState.CARD_NUMBER){
			
			// Create type safe assignment
			
			setState(ATMCardState.VALID_CARD);
			
			} else { setState(ATMCardState.DENIED); }
		}
		
	}
	
	public void verifyPIN(int pinNumber) {
		
		if (getState().equals(ATMCardState.VALID_CARD.toString())){
			
			if(pinNumber == ATMCardState.PIN_NUMBER){
			
			// Create type safe assignment
			
			setState(ATMCardState.VALID_PIN);
			
			} else { setState(ATMCardState.DENIED); }
		}
		
	}
	
	public void verifyWithdrawalAmount(double withdrawalRequest) {
		
		if (getState().equals(ATMCardState.VALID_PIN.toString())){
			
			if(withdrawalRequest <= ATMCardState.CARD_BALANCE){
			
			// Create type safe assignment
			
			setState(ATMCardState.VALID_CASH_REQUEST);
			
			} else { setState(ATMCardState.DENIED); }
		}
		
	}  
	
	public static void main(String[] args){
		
		ATMAccess user = new ATMAccess(); // CARD ENTERED
		
		System.out.println(user.getState());
		
		user.verifyCard(123456789); // VALID CARD
		
		System.out.println(user.getState());
		
		user.verifyPIN(1234); // VALID PIN
		
		System.out.println(user.getState());
		
		user.verifyWithdrawalAmount(1000); // VALID CASH REQUEST
		
		System.out.println(user.getState());
		
	}
	
}


// ***this class represents the state of a ATMAccess object.
// instead of this class we cud have created enum***
class ATMCardState{
	
	private final String state;
	
//	***private oldu�u i�in d��ar�dan do�rudan initialize edilemez. 
//	a�a��daki variable'lar vas�tas�yla d��ar�dan ula��m sa�lan�yor.***
	private ATMCardState(String state){

		this.state = state;
		
	}
	
	public String toString(){
		
		return state;
		
	}
	
	// **These type safe constants live in the class and can't be impersonated**
	public final static ATMCardState CARD_ENTERED = new ATMCardState("CARD ENTERED");
	public final static ATMCardState VALID_CARD = new ATMCardState("VALID CARD");
	public final static ATMCardState VALID_PIN = new ATMCardState("VALID PIN");
	public final static ATMCardState VALID_CASH_REQUEST = new ATMCardState("VALID CASH REQUEST");
	public final static ATMCardState DENIED = new ATMCardState("DENIED");
	
//	**below vars come from database or sth**
	public final static int CARD_NUMBER = 123456789;
	public final static int PIN_NUMBER = 1234;
	public final static double CARD_BALANCE = 1000.00;
	
}
/*
CARD ENTERED
VALID CARD
VALID PIN
VALID CASH REQUEST
*/