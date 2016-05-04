package online;

import java.util.ArrayList;
import java.util.HashSet;

public class Substring {

	public static char[] sortedArr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	public static int[] hm = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
	public static String convert(String str){
		char[] ch = str.toCharArray();
		int small=0;
		for(int i=str.length()-1;i>=0;i--){
			; 
			if(hm[ch[i]-'a'] != -1){
				ch[i]=sortedArr[hm[ch[i]-'a']];
			}else{
				hm[small] = ch[i]-'a';
				ch[i]=sortedArr[small++];
			}
		}
		for(int i=0;i<26;i++)hm[i]=-1;
		return String.valueOf(ch);
	}

	public static void function(){
		String str = "abbabbabbbbaaababababbaabbabbabbaaabbaaabb";
		for(int i=0;i<6;i++)str+=str;

//		String str = "abbababba";
		System.out.println("Str Length: " + str.length());
//		try {
//			str = br.readLine();
//		} catch (IOException e) {
//		}

		int length = str.length();
		int answer = 0;
		ArrayList<HashSet<String>> hashArr = new ArrayList<HashSet<String>>();
		for(int i=0;i<length;i++) hashArr.add(new HashSet<String>());
//		ArrayList<HashSet<String>> hArr = new ArrayList<HashSet<String>>();
//		for(int i=0;i<length;i++) hArr.add(new HashSet<String>());

//		HashSet<String> hashArr = new HashSet<String>();
//		HashSet<String> hArr = new HashSet<String>();
		int outeri = 0;
		for(int outer = 1 ; outer <= length ; outer++){
			String s = convert(str.substring(0,outer));
			for(int i = 0;i<outer;i++){
				outeri= outer -i -1;
//				if(outeri>=10 || !setSizeReached[outeri]){
					String x = s.substring(i, outer);
					if(hashArr.get(outeri).add(x)){
//						if(outeri<10){
//							arr[outeri]--;
//							if(arr[outeri]==0){
//								setSizeReached[outeri]=true;
//								System.out.println("Set Size Reached for "+outeri);
//							}
//						}
//					if(hashArr.add(x) && hArr.add(convert(x))){
						answer++;
					}
//				}
			}
			System.out.println(answer);
		}
		//System.out.println(hashArr.toString());

	}

	public static void calculateNumbers(){
		ArrayList<Integer> x = new ArrayList<Integer>();  
		x.add(1);
		int carry = 0;
		int temp = 0;
		ArrayList<Integer> setSize = new ArrayList<Integer>();
		setSize.add(1);
		int size = 0;
		int newnum = 0;
		while(x.size()<10){
			size = 0;
			carry = 0;
			for(int i=0;i<x.size();i++){
				temp = x.get(i);
				newnum = x.get(i)*(i+1)+carry;
				size +=newnum;
				x.set(i, newnum);
				carry = temp;
			}
			x.add(carry);
			size+=carry;
			setSize.add(size);
		}
		System.out.println(x);
		System.out.println(setSize);
	}

	public static void profiling(){
		String str = "abbabbabbbbaaababababbaabbabbabbaaabbaaabb";
		for(int i=0;i<6;i++)str+=str;
		int length = str.length();
		System.out.println("Str Length: " + length);
		long curtime = System.currentTimeMillis();
		int answer = 0;
		for(int outer = 1 ; outer <= length ; outer++){
			String s = convert(str.substring(0,outer));
			for(int i = 0;i<outer;i++){
				String x = s.substring(i, outer);
//				System.out.println(x.length());
				answer+=x.length();
			}
			System.out.println(answer);
		}
		System.out.println("Duration : " + (System.currentTimeMillis() - curtime));
	}
	
	public static void printarr(){
//		for(int i = 0 ; i<10;i++)System.out.println(setSizeReached[i]);
	}
	
    public static void main(String[] args) {
//   		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//1344..6603
    	//Array2688..35794
    	long curtime = System.currentTimeMillis();
//    	printarr();
    	//function();
    	profiling();
    	System.out.println("Time: " + (System.currentTimeMillis() - curtime));
    	
    }
}