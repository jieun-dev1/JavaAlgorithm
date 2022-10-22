package Programmers.Level2;

//Ǯ�̽ð�: 1�ð�

public class Carpet {

  int answerW = 0;
  int answerH = 0;
  int width;
  int height;
  int[] answer = new int[2];
  int[] ch = new int[1];

  public int[] solution(int brown, int yellow) {

    for (int i = yellow; i >= 1; i--) {
      if ((yellow % i) == 0) {
        //yellow �� width, height
        width = i;
        height = yellow / i;
        if (width >= height & (ch[0] != 1)) {
          DFS(width, height, yellow, brown);
        }
        if (ch[0] == 1) {
          return answer;
        }
      }
      //break ������ �־�� ��.
    }

    return answer;
  }

  public void DFS(int width, int height, int yellow, int brown) {
    //������ ����� ������
    int bSize = 2 * (width + 2) + 2 * height;
    if (bSize == brown) {
      int answerW = width + 2;
      int answerH = height + 2;
      answer[0] = answerW;
      answer[1] = answerH;
      ch[0] = 1;
      return;

    } else {
      return;
    }
  }

  public static void main(String[] args) {
    Carpet T = new Carpet();
    T.solution(24, 24);
  }
}
