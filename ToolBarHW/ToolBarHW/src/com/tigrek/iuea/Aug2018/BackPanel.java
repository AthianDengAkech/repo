package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class BackPanel extends JPanel implements MouseListener {
	ToolPanel tp;
	int tool=ToolPanel.OVAL;
	boolean start=false;
	Point stPoint=null;
	Point endPoint=null;
	public BackPanel() {
		setLayout(null);
		tp=new ToolPanel(this);
		tp.setBounds(0,0,60,600);
		tp.setBackground(Color.YELLOW);

		this.addMouseListener(this);
		tp.addMouseListener(this);
		add(tp);
		this.setFocusable(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JPanel p=(JPanel) e.getSource();

		if(p==tp)
		{
			System.out.println("Tools");
			Point ploc=e.getPoint();
			tool=tp.getTool(ploc);
			if(tool==ToolPanel.OVAL)
			{
				System.out.println("OVAL");
			}else if(tool==ToolPanel.RECT)
			{
				System.out.println("RECT");
			}
			repaint();
		}else
		{
			System.out.println("Canvas");

		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!start)
		{
			stPoint=e.getPoint();
			start=true;
			stPoint=e.getPoint();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(start)
		{
			endPoint=e.getPoint();
			start=false;
		}
		repaint();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if(tool==ToolPanel.OVAL)
		{
			if(stPoint!=null && endPoint!=null)
				g.drawOval((int)stPoint.getX(), (int)stPoint.getY(), (int)endPoint.getY()-(int)stPoint.getX(), (int)endPoint.getY()-(int)stPoint.getX());
		}else if(tool==ToolPanel.RECT)
		{
			if(stPoint!=null && endPoint!=null)
				g.drawRect((int)stPoint.getX(), (int)stPoint.getY(), (int)endPoint.getY()-(int)stPoint.getX(), (int)endPoint.getY()-(int)stPoint.getX());
		}
	}
}
