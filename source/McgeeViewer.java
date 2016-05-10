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

public class McgeeViewer extends JFrame{
	private JPanel panel;
	private MainWin my_mw;
	private Group[][] tiles;
	private BufferedImage original;
	private BufferedImage withTwist;
	private BufferedImage[] errors;

	public McgeeViewer(MainWin mw){
		my_mw = mw;
		createUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createUI(){
		panel = new JPanel();
		add(panel);
		panel.setLayout(null);

		setTitle("Inspired by Barry McGee");
		setSize(1070, 1020);

		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){
				closeWindow();
			}
		});
		backButton.setBounds(20, 20, 100, 30);
		panel.add(backButton);

		original = null;
		withTwist = null;
		errors = new BufferedImage[3]; 
		for (int i=0; i<3; i++) errors[i] = null;

		try{
			original = ImageIO.read(getClass().getResource("Images/mcgee.jpg"));
			withTwist = ImageIO.read(getClass().getResource("Images/withtwist.jpg"));
			errors[0] = ImageIO.read(getClass().getResource("Images/error1.jpg"));
			errors[1] = ImageIO.read(getClass().getResource("Images/error2.jpg"));
			errors[2] = ImageIO.read(getClass().getResource("Images/error3.jpg"));
		} catch(IOException e){}


		tiles = new Group[4][5];
		for (int d = 0; d < 4; d++){
			for (int r = 0; r < 5; r++){
				int type;
				if (d == 0 || r == 0 || d == 3 || r == 4) type = 0;
				else if (d == 1 && r < 3) type = 1;
				else if (d == 1 || r > 2) type = 2;
				else type = 3;
				tiles[d][r] = new Group(type, this, d, r);
				tiles[d][r].setIcon(new ImageIcon(original.getSubimage(r*200, d*200, 200, 200)));
				tiles[d][r].setBounds(20+r*200, 65+d*200, 200, 200);
				panel.add(tiles[d][r]);
			}
		}
	}
	
	public void adjustImage(int typeID, int down, int right){
		if (typeID == 0){
			for (int d=0; d<4; d++){
				for (int r=0; r<5; r++) tiles[d][r].setIcon(new ImageIcon(original.getSubimage(r*200, d*200, 200, 200)));
			}
			tiles[down][right].goOutside(new ImageIcon(withTwist.getSubimage(right*200, down*200, 200, 200)));
		}
		else{
			for (int d=0; d<4; d++){
				for (int r=0; r<5; r++) tiles[d][r].setIcon(new ImageIcon(errors[typeID-1].getSubimage(r*200, d*200, 200, 200)));
			}
		}
	}
	
	private void closeWindow(){
		my_mw.setVisible(true);
		dispose();
	}


}

