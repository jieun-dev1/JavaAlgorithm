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
    int[][] binArr1 = new int[n][n];
    int[][] binArr2 = new int[n][n];
    char[][] answerArr = new char[n][n];
    String[] stringAnswer = new String[n];

    /**
     * ���� for �� ���ο��� - for�� 2���� ��ħ 2X16X16  +16X16+16X16 = 16X16X4 = 1024;
     */
    for(int i=0;i<n;i++){
      String s = Integer.toString(arr1[i],2);
      if(s.length()<n){
        int tempLen = n - s.length();
        StringBuffer tempS = new StringBuffer(s); //1001 -> 01001
        for(int j=0;j<tempLen;j++){
          tempS.insert(0,"0");
        }
        s = tempS.toString();
      }
      for(int j=0;j<n;j++){
        binArr1[i][j] = s.charAt(j)-'0';
      }

      String s2 = Integer.toString(arr2[i],2);
      if(s2.length()<n){
        int tempLen = n - s2.length();
        StringBuffer tempS = new StringBuffer(s2);
        for(int j=0;j<tempLen;j++){
          tempS.insert(0,"0");
        }
        s2 = tempS.toString();
      }
      for(int j=0;j<n;j++){
        binArr2[i][j] = s2.charAt(j)-'0';
      }
    }

    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(binArr1[i][j]==1 || binArr2[i][j]==1 ){
          answerArr[i][j] = 1;
        }
      }
    }

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

  public static void main(String[] args) {
    SecretMap T = new SecretMap();
    System.out.println(T.solution(5, new int[]{9,20,28,18,11},new int[]{30, 1, 21, 17, 28}));
  }
}
