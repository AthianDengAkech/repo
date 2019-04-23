
package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	public static void main(String[] args) {
		JFrame mainWindow = new JFrame();
		mainWindow.setTitle("My Drawing Graphics");
		mainWindow.setBounds(200,200,600,630);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		
		
		BackPanel dc=new BackPanel();
		mainWindow.getContentPane().add(dc);
		dc.setBackground(Color.WHITE);
		dc.setLayout(null);
		
		
		
		mainWindow.setVisible(true);
		
	}
}
