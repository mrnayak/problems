import java.util.Arrays;
import java.util.Scanner;

public class LongSub {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int[] nums = new int[t];
		for (int i = 0; i < t; i++) {
			nums[i] = scan.nextInt();
		}
		
		System.out.println(longSequ(nums));
	}

	public static int longSequ(int nums[])
	{
		int data[] = new int[nums.length + 1];
		for(int i = 0; i < data.length; i++)
			data[i] = 1;
		boolean breakLoop = true ;
		for(int i = 0; i < nums.length && breakLoop; i++)
		{
			for(int j = i+1; j < nums.length; j++)
			{
				if(nums[i] <= nums[j])
				{
					data[j] = data[j] + 1;
				}
				else
					break;
				if(j == nums.length -1)
					breakLoop = false;
			}
		}
		
		System.out.println(Arrays.toString(data));
		int max = 0;
		for(int d : data)
		{
			if(d > max)
				max = d;
		}
		return max;
	}
	
}
