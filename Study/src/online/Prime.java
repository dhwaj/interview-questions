package online;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<Long> primes = new ArrayList<Long>();
        primes.add((long) 2);
        primes.add((long) 3);
        primes.add((long) 5);
        primes.add((long) 7);
        primes.add((long) 11);
        primes.add((long) 13);
        primes.add((long) 17);
        primes.add((long) 19);
        long r;
        long p = 0;
        long answer = 0;
        boolean notPrime;
        for(int i=0;i<t;i++){
        	r = in.nextLong();
        	long start = System.currentTimeMillis();
        	Iterator<Long> it = primes.iterator();
       		while(it.hasNext()){
       			p = it.next();
       			if(p>r)break;
       			while(r%p == 0){
       				r/=p;
       				answer = p;
       			}
        	}
       		if(r!=1){
       			for(long j=p+2;j*j<=r;j+=2){
       				notPrime = false;
       				it = primes.iterator();
       				it.next();
       				while(it.hasNext()){
       					p = it.next();
           				if(p*p>j)break;
           				if(j%p==0){
           					notPrime = true;
           					break;
           				}
       				}
       				if(!notPrime){
       					primes.add(j);
       					while(r%j==0){
       						r/=j;
       						answer = j;
       					}
       				}
       			}
       		}
       		if(r!=1)answer = r;
       		System.out.println(System.currentTimeMillis()-start);
        	System.out.println(answer);
        }
	}
}
