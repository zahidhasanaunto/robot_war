package GameFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import sun.audio.*;


public class GamePanel extends JPanel implements KeyListener,Serializable{
	
	private static final long serialVersionUID = 3L;
	
	Timer timer;
	int s_x, s_y, s2_x, s2_y;
	int ps_x, ps_y, ps2_x, ps2_y;
	
	int sm_s_x, sm_s_y, sm_s2_x, sm_s2_y;
	int sm_ps_x, sm_ps_y, sm_ps2_x, sm_ps2_y;
	
	int lifeX, lifeY, lifeW, lifeH;
	int e_lifeX, e_lifeY, e_lifeW, e_lifeH;
	
	MyRobot myRobot = new MyRobot();
	PcRobot pcRobot = new PcRobot();
	JLabel logoLabel,btnLabel;
	
	public GamePanel(){
		
		s_x = 900; s_y = 900;s2_x = 900; s2_y = 900;
		ps_x = 900; ps_y = 900;ps2_x = 900; ps2_y = 900;
		
		sm_s_x = 900; sm_s_y = 900;sm_s2_x = 900; sm_s2_y = 900;
		sm_ps_x = 900; sm_ps_y = 900;sm_ps2_x = 900; sm_ps2_y = 900;
		
		lifeX = 706; lifeY = 0; lifeW = 10; lifeH = 700;
		e_lifeX = 0; e_lifeY = 0; e_lifeW = 10; e_lifeH = 700;
		
		this.setSize(720, 700);
		this.setLocation(0, 0);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		this.setFocusable(true);
		this.addKeyListener(this);
		
		MusicWar();
		

		myRobot.setLocation(660, 650);
		pcRobot.setLocation(30, 20);
		timer = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		this.add(myRobot);
		this.add(pcRobot);
	}
	@Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(10, 0, 10, 700);
        g.drawLine(80, 0, 80, 700);g.drawLine(10, 70, 705, 70);
        g.drawLine(150, 0, 150, 700);g.drawLine(10, 140, 705, 140);
        g.drawLine(220, 0, 220, 700);g.drawLine(10, 210, 705, 210);
        g.drawLine(290, 0, 290, 700);g.drawLine(10, 280, 705, 280);
        g.drawLine(360, 0, 360, 700);g.drawLine(10, 350, 705, 350);
        g.drawLine(430, 0, 430, 700);g.drawLine(10, 420, 705, 420);
        g.drawLine(500, 0, 500, 700);g.drawLine(10, 490, 705, 490);
        g.drawLine(570, 0, 570, 700);g.drawLine(10, 560, 705, 560);
        g.drawLine(640, 0, 640, 700);g.drawLine(10, 630, 705, 630);
        g.drawLine(705, 0, 705, 700);
       
        //Lazer
        g.setColor(Color.RED);
        g.drawRect(s_x, s_y, 100, 1);
        g.drawRect(s2_x, s2_y, 1, 100);
        g.drawRect(ps_x, ps_y, 100, 1);
        g.drawRect(ps2_x, ps2_y, 1, 100);
        //Small Lazer
        g.drawRect(sm_s_x, sm_s_y, 30, 1);
        g.drawRect(sm_s2_x, sm_s2_y, 1, 30);
        g.drawRect(sm_ps_x, sm_ps_y, 30, 1);
        g.drawRect(sm_ps2_x, sm_ps2_y, 1, 30);
        
        //Life
        g.setColor(Color.RED);
        g.draw3DRect(e_lifeX, e_lifeY, e_lifeW, e_lifeH, true);
        g.fill3DRect(e_lifeX, e_lifeY, e_lifeW, e_lifeH, true);
        
