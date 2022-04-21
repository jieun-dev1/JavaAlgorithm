package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//q.poll() �� ���� ��� �ٽ� ����? q.offer(q.poll()) �ص� �ǳ�?
//e

public class Queue1 {

    public int solution(int cnt,int num){
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<cnt+1;i++){
            q.offer(i);
        }

        while(!q.isEmpty()) {
            for(int i=1;i<num;i++){
                q.offer(q.poll()); //num-1 ��ŭ ���ְ� �ٽ� �־��ְ�
            }
            q.poll(); //�������� �ƿ� ���� 4,7 ���� ������ ���� 4�� ������ �ٽ� ���� ���� 7�� �ٽ� ���µ� 4�� �ؿ� �����ϱ� 4�� ���� poll()��.
            //�ð� �������� ���ư��� ������, 3�� num �ε�, 2�����Ƶ� �����ϴ�. �������� �� �� ���� ���� �б� ���ָ� ��.

            if (q.size()==1) {
                answer = q.poll();
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Queue1 T = new Queue1();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int num = sc.nextInt();
        System.out.println(T.solution(cnt,num));

    }
}
