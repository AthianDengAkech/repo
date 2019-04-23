import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.swing.Timer;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class BackPanel extends JPanel implements ActionListener, Runnable{

	BufferedImage img,imgBall;
	BufferedImage bimage;
	int x=100,y=100;
	BufferedImage [] images;
	private Timer timer;
	private static int speed = 100;
	int imgw,imgh;
	int xvel=4,yvel=5;
	int xdir=1,ydir=1;
	int k=0;
	int sw=600;int sh=600;

	public BackPanel() {
		setLayout(null);	
		//takeImage();
		//processImage();
		otherImage();
		imgw=img.getWidth();
		imgh=img.getHeight();
		
	}
	public void takeImage() 
	{
		URL imgURL = getClass().getResource("/frames.jpg");
		System.out.println(imgURL);
		try {
			img=ImageIO.read(imgURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void processImage()
	{
		int r=5;
		int c=5;
		int pn=r*c;
		images=new BufferedImage[pn];
		int xorg=50;
		int yorg=50;
		int iNum=0;
		int w=240,h=240;
		for(int j=0;j<r;j++)
		{
			for(int i=0;i<c;i++)
			{
				images[iNum]=new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
				int x1=xorg+w*i;
				int y1=yorg+h*j;
				images[iNum]=img.getSubimage(x1,y1,w,h);	
				iNum++;
			}
		}
	}
	public void otherImage() 
	{
		URL imgURL = getClass().getResource("/earth2d.gif");
		System.out.println(imgURL);
		try {
			img=ImageIO.read(imgURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int r=6;
		int c=8;
		int pn=r*c;
		images=new BufferedImage[pn];
		int xorg=1;
		int yorg=0;
		int iNum=0;
		int w=80,h=80;
		for(int j=0;j<r;j++)
		{
			for(int i=0;i<c;i++)
			{
				images[iNum]=new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
				int x1=xorg+w*i;
				int y1=yorg+h*j;
				images[iNum]=img.getSubimage(x1,y1,w,h);	
				iNum++;
			}
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(images[k],x,y,this);
		//g.drawImage(img,x,y,x+imgw/3,y+imgh/3,0,0,imgw,imgh,this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		x=x+10;
		y=y+10;
		repaint();
	}
	@Override
	public void run() {
		 while(true){
	            try{
	            	int xold=x;
	            	int yold=y;
	               x=x+xdir*xvel;
	               y=y+ydir*yvel;
	               if(y>sh-images[0].getHeight() || y<0)
					{
						ydir=-1*ydir;
						x=xold;
						y=yold;
					}
					if(x>sw-images[0].getWidth() || x<0)
					{
						xdir=-1*xdir;
						x=xold;
						y=yold;
					}
	            	k=k+1;
	            	if(k>=48)
	            		k=0;
	                Thread.sleep(100);
	                repaint();
	            } catch (InterruptedException iex) {
	               
	            }
	        }
	}



}
