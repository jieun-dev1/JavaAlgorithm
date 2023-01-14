package Programmers.Level2.Kakao;

public class PressV2 {
  public int solution(String s) {
    int len = s.length();
    int answer = len; //ó������ �־��� ���̷� �ʱ�ȭ.
    int size = len/2; //2���� len�� ���� ����(==size) (Ȧ����� 17�̶�� 8����) ��ȸ�ϸ��.
    StringBuilder sb;
    //ù��° for�� �����ϴ� ����.
    //�ι�° for�� �����ϴ� �ε���.
      for(int i=2;i<=size;i++){
        sb = new StringBuilder(); //���̰� 2 - size ����. ���⼭ sb�� j�� �޶��� ������, �ʱ�ȭ
        int count = 1;
        for(int j=0;j<=len-i;){
        if(i+j>len){
          sb.append(s, i, len-1); // ������ �ε������� �����ְ� ����.
          break;
        }
        //i+j, i+2*j �� ���̿��� ����� �ʴ� ��, i,j�� �̵��ϸ鼭 count�� �����ش�.
        while((2*i+j<len)&&s.substring(j, i+j).equals(s.substring(i+j, 2*i+j))){ //���⼭ ���� ���ǹ���, ���� substring �� �κ��� i+2*j��� �ߴµ�, ������ i�̴�. ���� 2*i+j�� ����.
          count++;
          j+=i; //���̸�ŭ �þ.
        }
        //�� �̻� ���� ���ڰ� ���� ��� count�� ������ ���� ���ڸ� ���Ѵ�. �׸��� j�� �ű��.

        if(count!=1){
          sb.append(count);
          sb.append(s.substring(j, i+j)); //������� �����ֱ�
          j+=i;
          count = 1; // �ٽ� 1�� �ʱ�ȭ
          //j�� i��ŭ �̵��� ������, len�� ����� �ʾҴ��� Ȯ�� �ʿ�. ����ٸ� len �������� ���� ��.
          if(i+j>len){
            sb.append(count);
            sb.append(s.substring(j, len)); // ������ �ε������� �����ְ� ����. len-1�� �ƴ� len�̴�.
            break;
          }
        }
        //count�� 1�� �־ ���� ���� �� ������.
        if(count==1 && 2*i+j<len &&!s.substring(j, i+j).equals(s.substring(i+j, 2*i+j))){ //&&!s.substring(j, i+j).equals(s.substring(i+j, 2*i+j) - ����
          sb.append(s.substring(j, i+j));
          j+=i;
        }
      }
        answer = Math.min(sb.length(), answer);
      }
    //2����,
    return answer;
  }
  public static void main(String[] args) {
    PressV2 T = new PressV2();
    System.out.println(T.solution("abcabcabcabcdededededede"));
  }
}
