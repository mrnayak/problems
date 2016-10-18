import java.util.Scanner;

public class Relations {

	
	
	static String[] phrase = {"self", "sister", "brother", "daughter", "son","mother","father","niece",
			"nephew", "aunt", "uncle", "cousin", "grand", "great-","1st", "2nd", "3rd", "kin" };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int i = 0;
		
		while(i != -1)
		{
			i = scan.nextInt();
			int j = scan.nextInt();
			String s = scan.next();
			
			if(getParent(i) == getParent(j))
			{
				print( "brother", "sister", s);
			}
			else
			{
				if(isCousin(i, j))
				{
					System.out.println("cousin");
				}
			}
			
		}

	}
	
	static void print(String m1, String m2, String g)
	{
		if(g.equalsIgnoreCase("M"))
			System.out.println(m1);
		else
			System.out.println(m2);
	}
	static int getParent(int pos)
	{
		return (pos -1) / 2;
	}
	
	static boolean isCousin(int a, int b)
	{
		double level = Math.log(a+2)/Math.log(2);
		double level2 = Math.log(b+2) / Math.log(2);
		double lev = Math.ceil(level);
		if(Math.ceil(level) == Math.ceil(level2))
		{
			System.out.println("cousin");
			return true;
		}
		
		
		
		
		return false;
	}
	
	

}
