package algo;

public class Start {

	public static void main(String[] args) {
		String inp = "aabacbeabbed";
		int[] inp1 = new int[]{99,1,99};
		int[] inp2 = new int[]{1,100};
		// Find longest substring with 'm' unique characters
/*		int m = 2;
		findMaxSubst(inp,m);
*/
		System.out.println(findHops(inp1,inp2));
		
	}

	private static void findMaxSubstUniqchars(String inp, int m) {
		Character[] uChars = new Character[m];
		Integer[] uCharPos = new Integer[m];
		int i,j,k,len=0,countdown = m;
		for(j=0;j<m;j++){
			uChars[j]=' ';
			uCharPos[j] = -1;
		}
		String answer="",curstr="";

		char[] inpChars = inp.toCharArray();
		for(i=0;i<inpChars.length;i++){
			for(j=0;j<m;j++){
				if(uChars[j].compareTo(inpChars[i])==0){
					uCharPos[j]=i;
					len++;
					curstr += inpChars[i];
					break;
				}
			}
			if(j==m){
				k = findIndexLeastVal(uCharPos);
				uChars[k]=inpChars[i];
				uCharPos[k]=i;
				if(len>answer.length()){
					answer = curstr;
				}
				if(countdown==0){
					curstr="";
					len=0;
				}else{
					countdown--;
					curstr += inpChars[i];
					len++;
				}
			}
		}
		System.out.println(answer);
	}

	
	private static int findHops(int[] stoneDist, int[] hopDist){
		int total = 0 ;
		int numStone = stoneDist.length;
		int numHop = hopDist.length;
		int[] hopsNeeded = new int[numStone];
		boolean[] stonesMarked = new boolean[numStone];
		int leastVal = 0;
		int leastValind = 0;
		
		for(int i=0;i<numStone;i++){
			total+=stoneDist[i];
			stoneDist[i]=total;
		}
		hopDist = sortArr(hopDist);
		int strtind = 0,index;
		for(int i=0;i<numHop;i++){
			index = findIndexInSortedArr(stoneDist, hopDist[i], strtind, -2);
			if(index != -1){
				hopsNeeded[index]=1;
				strtind = index;
			}
		}
		boolean foundstone = false;
		while(!foundstone){
			if(hopsNeeded[numStone-1]!=0)break;
			leastVal = Integer.MAX_VALUE;
			for(int i=numStone-1;i>=0;i--){
				if(!stonesMarked[i] && hopsNeeded[i]!=0){
					if(hopsNeeded[i]<leastVal){
						leastVal = hopsNeeded[i];
						leastValind = i;
						foundstone = true;
					}
				}
			}
			if(!foundstone)break;
			foundstone=false;
			stonesMarked[leastValind]= true;
			int curpos = stoneDist[leastValind];
			int indx;
			for(int i = numHop-1;i>=0;i--){
				if(curpos+hopDist[i]<=stoneDist[numStone-1]){
					indx = findIndexInSortedArr(stoneDist, curpos+hopDist[i], leastValind, -2);
					if(indx!=-1 && (hopsNeeded[indx]==0 ||hopsNeeded[indx]>leastVal))
						hopsNeeded[indx]=leastVal+1;
				}
				if(curpos-hopDist[i]>0){
					indx = findIndexInSortedArr(stoneDist, curpos-hopDist[i], 0, leastValind);
					if(indx!=-1 && (hopsNeeded[indx]==0 ||hopsNeeded[indx]>leastVal))
						hopsNeeded[indx]=leastVal+1;
				}
			}
		}
		if(hopsNeeded[numStone-1]==0){
			return -1;
		}else{
			return hopsNeeded[numStone-1];
		}
	}
	
	private static int[] sortArr(int[] arr){
		// TODO : QuickSort Implementation
		return arr;
	}
	
	private static int findIndexInSortedArr(int[] arr,int num,int strtind, int endind){
		
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

	private static int findIndexLeastVal(Integer[] inpArr) {
		if(inpArr.length == 0) return -1;
		int minVal = inpArr[0];
		int minValindex=0;
		for(int i=1;i<inpArr.length;i++){
			if(inpArr[i]<minVal){
				minVal = inpArr[i];
				minValindex = i;
			}
		}
		return minValindex;
	}
}
