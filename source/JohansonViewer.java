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

import java.awt.Graphics;



public class JohansonViewer extends JFrame{
	private JPanel panel;
	private JLabel background;
	private MainWin my_mw;
	
	public JohansonViewer(MainWin mw){
		my_mw = mw;
		createView();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createView(){
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				closeWindow();
			}
		});
		backButton.setBounds(20, 20, 100, 30);
		panel.add(backButton);

		BufferedImage img;
		background = new JLabel();
		background.setBounds(20, 65, 1000, 800);
		panel.add(background);
		try{
			img = ImageIO.read(getClass().getResource("Images/johanson.jpg"));
			background.setIcon(new ImageIcon(img));
		} catch (IOException ex){}

		setTitle("Inspired by Chris Johanson");
		setSize(1070, 1020);

		Person David = new Person("Images/person1.jpg", "David", this);
		David.setBounds(60, 890, 100, 30);
		panel.add(David);

		Person Jim = new Person("Images/person2.jpg", "Jim", this);
		Jim.setBounds(260, 890, 100, 30);
		panel.add(Jim);

		Person Stacey = new Person("Images/person3.jpg", "Stacey", this);
		Stacey.setBounds(460, 890, 100, 30);
		panel.add(Stacey);

		Person George = new Person("Images/person4.jpg", "George", this);
		George.setBounds(660, 890, 100, 30);
		panel.add(George);
		
		Person Linda = new Person("Images/person5.jpg", "Linda", this);
		Linda.setBounds(860, 890, 100, 30);
		panel.add(Linda);
	}

	private void closeWindow(){
		my_mw.setVisible(true);
		dispose();
	}

	public void changeImage(String newImage){
		try{
			BufferedImage img = ImageIO.read(getClass().getResource(newImage));
			background.setIcon(new ImageIcon(img));
		} catch(IOException e){}
	}
}
