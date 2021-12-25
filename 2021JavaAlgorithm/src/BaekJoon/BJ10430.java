package BaekJoon;
import java.util.Scanner;

public class BJ10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int result = (a+b)%c;
		int result2 = ((a%c) + (b%c))%c;
		int result3 = (a*b)%c;
		int result4 = ((a%c) * (b%c))%c;
		
        System.out.println("(a+b)%c ดย "+result);
        
	}
}