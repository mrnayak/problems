import java.util.Scanner;

public class Selfie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();
		
		int s = 0;
		
		for(int i= 1; i <= n; i++)
		{
			s += select(n,i);
		}
		
		int y = s > x? s - x : x -s ;
		System.out.println(y);
	}

	public static int select(int n, int r){
	    if(n < r)
	        return 0;
	    if(r == 0 || r == n)
	        return 1;
	    return select(n-1,r-1)+select(n-1,r);
	}
}
