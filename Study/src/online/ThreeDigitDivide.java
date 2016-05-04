package online;

public class ThreeDigitDivide {

	public static void main(String[] args) {
		int a = 969;
		int palindrome = a*1000+reverse(a);
		System.out.println(palindrome);

	}
	
	public static int reverse(int a){
		int answer = (a%10)*100;
		a/=10;
		answer += (a%10)*10;
		a/=10;
		answer += (a%10);
		return answer;
	}

}
