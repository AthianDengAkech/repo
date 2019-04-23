
public class MainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p=0;
		for(int j=0;j<8;j++)
		{
			System.out.print(j+"::");
			for (int i=0;i<8;i++)
			{
				System.out.print("("+j+","+i+")");
				p=p+10;
			}
			System.out.println("//"+p);
		}
                
                
	}

}
