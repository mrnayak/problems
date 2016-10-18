import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Excel {
	public static void main(String[] args) {
        Map<Character, Integer> data = new HashMap<>();
        int i = 1;
        for(char c = 'a'; c <='z'; c++)
            data.put(c,i++);
        Scanner scan = new Scanner(System.in);
        String d = scan.next();
        d = d.toLowerCase();
        char[] cha = d.toCharArray();
        double sum = 0;
        int pos = 0;
        for( i = cha.length - 1; i >= 0; i--)
        {
            double pow = Math.pow(26.0,pos);
            int val = data.get(cha[i]);
            sum+= pow * val;
            pos++;
        }
        
        System.out.println((int)sum);
    }
}
