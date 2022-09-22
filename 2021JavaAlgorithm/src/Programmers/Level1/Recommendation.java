package Programmers.Level1;

public class Recommendation {

  public String solution(String new_id) {
    String answer = "";
    //1단계:모든 대문자를 대응되는 소문자로 치환
    answer = new_id.toLowerCase();
    //2단계:알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거 - 정규식
    //^는 not을 의미한다.
    //replaceAll 메서드는 String 으로 반환을 해주기 때문에, 리턴 값을(answer=으로) 할당해줘야 함.
    answer = answer.replaceAll("[^a-z0-9-_.]", "");

    //3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환 {n,} 최소한 n개

    answer = answer.replaceAll("[.]{2,}", ".");

    //4단계: 마침표가 처음이나 끝에 위치한다면 제거. .은 []안에 넣어야 함.
    answer = answer.replaceAll("^[.]", "");
    answer = answer.replaceAll("[.]$", "");

    //5단계:빈 문자열이라면, new_id에 "a"를 대입
    if (answer.equals("")) {
      answer += "a";
    }

    //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    if (answer.length() >= 16) {
      answer = answer.substring(0, 15);
      answer = answer.replaceAll("[.]$", "");
    }
    //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거

    //7단계: 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복
    //함수 밖에 할당할 경우, temp가 변하지 않는다. 동적으로 변하는 answer를 조건으로 줘야 함.
    //    int temp = answer.length();
    //    char last = answer.charAt(temp-1);
    //
    //    if (temp <= 2) {
    //      while (temp <= 3) {
    //        answer += last;
    //      }
    //    }
    if(answer.length()<=2) {
      while(answer.length()<3) {
        answer+=answer.charAt(answer.length()-1);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Recommendation T = new Recommendation();
    System.out.println(T.solution(	"...!@BaT#*..y.abcdefghijklm"));

  }
}
