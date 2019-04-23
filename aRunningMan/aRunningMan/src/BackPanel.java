

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class BackPanel extends JPanel implements MouseListener, Runnable{
	int sw=800,sh=800;
	Point [][] coords;
	BufferedImage img,imgBall;
	BufferedImage bimage;
	AudioInputStream myaudioIn;
	Clip myclip;
	int x=100,y=100;
	BufferedImage [] images;
	int [][] pixels={{4,35,33,33},{40,23,60,60},{105,0,93,93},{200,0,110,100},{315,0,113,100},{430,0,116,100},{552,0,106,100}};
	int pn=7;
	int [] size;
	int k=pn;
	int xvel=1;
	int dirx=1;
	public BackPanel() {
		setLayout(null);	
		takeImage();
		processImage();
		this.addMouseListener(this);
		takeSound();
	}
	public void takeImage() 
	{
		URL imgURL = getClass().getResource("/running2.jpg");
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
		int r=4;
		int c=3;
		pn=r*c;
		images=new BufferedImage[pn];
		int xorg=30;
		int yorg=30;
		int iNum=0;
		int w=180,h=180;
		for(int j=0;j<r;j++)
		{
			for(int i=0;i<c;i++)
			{
				images[iNum]=new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
				int x1=xorg+194*i;
				int y1=yorg+194*j;
				images[iNum]=img.getSubimage(x1,y1,w,h);	
				iNum++;
			}
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(images[k],x,y,this);
	}
	public void play() {
		if (myclip.isRunning())
			myclip.stop();
		myclip.start();     // Start playing
		myclip.setFramePosition(0); // rewind to the beginning
	}
	public void takeSound()
	{
		try {
			myaudioIn = AudioSystem.getAudioInputStream(getClass().getResource("/explode.wav"));              
			// Get a sound clip resource.
			myclip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			myclip.open(myaudioIn);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();
		y=e.getY();
		k=0;
		play();
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				k++;
				if(k>=pn)
					k=0;
				//x=x+5;
				if(x>800)
					x=0;
				repaint();
				Thread.sleep(30);
			} catch (InterruptedException iex) {

			}
		}
	}
}
