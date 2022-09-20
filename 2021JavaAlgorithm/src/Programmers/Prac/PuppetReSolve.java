package Programmers.Prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


//EmptyStackException 해결.

public class PuppetReSolve {
  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    Stack<Integer> bucket = new Stack<>();
    for(int i=0;i<moves.length;i++) {
      int currentOrder = moves[i]-1; //1-5의 순서가 주어지지만 배열은 0-4기 떄문.
      for(int j=0;j< board.length;j++){
        if(board[j][currentOrder]!=0){
          int temp = board[j][currentOrder];
          //0이 아니어서 넣으려고 했는데 bucket의 맨 위 원소와 같다면. answer+=2 (둘다 pop이니까), 그리고 마지막 원소도 pop해줌. null일 경우 처리 필요한가?
          if(bucket.peek()==null || bucket.peek()!=temp){
            bucket.push(temp); //버킷이 비어있으면 무조건 넣기 or 버킷의 맨 위 숫자가 현재 숫자와 일치 x 넣어주기.
          }
          else {
            bucket.pop();
            answer+=2;
          }
        }
      }

    }
    return answer;
  }

  public static void main(String[] args) {
    PuppetReSolve T = new PuppetReSolve();
    System.out.println(T.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
  }
}
