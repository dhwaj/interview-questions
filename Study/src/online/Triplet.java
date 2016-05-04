package online;

import java.util.Arrays;

public class Triplet {

	public static int findmaxlessthan(int[] arr, int x){
		if(arr.length == 1) return 0;
		if(arr.length == 2){
			if(arr[1] <= x) return 1;
			if(arr[0] > x) return -1;
			return 0;
		}
		if(arr[arr.length/2] > x) 
			return findmaxlessthan(Arrays.copyOfRange(arr, 0, arr.length/2 - 1), x);
		else
			return arr.length/2 + findmaxlessthan(Arrays.copyOfRange(arr, arr.length/2,arr.length-1),x);
	}

	public static int functionx (int[] arr, int threshold){
		int pointer1 = 0;
		
		int pointer2 = findmaxlessthan(arr,threshold-arr[pointer1]);
		if(pointer2 == -1) return 0;
		int answer = 0;
		while(pointer1 < pointer2){
			int index = findmaxlessthan(arr,threshold-arr[pointer1]-arr[pointer2]);
			if(index == -1) break;
			if(index > pointer2){
				pointer1++;
				pointer2 = findmaxlessthan(arr,threshold-arr[pointer1]);
				if(pointer2 == -1 || pointer2 <= pointer1) break;
				continue;
			}
			pointer2--;
			if(index <= pointer1){
				continue;
			}
			answer += index - pointer1 + 1;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(functionx(new int[]{1,2,3,4,5,6,7,8,9},10));
	}

}
