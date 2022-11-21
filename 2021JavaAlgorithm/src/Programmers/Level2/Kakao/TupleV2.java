package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**

 * 2�ð� 30�� �ҿ�.
 *
 * Ʋ�ȴ� ����.
 * regex split�� �� " , " �� �ڷ� ���Ⱑ ���� ��
 * String�� int�� �ٲ� �� Integer.parseInt�� �ٲ۴�.
 *
 * ù ��° for��: 500
 * arr�� ������ Ʃ�ÿ��� ������ ���� ���� ������ ���̿� ����.
 * �����ϴ� �迭�� ���̰� 500 �����̹Ƿ�, �ִ� 500.
 *
 * �� ��° for��: �� ��° for �� ����. �ּ� 1- �ִ� 500 (������ ����)
 * 500x 500 = 2500000 +
 *
 * (O(n)) for�� = 500 (�ִ� 500�� ���� ����)
 *
 * 500x500 + 500 = 2500500.
 *
 */

public class TupleV2 {

  public int[] solution(String s) {
    String[] arr = s.replaceAll("[{}]", " ").trim().split(" , ");
//    Arrays.sort(arr, (a,b) -> (a.length()-b.length()));
    ArrayList<String> list = new ArrayList<>();
    Arrays.sort(arr, Comparator.comparingInt(String::length));

    for(String element: arr){
      for(String a : element.split(",")){
        if(list.isEmpty()){ //�� ���� �������� �ʾ��� ��� ù ��° ���Ҹ� ���Ѵ�.
          list.add(a);
        } else if(!list.contains(a)) { //list�� �����ϰ� ���� �ʴٸ�, ������ ��.
          list.add(a);
        } else if (list.contains(a)) {
          continue;
        }
      }
    }

    int[] answer = new int[list.size()];

    for(int i=0;i<list.size();i++){
        answer[i] = Integer.parseInt(list.get(i)); //Integer.parseInt�� String�� int�� �ٲ۴�.
    }

    return answer;
  }

  public static void main(String[] args) {
    TupleV2 T = new TupleV2();
    System.out.println(T.solution("{{2},{2,1},{2,1,3},{2,1,3,4}"));
}
}