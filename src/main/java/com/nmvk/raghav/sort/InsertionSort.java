package com.nmvk.raghav.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = {1,4,3,5,6,2};
		insertSort(x);
	}

	static void insertSort(int[] num){
		for(int i = 1; i < num.length;i++)
		{
			int j = i;
			int key = num[j];
			while(j>0 && num[j-1] > key )
			{
				num[j] = num[j-1];
				j--;
			}
			
			num[j]= key;
			
			System.out.println(Arrays.toString(num).replaceAll(",", "").replaceAll("\\[", "").replaceAll("\\]", ""));
		}
	}
}
