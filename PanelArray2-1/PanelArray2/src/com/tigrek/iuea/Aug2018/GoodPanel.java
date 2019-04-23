package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class GoodPanel extends JPanel {
	int [] x= {100,140,145};
	int [] y= {200,230,250};
	int sw=50;
	int sh=50;
	int n;
	JPanel [] parray=new JPanel[20];
	public GoodPanel(int w,int h,int n) {
		super();
		sw=w;
		sh=h;
		this.n=n;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int del;
		del=sw/n;
		for(int i=0;i<n;i++)
		{
			g.drawLine(i*del, 0, sw,i*del);;
			g.drawLine(sw-i*del, 0, 0,i*del);;
			g.drawLine(i*del, sw, sw,sw-i*del);;
			g.drawLine(0, i*del,i*del,sw);;
		}
	}
}
