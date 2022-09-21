package Programmers.Prac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/*
이전 코드의 문제 개선
pop 이 되던 되지 않건, 인형이 존재 했다면 (1) 버킷이 푸시하거나 (2) pop()하면서 board 열을 0으로 바꾸고
(공통 1,2 모두) moves 열의 다음 원소로 이동해야 한다.
다음 j로 이동해야 함. 다음 i로 이동해야 한다.
 */

public class PuppetReSolve {
  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    Stack<Integer> bucket = new Stack<>();
    for(int i=0;i<moves.length;i++) {
      int currentOrder = moves[i]-1; //1-5의 순서가 주어지지만 배열은 0-4기 떄문.
      for(int j=0;j< board.length;j++){
        int temp = board[j][currentOrder];
        if(temp!=0){
          //stackempty exception
          if(bucket.isEmpty()||bucket.peek()!=temp) {  //버킷이 비어있으면 무조건 넣기 or 버킷의 맨 위 숫자가 현재 숫자와 일치 x 넣어주기.
            bucket.push(temp);
            board[j][currentOrder]= 0;
          }
          //마지막 숫자와 temp 숫자가 일치하고, bucket 도 비어있지 않을 때.
          else {
            bucket.pop();
            answer+=2;
            board[j][currentOrder]= 0;
//            break; //한 번 터뜨리고 나면, 다음으로 넘어가야한다.
          }
          break;
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
