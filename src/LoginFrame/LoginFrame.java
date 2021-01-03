package LoginFrame;

import GameFrame.*;
import signupFrame.signupFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

public class LoginFrame extends JFrame{

	JPanel loginPanel;
	GameFrame gameFrame = new GameFrame();
	
	DataAccess da=new DataAccess();
    ResultSet rs=null;
    
   
	
	public LoginFrame(){
		
		this.setTitle("Login");
		this.setSize(723, 700);
		
		ImageIcon icon = createImageIcon("/Tank_Right.png", "Nothing");
		this.setIconImage(icon.getImage());
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.requestFocusInWindow();
		
		
	
		addLoginPanel();
	}
	
	public void Close(){
		WindowEvent windowEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
	}
	public void addLoginPanel(){
		loginPanel = new JPanel();
		loginPanel.setSize(300, 250);
		loginPanel.setLocation(400, 150);
		loginPanel.setLayout(null);
		loginPanel.setBorder(new TitledBorder("Login"));
		loginPanel.setBackground(Color.lightGray);
		
		JLabel userLbl = new JLabel("Username");
		JLabel passLbl = new JLabel("Password");
		JLabel signupLbl = new JLabel("If Not Registered, Sign Up");
		JTextField userFld = new JTextField();
		userFld.setBorder(BorderFactory.createLineBorder(Color.black));
		JPasswordField passFld = new JPasswordField();
		passFld.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton loginBtn = new JButton("Login");
		JButton signupBtn = new JButton("Signup");
		
		userLbl.setBounds(30, 80, 60, 10);userFld.setBounds(130, 75, 140, 20);
		passLbl.setBounds(30, 120, 60, 10);passFld.setBounds(130, 115, 140, 20);
		loginBtn.setBounds(185, 160, 80, 20);
		signupLbl.setBounds(30, 200, 150, 20);
		signupBtn.setBounds(185, 200, 80, 20);
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Close();
				gameFrame.setVisible(true);
				String name = userFld.getText();
				String passw = new String(passFld.getPassword());
		        try {
		        	String q="select * from profile";
			        rs=da.getData(q);
			        int flag = 0;
			        
					while(rs.next()){
					    String uname = rs.getString("username");
						String pass = rs.getString("password");
						
						if(name.equals(uname) && passw.equals(pass)){
							Label l1 = new Label("Logged in successfully");
							JOptionPane.showMessageDialog(null,l1);
							if (JOptionPane.OK_OPTION == 0) {
								
								Close();
								gameFrame.setVisible(true);
								
									
							}
							//this.setVisible(true);
							flag = 1;
							break;
						}
						
						else{
							flag = 0;
						}	
					}
					
					if(flag == 0){
						Label l2 = new Label("Invalid Username or password");
						JOptionPane.showMessageDialog(null,l2);
						//this.setVisible(true);	
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
				
				
			}
		});
		
		signupBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e1) {
				Close();
				signupFrame signupFrame = new signupFrame();
				signupFrame.setVisible(true);
				
				
			}
			
		});
		
		loginPanel.add(userLbl);loginPanel.add(userFld);
		loginPanel.add(passLbl);loginPanel.add(passFld);
		loginPanel.add(loginBtn);loginPanel.add(signupBtn);
		loginPanel.add(signupLbl);
		
		this.add(loginPanel);
		
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
