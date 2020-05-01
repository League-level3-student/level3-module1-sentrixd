package _03_IntroToStacks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	JFrame frame;
	JPanel panel;
	JLabel label;
	
	public static void main(String[] args) {
		new _02_TextUndoRedo().run();
	}
	
	void run() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		
		panel.add(label);
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		
		frame.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		
		if (key == KeyEvent.VK_BACK_SPACE) {
			// Make sure that the text isn't blank
			if (label.getText() != "" || label.getText() != null) {
				String text = label.getText().substring(0, label.getText().length() - 1); 
				
				label.setText(text);
			}
		} else {
			label.setText(label.getText() + ke.getKeyChar());
			System.out.println(ke.getKeyChar() + " ");
		}
		
		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method 
	}
}
