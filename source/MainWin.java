package viewer;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class MainWin extends JFrame{
	private JPanel panel;
	private MainWin test;

	public MainWin(){
		initUI();
		test = this;
	}
	
	private void initUI(){
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);
	
		JLabel welcome = new JLabel("View digital art inspired by artists from \"Beautiful Losers.\" A final project by Melanie Hamasaki.");
		welcome.setBounds(106, 30, 600, 30);
		panel.add(welcome);

		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		quitButton.setBounds(500, 315, 100, 30);
		panel.add(quitButton);

		setTitle("Gallery");
		setSize(780, 460);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JButton johanson = new JButton("Chris Johanson");
		try{
			BufferedImage johansonIcon = ImageIO.read(getClass().getResource("Images/johanson.jpg"));
			johanson.setIcon(new ImageIcon(johansonIcon.getScaledInstance(250, 200, Image.SCALE_DEFAULT)));
		} catch (IOException ex){}
		johanson.setVerticalTextPosition(SwingConstants.CENTER);
		johanson.setHorizontalTextPosition(SwingConstants.CENTER);
		johanson.setBounds(100, 90, 250, 200);
		johanson.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				JohansonViewer jv = new JohansonViewer(test);
				jv.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(johanson);

		JButton mcgee = new JButton("Barry McGee");
		try{
			BufferedImage mcgeeIcon = ImageIO.read(getClass().getResource("Images/mcgee.jpg"));
			mcgee.setIcon(new ImageIcon(mcgeeIcon.getScaledInstance(250, 200, Image.SCALE_DEFAULT)));
		} catch (IOException ex){}
		mcgee.setVerticalTextPosition(SwingConstants.CENTER);
		mcgee.setHorizontalTextPosition(SwingConstants.CENTER);
		mcgee.setBounds(400, 90, 250, 200);
		mcgee.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				McgeeViewer mv = new McgeeViewer(test);
				mv.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(mcgee);	
	}


	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run(){
				MainWin mw = new MainWin();
				mw.setVisible(true);
			}
		});
	}
}
