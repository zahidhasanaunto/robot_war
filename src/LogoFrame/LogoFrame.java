package LogoFrame;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import LoginFrame.LoginFrame;

public class LogoFrame extends JFrame implements KeyListener{

	LogoPanel logoPanel = new LogoPanel();
	LoginFrame loginFrame = new LoginFrame();
	
	public LogoFrame(){
		this.setTitle("Robot War");
		this.setSize(723, 700);
		
		ImageIcon icon = createImageIcon("/Tank_Right.png", "Nothing");
		this.setIconImage(icon.getImage());
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.requestFocusInWindow();
		
		this.setLayout(null);
		Music();
		logoPanel.addKeyListener(this);
		this.add(logoPanel);
		
	}
	public void Close(){
		WindowEvent windowEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ENTER: {
			Music1();
			Close();
			loginFrame.setVisible(true);
			
		}break;
		
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
public void Music(){
		
		try {
	         URL url = this.getClass().getClassLoader().getResource("blast.wav");
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	         Clip clip = AudioSystem.getClip();
	         clip.open(audioIn);
	         clip.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	   }

public void Music1(){
	
	try {
         URL url = this.getClass().getClassLoader().getResource("Shoot_sound.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         Clip clip = AudioSystem.getClip();
         clip.open(audioIn);
         clip.start();
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }
}
