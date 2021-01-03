package GameFrame;

import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PcRobot extends JPanel {

	
	public PcRobot(){
		this.setSize(30, 30);
		this.setLayout(null);
		this.setFocusable(true);
		ImageIcon icon = createImageIcon("/Tank_Right.png", "Nothing");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 30, 30);
		label.setIcon(icon);
		this.add(label);
		
	}
	public void addIconRight(){
		ImageIcon icon = createImageIcon("/Tank_Right.png", "Nothing");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 30, 30);
		label.setIcon(icon);
		this.add(label);
	}
	public void addIconDown(){
		ImageIcon icon = createImageIcon("/Tank_Down.png", "Nothing");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 30, 30);
		label.setIcon(icon);
		this.add(label);
	}
	public void addIconUp(){
		ImageIcon icon = createImageIcon("/Tank_Up.png", "Nothing");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 30, 30);
		label.setIcon(icon);
		this.add(label);
	}
	public void addIconLeft(){
		ImageIcon icon = createImageIcon("/Tank_Left.png", "Nothing");
		JLabel label = new JLabel();
		label.setBounds(0, 0, 30, 30);
		label.setIcon(icon);
		this.add(label);
	}
	
	ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } 
        else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	    
}

