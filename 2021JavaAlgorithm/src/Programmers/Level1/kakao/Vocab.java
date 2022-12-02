package Programmers.Level1.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 아래 문제는 for 문을 돌면서, s가 하나씩 바뀜. 바뀐 것이 계속 축적되어야 하기 때문에, s에 다시 재할당해주는 것이다.
 * 만약 for 문을 돌지 않는다면, String s1 = s.replace 로 해도 됨.
 * for 문에서는, 아래와 같이 하게 되면, 원소가 하나씩 바뀌고 그 상태가 저장되지 않는다.
 *
 *
 * //    String s1 = s;
 *     for (int i = 0; i < arr.length; i++) {
 *       s1 =  s.replace(arr[i], String.valueOf(i)); //String은 객체의 속성을 바꾸는 건 불가하지만, 객체의 재 할당은 가능하다.
 *     }
 */
public class Vocab {

  public int solution(String s) {
    String[] arr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine"};
    for (int i = 0; i < arr.length; i++) {
      s =  s.replace(arr[i], String.valueOf(i)); //String은 객체의 속성을 바꾸는 건 불가하지만, 객체의 재 할당은 가능하다.
    }
        return Integer.parseInt(s);
  }


    public static void main (String[]args){
      Vocab T = new Vocab();
      T.solution("one4seveneight");
    }

}