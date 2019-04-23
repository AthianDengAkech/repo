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
	int nHorizontal=8;
	int nVertical=8;
	int nEarth=nHorizontal*nVertical;
	int nLimit=2;
	int fLimit=10;
	Earth [] e;
	int ew=80,eh=80; // earth dimensions
	int sw=800,sh=800;
	public BackPanel() {
		setLayout(null);	
		makeImages();
		
		e=new Earth[nEarth];
		createEarths();
		this.setDoubleBuffered(true);
	}
	public void createEarths()
	{
		int p=0;
		for(int j=0;j<nVertical;j++)
		{
			for (int i=0;i<nHorizontal;i++)
			{
				e[p]=new Earth(this,images,j*100,i*100,i);
				p++;
			}
		}
	}
	public void makeImages() 
	{
		URL imgURL = getClass().getResource("/earth2d.png");
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
		
		for(int j=0;j<r;j++)
		{
			for(int i=0;i<c;i++)
			{
				images[iNum]=new BufferedImage(ew,eh, BufferedImage.TYPE_INT_RGB);
				int x1=xorg+ew*i;
				int y1=yorg+eh*j;
				images[iNum]=img.getSubimage(x1,y1,ew,eh);	
				iNum++;
			}
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//g.drawImage(img,x,y,x+imgw/3,y+imgh/3,0,0,imgw,imgh,this);
		for(int i=0;i<nLimit;i++)
		{
			e[i].draw(g);
		}
	}
	public void additionaldrawing(Graphics g)
	{

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
				for(int i=0;i<nLimit;i++)
				{
					e[i].update();
				}
				Thread.sleep(30);
				repaint();
			} catch (InterruptedException iex) {
					
			}
		}
	}
	


}
