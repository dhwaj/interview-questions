package online;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class GraphTheory {

	static class node{
		public int vert;
		public ArrayList<node> children;
		
		public node(int v){
			this.vert = v;
			this.children = new ArrayList<node>();
		}
		
		public void addchildren(node x){
			this.children.add(x);
		}
		
		public String toString(){
			String ret ="("+(vert+1);
			if(children.size()>0)ret+="=>"+children.get(0).toString();
			for(int i=1;i<children.size();i++){
				ret += ","+children.get(i).toString();
			}
			return ret + ")";
		}
		
		public int count(){
			int answer = 1;
			for(int i=0;i<children.size();i++){
				answer+=children.get(i).count();
			}
			return answer;
		}
	}
	
	public static node createTree(int[][] a,node x){
		int maxvert = 0,maxedges = 0,edges = 0;
		if(x==null){
			for(int i = a.length-1;i>=0;i--){
				edges = 0;
				for(int j = a[i].length-1;j>=0;j--){
					if(a[i][j]==1)edges++;
				}
				if(edges>maxedges){
					maxvert = i;
					maxedges = edges;
				}
			}
			x = new GraphTheory.node(maxvert);
			return createTree(a, x);
		}else{
			ArrayList<Integer> children = new ArrayList<Integer>();
			for(int i=a[x.vert].length-1;i>=0;i--){
				if(a[x.vert][i]==1){
					a[x.vert][i]=0;
					a[i][x.vert]=0;
					children.add(i);
				}
			}
			for(int i=0;i<children.size();i++){
				x.addchildren(createTree(a,new node(children.get(i))));
			}
		}
		
		return x;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int i;
        int j;
        int[][] a = new int[n][n];
        for( i=0;i<n;i++){
        	for( j=0;j<n;j++){
        		a[i][j]=0;
        	}
        }
        for( i=0;i<m;i++){
        	int x = in.nextInt();
        	int y = in.nextInt();
        	a[x-1][y-1]=1;
        	a[y-1][x-1]=1;
        }
        GraphTheory.node root = createTree(a,null);
        System.out.println(root);
        int count = breakTree(root);
        System.out.println(root);
        System.out.println(count);
        
	}

	private static int breakTree(node root) {
		int answer = 0;
		if(root == null)return answer;
		for(int i=0;i<root.children.size();i++){
			answer += breakTree(root.children.get(i));
		}
		for(int i=0;i<root.children.size();i++){
			if(root.children.get(i).count() % 2 == 0){
				answer++;
				System.out.println(root.children.get(i));
				root.children.remove(i);
				i--;
			}
		}
		return answer;
	}
}
