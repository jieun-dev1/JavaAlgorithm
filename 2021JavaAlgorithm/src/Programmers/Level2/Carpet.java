package Programmers.Level2;

//풀이시간: 1시간

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
        //yellow 의 width, height
        width = i;
        height = yellow / i;
        if (width >= height & (ch[0] != 1)) {
          DFS(width, height, yellow, brown);
        }
        if (ch[0] == 1) {
          return answer;
        }
      }
      //break 조건이 있어야 함.
    }

    return answer;
  }

  public void DFS(int width, int height, int yellow, int brown) {
    //갈색과 노란색 사이즈
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
