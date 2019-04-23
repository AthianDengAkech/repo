import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Earth {
	BufferedImage [] images;
	int k=0;
	int x=10,y=10;
	Random r=new Random();
	int xvel=3;
	int yvel=4;
	int xdir=1,ydir=1;
	BackPanel parent;
	int id;
	public Earth(BackPanel p,BufferedImage [] imgs,int x,int y,int id)
	{
		parent=p;
		images=imgs;
		this.id=id;
		this.x=x;
		this.y=y;
		//x=r.nextInt(600);
		//y=r.nextInt(600);
		k=r.nextInt(48);
	}
	public void draw(Graphics g)
	{
		//g.drawImage(images[k],x,y,null);
		g.fillOval(x,y,parent.ew,parent.eh);
	}
	public void update()
	{
		k++;
		if(k>parent.fLimit)
		{
			k=0;
		}
		int yold=y;
		int xold=x;
		x=x+xdir*xvel;
		y=y+ydir*yvel;
		
		if(y>parent.sh-parent.eh || y<0)
		{
			ydir=-1*ydir;
			x=xold;
			y=yold;
		}
		if(x>parent.sw-parent.ew || x<0)
		{
			xdir=-1*xdir;
			x=xold;
			y=yold;
		}
		
	}
}
