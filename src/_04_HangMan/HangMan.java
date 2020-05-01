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
	
	String currentWord;
	String word;
	int wordIndex;
	
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
		
		word = "";
		for (int i = 0; i < currentWord.length(); i ++) {
			word = word + "_";
		}
		
		frame = new JFrame();
		panel = new JPanel();
		frame.add(panel);
		
		label = new JLabel(word);
		panel.add(label);
		
		frame.pack();
		frame.setVisible(true);
		
		frame.addKeyListener(this);
		
		wordIndex = 0;
		
		System.out.println(currentWord);
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		char keyChar = ke.getKeyChar();
		String stringAtIndex = currentWord.substring(wordIndex, wordIndex + 1);
		char charAtIndex = stringAtIndex.charAt(0);
		
		if (keyChar == charAtIndex) { 
			System.out.println("yes");
		}
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
