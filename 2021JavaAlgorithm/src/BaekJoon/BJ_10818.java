//package BaekJoon;
//
//import java.util.Scanner;
//
//public class BJ_10818 {
//	Scanner scanner = new Scanner(System.in);
//	// (1) �迭 ���� ���� �޾ƿ���.
//	int number = scanner.nextInt();
//	// (2) �迭�� ���� ��ŭ array �����.
//
//	// (3) �����κ�.. ���⼭ �� {} ��� ������ ����?
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
//	// (3) ù ���� min�̶�� ���Ƿ� ����.
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