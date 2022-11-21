package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**

 * 2시간 30분 소요.
 *
 * 틀렸던 이유.
 * regex split할 떄 " , " 앞 뒤로 띄어쓰기가 들어가야 함
 * String을 int로 바꿀 때 Integer.parseInt로 바꾼다.
 *
 * 첫 번째 for문: 500
 * arr의 개수는 튜플에서 개수가 가장 많은 원소의 길이와 같음.
 * 리턴하는 배열의 길이가 500 이하이므로, 최대 500.
 *
 * 두 번째 for문: 두 번째 for 문 역시. 최소 1- 최대 500 (마지막 원소)
 * 500x 500 = 2500000 +
 *
 * (O(n)) for문 = 500 (최대 500번 돌기 때문)
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
        if(list.isEmpty()){ //한 번도 더해지지 않았을 경우 첫 번째 원소를 더한다.
          list.add(a);
        } else if(!list.contains(a)) { //list가 포함하고 있지 않다면, 더해줄 것.
          list.add(a);
        } else if (list.contains(a)) {
          continue;
        }
      }
    }

    int[] answer = new int[list.size()];

    for(int i=0;i<list.size();i++){
        answer[i] = Integer.parseInt(list.get(i)); //Integer.parseInt로 String을 int로 바꾼다.
    }

    return answer;
  }

  public static void main(String[] args) {
    TupleV2 T = new TupleV2();
    System.out.println(T.solution("{{2},{2,1},{2,1,3},{2,1,3,4}"));
}
}