package BaekJoon;

import java.util.Scanner;
//�� ���� A,B�� �Է¹���. A+B ��� (, �� �ƴ϶� ���ͷ� �����Ѵ�. )
//nextInt: Scanner Ŭ������ �޼ҵ� �߿� ������ �Է� �ް� ������ ���� ����. 
//next: Scanner Ŭ������ �޼ҵ� �߿� ���� ���������� ���ڿ��� �Է¹ް�, name ������ ���� �֤�����. 
// \n : �ٹٲ�. 
//System.in ȭ�鿡�� �Է��� �ްڴٴ� �ǹ�. 
//hasNext() �о�� ��Ұ� �����ִ��� Ȯ���ϴ� �޼���. ������ true ������ false. 
//next() ���� ������ ��ȯ.  nextLine()�� �� �� ������ �Է¹���. 
//remove() : next()�� �о�� ��� ���� 

public class BJ_1000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Scanner Ŭ���� ��ü ����
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a + b);
	}
}
