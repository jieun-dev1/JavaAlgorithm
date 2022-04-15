//package BaekJoon;
//
//import java.util.Scanner;
//
//public class BJ_10818 {
//	Scanner scanner = new Scanner(System.in);
//	// (1) 배열 길이 먼저 받아오기.
//	int number = scanner.nextInt();
//	// (2) 배열의 길이 만큼 array 만들기.
//
//	// (3) 막힌부분.. 여기서 왜 {} 라고 에러가 날까?
//
//	int[] array = new int[number];
//
//	numbers[0]=n.nextInt();numbers[1]=n.nextInt();numbers[2]=n.nextInt();numbers[3]=n.nextInt();numbers[4]=n.nextInt();
//
////	for(int i = 0;i<number;i++)
////	{
////		array[i] = scanner.nextInt();
////	}
//
//	// (3) 첫 값을 min이라고 임의로 놓기.
//
//	int min = array[0];
//	int max = array[0];
//
//	for(
//	int j = 0;j<array.length;j++)
//	{
//		if (min <= array[j + 1]) {
//			continue;
//		} else {
//			min = array[j + 1];
//		}
//	}
//
//}
//
//}