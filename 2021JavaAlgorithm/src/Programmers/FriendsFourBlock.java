package Programmers;

import java.util.ArrayList;

/**
 * 이 문제를 풀면서 어려웠던 점 - 구현 아이디어를 못 냈다.
 *
 * 핵심적으로 막힌 것.
 *
 * 1. 2X2짝을 발견하면, 삭제하는 걸 어떻게 할지 아이디어를 내는 것 - STACK으로만 구현해봤는데 배열로는 어떻게 하지? -> 특정 위치에 0을 삽입해줘도 된다. 새로 LIST를 만들어도 됨.
 * 2. 아직 배열이 익숙하지 않다. 순회할 때, M-1/N-1만큼만 가면 되고, 4개 값을 모두 조회해서 모두 같으면 TRUE 이다. 이때, 겹쳐도 상관 없다.
 * 3. update - 2차원 배열 다룰 때, 행렬은 [m][n] 즉, [행][렬]이다.
 * 4. 삭제할 배열을 찾고 없애서 다시 업데이트 해줄 때, n(열)을 기준으로 m(행)을 바꿔가며 검사한다.
 *
 * 시행착오
 * 1. 답이 틀렸던 이유 - ch배열을 static으로 썼고, 이전 결과를 갱신해주지 않았기 때문.
 * -> mark를 하나의 스테이지로 보고, 스테이지마다 ch 배열을 만들어주는 것으로 함.
 * 2. 0이 답이었던 이유 - 처음에 flag 를 false 로 줘서, while 문을 한번도 시도하지 않음.
 * 처음에 true 여야 함. (mark 안에서 다시 false 를 해주고, true 가 발견되면 true 로 바꿔주기)
 *
 * 팁
 * 여러 메서드로 분할 할 때는, static 변수 활용하는 게 좋다. 그리고 solution에서 할당하는 식으로 쓰기.
 */

//시간복잡도 약 94000
public class FriendsFourBlock {
  static char[][] matrix;
  static int m;
  static int n;
  static int answer;
  static boolean flag = true; //시작점이 false 면 while문이 돌 수 없음.

  public int solution(int m, int n, String[] board) {
    this.m = m;
    this.n = n;
    matrix = new char[m][n];
    answer = 0;

    //1. 배열 초기화: O(900)
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        char temp = board[i].charAt(j);
        matrix[i][j] = temp;
      }
    }
    //2. 한 번 MARK 가 일어날 때마다, UPDATE 필요.
    while(flag==true){
      //O(900)
      boolean[][] ch = mark(m, n);
      //O(92700)
      answer+=update(m,n, ch);
    }
    return answer;
  }

  //3. mark의 목적: 지워질 블록 파악하기: ch 배열에 true false로 지우기 여부 선택.
  //마지막 flag가 false 더라도, answer+=update 0까지 가긴 함.
  public boolean[][] mark(int m, int n){
    flag = false;
    boolean[][] ch = new boolean[m][n];
    for(int i=0;i<m-1;i++){
      for(int j=0;j<n-1;j++){
        char point = matrix[i][j];
        if(point!='0'&&point==matrix[i][j+1]&&point==matrix[i+1][j]&&point==matrix[i+1][j+1]){
          ch[i][j]=true;
          ch[i][j+1]=true;
          ch[i+1][j]=true;
          ch[i+1][j+1]=true;
          flag = true;
        }
      }
    }
//    System.out.println(matrix[3][4]); // matrix 잘 들어갔는지 확인 - F 여야 함.
    System.out.println(ch[1][1]); //true 여야 함.
    return ch;
  }

  //4. update 시 사라지는 원소 갯수를 cnt로 반환해서 매번 스테이지마다 더해준다 + true를 없애고 '0'을 더해준다.
  //행만 바뀌기 때문에 i가 아닌, j만 바뀌고 j가 앞의(행)위치에 와있는 것이 포인트.
  public int update(int m, int n, boolean[][] ch){
    int cnt = 0;
    //o(30*((30*30)+30)) = 30*930 = 92700
    for(int i=0;i<n;i++){
      ArrayList<Character> list = new ArrayList<>();
      for(int j=0;j<m;j++){
        if(ch[j][i]==true) {
          //O(30) 최대 판의 높이. 인덱스를 지정해서 더하면 O(N)이다.
          list.add(0, '0');
          cnt++;
        } else {
          list.add(matrix[j][i]);
        }
      }
      //O(30)
      for(int j=0;j<m;j++){
        matrix[j][i] = list.get(j); //list에 담긴 원소들로 matrix 배열 갱신해주기. //순서대로.
      }
    }
    System.out.println(cnt);
    return cnt;
  }

  public static void main(String[] args) {
    FriendsFourBlock T = new FriendsFourBlock();
    System.out.println(T.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
  }
}