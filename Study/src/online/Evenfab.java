package online;

import java.util.ArrayList;
import java.util.Scanner;

public class Evenfab {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long num;
        ArrayList<Long> fab = new ArrayList<Long>();
        fab.add((long) 1);
        fab.add((long) 2);
        long slast = 1;
        long last = 2;
        long answer;
        for(int i=0;i<t;i++){
        	num = in.nextLong();
        	if(num<2)answer = 0;
        	else if(num==2)answer = 2;
        	else{
        		answer = 0;
        		if(last<num){
        			while(last<num){
        				fab.add(last+slast);
        				last = last + slast;
        				slast = last - slast;
        			}
        		}
        		for(int j=1;j<fab.size();j+=3){
        			if(fab.get(j)<num)
        				answer +=fab.get(j);
        			else
        				break;
        		}
        	}
        	System.out.println(answer);
        	//System.out.println(fab);
        }
	}
}
