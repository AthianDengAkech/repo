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
	int sw=600,sh=600;
	public BackPanel() {
		setLayout(null);	
		takeImage();
		imgw=img.getWidth();
		imgh=img.getHeight();
		imgBall=new BufferedImage(30,30, BufferedImage.TYPE_INT_RGB);
		Graphics g=imgBall.getGraphics();
		g.drawImage(img,0,0,x+imgBall.getWidth(),y+imgBall.getHeight(),0,0,imgw,imgh,this);
	}
	public void takeImage() 
	{
		URL imgURL = getClass().getResource("/earth.jpeg");
		System.out.println(imgURL);
		try {
			img=ImageIO.read(imgURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img,x,y,this);
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
	            	
	               x=x+xdir*xvel;
	               y=y+ydir*yvel;
	                Thread.sleep(100);
	                repaint();
	            } catch (InterruptedException iex) {
	               
	            }
	        }
	}



}
