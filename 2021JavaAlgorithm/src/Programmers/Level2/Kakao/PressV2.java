package Programmers.Level2.Kakao;

public class PressV2 {
  public int solution(String s) {
    /**
     * ������ �ڵ� ����.
     *
     * �ٽ� ����
     * -j���� ����Ͽ�, i�������� �þ��. ���� i< length/2+1
     *
     * -�������� i�� �ٲ� �� 0�̴�
     */
    int len = s.length();
    int answer = len;
    //���̰� 1�� ���ڰ� �����ϰ� �־��� ���� ����. - �׽�Ʈ 1 ����� ����. ���� 1���� ����/2���� ����.
    for(int i=1;i<=len/2;i++){
      //j�� len�̶� �������� ���� == �������� ����� exit ��. substring�� �� ���̹Ƿ� ==�� ��. ���� == str. ���� == compare.
      String str = s.substring(0, i);
      //i+j�� len�� ���� ��/�������� �� �б�.
      StringBuilder sb = new StringBuilder();
      int count = 1;

      for(int j=i;j<=len;j+=i){
        int limit = 0;
        //i+j == len �� �� (i�������� �� ������ ��. �̶�, ������ compare�� �� string�̴�.
        //�������� ���� ���� compare ���� �����Ѵ�.
        if(j+i>len) {
        limit = len; //
      } else {
        limit = j+i;
      }
        String compare = s.substring(j, limit);
        if(str.equals(compare)){
          count++;
          //������ ���ڰ� ���, sb�� ������ �� count�� �ٽ� 1�� �ʱ�ȭ�Ѵ�.
        } else {
         if(count>=2){
           sb.append(count);
         }
         sb.append(str);
         count = 1;

          /**
           * str =compare �� �ؾ��ϴ� ����
           * str = s.substring(j, i+j); //i+j �� ���� ���̾ ���� ��.
           * ���⼭ s.substring(j, i+j)�� �ϰ� �Ǹ�, i+j�� limit�� �Ѿ�� ��츦 �ݿ����� ���Ѵ�.
           * ex. ���̰� 5�� ���.
           * limit�� len�� ������ str = compare �� �Ҵ��� �ִ� �� ���ǹ��ص�, j+=i�� �Ǿ��� �� (j==25���� j>len��. ���� for ������ �ٷ� ����)
           *
           */

         str = compare;
        }
      }
      sb.append(str); //������ ���� ������ �ش���� �ʾƼ� for ������ �������� �� �ִ�. �� ���, ������� ��.
      answer = Math.min(answer, sb.length());
    }

    return answer;
  }
  public static void main(String[] args) {
    PressV2 T = new PressV2();
    System.out.println(T.solution("aabbaccc"));
//    System.out.println(T.solution("abcabcabcabcdededededede"));
  }
}
