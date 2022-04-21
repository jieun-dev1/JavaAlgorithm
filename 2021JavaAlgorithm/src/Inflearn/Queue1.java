package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//q.poll() 한 것을 어떻게 다시 넣지? q.offer(q.poll()) 해도 되나?
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
                q.offer(q.poll()); //num-1 만큼 빼주고 다시 넣어주고
            }
            q.poll(); //마지막은 아예 빼줌 4,7 둘이 남았을 때는 4가 빠지고 다시 위로 들어가고 7도 다시 들어가는데 4가 밑에 있으니까 4가 먼저 poll()됨.
            //시계 방향으로 돌아가기 때문에, 3이 num 인데, 2만남아도 가능하다. 마지막에 한 명 남을 때만 분기 해주면 됨.

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
