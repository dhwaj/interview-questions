package online;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dj{
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        int T= Integer.parseInt(inp.readLine());
    
        for(int i=0;i<T;i++) {
            String s= inp.readLine();
            int[] m= new int[2];
            String[] s1 = inp.readLine().split(" ");
            m[0]=Integer.parseInt(s1[0]);
            m[1]=Integer.parseInt(s1[1]);

            // Checking whether I am taking the inputs correctly
            System.out.println(s);
            System.out.println(m[0]);
            System.out.println(m[1]);
        }
    }
}