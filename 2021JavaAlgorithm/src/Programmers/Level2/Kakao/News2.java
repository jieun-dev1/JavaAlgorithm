package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.List;

public class News2 {
  //���Խ� ("[A-Z]")" ��� ������.
  //������: retainAll
  //double�� int�� cast �� � ����?
  public int solution(String str1, String str2) {
    int answer = 0;

    String s1 = str1.toUpperCase();
    String s2 = str2.toUpperCase();
    ArrayList<String> s1List = new ArrayList<>();
    ArrayList<String> s2List = new ArrayList<>();

    s1List = parse(s1, s1List);
    s2List = parse(s2, s2List);

    if(s1List.size()==0&&s2List.size()==0){
      return 65536;
    }

    List<String> intersection = new ArrayList<>();
    intersection.addAll(s1List);
    intersection.retainAll(s2List);

    int union = s1List.size()+s2List.size()- intersection.size();
    double ratio = (double) intersection.size()/union;
    answer = (int) (ratio *65536);
    return  answer;
  }

  //      if(s.substring(i,i+2).matches("[A-Z]]")) -> �ȵ�. String�� ���ϰ��� �ֱ� ������ ���ο� String������ �Ҵ� �ʿ�.
  // [a-z] ��� �� ���, �ϳ��� character�� ��Ī��. ���⼭�� �� �����̱� ������ ��� false �� ��ȯ��. �ڿ� +�� �ٿ���, �ϳ� �̻��� ���ڿ� ������ ����.
  public ArrayList<String> parse(String s, ArrayList<String> list){
    for(int i=0;i<s.length()-1;i++){
      String temp = s.substring(i,i+2);
      if(temp.matches("[A-Z]+")){
        list.add(temp);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    News2 T = new News2();
//    System.out.println(T.solution("FRANCE", "french"));
//    System.out.println(T.solution("handshake", "shake hands"));
    System.out.println(T.solution("aa1+aa2", "AAAA12"));

  }
}
