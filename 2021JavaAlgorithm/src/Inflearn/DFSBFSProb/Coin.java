package Inflearn.DFSBFSProb;

import java.util.*;

//�迭�� 1,2,5�� ���, 1���� �����ϸ� ��ȿ����. �ּҶ�� �� �����غ��� ��, ū ������ �־����
public class Coin {
    static int answer=Integer.MAX_VALUE, n;
    static int target;

    public void DFS(int Level, int sum, Integer[] arr) {
        if (sum > target) return;
//        if (flag == true) return; //���� ����: ���� �ϳ��� ������ �Լ��� ������ �� �ִ� ��찡 �ƴϱ� ����. ���� Ž���̾, �� ����� ��� ���� Ž�� �� �ö󰡴� ���¿���. Math.min ���� �ּҰ� ã�� �۾� �ʼ�.
        //���� ������, L�� �ּҰ�.
        if(Level>=answer) return; // �߿�! ó�� target = sum �� ����, �ش� ������ �ּҰ��̱� ����.
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
//            int[] arr = new int[n]; �⺻�� int �ȵ�. Required type:T[]
            Integer [] arr = new Integer[n];
//        int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            //sort�� ArrayList �� �ƴ� Arrays �迭�� ���ϴ� �޼��� T[] a�� ���ڷ� ����.
            Arrays.sort(arr, Collections.reverseOrder());// Collections.reverseOrder() �迭�� ������������.
            target = sc.nextInt();
            int sum = 0;
            T.DFS(0, sum, arr);
            System.out.println(answer);
        }
    }
