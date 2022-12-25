package BaekJoon.Greedy;

import java.util.Scanner;

/**
 * ���� ����: �ε���. input.length()-target.length()+1 �� ����� ��. -> ó������ �Ĳ��� ����� ��. ���ÿ� �´��� Ȯ���� ��.
 * �ð� ���⵵:
 * ���̵� �ǹ� 4
 *
 */
public class BJ1543 {
  public int solution(String input,String target){
    int answer = 0;
    int len = target.length();
    //substring�� �ð� ���⵵ o(n)
    //equals�� �ð� ���⵵ o(n) ���� o(n) * o(2n) = 2n^2. n�� 2500. �ִ� �� 1000��.
    for(int i=0;i<input.length()-target.length()+1;i++){
      String temp = input.substring(i, i+len);
      if(temp.equals(target)){
        i+=len-1;//�ݺ����� ���� �̻�, i++�� �Ǳ⿡ -1�� ���ش�.
        answer++;
      } else {
        continue;
      }
    }
    return answer;
  }
  public static void main(String[] args) {
    BJ1543 T = new BJ1543();
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine(); //������� ��������.
    String target =  sc.nextLine();//������� ���� ��
    System.out.println(T.solution(input, target));
  }
}
