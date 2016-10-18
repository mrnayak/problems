package com.nmvk.raghav;

import java.util.Arrays;

public class MergeSort {

	int num[];
	int helper[];
	
	public MergeSort(int[] n)
	{
		num = n;
		helper = new int[n.length];
	}
	
	public void mergeSort(int low,  int high)
	{
		if(low < high)
		{
			int mid = low + (high - low) / 2;
			mergeSort(low, mid);
			mergeSort(mid+1, high);
			merge(low, mid, high);
		}
		
	}
	
	private void merge(int low, int mid, int high)
	{
		for(int k = low; k<=high; k++)
		{
			helper[k] =num[k];
		}
		
		
		int i = low;
		int j = mid + 1;
		int k  = low;
		while(i <= mid && j <= high)
		{
			if(helper[i] <= helper[j])
			{
				num[k++] = helper[i];
				i++;
			}
			else
			{
				num[k++] = helper[j];
				j++;
			}
		}
		
		while(i <= mid)
		{
			num[k++] = helper[i];
			i++;
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = {4,2,1,5,6};
		MergeSort ms = new MergeSort(a);
		
		ms.mergeSort(0, a.length - 1);
		
		System.out.println(Arrays.toString(ms.num));
		
	}

}
