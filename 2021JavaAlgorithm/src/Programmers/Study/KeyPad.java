package Programmers.Study;


public class KeyPad {

  public String solution(int[] numbers, String hand) {
    StringBuilder answer = new StringBuilder(); //��
    int[][] keyPad = new int[][]{{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    int[] current = new int[2]; //[0,0]���� �ʱ�ȭ. ��/��

    for(int i=0;i<numbers.length;i++){
      if(numbers[i]==1 ||numbers[i]==4 ||numbers[i]==7){
        answer.append('L');
        current[0] = numbers[i];
      } else if(numbers[i]==3 ||numbers[i]==6 ||numbers[i]==9){
        answer.append('R');
        current[1] = numbers[i];
      } else {
        //keypad���� �־��� ������ ��ġ
        int givenX = keyPad[numbers[i]][0];
        int givenY = keyPad[numbers[i]][1];
        //���� ��/�� �հ����� ��ġ.
        int leftX = keyPad[current[0]][0];
        int leftY = keyPad[current[0]][1];
        int rightX = keyPad[current[1]][0];
        int rightY = keyPad[current[1]][1];

        int leftDis = Math.abs(leftX-givenX)+Math.abs(leftY-givenY);
        int rightDis = Math.abs(rightX-givenX)+Math.abs(rightY-givenY);

        //�� ���� ���� �������� ���ڸ� �ٿ��ش� (������� �ϴϱ�)
        if(leftDis<rightDis){
          current[0] = numbers[i];
          answer.append('L');
        } else if (leftDis==rightDis){
          if(hand.equals("right")){
            current[1] = numbers[i];
            answer.append('R');
          } else {
            current[0] = numbers[i];
            answer.append('L');
          }
        }
          else {
          current[1] = numbers[i];
          answer.append('R');
        }
      }
    }
    return answer.toString();
  }
}
