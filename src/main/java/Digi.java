import java.math.BigInteger;
import java.util.Scanner;

public class Digi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String n = in.next();
		String x = in.next();
		
		BigInteger ex = new BigInteger(x);
		BigInteger en = new BigInteger(n);
		
		long sum=1l;
		for(;; en = en.add(BigInteger.ONE))
		{
			if(en.compareTo(ex) == 0)
				break;
			String str = en.toString();
			long tsum = 0;
			for(int j = 1; j < str.length() -1; j++)
			{
				if(str.charAt(j) > str.charAt(j+1) && str.charAt(j) > str.charAt(j-1)){
					sum++;
				}
				else if(str.charAt(j) < str.charAt(j+1) && str.charAt(j) < str.charAt(j-1)){
					sum++;
				}
			}
			
		}
		
		System.out.println(sum);
	}

}
