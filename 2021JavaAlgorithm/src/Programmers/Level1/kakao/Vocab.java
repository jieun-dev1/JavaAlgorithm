package Programmers.Level1.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * �Ʒ� ������ for ���� ���鼭, s�� �ϳ��� �ٲ�. �ٲ� ���� ��� �����Ǿ�� �ϱ� ������, s�� �ٽ� ���Ҵ����ִ� ���̴�.
 * ���� for ���� ���� �ʴ´ٸ�, String s1 = s.replace �� �ص� ��.
 * for ��������, �Ʒ��� ���� �ϰ� �Ǹ�, ���Ұ� �ϳ��� �ٲ�� �� ���°� ������� �ʴ´�.
 *
 *
 * //    String s1 = s;
 *     for (int i = 0; i < arr.length; i++) {
 *       s1 =  s.replace(arr[i], String.valueOf(i)); //String�� ��ü�� �Ӽ��� �ٲٴ� �� �Ұ�������, ��ü�� �� �Ҵ��� �����ϴ�.
 *     }
 */
public class Vocab {

  public int solution(String s) {
    String[] arr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine"};
    for (int i = 0; i < arr.length; i++) {
      s =  s.replace(arr[i], String.valueOf(i)); //String�� ��ü�� �Ӽ��� �ٲٴ� �� �Ұ�������, ��ü�� �� �Ҵ��� �����ϴ�.
    }
        return Integer.parseInt(s);
  }


    public static void main (String[]args){
      Vocab T = new Vocab();
      T.solution("one4seveneight");
    }

}