        g.setColor(Color.GREEN);
        g.draw3DRect(lifeX, lifeY, lifeW, lifeH, true);
        g.fill3DRect(lifeX, lifeY, lifeW, lifeH, true);
    }
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			
			// Player one move
			case KeyEvent.VK_K: {
				myRobot.removeAll();
				myRobot.addIconRight();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getX()<=630){
					myRobot.setLocation(myRobot.getX() + 70, myRobot.getY() + 0);
				}
				else break;
			}break;
			case KeyEvent.VK_H: {
				myRobot.removeAll();
				myRobot.addIconLeft();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getX()>=70){
					myRobot.setLocation(myRobot.getX() - 70, myRobot.getY() + 0);
				}
				else break;
			}break;
			case KeyEvent.VK_U: {
				myRobot.removeAll();
				myRobot.addIconUp();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getY()>=70){
					myRobot.setLocation(myRobot.getX() + 0, myRobot.getY() - 70);
				}
				else break;
			}break;
			case KeyEvent.VK_J: {
				myRobot.removeAll();
				myRobot.addIconDown();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;
				s_x = 900;s_y = 900;
				if(myRobot.getY()<=630){
					myRobot.setLocation(myRobot.getX() + 0, myRobot.getY() + 70);
				}
				else break;
			}break;
			
			// player one shoot
			
			case KeyEvent.VK_A: {
				myRobot.removeAll();
				myRobot.addIconLeft();
				myRobot.repaint();
				myRobot.revalidate();			
				s2_x = 900;s2_y = 900;sm_s2_x = 900;sm_s2_y = 900;
				int x = myRobot.getX() - pcRobot.getX();
				if (x==70) {
					sm_s_x = myRobot.getX() - 30;
					sm_s_y = myRobot.getY() + 15;
				}else {
					s_x = myRobot.getX() - 105;
					s_y = myRobot.getY() + 15;
				}
				System.out.println(pcRobot.getX()+" "+pcRobot.getY());
				System.out.println(sm_s_x+" "+sm_s_y);
				System.out.println(myRobot.getX()+" "+myRobot.getY());
				MusicShoot();
				ShootToEnemyLeft();
				
			}break;
			case KeyEvent.VK_D: {
				myRobot.removeAll();
				myRobot.addIconRight();
				myRobot.repaint();
				myRobot.revalidate();
				s2_x = 900;s2_y = 900;sm_s2_x = 900;sm_s2_y = 900;
				int x = pcRobot.getX() - myRobot.getX();
				if (x==70) {
					sm_s_x = myRobot.getX() + 35;
					sm_s_y = myRobot.getY() + 15;
				}else {
					s_x = myRobot.getX() + 35;
					s_y = myRobot.getY() + 15;
				}
				System.out.println(pcRobot.getX()+" "+pcRobot.getY());
				System.out.println(sm_s_x+" "+sm_s_y);
				System.out.println(myRobot.getX()+" "+myRobot.getY());
				MusicShoot();
				ShootToEnemyRight();
				
			}break;
			case KeyEvent.VK_W: {
				myRobot.removeAll();
				myRobot.addIconUp();
				myRobot.repaint();
				myRobot.revalidate();
				s_x = 900;s_y = 900;sm_s_x = 900;sm_s_y = 900;
				int y = myRobot.getY() - pcRobot.getY();
				if (y==70) {
					sm_s2_y = myRobot.getY() - 35;
					sm_s2_x = myRobot.getX() + 15;
				}else {
					s2_y = myRobot.getY() - 105;
					s2_x = myRobot.getX() + 15;
				}
				System.out.println(pcRobot.getX()+" "+pcRobot.getY());
				System.out.println(sm_s2_x+" "+sm_s2_y);
				System.out.println(myRobot.getX()+" "+myRobot.getY());
				MusicShoot();
				ShootToEnemyUp();
//				System.out.println(pcRobot.getX()+" "+pcRobot.getY());
//				System.out.println(s2_x+" "+s2_y);
//				System.out.println(myRobot.getX()+" "+myRobot.getY());
			}break;
			case KeyEvent.VK_S: {
				myRobot.removeAll();
				myRobot.addIconDown();
				myRobot.repaint();
				myRobot.revalidate();
				s_x = 900;s_y = 900;sm_s_x = 900;sm_s_y = 900;
				int y = pcRobot.getY() - myRobot.getY();
				if (y==70) {
					sm_s2_y = myRobot.getY() + 35;
					sm_s2_x = myRobot.getX() + 15;
				}else {
					s2_y = myRobot.getY() + 35;
					s2_x = myRobot.getX() + 15;
				}
				System.out.println(pcRobot.getX()+" "+pcRobot.getY());
				System.out.println(sm_s2_x+" "+sm_s2_y);
				System.out.println(myRobot.getX()+" "+myRobot.getY());
				MusicShoot();
				ShootToEnemyDown();
			}break;
			
			
			// player two Robot move
			
			case KeyEvent.VK_RIGHT: {
				pcRobot.removeAll();
				pcRobot.addIconRight();
				pcRobot.repaint();
				pcRobot.revalidate();
				ps2_x = 900;ps2_y = 900;
				ps_x = 900;ps_y = 900;
				if(pcRobot.getX()<=630){
					pcRobot.setLocation(pcRobot.getX() + 70, pcRobot.getY() + 0);
				}
				else break;
			}break;
			case KeyEvent.VK_LEFT: {
				pcRobot.removeAll();
				pcRobot.addIconLeft();
				pcRobot.repaint();
				pcRobot.revalidate();
				ps2_x = 900;ps2_y = 900;
				ps_x = 900;ps_y = 900;
				if(pcRobot.getX()>=70){
					pcRobot.setLocation(pcRobot.getX() - 70, pcRobot.getY() + 0);
				}
				else break;
			}break;
			case KeyEvent.VK_UP: {
				pcRobot.removeAll();
				pcRobot.addIconUp();
				pcRobot.repaint();
				pcRobot.revalidate();
				ps2_x = 900;ps2_y = 900;
				ps_x = 900;ps_y = 900;
				if(pcRobot.getY()>=70){
					pcRobot.setLocation(pcRobot.getX() + 0, pcRobot.getY() - 70);
				}
				else break;
			}break;
			case KeyEvent.VK_DOWN: {
				pcRobot.removeAll();
				pcRobot.addIconDown();
				pcRobot.repaint();
				pcRobot.revalidate();
				ps2_x = 900;ps2_y = 900;
				ps_x = 900;ps_y = 900;
				if(pcRobot.getY()<=630){
					pcRobot.setLocation(pcRobot.getX() + 0, pcRobot.getY() + 70);
				}
				else break;
			}break;
			
			// Player two shoot 
			
			case KeyEvent.VK_NUMPAD4: {
				pcRobot.removeAll();
				pcRobot.addIconLeft();
				pcRobot.repaint();
				pcRobot.revalidate();			
				ps2_x = 900;ps2_y = 900;sm_ps2_x = 900;sm_ps2_y = 900;
				int x = pcRobot.getX() - myRobot.getX();
				if (x==70) {
					sm_ps_x = pcRobot.getX() - 35;
					sm_ps_y = pcRobot.getY() + 15;
				}else {
					ps_x = pcRobot.getX() - 105;
					ps_y = pcRobot.getY() + 15;
				}
				MusicShoot();
				ShootToMeLeft();
			}break;
			case KeyEvent.VK_NUMPAD6: {
				pcRobot.removeAll();
				pcRobot.addIconRight();
				pcRobot.repaint();
				pcRobot.revalidate();
				ps2_x = 900;ps2_y = 900;sm_ps2_x = 900;sm_ps2_y = 900;
				int x = myRobot.getX() - pcRobot.getX();
				if (x==70) {
					sm_ps_x = pcRobot.getX() + 35;
					sm_ps_y = pcRobot.getY() + 15;
				}else {
					ps_x = pcRobot.getX() + 35;
					ps_y = pcRobot.getY() + 15;
				}
				MusicShoot();
				ShootToMeRight();
			}break;
			case KeyEvent.VK_NUMPAD8: {
				pcRobot.removeAll();
				pcRobot.addIconUp();
				pcRobot.repaint();
				pcRobot.revalidate();
				ps_x = 900;ps_y = 900;sm_ps_x = 900;sm_ps_y = 900;
				int y = pcRobot.getY() - myRobot.getY();
				if (y==70) {
					sm_ps2_y = pcRobot.getY() - 35;
					sm_ps2_x = pcRobot.getX() + 15;
				}
				else {
					ps2_y = pcRobot.getY() - 105;
					ps2_x = pcRobot.getX() + 15;
				}
				MusicShoot();
				ShootToMeUp();
			}break;
			case KeyEvent.VK_NUMPAD2: {
				pcRobot.removeAll();
				pcRobot.addIconDown();
				pcRobot.repaint();
				pcRobot.revalidate();
				ps_x = 900;ps_y = 900;sm_ps_x = 900;sm_ps_y = 900;
				int y = myRobot.getY() - pcRobot.getY();
				if (y==70) {
					sm_ps2_y = pcRobot.getY() + 35;
					sm_ps2_x = pcRobot.getX() + 15;
				}else {
					ps2_y = pcRobot.getY() + 35;
					ps2_x = pcRobot.getX() + 15;
				}
				MusicShoot();
				ShootToMeDown();
			}break;
	
			default:
			break;
		}
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		
		// player one shoot release
		case KeyEvent.VK_A: {
			s_x = 900;
			s_y = 900;
			sm_s_x = 900;
			sm_s_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_D: {
			s_x = 900;
			s_y = 900;
			sm_s_x = 900;
			sm_s_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_W: {
			s2_x = 900;
			s2_y = 900;
			sm_s2_x = 900;
			sm_s2_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_S: {
			s2_x = 900;
			s2_y = 900;
			sm_s2_x = 900;
			sm_s2_y = 900;
			repaint();
		}break;
		
		// player two robot shoot release
		
		case KeyEvent.VK_NUMPAD4: {
			ps_x = 900;
			ps_y = 900;
			sm_ps_x = 900;
			sm_ps_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_NUMPAD6: {
			ps_x = 900;
			ps_y = 900;
			sm_ps_x = 900;
			sm_ps_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_NUMPAD8: {
			ps2_x = 900;
			ps2_y = 900;
			sm_ps2_x = 900;
			sm_ps2_y = 900;
			repaint();
		}break;
		case KeyEvent.VK_NUMPAD2: {
			ps2_x = 900;
			ps2_y = 900;
			sm_ps2_x = 900;
			sm_ps2_y = 900;
			repaint();
		}break;
	
		default:
			break;
		}
	
	}
	
	public void ResetGame(){
		
		myRobot.setLocation(650, 650);
		pcRobot.setLocation(20, 20);
	}
	public void ResetLife(){
		lifeX = 706; lifeY = 0; lifeW = 10; lifeH = 700;
		e_lifeX = 0; e_lifeY = 0; e_lifeW = 10; e_lifeH = 700;
	}
	public void ShootToEnemyLeft(){
		int x = s_x - pcRobot.getX();
		int y = s_y - pcRobot.getY();
		int x2 = sm_s_x - pcRobot.getX();
		if (x<=35 && y==15) {
			e_lifeY = e_lifeY + 10;
			e_lifeH = e_lifeH - 10;
			if (e_lifeH == 0) {
				
				String string = "Player 1";
				MusiceEmotion();
				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
				s_x = 900;s_y = 900;
				ps_x = 900;ps_y = 900;
				sm_s_x = 900;sm_s_y = 900;
				sm_ps_x = 900;sm_ps_y = 900;
			}
		}
//		if (x2==40 && y==15) {
//			e_lifeY = e_lifeY + 10;
//			e_lifeH = e_lifeH - 10;
//			if (e_lifeH == 0) {
//				
//				String string = "Player 1";
//				MusiceEmotion();
//				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
//				s_x = 900;s_y = 900;
//				ps_x = 900;ps_y = 900;
//				sm_s_x = 900;sm_s_y = 900;
//				sm_ps_x = 900;sm_ps_y = 900;
//			}
//		}
	}
	public void ShootToEnemyRight(){
		int x = pcRobot.getX() - s_x;
		int y = s_y - pcRobot.getY();
		if (x<=105 && y==15) {
			e_lifeY = e_lifeY + 10;
			e_lifeH = e_lifeH - 10;
			if (e_lifeH == 0) {
				
				String string = "Player 1";
				MusiceEmotion();
				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
				s_x = 900;s_y = 900;
				ps_x = 900;ps_y = 900;
			}
		}
	}
	public void ShootToEnemyUp(){
		int x = s2_y - pcRobot.getY();
		int y = s2_x - pcRobot.getX();
		if (x<=35 && y==15) {
			e_lifeY = e_lifeY + 10;
			e_lifeH = e_lifeH - 10;
			if (e_lifeH == 0) {
				
				String string = "Player 1";
				MusiceEmotion();
				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
				s_x = 900;s_y = 900;
				ps_x = 900;ps_y = 900;
			}
		}
	}
	public void ShootToEnemyDown(){
		int x = pcRobot.getY() - s2_y;
		int y = s2_x - pcRobot.getX();
		if (x<=105 && y==15) {
			e_lifeY = e_lifeY + 10;
			e_lifeH = e_lifeH - 10;
			if (e_lifeH == 0) {
				
				String string = "Player 1";
				MusiceEmotion();
				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
				s_x = 900;s_y = 900;
				ps_x = 900;ps_y = 900;
			}
		}
	}
	//Shoot to My Robot
	public void ShootToMeLeft(){
		int x = ps_x - myRobot.getX();
		int y = ps_y - myRobot.getY();
		if (x<=35 && y==15) {
			lifeY = lifeY + 10;
			lifeH = lifeH - 10;
			if (lifeH == 0) {
				
				String string = "Player 2";
				MusiceEmotion();
				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
				s_x = 900;s_y = 900;
				ps_x = 900;ps_y = 900;
			}
		}
	}
	public void ShootToMeRight(){
		int x = myRobot.getX() - ps_x;
		int y = ps_y - myRobot.getY();
		if (x<=105 && y==15) {
			lifeY = lifeY + 10;
			lifeH = lifeH - 10;
			if (lifeH == 0) {
				
				String string = "Player 2";
				MusiceEmotion();
				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
				s_x = 900;s_y = 900;
				ps_x = 900;ps_y = 900;
			}
		}
	}
	public void ShootToMeUp(){
		int x = ps2_y - myRobot.getY();
		int y = ps2_x - myRobot.getX();
		if (x<=35 && y==15) {
			lifeY = lifeY + 10;
			lifeH = lifeH - 10;
			if (lifeH == 0) {
				
				String string = "Player 2";
				MusiceEmotion();
				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
				s_x = 900;s_y = 900;
				ps_x = 900;ps_y = 900;
			}
		}
	}
	public void ShootToMeDown(){
		int x = myRobot.getY() - ps2_y;
		int y = ps2_x - myRobot.getX();
		if (x<=105 && y==15) {
			lifeY = lifeY + 10;
			lifeH = lifeH - 10;
			if (lifeH == 0) {
				
				String string = "Player 1";
				MusiceEmotion();
				JOptionPane.showMessageDialog(null, string +" win :) :) :)");
				s_x = 900;s_y = 900;
				ps_x = 900;ps_y = 900;
			}
		}
	}
	public void MusicWar(){
		
		try {
	         URL url = this.getClass().getClassLoader().getResource("war.wav");
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
	
	public void MusiceEmotion(){
		
		try {
	         URL url = this.getClass().getClassLoader().getResource("emotion.wav");
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
	public void MusicShoot(){
		
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