package GameFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class AboutPanel extends JPanel{
	
	
	
	JTextPane textPane;

	public AboutPanel(){
		this.setSize(720, 700);
		this.setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setFocusable(true);
		
		textPane = new JTextPane();
		
		Font font = new Font("Helvetica", Font.BOLD, 14);
		textPane.setFont(font);

		SimpleAttributeSet attributeSet = new SimpleAttributeSet();
	    StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
	    textPane.setCharacterAttributes(attributeSet, true);
	    textPane.setEditable(false);
	    this.add(textPane);
	    
	    
	    textPane.setBounds(0,0,720,700);
	    
	    StringBuilder about = new StringBuilder();
	    //about.append("FunCKit ").append(getVersion()).append("\n\n");
	    about.append("It is the year of 2089. People keep on inventing new ways to"
	    		+ " destroy each other. But this time something went wrong.The new war has started and people did not pay much attention to what they have done to the biggest part of the world."
	    		+ " Ruin, radiation – this is what remained after laser weapon reached the territories. But other nations flourished."
	    		+ " So people started to use robots to conquer new territories and slave other nations."
	    		+ "Then the Robot War begins...\n");
	    about.append("\nRobot War is a top-down shooter video game developed and released by Mustakim,Ahsan and Talha.It is released for the Windows platform. It is released in Bangladesh on August 30,2016. The game is a multiplayer shooter game where players can control their robots and fight. With this JAVA game you will not be bored in school or at work."
	    		+ " Beautiful graphics and addictive gameplay will keep you captivated for a very long time.\n");
	    about.append("\nAdditional Information:\n");
	    about.append("Robot War\n");
	    about.append("Version:1.0\n");
	    about.append("Developer:Mustakim\n");
	    about.append("Designer:Ahsan\n");
	    about.append("Management:Talha\n");
	    about.append("Requirement:Windows XP,7 or 10 [Java must be installed]\n");
	    about.append("Released On:30 August,2016\n");

	    textPane.setText(about.toString());
	    
	}
	
	
	
}
/*
public AboutWindow(JFrame frame) {
	
    super(frame);

    this.setTitle(tr("AboutWindow.about"));
    this.setLayout(new BorderLayout(500, 80));
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.setSize(400, 400);
    Font font = new Font("Helvetica", Font.PLAIN, 14);

    JTextPane textPane = new JTextPane();
    textPane.setFont(font);
    SimpleAttributeSet attributeSet = new SimpleAttributeSet();
    StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
    textPane.setCharacterAttributes(attributeSet, true);
    textPane.setEditable(false);

    StringBuilder about = new StringBuilder();
    about.append("FunCKit ").append(getVersion()).append("\n\n");
    about.append("Peter Dahlberg\n");
    about.append("Lukas Elsner\n");
    about.append("Thomas Poxrucker\n");
    about.append("Julian Stier\n");
    about.append("Alexander Treml\n");
    about.append("Sebastian Vetter");

    textPane.setText(about.toString());
    this.add(textPane);
}
private Object tr(String string) {
	// TODO Auto-generated method stub
	return null;
}
private void setDefaultCloseOperation(int disposeOnClose) {
	// TODO Auto-generated method stub
	
}
*/