package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class BackPanel extends JPanel implements MouseListener {
	
	public BackPanel() {
		super();
		JPanel pp=new JPanel();
		pp.setBounds(300,300,100,100);
		pp.setBackground(Color.RED);
		add(pp);
		pp.addMouseListener(this);
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
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicked");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse pressed");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse released");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Entered");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse exited");
	}
}
