import java.util.Scanner;

public class EulerHex {

	static int x = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long ip = scan.nextInt();

		long op = (ip - 1) * (ip - 1);

		for (long i = ip - 2; i > 0; i--) {
			op *= i;

		}
		
		long modulo = (long) (Math.pow(10,9) + 7);
		System.out.println(op % modulo);

	}
}
