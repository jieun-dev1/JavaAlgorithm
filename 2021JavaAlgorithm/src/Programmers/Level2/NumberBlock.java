package Programmers.Level2;


/**
 * end-begin�� 10,000�� ���� �ʱ� ������ int[] answer�� ���̴� 10,000 ���� ����.
 * �ڱ� �ڽ��� �ƴ� ��� �� ���� ū ���.
 */
public class NumberBlock {

  public int[] solution(long begin, long end) {


    //1 - end ������ �����, begin-end �� ����.
    int answer[] = new int[(int) end-(int) begin+1]; //

    for(long i=begin;i<end+1;i++) {
      if(i%2 == 0) {
        answer[((int)i-(int)begin)] = (int)i/2; ///2�� ����� ��� 2�� ���� ���� ��� �� ���� ū ��. 2�� ����� ��ȸ�� �ʿ� x.
      } else {
        for(long j=(int)i/2;j>=1;j--) {
          if(i%j==0) {
            answer[((int)i-(int)begin)] = (int) j;
            break;
          }
        }
      }
    }
    return answer;
  }
}
