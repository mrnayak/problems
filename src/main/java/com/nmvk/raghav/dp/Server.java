package com.nmvk.raghav.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        List<Long> xor = new ArrayList<>();
        xor.add(0l);
        xor.add(1l);
        xor.add(3l);
        xor.add(0l);
        xor.add(4l);
        xor.add(1l);
        xor.add(7l);
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
            
            for(int i = xor.size();i <=R;i++)
            {
            	
            	
            	xor.add(i ^ xor.get(i -1));
            }
            
            long x = 0;
            for(long i =L+1; i<=R; i++){
            	x= x ^ xor.get((int)i);
            }
            System.out.println(x);
        }
	}
	
	
	
}
