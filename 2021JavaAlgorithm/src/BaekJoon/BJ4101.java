package BaekJoon;
import java.util.Scanner;

public class BJ4101 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
					
//			String result = a > b ? "Yes":"No";
			System.out.println(a > b ? "Yes": "No");
//			(a, b) -> a > b ? System.out.println("Yes"):System.out.println("No");
			if (a == 0 & b == 0) break;
			}
		}
	}



//´ä¾È

//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//
//	while (true) {
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		
//		if (a == 0 && b == 0) break;
//		
//		System.out.println(a > b ? "YES":"NO");
//	}
//
//}


//public class BJ4101 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//
//		while (true) {
//			if (a > b) {
//				System.out.println("Yes");
//
//			}
//
//			else if (a < b || ((a == b) & (a*b)!=0)) {
//				System.out.println("No");
//			}
//
//			if (a == 0 & b == 0) 
//				break;
//			
//		}
//
//	}
//}
// 