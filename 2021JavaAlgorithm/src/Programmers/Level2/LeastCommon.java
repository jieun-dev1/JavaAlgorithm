package Programmers.Level2;

/**
 * �ּ� ������� Ư¡
 * �ּ� ������� �� ���� ���� �������(�� ���� ��� ���� ��)���� �۰ų� ����.
 * arr�� ���� = 15 �����̰�, ���Ҵ� 100 ������ �ڿ���.
 * ���Ұ� 100���� ������ �� ���� for������ Ǯ�� �ð��ʰ��� �� �� ���� �� ����.
 *
 * i�� ��ȸ�� ��, 1���� �ϱ� ������ multiple+1 �� ����� ��.
 */
public class LeastCommon {
  public int solution(int[] arr) {
    int answer = 0;
    long multiple = 1; //����� �ʱ�ȭ
    for(int i=0;i<arr.length;i++) {
      multiple = multiple*arr[i];
    }

    for(int i=1;i<multiple+1;i++) {
      for(int j=0;j<arr.length;j++) {
        if(i%arr[j] != 0) {
          break;
        } else if((i%arr[j]==0) && (j==arr.length-1)) { //������ ���Ҷ��
          answer = i;
          return answer;
        }
        else if(i%arr[j]==0 && (j!=arr.length-1)) {
          continue;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    LeastCommon T = new LeastCommon();
    System.out.println(T.solution(new int[] {2,6,8,14}));

  }
}
