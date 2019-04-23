
public class MoveMain implements Runnable {
	int x=10;
	int k=0;
	int dir=1;
	public MoveMain()
	{
		print();
	}
	public void print()
	{
		for(int i=0;i<k;i++)
		{
			System.out.print(" ");
		}
		System.out.println("*");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveMain mm=new MoveMain();
		Thread t=new Thread(mm);
		t.start();
	}
	@Override
	public void run() {
		 while(true){
	            try{
	            	x=x+1;
	            	k=k+dir;
	            	if(k>20 || k<0)
	            	{
	            		dir=-1*dir;
	            	}
	            	print();
	                Thread.sleep(300);
	                
	            } catch (InterruptedException iex) {
	               
	            }
	        }
	}
}
