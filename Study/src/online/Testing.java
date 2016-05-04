package online;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Testing {
	   BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
	    int T;//= Integer.parseInt(inp.readLine());

	 
	public static int fn(int n){
		int arr[] = new int[n+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		q.add(n);
		q2.add(0);
		arr[n] = 0;
		int i = 1;
		int processing = 0;
		while(!q.isEmpty()){
			int x = q.poll();
			System.out.println("processing: " + x);
			 
			int needed = q2.poll();
			for(i = 1; i*i < x; i ++){
				processing = x - (i*i);
				if(arr[processing]==0){
					System.out.println("Adding " + processing);
					q.add(processing);
					q2.add(needed+1);
					arr[processing]=i*i;
				}else{
					System.out.println("Already present " + processing);
				}
			}
			if(i*i == x){
				System.out.println("Answer:");
				int num = i * i;
				System.out.println(num);
				while(num < n){
					System.out.println(arr[num]);
					num += arr[num];
				}
				return needed+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Permutation.permute("abc");
	}

}
