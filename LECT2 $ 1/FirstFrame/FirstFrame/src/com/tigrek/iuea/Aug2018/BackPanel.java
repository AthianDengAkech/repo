package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class BackPanel extends JPanel {
	
	public BackPanel() {
		super();
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawOval(100, 100, 50, 50);
		
	}
}
