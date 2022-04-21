package Inflearn;

import java.util.*;

//막힌 점은 어떻게 2차원 배열의 칼럼별로 [0,1],[1,1],[2,1]... Stack 을 만들어줄 수 있을까? [i][pos-1]
//스택을 완성하고 나서 스택 안에서 연속값을 터뜨릴 방법이 마땅찮다.. 그러니까 스택을 쌓는 과정에서  값 비교.
//else 블록 안에 break를 넣으면, 코드가 참일 때 break가 되지 않고, 인형을 하나 더 꺼내게됨.

public class Stack3 {
    public int solution(int[][] arr, int[] moveArr) {
        Stack<Integer> sc = new Stack<>();
        int answer = 0;
        //2차원 배열 for 문을 돌면서, if 0이 아닌 것. stack에 push 하고. 0으로 바꾸고
        //해결책: 임시 int 값을 만들어서 여기서 비교. 그리고 한 번 읽은 값은 0으로 바꿔주어야 다음 값을 읽어올 수 있지.
        for(int i=0;i<moveArr.length;i++){
            int pos = moveArr[i]-1;
            for(int j=0;j<arr.length;j++) {
                if (arr[j][pos] != 0) {
                    int tmp = arr[j][pos];
                    arr[j][pos] = 0;
                    if (!sc.empty() && sc.peek()==tmp) {
                        answer +=2;
                        sc.pop();
                    }
                    else
                        sc.push(tmp);

                    break;
                    //push 한 다음에는 그만 넣어야 함. break 로 for 문 탈출 뒤 다음 column으로. //break를 else 블록에 넣으면, (!sc.empty() && sc.peek()==tmp 코드가 참일 때 break가 안된다.
                  //한 컬럼을 읽었으면 true이든 false 이든 break를 무조건 해야한다 그렇기 때문에
                  //{} 블록은 여러 문장을 하나의 단위로 묶을 때 쓴다. 하나 뿐일 때는 {} 안써도 된다. 여기서는 else 일때는 push 한 문장만 하면 되니까 괄호 생략 가능.
                  //break면 무조건 안쪽 for문을 탈출한다. 다음에 i=1로 넘어감.

                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack3 T = new Stack3();
        Scanner sc = new Scanner(System.in);
        int column = sc.nextInt();
        //ex) column 가로x세로 2차원 배열 생성
        int[][] arr = new int[column][column];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < column; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int move = sc.nextInt();
        int[] moveArr = new int[move];
        for(int i=0;i<moveArr.length;i++){
            moveArr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr, moveArr));

        }
    }
