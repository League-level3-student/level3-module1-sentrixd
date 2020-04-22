package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	
	ArrayList<String> names = new ArrayList<String>();
	
	JFrame frame;
	JPanel panel;
	
	JButton addName;
	JTextField inputBox;
	JButton viewName;
	
	
	public static void main(String[] args) {
		new _02_GuestBook().showPanel();
	}
	
	void showPanel() {
		frame = new JFrame();
		frame.setTitle("Hotel list");
		
		panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JLabel title = new JLabel("Hotel List");
		panel.add(title);
		
		addName = new JButton("Add Name(s)");
		inputBox = new JTextField("");
		viewName = new JButton("View Name(s)");
		
		panel.add(addName);
		panel.add(inputBox);
		panel.add(viewName);
		
		addName.addActionListener(this);
		viewName.addActionListener(this);
		
		frame.add(panel);
		
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(addName)) {
			if (!inputBox.getText().equals("")) {
				System.out.println(inputBox.getText());
				names.add(inputBox.getText());
			} else {
				// System.out.println("INPUT BLANK")
			}
		} else if (e.getSource().equals(viewName)) {
			for (String s : names) {
				JLabel tempText = new JLabel(s + "");
				
				panel.add(tempText);
			}
			
			frame.pack();
		}
	}
}
