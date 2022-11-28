package Programmers.Study;

/**
 * StringBuffer �� String Builder
 * String Builder:
 * (1) ����ȭ�� �������� �ʴ� �ݸ�, �ӵ��鿡�� StringBuffer ���� ������ �����ϴ�.
 * (2) ���� ������ ȯ�� �� ���ڿ��� �߰�, ����, ���� ���� ����� �߻��ϴ� ���
 * StringBuffer: ��Ƽ������ ȯ�� ��, ���ڿ� �߰�/����/������ ����� �߻��� ��
 */
public class SecretMap {

  public String[] solution(int n, int[] arr1, int[] arr2) {

  }

  public int[][] convertToBinary(int[] arr, int n){
    int[][] intArr  = new int[n][n];
    for (int i = 0; i < n; i++) {
      String s = Integer.toString(arr[i], 2);
      if (s.length() < n) {
        int tempLen = n - s.length();
        StringBuffer tempS = new StringBuffer(s); //1001 -> 01001
        for (int j = 0; j < tempLen; j++) {
          tempS.insert(0, "0");
        }
        s = tempS.toString();
      }
      for (int j = 0; j < n; j++) {
        intArr[i][j] = s.charAt(j) - '0';
      }
    }
    return intArr;
  }


  public static void main(String[] args) {
    SecretMap T = new SecretMap();
    System.out.println(T.solution(5, new int[]{9,20,28,18,11},new int[]{30, 1, 21, 17, 28}));
  }
}
