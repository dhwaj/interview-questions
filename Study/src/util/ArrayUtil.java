package util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

	public static void printList(List<Integer>arr){
		System.out.println(arr.toString());
	}
	
	public static List<Integer> heapify(List<Integer> arr){
		for(int i=0;i<arr.size();i++){
			int j = i;
			while(true){
				if(j==0)break;
				if(arr.get((j-1)/2) < arr.get(j)){
					arr = swap(arr,(j-1)/2,j);
					j = j/2;
				}else{
					break;
				}
			}
		}
		
		return arr;
		
	}
	
	public static int findIndexInSortedArr(Integer[] arr,int num,Integer strtind, Integer endind){
		
		// -2 endval considered as array last element
		if(endind == -2)endind = arr.length-1;
		if(strtind>endind)return -1;
		int midval = arr[(strtind+endind)/2];
		if(num == midval)return (strtind+endind)/2;
		if(num > midval){
			return findIndexInSortedArr(arr, num,(strtind+endind)/2+1,endind);
		}
		return findIndexInSortedArr(arr, num,strtind,(strtind+endind)/2-1);
	}
	
	public static List<Integer> swap(List<Integer> arr, int i, int j) {
		System.out.println("Swaping: " + arr.toString() + " Index: " + i + " and " + j);
		if(i==j)return arr;
		int temp = arr.get(i);
		arr.set(i,arr.get(j));
		arr.set(j,temp);
		System.out.println("to: " + arr.toString());
		return arr;
	}

	public static int findIndexMinVal(List<Integer> list){
		if(list.isEmpty())return -1;
		int minVal=list.get(0),minInd=0;
		for(int i=1;i<list.size();i++){
			if(list.get(i)<minVal){
				minVal = list.get(i);
				minInd = i;
			}
		}
		return minInd;
	}
	
	public static int findIndexLeastVal(Integer[] arr) {
		if(arr.length == 0) return -1;
		int minVal = arr[0];
		int minValindex=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]<minVal){
				minVal = arr[i];
				minValindex = i;
			}
		}
		return minValindex;
	}

}
