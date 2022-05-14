package Inflearn.DFSBFSProb;

import java.util.*;

//배열이 1,2,5인 경우, 1부터 시작하면 비효율적. 최소라는 걸 생각해봤을 떄, 큰 값부터 넣어봐야
public class Coin {
    static int answer=Integer.MAX_VALUE, n;
    static int target;

    public void DFS(int Level, int sum, Integer[] arr) {
        if (sum > target) return;
//        if (flag == true) return; //삭제 이유: 답이 하나라도 나오면 함수를 종료할 수 있는 경우가 아니기 때문. 깊이 탐색이어서, 한 노드의 모든 레벨 탐색 후 올라가는 형태여서. Math.min 으로 최소값 찾는 작업 필수.
        //값이 같으면, L이 최소값.
        if(Level>=answer) return; // 중요! 처음 target = sum 의 값이, 해당 깊이의 최소값이기 때문.
        if (target == sum) {
            answer = Math.min(Level, answer);
//            answer = Level;
            return;
        } else {
            for(int i=0;i<n;i++){
                DFS(Level + 1,sum + arr[i], arr);
            }
        }
    }

        public static void main(String[] args){
            Coin T = new Coin();
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
//            int[] arr = new int[n]; 기본형 int 안됨. Required type:T[]
            Integer [] arr = new Integer[n];
//        int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            //sort는 ArrayList 가 아닌 Arrays 배열에 속하는 메서드 T[] a를 인자로 받음.
            Arrays.sort(arr, Collections.reverseOrder());// Collections.reverseOrder() 배열을 내림차순으로.
            target = sc.nextInt();
            int sum = 0;
            T.DFS(0, sum, arr);
            System.out.println(answer);
        }
    }
