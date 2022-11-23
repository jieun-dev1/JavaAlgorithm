package Programmers.Study;

/**
 * 풀이 시간: 40시간
 * 1. arr1 과 arr2가 반복되는 코드를 어떻게 줄이지?
 */
public class SecretMap {

  public String[] solution(int n, int[] arr1, int[] arr2) {
    /**
     * 숫자를 2진수로 변환한
     */
    char[][] answerArr = new char[n][n];
    String[] stringAnswer = new String[n];

    int[][] binArr1 = convertToBinary(arr1, n);
    int[][] binArr2 = convertToBinary(arr2, n);

    /**
     * 이중 for 문 내부에서 - for문 2개를 거침 2X16X16  +16X16+16X16 = 16X16X4 = 1024;
     */

    // 하나라도 1이 나오면 answerArr는 1이 되는 것.
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(binArr1[i][j]==1 || binArr2[i][j]==1 ){
          answerArr[i][j] = 1;
        }
      }
    }

    // # 혹은 공백으로 채워주기.
    for(int i=0;i<n;i++){
      StringBuilder s = new StringBuilder();
      for(int j=0;j<n;j++){
        //한 행마다 s를 갖는다.
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
