package com.tigrek.iuea.Aug2018;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BackPanel extends JPanel {
	int [] x= {100,140,145};
	int [] y= {200,230,250};
	int sw=600;
	int sh=600;
	JPanel [] parray=new JPanel[20];
	public BackPanel() {
		super();
		setLayout(null);
		for(int i=0;i<20;i++)
		{
			parray[i]=new JPanel();
			parray[i].setBounds(10+i*50,200,30,30);
			parray[i].setBackground(Color.red);

			add(parray[i]);
		}
	}
}
