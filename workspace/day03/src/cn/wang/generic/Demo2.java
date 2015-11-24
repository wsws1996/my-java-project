package cn.wang.generic;

import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3 };
		swap(arr, 1, 2);
		System.out.println(Arrays.asList(arr));
		Integer arr2[]={1,2,3,4,5};
		reverse(arr2);
		System.out.println(Arrays.asList(arr2));
	}

	public static <T> void swap(T arr[], int pos1, int pos2) {
		T temp = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = temp;
	}
	public static <T> void reverse(T arr[]) {
		int start=0;
		int end=arr.length-1;
		while (true) {
			
			if (start>=end) {
				break;
			}
			
			T temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}
