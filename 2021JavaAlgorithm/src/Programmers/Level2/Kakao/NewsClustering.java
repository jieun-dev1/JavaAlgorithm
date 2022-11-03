package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.List;

public class NewsClustering {
  public int solution(String str1, String str2) {
    double answer = 0;
    //ĳ���Ͱ� ���� ��� Upper�� ��.
    str1 = str1.toUpperCase(); //�ٽ� �Ҵ������ ��.
    str2 = str2.toUpperCase();

    ArrayList<String> str1List = new ArrayList<>();
    ArrayList<String> str2List = new ArrayList<>();

    //�ϳ��� subString �� �� array�� �����.
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

    //���� �� ��ü�� copy�ϱ� ������, ArrayList�� ����ȯ�� �ʿ��ϴ�.
    ArrayList<String> str1ListCopy = (ArrayList<String>)str1List.clone();
    ArrayList<String> str2ListCopy = (ArrayList<String>)str2List.clone();


    //�� ���� ���� ��, copy �� �ֵ�� ���ؾ� �������鼭 ������ �����ϴ�.
    List<String> intersection = new ArrayList<>();
    for(int i=0;i<str1List.size();i++) {
      if(str2ListCopy.contains(str1List.get(i))) {
        str2ListCopy.remove(str1List.get(i)); //������ �ߺ� ���Ұ� ���� ��, �ߺ� ���ҵ� �ִ��� Ȯ���� ������.
        intersection.add(str1List.get(i));
      }
    }

    //removesAll�� �ϰ� �Ǹ�, ���� ���Ҹ� �ƿ� �� ���ֹ��� (aa 2���� �����ϴ� ���� �ƴ�)
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
