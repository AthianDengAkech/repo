import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Earth {
	BufferedImage [] images;
	int k=0;
	int x=10,y=10;
	Random r=new Random();
	public Earth(BufferedImage [] imgs,int x,int y)
	{
		images=imgs;
		this.x=x;
		this.y=y;
		//x=r.nextInt(600);
		//y=r.nextInt(600);
		k=r.nextInt(48);
	}
	public void draw(Graphics g)
	{
		g.drawImage(images[k],x,y,null);
	}
	public void update()
	{
		k++;
		if(k>47)
		{
			k=0;
		}
	}
}
