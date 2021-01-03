package LogoFrame;
import java.awt.Color;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogoPanel extends JPanel {

	JLabel logoLabel;
	
	public LogoPanel(){
		
		this.setSize(720, 660);
		this.setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setFocusable(true);
		
		logoLabel = new JLabel();
		logoLabel.setBounds(0, 0, 720, 660);
		logoLabel.setBackground(Color.WHITE);
		ImageIcon icon = createImageIcon("/RobotWar_Logo.jpg", "Nothing");
		logoLabel.setLayout(null);
		logoLabel.setIcon(icon);
		
		this.add(logoLabel);
	}
	ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
