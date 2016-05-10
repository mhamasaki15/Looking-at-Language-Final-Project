package viewer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Group extends JButton{
	private int typeID;
	private McgeeViewer myViewer;
	int my_down, my_right;
	
	public Group(int new_type, McgeeViewer mv, int down, int right){
		typeID = new_type;
		myViewer = mv;
		my_down = down;
		my_right = right;

		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				myViewer.adjustImage(typeID, my_down, my_right); //implement this.	
			}
		});
	}
	
	private void goInside(ImageIcon withTwist){
		setIcon(withTwist);
	}

	public void goOutside(ImageIcon withTwist){
		setIcon(withTwist);
	}
	

}
