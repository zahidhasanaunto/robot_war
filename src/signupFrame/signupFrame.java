package signupFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import GameFrame.GameFrame;
import LoginFrame.DataAccess;
import LoginFrame.LoginFrame;

public class signupFrame extends JFrame{
	
	
	protected static final Component Component = null;
	JPanel signupPanel;
	GameFrame gameFrame = new GameFrame();
	
	DataAccess da=new DataAccess();
    ResultSet rs=null;
    
public signupFrame(){
		
		this.setTitle("SignUp");
		this.setSize(723, 700);
		
		ImageIcon icon = createImageIcon("/Tank_Right.png", "Nothing");
		this.setIconImage(icon.getImage());
		
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.requestFocusInWindow();
		
		
	
		addSignupPanel();
	}

public void Close(){
	WindowEvent windowEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
}
	
public void addSignupPanel(){
	signupPanel = new JPanel();
	signupPanel.setSize(400, 300);
	signupPanel.setLocation(180, 150);
	signupPanel.setLayout(null);
	signupPanel.setBorder(new TitledBorder("Signup"));
	signupPanel.setBackground(Color.lightGray);
	
	JLabel userLbl = new JLabel("Username");
	JLabel passLbl = new JLabel("Password");
	JLabel passLb2 = new JLabel("Confirm Password");
	
	JTextField userFld = new JTextField();
	userFld.setBorder(BorderFactory.createLineBorder(Color.black));
	
	JPasswordField passFld = new JPasswordField();
	passFld.setBorder(BorderFactory.createLineBorder(Color.black));
	
	JPasswordField passFld1 = new JPasswordField();
	passFld1.setBorder(BorderFactory.createLineBorder(Color.black));
	
	JButton ConfirmBtn = new JButton("Confirm");
	
	
	userLbl.setBounds(30, 80, 60, 10);userFld.setBounds(160, 75, 140, 20);
	passLbl.setBounds(30, 120, 60, 10);passFld.setBounds(160, 115, 140, 20);
	passLb2.setBounds(30, 160, 150, 10);passFld1.setBounds(160, 153, 140, 20);
	ConfirmBtn.setBounds(140,220,140,20);
	
	ConfirmBtn.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			String uname = userFld.getText();
			String pass = passFld.getText();
			String pass1 = passFld1.getText();
			
			if(!pass.equals(pass1) ){
				JOptionPane.showMessageDialog(Component, "Password Does not match");
				userFld.setText("");
				passFld.setText("");
				passFld1.setText("");
			}
			else{
				try {
					String q="insert into profile values('"+uname+"','"+pass+"')";
					int c=da.updateDB(q);
					da.close();
					JOptionPane.showMessageDialog(Component, "Regestered Successfully");
					Close();
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.setVisible(true);
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		
	});
	
	signupPanel.add(userLbl);signupPanel.add(userFld);
	signupPanel.add(passLbl);signupPanel.add(passFld);signupPanel.add(passFld1);
	signupPanel.add(passLb2);signupPanel.add(ConfirmBtn);
	
	
	this.add(signupPanel);
}
	/*public void setvisible(boolean b) {
		// TODO Auto-generated method stub
		
	}*/
	
	
	
	
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
