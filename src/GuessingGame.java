
public class GuessingGame {
	
	public static void main(String[] args) {
		
		GuessNumber game = new GuessNumber();
		
	    System.out.print("\n** Guessing Game **\n");
	    System.out.print("The goal is to guess a correct number that the Game randomly pick.\n");
	    System.out.print("Hint: The Game will tell you if the number is too big or too small compared\n");
	    System.out.print("to the secret number to find.\n");
	    
	    game.beginGame();   
	}
}
