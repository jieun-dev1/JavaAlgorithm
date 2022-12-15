package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1시간 풀었음. 틀린 부분: 1-3인 케이스만 가정함. 4일수도 5일수도 있음. A-Z : 65-90 (아스키코드)
 */
public class Press {

  public int[] solution(String msg) {
    //알파벳 초기화
    HashMap<String, Integer> hm = new HashMap<>();
    int len = 27; //z다음에 올 키 값.
    int index = 0;
    ArrayList<Integer> answerList = new ArrayList<>();
    int[] answer = {};
    //A-Z를 초기화.
    for (int i = 1; i < 27; i++) {
      char temp = (char) (64 + i);
      hm.put(Character.toString(temp), i);
    }
//    System.out.println(hm.get("A"));F

    //맨 마지막 인덱스까지만 while 문 해당.
    //O(1000)
    while (index <= msg.length() - 1) {
      //O(1000)
      //문자열 길이가 1인 경우 예외처리 필요. 아래 if 문은 break 시, while 문을 빠져나오기 때문에 index 추가할 필요 없음. 반면, 아래 for문은 반복문이 while 까지 두 개 있기 때문에, while 탈출 하려면 index 증가 필요.
      if (msg.length() == 1) {
        answerList.add(hm.get(msg.substring(index, index + 1)));
        break;
      }
      for (int j = 2; j < msg.length() + 1; j++) {
        //맨 마지막 인덱스를 가리킬 때, 여기서 exit.
        if (index == msg.length() - 1) {
          answerList.add(hm.get(msg.substring(index, index + 1)));
          index += 1;
          break;
        }
        //두번째 인덱스 = 마지막 인덱스일 때. 그리고 MAP 에 존재할 때.
        if (index + j == msg.length() && hm.get(msg.substring(index, index + j)) != null) {
          answerList.add(hm.get(msg.substring(index, index + j)));
          index += j;
          break;
        }
        //두번째 인덱스 = 마지막 인덱스일 때. 그리고 MAP 에 존재하지 않을 때. HM에 넣어주기. j-1까지만 더했으므로, 인덱스도 j-1만큼 더한다.
        if (index + j == msg.length() && hm.get(msg.substring(index, index + j)) == null) {
          answerList.add(hm.get(msg.substring(index, index + j - 1)));
          hm.put((msg.substring(index, index + j)), len);
          len++;
          index += j - 1;
          break;
        }
        if (hm.get(msg.substring(index, index + j)) == null) { //마지막이 hashmap에 있을 경우 ++를 하게 됨. 그런데 맨 끝자리에서 ++가되면, indexOutOfBounds가 나옴
          answerList.add(hm.get(msg.substring(index, index + j - 1)));
          hm.put((msg.substring(index, index + j)), len);
          len++;
          index += j - 1;
          j = 1;//for문을 돌면서 j가 ++되기에, j가 3이 될 것임. 다음 for 문을 돌 때는 리셋 필요. j=1로 해야 2로 초기화.
        } else {
          continue;
        }
      }
    }
    answer = answerList.stream().mapToInt(i -> i.intValue()).toArray();
    return answer;
  }

  public static void main(String[] args) {
    Press T = new Press();
    System.out.println(T.solution("KAKAO"));
//    System.out.println(T.solution("TOBEORNOTTOBEORTOBEORNOT"));
//    System.out.println(T.solution("A"));
  }

}
