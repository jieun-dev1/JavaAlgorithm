package BaekJoon;
//nextInt: Scanner Ŭ������ �޼ҵ� �߿� ������ �Է� �ް� ������ ���� ����. 
//next: Scanner Ŭ������ �޼ҵ� �߿� ���� ���������� ���ڿ��� �Է¹ް�, name ������ ���� �֤�����. 
//���� ���� ������ ���ڸ� �д´�. ó������ ������ ������ �� ���� �ʴ´�. 
// \n : �ٹٲ�. 

import java.util.Scanner;

public class ScannerPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); //Scanner Ŭ���� ��ü ���� 
		String name; 
		int age;
		System.out.println("�̸��� �Է��� �ּ���");
		name = scanner.next();
		System.out.println("���̸� �Է��� �ּ���");
		age = scanner.nextInt();
		
		System.out.println("\n�̸�"+  name + "\n");
		System.out.println("����:"+  age + "��");


	}

}


