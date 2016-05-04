package online;

import java.util.ArrayList;

public class Permutation {

	public static void permute(char[] arr, int fromInd){
//		System.out.println("FromInd: " + fromInd);
		if(fromInd == arr.length-1){
			System.out.println(arr);
			return;
		}
		char temp = arr[fromInd];
		for(int i = fromInd; i< arr.length; i ++){
			arr[fromInd] = arr[i];
			arr[i] = temp;
			permute(arr, fromInd+1);
			arr[i] = arr[fromInd];
		}
		arr[fromInd] = temp;
		return;
	}
	
	public static void permute(String s){
		char[] charArr = s.toCharArray();
		
		ArrayList<String> arr = new ArrayList<String> ();
		arr = generateCombination(charArr, arr, -1);
		
		
		//permute(charArr, 0);
	}

	private static ArrayList<String> generateCombination(char[] charArr, ArrayList<String> stack, int start) {
		System.out.println("Generating combinations");
		int end = stack.size();
		for(int i = 0 ; i < charArr.length; i ++ ){
			if(end==0)
				stack.add(""+charArr[i]);
			else{
				for(int j = start; j < end; j ++){
					if(!stack.get(j).contains(charArr[i]+"")){
						stack.add(stack.get(j)+charArr[i]);
					}
				}
			}
		}
		System.out.println(stack);
		if(end!=stack.size())
			stack = generateCombination(charArr,stack,end);
		return stack;
	}
}
