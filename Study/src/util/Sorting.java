package util;

import java.util.ArrayList;
import java.util.List;


public class Sorting {

	public static List<Integer> insertionSort(List<Integer> arr){
		int arrSize = arr.size();
		for(int i=1;i<arrSize;i++){
			int inspectingVal = arr.get(i);
			System.out.println("InspectingVal "+ inspectingVal);
			for(int j=i-1;j>=-1;j--){
				if(j==-1){
					arr.set(j+1, inspectingVal);
					ArrayUtil.printList(arr);
					break;
				}
				if(inspectingVal<arr.get(j)){
					arr.set(j+1, arr.get(j));
					ArrayUtil.printList(arr);
				}else{
					arr.set(j+1, inspectingVal);
					ArrayUtil.printList(arr);
					break;
				}
			}
		}
		return arr;
	}

	public static List<Integer> selectionSort(List<Integer> arr){
		int minInd = 0,arrSize = arr.size();
		for(int i=0;i<arrSize;i++){
			minInd = i + ArrayUtil.findIndexMinVal(arr.subList(i, arrSize));
			arr = ArrayUtil.swap(arr,i,minInd);
			ArrayUtil.printList(arr);
		}
		return arr;
	}

	public static List<Integer> mergeSort(List<Integer> arr){
		System.out.println("Sorting "+arr.toString());
		int arrSize = arr.size();
		if(arrSize==0 || arrSize==1)return arr;
		System.out.println("Dividing into "+arr.subList(0, arrSize/2).toString() + " and " +arr.subList(arrSize/2,arrSize).toString() );
		List<Integer> arrLeft = mergeSort(arr.subList(0, arrSize/2));
		List<Integer> arrRight = mergeSort(arr.subList(arrSize/2,arrSize));
		List<Integer> newArr = new ArrayList<Integer>();
		System.out.println("Merging "+arrLeft.toString() + " and " +arrRight.toString() );
		
		int i=0,j=0;
		while(i < arrLeft.size() || j < arrRight.size()){
			if(i==arrLeft.size())newArr.add(arrRight.get(j++));
			else if(j==arrRight.size())newArr.add(arrLeft.get(i++));
			else{
				if(arrLeft.get(i) < arrRight.get(j)){
					newArr.add(arrLeft.get(i++));
				}else{
					newArr.add(arrRight.get(j++));
				}
			}
		}
		System.out.println("Returning "+newArr.toString());
		return newArr;
	}
	
	public static List<Integer> heapSort(List<Integer> arr){
		int arrSize = arr.size();
		if(arrSize==0 || arrSize==1)return arr;
		arr = ArrayUtil.heapify(arr);
		for(int i=arrSize-1;i>=0;i--){
			arr = ArrayUtil.swap(arr,0,i);
			int j = 0;
			while(j<i){
				int x = (j*2 + 1 >= i) ? j :
						((j*2 + 2 >= i) ? j*2 + 1 :
						((arr.get(j*2+1)>arr.get(j*2+2))? j*2 + 1 : j*2 + 2));
				x = (arr.get(j) > arr.get(x)) ? j : x;
				if(j == x) break;
				arr = ArrayUtil.swap(arr,j,x);
				j = x;
			}
		}
		return arr;
	}
	
	public static List<Integer> quickSort(List<Integer> arr){
		int arrSize = arr.size();
		if(arrSize==0 || arrSize==1)return arr;
		return quickSortP(arr,0,arrSize-1);
/*		int inspectVal = arr.get(0);
		List<Integer> arrLeft = new ArrayList<Integer>();
		List<Integer> arrRight = new ArrayList<Integer>();
		for(int i = 1 ; i < arrSize; i++){
			if(arr.get(i) < inspectVal)arrLeft.add(arr.get(i));
			else arrRight.add(arr.get(i));
		}
		System.out.println("Sorting: " + arr.toString() + " into " + arrLeft.toString() + " and " + arrRight.toString());
		arrRight = quickSort(arrRight);
		arrLeft = quickSort(arrLeft);
		
		List<Integer> newArr = new ArrayList<Integer>();
		newArr.addAll(arrLeft);
		newArr.add(inspectVal);
		newArr.addAll(arrRight);
		return newArr;
	*/}

	// QuickSort within start index and end index inclusive
	private static List<Integer> quickSortP(List<Integer> arr, int start, int end){
		System.out.println("quickSort: "+arr.subList(start, end+1).toString());
		if(start >=end)return arr;
		if(start+1==end){
			if(arr.get(start)>arr.get(end))
				ArrayUtil.swap(arr, start, end);
			return arr;
		}
		int pivot = arr.get(start);
		int i = start + 1;
		int j = end;
		while(true){
			while(i<=j && arr.get(i)<pivot)i++;
			while(i<j && arr.get(j)>pivot)j--;
			if(i<j)
				ArrayUtil.swap(arr, i, j);
			else
				break;
		}
		ArrayUtil.swap(arr, start, i-1);
		arr = quickSortP(arr,start,i-2);
		return quickSortP(arr,i,end);
	}


}
