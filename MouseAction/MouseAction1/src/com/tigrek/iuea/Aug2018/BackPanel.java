package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class BackPanel extends JPanel  {
	
	public BackPanel() {
		
	}
	@Override
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int k=5;
		for(int i=0;i<50;i++)
		{
			g.drawOval(300-k*i, 300-k*i,10+2*k *i, 10+2*k*i);
		}
	}
}
