import java.awt.Color;

import javax.swing.JFrame;



public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mainWindow = new JFrame();
		mainWindow.setTitle("My Drawing Graphics");
		mainWindow.setBounds(800,200,800,830);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		BackPanel dc=new BackPanel();
		mainWindow.getContentPane().add(dc);
		dc.setBackground(Color.WHITE);
		dc.validate();
		dc.repaint();
		mainWindow.setVisible(true);
		
		Thread t=new Thread(dc);
		t.start();
	}

}
