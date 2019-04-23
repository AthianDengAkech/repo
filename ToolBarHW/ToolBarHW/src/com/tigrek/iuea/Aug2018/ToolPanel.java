package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class ToolPanel extends JPanel {
	BackPanel mainPanel;
	Rectangle cRect=new Rectangle(0,0,50,50);
	Rectangle rRect=new Rectangle(0,55,50,50);
	public static final int OVAL=0;
	public static final int RECT=1;
	int tool=OVAL;
	public ToolPanel(BackPanel bp)
	{
		super();
		mainPanel=bp;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0,0, 50, 110);

		g.setColor(Color.BLUE);
		g.drawOval(3,3, 50, 50);
		g.drawRect(3,60, 50, 50);
		if(tool==OVAL)
		{
			g.fillOval(3,3, 50, 50);
		}else if(tool==RECT)
		{
			g.fillRect(3,60, 50, 50);
		}

	}
	public int getTool(Point p)
	{
		//System.out.println("Coordinates "+p.x+" "+p.y);
		//printRect(rRect);
		//printRect(cRect);
		if(cRect.contains(p.x, p.y))
		{
			tool=OVAL;
			return OVAL;

		}else if (rRect.contains(p.x, p.y))

		{	
			tool=RECT;
			return RECT;
		}
		repaint();
		return -1;
	}
	public void printRect(Rectangle r)
	{
		System.out.println("RECT "+r.x+" "+r.y+" "+r.width+" "+r.height);
	}
}