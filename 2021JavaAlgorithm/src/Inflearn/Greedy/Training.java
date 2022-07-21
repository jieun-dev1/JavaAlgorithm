package Inflearn.Greedy;

import java.util.*;


/*
참고: https://school.programmers.co.kr/learn/courses/30/lessons/42862#

 전체 카운트 - lost 학생 수: default 값
 lost 배열을 Queue에 넣는다.
 if lost[i] 가 reserve 의 앞이나 뒤라면, +1을 리턴.
 reserve 배열 읽기

  */
public class Training {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] arr = new int[n+2];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        //체육복 잃어버린 학생 = 0;
        //주어지는 건 숫자지만, 0부터 인덱스가 시작하기 때문에, 실제로 인덱싱은 -1을 해준다.


        //lost와 reserve 가 겹칠 때, 어떻게 제거해줄 수 있지?
        //이중 for 문으로 겹치는 경우는 -2 넣어주기 (-2 = 빌려줄 수 없다는 뜻의 임의 값)
        // -1이면, lost +1이면 reserve.
        for (int i : lost) {
            for(int j: reserve) {
                if (i == j) {
                    arr[i] = -2;
                }
            }
        }

        for(int i:lost) {
            if(arr[i]!=-2) {
                arr[i] -= 1;  // lost라면 -1
            }
        }
        for (int j : reserve) {
            if(arr[j]!=-2) {
                arr[j] += 1; // +1 reserve 라면 여분이 있으니 +1
            }
        }

        //반례: 6, [2,4,6], [1,3,5]
        for (int i = 1; i <= n; i++) {
            if (arr[i] == -1 && arr[i - 1] == 1) {
                arr[i - 1] -= 1;
                arr[i] += 1;
            } else if (arr[i] == -1 && arr[i + 1] == 1) {
                arr[i + 1] -= 1;
                arr[i] += 1;
            }
        }

        for(int i=1;i<=n;i++) {
            if(arr[i] == -1) {
                answer--;
            }
        }
        return answer;
    }
}




