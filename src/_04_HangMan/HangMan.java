package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangMan implements KeyListener {
	Stack<String> words;
	int wordsInDictionary = 0;
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	JLabel lives;
	
	String currentWord;
	String word;
	String pastCharacters;
	
	char[] characters;
	
	int wordIndex;
	
	int maxHealth = 10;
	int health;
	
	public static void main(String[] args) {
		new _04_HangMan.HangMan().run();
	}
	
	void run() {
		
		wordsInDictionary = Utilities.getTotalWordsInFile("dictionary.txt");
		
		words = new Stack<String>();
		
		String input1 = JOptionPane.showInputDialog("Hangman: How many words would you like to guess? Please select a number below " + wordsInDictionary + "!");
		int convertedInput1 = Integer.parseInt(input1);
		
		for (int i = 0; i < convertedInput1; i ++) {
			String randomWord = Utilities.readRandomLineFromFile("dictionary.txt");
			
			if (!words.contains(randomWord)) { 
				words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			}
		}
		
		//for (int i = 0; i < words.capacity() - 1; i++) {
			//System.out.println(words.pop());
		//}
		
		currentWord = words.pop();
		
		word = "null";
		health = 10;
		
		characters = new char[currentWord.length()];
		
		word = "";
		for (int i = 0; i < currentWord.length(); i ++) {
			word = word + "_";
			characters[i] = '_';
		}
		
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		
		label = new JLabel(word);
		lives = new JLabel("Health: " + health + "/" + maxHealth);
		
		panel.add(label);
		panel.add(lives);
		
		frame.pack();
		frame.setVisible(true);
		
		frame.addKeyListener(this);
		
		wordIndex = 0;
		
		System.out.println(currentWord);
	}
	
	void restartGame() {
		currentWord = words.pop();
		
		word = "null";
		health = 10;
		
		characters = new char[currentWord.length()];
		
		word = "";
		for (int i = 0; i < currentWord.length(); i ++) {
			word = word + "_";
			characters[i] = '_';
		}
		
		label.setText(word);
		lives.setText("Health: " + health + "/" + maxHealth);
		
		frame.pack();
		
		wordIndex = 0;
		
		System.out.println(currentWord);
	}
	
	void removeHealth() {
		if (health > 0) {
			health--;
			lives.setText("Health: " + health + "/" + maxHealth);
			
			frame.pack();
		} else {
			JOptionPane.showMessageDialog(null, "Aw Man! You died.");
			
			restartGame();
		}
	}
	
	void checkIfWon() {
		String wordConverted = makeStringFromCharArray(characters);
		
		if (wordConverted.contains(currentWord)) {
			JOptionPane.showMessageDialog(null, "You won congrats!");
			restartGame();
		}
	}
	
	String makeStringFromCharArray(char[] chr) {
		String convertedString = "";
		
		for (int i = 0; i < chr.length; i++) {
			convertedString = convertedString + chr[i];
		}
		
		return convertedString;
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		char keyChar = ke.getKeyChar();
		boolean found = false;
		
		for (int i = 0; i < currentWord.length(); i++) {
			char charAtIndex = currentWord.charAt(i);
			
			if (keyChar == charAtIndex) {

				characters[i] = charAtIndex;
				
				found = true;
			}
		}
		
		
		if (!found) {
			removeHealth();
		}
		
		label.setText(makeStringFromCharArray(characters));
		frame.pack();
		
		checkIfWon();
		
		//if (keyChar == charAtIndex) { 
		//	System.out.println("yes");
		//	word = currentWord.substring(wordIndex, wordIndex + 1) + word.substring(wordIndex + 1, word.length());
			
		//	wordIndex++;
			
		//	update();
		//} else {
		//	if (health <= 0) {
		//		System.out.println("oof");
				
		//		JOptionPane.showMessageDialog(null, "You ran out of lives! Aw man!");
		//	} else {
		//		removeHealth();
		//	}
		//}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
