package Inflearn.Greedy;

import java.util.*;


/*
����: https://school.programmers.co.kr/learn/courses/30/lessons/42862#

 ��ü ī��Ʈ - lost �л� ��: default ��
 lost �迭�� Queue�� �ִ´�.
 if lost[i] �� reserve �� ���̳� �ڶ��, +1�� ����.
 reserve �迭 �б�

  */
public class Training {

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] arr = new int[n+2];
        Arrays.sort(lost);
        Arrays.sort(reserve);
        //ü���� �Ҿ���� �л� = 0;
        //�־����� �� ��������, 0���� �ε����� �����ϱ� ������, ������ �ε����� -1�� ���ش�.


        //lost�� reserve �� ��ĥ ��, ��� �������� �� ����?
        //���� for ������ ��ġ�� ���� -2 �־��ֱ� (-2 = ������ �� ���ٴ� ���� ���� ��)
        // -1�̸�, lost +1�̸� reserve.
        for (int i : lost) {
            for(int j: reserve) {
                if (i == j) {
                    arr[i] = -2;
                }
            }
        }

        for(int i:lost) {
            if(arr[i]!=-2) {
                arr[i] -= 1;  // lost��� -1
            }
        }
        for (int j : reserve) {
            if(arr[j]!=-2) {
                arr[j] += 1; // +1 reserve ��� ������ ������ +1
            }
        }

        //�ݷ�: 6, [2,4,6], [1,3,5]
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




