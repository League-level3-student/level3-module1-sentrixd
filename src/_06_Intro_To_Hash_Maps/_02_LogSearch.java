package _06_Intro_To_Hash_Maps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements MouseListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer,String> database = new HashMap<Integer,String>();
	
	int id;
	String name;
	
	JFrame frame;
	JPanel panel;
	
	JButton button1;
	JButton button2;
	JButton button3;
	
	JButton button4;
	
	JButton button5;
	
	
	public static void main(String[] args) {
		new _02_LogSearch().load();
	}
	
	void load() {
		frame = new JFrame();
		panel = new JPanel();
		
		button1 = new JButton("Click to enter the user's ID");
		button2 = new JButton("Click the button above before using this one");
		button3 = new JButton("Done");
		button4 = new JButton("View USER");
		button5 = new JButton("View list");
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		
		button1.addMouseListener(this);
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		button4.addMouseListener(this);
		button5.addMouseListener(this);
		
		frame.add(panel);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == button1) {
			String input = JOptionPane.showInputDialog("Please enter the ID of the user.");
			id = Integer.parseInt(input);
			
			button2.setText("Click to enter the user's name");
		} else if (e.getSource() == button2) {
			String input2 = JOptionPane.showInputDialog("Please enter the NAME of the user.");
			
			name = input2;
			
			button3.setText("Click to save!");
		} else if (e.getSource() == button3) {
			database.put(id, name);
			
			JOptionPane.showMessageDialog(null, "Successfully saved the user to the database! \n " + "ID: " + id + "\n" + "NAME: " + name);
		} else if (e.getSource() == button4) {
			String input3 = JOptionPane.showInputDialog("Please enter an ID number");
			int convertedInput = Integer.parseInt(input3);
			
			JOptionPane.showMessageDialog(null, "The USER you looked for returned: " + database.get(convertedInput));
		} else if (e.getSource() == button5) {
			for(int i : database.keySet()){
				JLabel tempLabel = new JLabel("ID: " + i + " USER: " + database.get(i));
				
				panel.add(tempLabel);
			}
			
			frame.pack();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
