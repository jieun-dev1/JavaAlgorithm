package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.List;

public class NewsClustering {
  public int solution(String str1, String str2) {
    double answer = 0;
    //캐릭터가 있을 경우 Upper를 함.
    str1 = str1.toUpperCase(); //다시 할당해줘야 함.
    str2 = str2.toUpperCase();

    ArrayList<String> str1List = new ArrayList<>();
    ArrayList<String> str2List = new ArrayList<>();

    //하나씩 subString 한 후 array로 만들기.
    for(int i=0;i<str1.length()-1;i++) {
      if((String.valueOf(str1.charAt(i)).matches("[A-Z]")&&(String.valueOf(str1.charAt(i+1)).matches("[A-Z]")))){
        String str1Element = str1.substring(i,i+2);
        str1List.add(str1Element);
      }
    }

    for(int i=0;i<str2.length()-1;i++) {
      if((String.valueOf(str2.charAt(i)).matches("[A-Z]")&&(String.valueOf(str2.charAt(i+1)).matches("[A-Z]")))){
        String str2Element = str2.substring(i,i+2);
        str2List.add(str2Element);
      }
    }

    //복사 시 객체를 copy하기 때문에, ArrayList로 형변환이 필요하다.
    ArrayList<String> str1ListCopy = (ArrayList<String>)str1List.clone();
    ArrayList<String> str2ListCopy = (ArrayList<String>)str2List.clone();


    //교 집합 구할 때, copy 한 애들로 구해야 지워가면서 구현이 가능하다.
    List<String> intersection = new ArrayList<>();
    for(int i=0;i<str1List.size();i++) {
      if(str2ListCopy.contains(str1List.get(i))) {
        str2ListCopy.remove(str1List.get(i)); //지워야 중복 원소가 있을 때, 중복 원소도 있는지 확인이 가능함.
        intersection.add(str1List.get(i));
      }
    }

    //removesAll을 하게 되면, 동일 원소를 아예 다 없애버림 (aa 2개만 제거하는 것이 아님)
    int str1Cha = str1List.size()- intersection.size();
    int str2Cha  = str2List.size() - intersection.size();
    int unionSize = str1Cha+str2Cha +  intersection.size();

    if(str2List.isEmpty()&&str1List.isEmpty()) {
    return 65536; }

    answer = (double)intersection.size()/unionSize;

    answer*=65536;
    return (int)answer;
  }

  public static void main(String[] args) {
    NewsClustering T = new NewsClustering();
    System.out.println(T.solution("aa1+aa2", "AAAA12"));
//    System.out.println(T.solution("FRANCE", "french"));
//    System.out.println(T.solution("handshake", "shake hands"));
//    System.out.println(T.solution("E=M*C^2", "e=m*c^2"));
  }
}
