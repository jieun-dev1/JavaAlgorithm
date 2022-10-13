package Programmers.Level2;


/**
 * end-begin�� 10,000�� ���� �ʱ� ������ int[] answer�� ���̴� 10,000 ���� ����.
 * �ڱ� �ڽ��� �ƴ� ��� �� ���� ū ���.
 *
 * double�� int�� ��ȯ�ϸ� �������� ���.
 * �������� ������ �ƴ϶��, ������ ��� ����.
 */
public class NumberBlock {

  public int[] solution(long begin, long end) {
    //int �迭�� ��ȯ�ؾ� �ϴ�, �ʱ⿡ long�� int �� ��ȯ���ֱ�.
    int beginPoint = (int) begin;
    int endPoint = (int) end;
    //1 - end ������ �����, begin-end �� ����.
    int answer[] = new int[endPoint-beginPoint+1]; //

    for(int i=beginPoint;i<endPoint+1;i++) {
        for(int j=i/2;j>=(int)Math.sqrt(i);j--) {
          if(j>=10000000) {
            continue;
          }
          else if((j<=10000000)&& (i%j==0)) {
            answer[(i-beginPoint)] = j;
            break;
          }
          else  if ((j<=10000000) && (j==(int) Math.sqrt(i)) && (i%j!=0)) {
            answer[(i-beginPoint)] = 1; //���������� �������� �ʴ´ٸ�,
            break;
          }
        }
      }
    return answer;
  }
}
