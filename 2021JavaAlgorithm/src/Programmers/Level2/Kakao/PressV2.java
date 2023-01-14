package Programmers.Level2.Kakao;

public class PressV2 {
  public int solution(String s) {
    /**
     * ���� �ڵ� ���� - substring()�� �Ⱦ��� �ڵ�.
     */
    int len = s.length();
    int answer = len;

    //1. i�� ���̰� �߸��� ������. i����length �� �纻��.
    for(int i=1;i<=len/2;i++){
      String[] results = s.split("(?<=\\G.{" + i + "})");
      StringBuilder sb = new StringBuilder();
      String str = results[0]; //���� ��
      int count = 1;
      for(int j=1;j<=results.length-1;j++){ //results�� length�� ������. len �̶�� �Ǽ���.
        if (str.equals(results[j])){
          count++;
        } else {
          if(count!=1){
            sb.append(count);
            count = 1;
          }
          sb.append(str);
          str = results[j]; //���� ������ ��ġ �ٲ��ֱ�.
        }

        if(j == results.length-1){
          if(count!=1){
            sb.append(count);
          }
          sb.append(str);
        }
      }

      //count�� ++�ǰ�, ������ ���� ������ �������� �ʴ´�.
      answer = Math.min(answer, sb.length());
    }

    return answer;
  }
  public static void main(String[] args) {
    PressV2 T = new PressV2();
    System.out.println(T.solution("aabbaccc"));
    System.out.println(T.solution("abcabcabcabcdededededede"));
  }
}
