import java.util.Scanner;

public class GuessNumber {

	private int secretNumber, max, life = 5;
	static Scanner input = new Scanner(System.in);
	
  //*****    Start a Game     *****//	
	public void beginGame(){
		System.out.print("\nSelect difficulty mode:\n");
	    System.out.print("1 : Easy (0-15)\n");
	    System.out.print("2 : Medium (0-30)\n");
	    System.out.print("3 : Difficult (0-50)\n");
	    System.out.print("or type anything to quit: ");

    	if(input.hasNext()){
    		String mode = input.next();
    		System.out.println();
			switch(mode) {
				case "1": 
					max = 15;
				  break;
				case "2": 
					max = 30;
				  break;
				case "3": 
					max = 50;
				  break;  
			    default:
			       exitGame();
			      break;
			}
			setSecretNumber();
    	}
	}
	
	
  //*****  number between 0 to max *****//	
	private void setSecretNumber(){
		secretNumber = (int)(Math.random()*max);
		System.out.print("You have ("+life+")Lives to guess a correct number between 0 to "+max+"\n\n");
		getResult();
	}
	
	
  //***** Get a result if a player win or lose  *****//	
	private void getResult(){		
		if (life<=0){
			System.out.print("Sorry, You lose!\n");
			life = 5;
			tryAgain();
		}
		String enteredValue = null;
		System.out.print("Type a guess number: ");			
		if(input.hasNext()){
			enteredValue = input.next();
		}
		if(isInteger(enteredValue)){
			int guessNumber = Integer.parseInt(enteredValue);
		    if((guessNumber>max) || (guessNumber<0)) { 
			 	System.out.print("\nError: number must be between 0 to "+max+"\n\n");
			 	getResult();
		    }
		    if (guessNumber == secretNumber) {
		 		System.out.print("\nYOU WIN! \n("+life+")Life bonus awarded!\n");
		 		life *= 2;
		 		System.out.print("Total Lives remaining: "+life+"\n");
		 		tryAgain();
		 	} else if(guessNumber>secretNumber) {
		 		System.out.print("Too BIG\n");
		 		life = life - 1;
		 		System.out.print("Lives remaining: "+life+"\n\n");
		 		getResult();
		 	} else if(guessNumber<secretNumber) {
		 		System.out.print("Too SMALL\n");
		 		life = life - 1;
		 		System.out.print("Lives remaining: "+life+"\n\n");
		 		getResult();
		 	}		
		} else {
			System.out.println("\n\""+enteredValue+"\" is not a Number\n");
			getResult();
		}
	}	
	
	
  //***** Try again ****//
	private void tryAgain(){
		System.out.print("\nWould you like to Start again?\nEnter (y/Y=YES) or anything else to quit: ");
		if(input.hasNext()){
			String choice = input.next();
			if (choice.compareToIgnoreCase("y") == 0){
				beginGame();
			} else {
				exitGame();
			}			
		}
	}
	
	
  //**** Check if a value entered is an Integer *****//
	private static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    if (str.isEmpty()) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (str.length() == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}
		
	
  //**** Exit a game *****//
	private void exitGame(){
		System.out.print("\nGoodBye!");
	    System.exit(0);
	}
	
	
}
