package GameFrame;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class RulesPanel extends JPanel {
	
	JTextPane textPane1;

	public RulesPanel(){
		this.setSize(720, 700);
		this.setLocation(0, 0);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setFocusable(true);
		
		textPane1 = new JTextPane();
		
		Font font = new Font("Helvetica", Font.BOLD, 15);
		textPane1.setFont(font);

		SimpleAttributeSet attributeSet = new SimpleAttributeSet();
	    StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
	    textPane1.setCharacterAttributes(attributeSet, true);
	    textPane1.setEditable(false);
	    this.add(textPane1);
	    
	    
	    textPane1.setBounds(0,0,720,700);
	    
	    StringBuilder about = new StringBuilder();
	    
	    about.append("\t\t\t\tControl:\n");
	    about.append("Player 1: Green Robot:\n\n");
	    about.append("Move:\t\t Up->U\n");
	    about.append("\t Left->H \t\tRight->K\t\t\t***Green bar is player 1 Health\n");
	    about.append("\t\t Down->J\n\n\n");
	    
	    about.append("Shoot:\t\t       Upper shoot->W\n");
	    about.append("\t Left shoot->A \t\tRight shoot->D\n");
	    about.append("\t\t       Down shoot->S\n\n\n\n\n");
	    
	    
	    about.append("Player 2: Red Robot:\n\n");
	    about.append("Move:\t\t   Up->Up arrow\n");
	    about.append("\t Left->Left arrow \t\tRight->Right arrow\t    ***Red bar is player 2 Health\n");
	    about.append("\t\t   Down->Down arrow\n\n\n");
	    
	    about.append("Shoot:\t\t             Upper shoot->Numpad8\n");
	    about.append("\t Left shoot->Numpad4 \t\tRight shoot->Numpad6\n");
	    about.append("\t\t              Down shoot->Numpad2\n\n\n\n\n");
	    
	    about.append("\t\t\t\tRules:\n\n");
	    about.append("IF PLAYER 1 ABLES TO REDUCE THE LIFE OF PLAYER 2, THEN THE PLAYER 1 WINS."
	    		+ "IF PLAYER 2 ABLES TOREDUCE THE LIFE OF PLAYER 1, THEN THE PLAYER 2 WINS");
	    textPane1.setText(about.toString());
	}
}
