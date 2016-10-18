import java.util.Scanner;

public class Refract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double d = scan.nextDouble();
		double h = scan.nextDouble();
		double x = scan.nextDouble();
		double n1 = scan.nextDouble();
		double n2 = scan.nextDouble();
		
		double min = 0.01;
		double max = 89.99;
		double phi = 0D; 
		while(true)
		{
			phi = (max+min) / 2;
			double t1 = 90 - phi;
			double x1 = d * Math.tan(Math.toRadians(t1));
			
			double t2 = Math.asin(n2*Math.sin(Math.toRadians(t1))/n1);
			
			double x2 = h* Math.tan(t2);
			
			x1 = Math.round(x1 * 100.0) / 100.0;
			x2 = Math.round(x2 * 100.0) / 100.0;
			
			if(x1+ x2  == x)
			{
				System.out.println(Math.round((phi * 100.0))/100.0);
				break;
			}
			if(x1 + x2 > x){
				min = phi; 
			}
			else
			{
				max = phi;
			}
			
		}
		

	}

}
