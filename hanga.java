import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math.*;

public class hanga {
	public static void main (String[] arg) {
		String randomOrd = selectOrd();
		String displayOrd = createDisplayOrd(randomOrd);
		
		boolean hasWon = false;
		int wordCounter = 0;
		
		//Window
		while(hasWon == false){
		String input = "";
		input = JOptionPane.showInputDialog(null, "Gissa en bokstav eller ord!" + "\n" + randomOrd + "\n" + displayOrd);
		
		//Check for answer
			if(input.length() == 1 ){
				int wordChecker = randomOrd.indexOf(input);
			
				while(wordChecker != -1){
				String wordCut1 = displayOrd.substring(0, wordChecker);
				String wordCut2 = displayOrd.substring(wordChecker + 1 );
				displayOrd = wordCut1 + input + wordCut2;
				wordCounter++;
				System.out.println("Position of guessed character = " + wordChecker + "\n" + displayOrd + "\n" + "Wordcounter = " + wordCounter);
				wordChecker = randomOrd.indexOf(input, wordChecker + 1);
				}
			}
			else if(input.equals(randomOrd)){
				JOptionPane.showMessageDialog(null, "You Win!");
				System.exit(0);
			} 
			else if(wordCounter == randomOrd.length()){
				JOptionPane.showMessageDialog(null, "You Win!");
				System.exit(0);
				}
			}
		}	

	
	public static String selectOrd() {
		// Meme list
		String[] ord = {"forever alone",
						"doge",
						"lenny face", 
						"trollface",
						"me gusta", 
						"bitch please", 
						"dolan", 
						"you dont say"};
		// Random Meme Selector
		int r = (int)(Math.random()*ord.length);
		String randomOrd = ord[r];
		
		// Random Word Length Checker
		int randomOrdL = randomOrd.length();
		for (int i = 0 ; i < randomOrdL;i++) {
			if(randomOrd.charAt(i) == ' '){
				randomOrdL = randomOrdL - 1;
			}
		}
		System.out.println("Random word length = " + randomOrdL);
		return randomOrd;
	}
	
	public static String createDisplayOrd(String randomOrd) {
		// Word replacement to "_" 
		int displayOrdL = randomOrd.length();
		String displayOrd = "";
		int displayOrdL2 = randomOrd.length();
		
		for (int i = 0 ; i < displayOrdL;i++) {
			if(randomOrd.charAt(i) == ' '){
				displayOrd = displayOrd + ' ';
				displayOrdL2 = displayOrdL2 - 1;
			}
			else{
				displayOrd = displayOrd + "_";
			}
		} 
		System.out.println("Random word cencored length = " + displayOrdL2);
		return displayOrd;
	}
}