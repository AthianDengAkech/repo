package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class BackPanel extends JPanel {
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
			parray[i]=new GoodPanel(pw,pw,10);// 10 is number of division for lines
			parray[i].setBounds(space+i*(pw+space),space,pw,pw);
			parray[i].setBackground(Color.red);

			add(parray[i]);
		}


	}


}
