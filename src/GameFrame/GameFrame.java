package GameFrame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import LogoFrame.LogoFrame;

public class GameFrame extends JFrame implements Serializable{

	private static final long serialVersionUID = 2L;
	
	GamePanel gamePanel = new GamePanel();
	 AboutPanel aboutPanel = new AboutPanel();
	 RulesPanel rulesPanel = new RulesPanel();
	 Container container;
	 JMenuBar bar;
	 JMenu fileMenu,helpMenu;
     JMenuItem newGameMenuItem,exitMenuItem,aboutMenuItem,rulesMenuItem,saveGameMenuItem,loadGameMenuItem;
	
	public GameFrame(){
		this.setTitle("Game");
		this.setSize(723, 750);
		
		ImageIcon icon = createImageIcon("/Tank_Right.png", "Nothing");
		this.setIconImage(icon.getImage());
		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		addMenu();addMenuListToFrame();
		
		this.add(gamePanel);
	}
	public void addMenuListToFrame(){
		this.exitMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int exitOption = JOptionPane.YES_NO_OPTION;
				JOptionPane optionPane = new JOptionPane();
				JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning", exitOption);
				if (exitOption == JOptionPane.YES_OPTION) {
					System.exit(0);
				}if (exitOption == JOptionPane.NO_OPTION) {
					remove(optionPane);
				}
			}
		});
		this.newGameMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				container = getContentPane();
				container.removeAll();
				container.revalidate();
				container.add(gamePanel);
				container.revalidate();
				container.repaint();
				gamePanel.ResetGame();
				gamePanel.ResetLife();
				gamePanel.requestFocusInWindow();
			}
		});
		this.rulesMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RulesPanel rulesPanel = new RulesPanel();
				container = getContentPane();
				container.removeAll();
				container.revalidate();
				container.add(rulesPanel);
				container.revalidate();
				container.repaint();
				rulesPanel.requestFocusInWindow();
				
			}
		});
		this.aboutMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AboutPanel aboutPanel = new AboutPanel();
				container = getContentPane();
				container.removeAll();
				container.revalidate();
				container.add(aboutPanel);
				container.revalidate();
				container.repaint();
				aboutPanel.requestFocusInWindow();
				
			}
		});
		this.saveGameMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String file = "RobotWar.ser";
				
				try {
					   FileOutputStream   fileOutput = new FileOutputStream(file);
					   ObjectOutputStream output = new ObjectOutputStream(fileOutput);
					   output.writeObject(gamePanel);
					   output.close();
					   fileOutput.close();
					   JOptionPane.showMessageDialog(null, "Game Saved");
					  } catch(IOException i) {
					   i.printStackTrace();
					  } catch(Exception e1){
					   e1.printStackTrace();
					  } finally{
						 gamePanel = null;
					  }
				
			}
		});
		this.loadGameMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String file = "RobotWar.ser";
				try {
					   FileInputStream fileInput = new FileInputStream(file);
					   ObjectInputStream input = new ObjectInputStream(fileInput);
					   gamePanel = (GamePanel) input.readObject();
					   getContentPane().removeAll();
					   revalidate();repaint();
					   getContentPane().add(gamePanel);
					   revalidate();repaint();
					   input.close();
					   fileInput.close();
					   JOptionPane.showMessageDialog(null, "Game Loaded");
					  } catch (IOException i) {
					   i.printStackTrace();
					   return;
					  } catch (ClassNotFoundException c) {
					   System.out.println("Data class not found");
					   c.printStackTrace();
					  }
			}
		});
	}
	public void addMenu(){
		this.bar = new JMenuBar();
        this.fileMenu = new JMenu("File");
        this.helpMenu = new JMenu("Help");
        this.newGameMenuItem = new JMenuItem("New Game");
        this.exitMenuItem = new JMenuItem("Exit");
        this.aboutMenuItem = new JMenuItem("About");
        this.rulesMenuItem = new JMenuItem("Game Rules");
        this.saveGameMenuItem = new JMenuItem("Save");
        this.loadGameMenuItem = new JMenuItem("Load");
        
        this.setJMenuBar(this.bar);
        bar.setVisible(true);
        this.bar.add(this.fileMenu);this.bar.add(this.helpMenu);
        this.fileMenu.add(newGameMenuItem);this.fileMenu.add(exitMenuItem);this.fileMenu.add(saveGameMenuItem);this.fileMenu.add(loadGameMenuItem);
        this.helpMenu.add(rulesMenuItem);this.helpMenu.add(aboutMenuItem);
        
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
