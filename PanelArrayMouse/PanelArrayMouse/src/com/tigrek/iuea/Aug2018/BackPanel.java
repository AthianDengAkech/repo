package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class BackPanel extends JPanel implements MouseListener{
	int [] x= {100,140,145};
	int [] y= {200,230,250};
	int sw=600;
	int sh=600;
	GoodPanel [] parray=new GoodPanel[20];
	public BackPanel() {
		super();
		setLayout(null);
		int nx=10;
		int space=10;
		int pw=(sw-(nx+1)*space)/nx;
		for(int i=0;i<nx;i++)
		{
			parray[i]=new GoodPanel(i,pw,pw,10);// 10 is number of division for lines
			parray[i].setBounds(space+i*(pw+space),space,pw,pw);
			parray[i].setBackground(Color.red);
			parray[i].addMouseListener(this);
			add(parray[i]);
			
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
		GoodPanel cp=(GoodPanel) e.getSource();
		cp.printId();
		if(cp.id==5)
		{
			cp.setBackground(Color.BLUE);
			cp.setBounds(300,300,100,100);
		}
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
