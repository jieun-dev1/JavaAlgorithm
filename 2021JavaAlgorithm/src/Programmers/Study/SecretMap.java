package Programmers.Study;

/**
 * Ǯ�� �ð�: 40�ð�
 * 1. arr1 �� arr2�� �ݺ��Ǵ� �ڵ带 ��� ������?
 */
public class SecretMap {

  public String[] solution(int n, int[] arr1, int[] arr2) {
    /**
     * ���ڸ� 2������ ��ȯ��
     */
    char[][] answerArr = new char[n][n];
    String[] stringAnswer = new String[n];

    int[][] binArr1 = convertToBinary(arr1, n);
    int[][] binArr2 = convertToBinary(arr2, n);

    /**
     * ���� for �� ���ο��� - for�� 2���� ��ħ 2X16X16  +16X16+16X16 = 16X16X4 = 1024;
     */

    // �ϳ��� 1�� ������ answerArr�� 1�� �Ǵ� ��.
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(binArr1[i][j]==1 || binArr2[i][j]==1 ){
          answerArr[i][j] = 1;
        }
      }
    }

    // # Ȥ�� �������� ä���ֱ�.
    for(int i=0;i<n;i++){
      StringBuilder s = new StringBuilder();
      for(int j=0;j<n;j++){
        //�� �ึ�� s�� ���´�.
        if(answerArr[i][j]==1){
          answerArr[i][j] = '#';
        } else {
          answerArr[i][j] = ' ';
        }
        s.append(answerArr[i][j]);
      }
      stringAnswer[i] = s.toString();
    }
    return stringAnswer;
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
