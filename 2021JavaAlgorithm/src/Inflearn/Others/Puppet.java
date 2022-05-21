package Inflearn.Others;

import java.util.*;

/**
 *인형뽑기는 영어로 Puppet Draw다.
 *  Queue 의 peek은 가장 먼저 저장된 요소 읽어옴.
 *  ArrayList를 만들어서 그 안에 Stack 을 만들려고 했었는데,
 * 빈 stack 을 peek() 하면 empty stackException이 뜸.
 * 임시로 만들어줄 것. doub[j][pos-1]
 * 여러 조건문을 걸고, 한번만 통과하게 하는 요구사항 처리가 아직 어려운듯.
 * 행을 구할 떄, 2차원배열.length() 열 = 2차원배열[0].length()
 * 1차: 인형을 찾아서 push 하기 2차 if: Stack 이 비어있지 않고(peek)을 하려면, stack 이 차있음. tmp 가 stack.peek() 와 같다면, pop시켜주기.
 * for, if, break 활용.
 * break 는 자신이 포함된 가장 가까운 반복문을 벗어난다.
 * else 를 block 으로 걸 경우, 답이 2가 된다. 이유는, break 가 else 블록에만 적용되고 if 블록에는 적용되지 않아서,
 * if 문에서 참이 되었을 때 두번째 for 문을 한 번 더돌기 때문이다. if 에도 break 를 넣으면 정답이 된다.
 */

public class Puppet {
    public int solution(int[][] doub, int n, int[] moves) {
        int answer = 0;
        Stack<Integer> movedArr = new Stack<>();
        for(int pos: moves) {
            for (int j = 0; j < doub.length; j++) {
                //0이 아님 = 인형을 찾았다.0이 아니라면, 무조건 0으로 만들어야 함 (원소 같음여부와 상관없이.
                //tmp 에 복사해주지 않으면, 위치를 0으로 바꾼 채로 값을 비교하게 됨.
                if (doub[j][pos-1]!=0) {
                    int tmp = doub[j][pos-1];
                    doub[j][pos-1] = 0;
                    //movedArr가 비어있지 않고 peek 과 현재 원소가 같다면 Pop
                    if(!movedArr.isEmpty()&&tmp == movedArr.peek()){
                            answer = answer + 2;
                            movedArr.pop();
                    //그 외 모든 조건 movedArr 가 비어있던, peek 과 같지 않던 push 한다.
                    } else movedArr.push(tmp);
                        break; //가장 가까운 반복문은 doub.length 도는 for문,
                    }
                }
                }
//            break; //break: 자신이 포함된 가장 가까운 반복문을 벗어난다.
        return answer;
    }

    public static void main(String[] args){
        Puppet T = new Puppet();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //2차원 배열을 먼저 만들고 스택화하기
        int[][] doub = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                    doub[i][j] = sc.nextInt();
            }
        }
        int movesCnt = sc.nextInt();
        int[] moves = new int[movesCnt];
        for(int i=0;i<movesCnt;i++){ //movesCnt 길이의 배열이 생긴다.
            moves[i] = sc.nextInt();
        }
        System.out.println(T.solution(doub, n, moves));
    }
}
