package Programmers.Level2;

/**
 * ���� ����:
 * answer�� 3�̾�� �� ��, ������� 2�� ����.
 */
public class Tournament {
  public int solution(int n, int a, int b)
  {
    int answer = 1;

    // 2�� �����̱� ������ �������� ���ϰ� �;�����, �̴� math �Լ����� �������� ����. 20���϶�� ������ �־�����, 20������ �ݺ��ϸ� �ȴ�.
    for(int i=0;i<20;i++) {

      if(a%2 != 0) {
        a = (a+1)/2;
      } else {
        a = a/2;
      }

      if(b%2 != 0) {
        b = (b+1)/2;
      } else {
        b = b/2;
      }

      if(a==b) {
        return answer;
      }

      answer++;

    }

    return answer;
  }

  public static void main(String[] args) {
    Tournament T = new Tournament();
    System.out.println(T.solution(8,4,7));
  }
  }
