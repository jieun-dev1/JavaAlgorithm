package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.List;

public class News2 {

  //정규식 ("[A-Z]")" 모든 영문자.
  //교집합: retainAll - 이 문제는 교집합이 중복을 허용하기 때문에, addAll RetainAll로 풀면 안되고, 교집합을 발견할 때마다 집합 중 하나를 지워가야 함.
  //double을 int로 cast 시 intValue만 얻게 됨.
  public int solution(String str1, String str2) {
    int answer = 0;

    String s1 = str1.toUpperCase();
    String s2 = str2.toUpperCase();
    ArrayList<String> s1List = new ArrayList<>();
    ArrayList<String> s2List = new ArrayList<>();

    //O(1000)
    s1List = parse(s1, s1List);
    //O(1000)
    s2List = parse(s2, s2List);

    if (s1List.size() == 0 && s2List.size() == 0) {
      return 65536;
    }

    List<String> intersection = new ArrayList<>();
    //o(1000) 문자열 개수 최대 999
    for (String s : s1List) {
      if (s2List.remove(s)) { //remove는 중복 원소가 있더라도, 첫 번째 한 번만 지운다. 특정 요소를 포함하면 true를 반환한다.
        intersection.add(s);
      }
    }

    int union = s1List.size() + s2List.size();
    double ratio = (double) intersection.size() / union;
    answer = (int) (ratio * 65536);
    return answer;
  }

  // if(s.substring(i,i+2).matches("[A-Z]]")) -> 안됨. String은 리턴값이 있기 때문에 새로운 String변수에 할당 필요.
  // [a-z] 라고 할 경우, 하나의 character만 매칭함. 여기서는 두 글자이기 때문에 계속 false 가 반환됨. 뒤에 +를 붙여야, 하나 이상의 문자열 감지가 간으.
  public ArrayList<String> parse(String s, ArrayList<String> list) {
    for (int i = 0; i < s.length() - 1; i++) {
      String temp = s.substring(i, i + 2);
      if (temp.matches("[A-Z]+")) {
        list.add(temp);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    News2 T = new News2();
//    System.out.println(T.solution("FRANCE", "french"));
//    System.out.println(T.solution("handshake", "shake hands"));
//    System.out.println(T.solution("aa1+aa2", "AAAA12"));
    System.out.println(T.solution("BAAAA", "AAA"));
//    System.out.println(T.solution("di mi mi mi mi", "di di di go"));
  }
}
