package viewer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Person extends JButton{
	private String imgName;
	private JohansonViewer myViewer;
	
	public Person(String imageName, String name, JohansonViewer par){
		super(name);
		imgName = imageName;
		myViewer = par;

		addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				myViewer.changeImage(imgName);
			}
		});
	}
}
