package Programmers.Level2;

/**
 * 풀이시간: 40분 s.split("\\s+") 은 String 배열을 괄호 안의 구분자로 구분하여 리턴한다. NumberFormatException: 숫자가 아닌 형을
 * 숫자형으로 변환할 때 나오는 에러 (ex 알파벳 O) parseInt vs valueOf 중 valueOf가 더 좋다 (캐싱 제공) 변환 시, digit 뿐만 아니라 음수를
 * 위한 -사인도 함께 변환해준다.
 */

public class MinMax {

  public String solution(String s) {
    String answer = "";
    String[] splited = s.split("\\s+");
    int[] arr = new int[splited.length];

    for (int i = 0; i < splited.length; i++) {
      arr[i] = Integer.valueOf(splited[i]);
    }

    //임의로 최소, 최대 값을 할당
    int minTemp = arr[0];
    int maxTemp = arr[0];

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < minTemp) {
        minTemp = arr[i];
      }
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > maxTemp) {
        maxTemp = arr[i];
      }
    }

    answer += minTemp;
    answer += " ";
    answer += maxTemp;
    return answer;
  }

  public static void main(String[] args) {
    MinMax T = new MinMax();
//    String answer = T.solution("-1 -2 -3 -4");
    String answer = T.solution("-1 -1");
    System.out.println(answer);
  }
}
